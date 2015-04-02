import java.util.Stack;

public class Fonction implements Constante {
	private IdFonct fonctionCourante;
	private Stack<IdFonct> fonctionsAppelees;
	private Stack<Stack<eType>> fonctionsAppeleesParametres;
	
	public Fonction() {
		this.fonctionsAppelees = new Stack<IdFonct>();
		this.fonctionsAppeleesParametres = new Stack<Stack<eType>>();
	}
	
	public void debut() {
		Yaka.tabIdent.effacerLocaux();
		Yaka.declaration.effacer();
	}
	
	public void setFonctionCourante(String ident, eType type) {
		if (Yaka.tabIdent.existeGlobaux(ident)) {
			System.out.println("Erreur: la fonction '" + ident + "' existe deja (ligne:" + Yaka.token.beginLine + ").");
		}
		
		this.fonctionCourante = new IdFonct(ident, type);
		Yaka.tabIdent.rangeGlobaux(ident, this.fonctionCourante);
		Yaka.yvm.etiquette(ident);
	}
	
	public void addTypeParametreFonctionCourante(eType type){
		this.fonctionCourante.addTypeParametre(type);
	}
	
	public void addParametreFonctionCourante(String ident, eType type){
		if (Yaka.tabIdent.existeLocaux(ident)) {
			System.out.println("Erreur: l'ident '" + ident + "' existe deja (ligne:" + Yaka.token.beginLine + ").");
		}
		
		Yaka.tabIdent.rangeLocaux(ident, new IdVar(ident, type, this.fonctionCourante.nbParametres()));
	}
	
	public void setOffsetParametresFonctionCourante() {
		Yaka.tabIdent.setOffsetParametresFonctionCourante(this.fonctionCourante.nbParametres());
	}
	
	public void retourne() {
		eType expressionType = Yaka.expression.type();
		
		if(expressionType == this.fonctionCourante.getType()) {
		
		}
		else {
			System.out.println("Erreur : problème du type de retour de la fonction (ligne : " + Yaka.token.beginLine + ").");
		}
		
		Yaka.yvm.ireturn(2 * this.fonctionCourante.nbParametres() + 4);
	}
	
	public void debutAppelFonction(String ident) {
		IdFonct id = (IdFonct) Yaka.tabIdent.chercheGlobaux(ident);
		
		this.fonctionsAppelees.push(id);
		this.fonctionsAppeleesParametres.push(new Stack<eType>());
		
		Yaka.yvm.reserveRetour();
	}
	
	public void debutAppelFonctionErreur(String ident) {
		IdFonct id = new IdFonct(ident, eType.ERREUR);
		
		this.fonctionsAppelees.push(id);
		this.fonctionsAppeleesParametres.push(new Stack<eType>());
		
		Yaka.yvm.reserveRetour();
	}
	
	public void verifierParametre() {
		eType expressionType = Yaka.expression.getType();
		this.fonctionsAppeleesParametres.lastElement().push(expressionType);
	}
	
	public void finAppelFonction() {
		IdFonct id = this.fonctionsAppelees.pop();
		
		// On vérifie les types de l'appel de la fonction
		Stack<eType> typesAttendus = (Stack<eType>) id.getTypeParametres().clone();
		Stack<eType> typesRecus = this.fonctionsAppeleesParametres.lastElement();
		int nbParametres = typesRecus.size();
		
		if (typesAttendus.size() == typesRecus.size()) {
			while(typesRecus.size() > 0) {
				if (typesRecus.pop() != typesAttendus.pop()) {
					System.out.println("Erreur : problème de type lors de l'appel de la fonction (ligne : " + Yaka.token.beginLine + ").");
				}
			}
		}
		else {
			System.out.println("Erreur : le nombre d'arguments lors de l'appel de la fonction ne correspond pas (ligne : " + Yaka.token.beginLine + ").");
		}
				
		// On dépile les paramètres
		for (int i = 0 ; i < nbParametres ; i++) {
			Yaka.expression.type();
		}
		
		Yaka.expression.ajoutType(id.getType());
		
		this.fonctionsAppeleesParametres.pop();
		
		Yaka.yvm.call(id.getNom());
	}
	
	public void fin() {
		Yaka.yvm.fermeBloc(2 * this.fonctionCourante.nbParametres());
	}
}
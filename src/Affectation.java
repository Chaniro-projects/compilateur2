public class Affectation implements Constante {
	private IdVar identAffectation;
	
	
	public void setIdentAffectation(String ident) {
		if (!Yaka.tabIdent.existeLocaux(ident)) {
			System.out.println("Erreur: l'ident '" + ident + "' n'existe pas (ligne : " + Yaka.token.beginLine + ").");
		}
		else {
			Ident id = Yaka.tabIdent.chercheLocaux(ident);
			
			if(id instanceof IdConst) {
				System.out.println("Erreur: l'ident '" + ident + "' est une constante alors qu'on attend une variable (ligne : " + Yaka.token.beginLine + ").");
			}
			else if(id instanceof IdVar) {
				this.identAffectation = (IdVar) id;
			}
		}
	}
	
	public void affectation() {
		eType expressionType = Yaka.expression.type();
		
		if (this.identAffectation != null) {
			if (expressionType == this.identAffectation.getType()) {
				Yaka.yvm.istore(((IdVar) this.identAffectation).getOffset());
			}
			else {
				System.out.println("Erreur : probleme de type lors de l'affectation (ligne : " + Yaka.token.beginLine + ").");
			}
		}
	}
}

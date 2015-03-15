public class Affectation implements Constante {
	private IdVar identAffectation;
	
	
	public void setIdentAffectation(String ident) {
		if (!Yaka.tabIdent.existeIdent(ident)) {
			System.out.println("Erreur: l'ident '" + ident + "' n'existe pas (ligne : " + Yaka.token.beginLine + ").");
		}
		else {
			Ident id = Yaka.tabIdent.chercheIdent(ident);
			
			if(id instanceof IdConst) {
				System.out.println("Erreur: l'ident '" + ident + "' est une constante (ligne : " + Yaka.token.beginLine + ").");
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
				System.out.println("Erreur: probl�me de type (ligne : " + Yaka.token.beginLine + ").");
			}
		}
	}
}
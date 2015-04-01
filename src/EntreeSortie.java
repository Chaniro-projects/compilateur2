public class EntreeSortie implements Constante {
	public void lire(String ident) {
		Ident id = Yaka.tabIdent.chercheLocaux(ident);
		
		if(id instanceof IdConst) {
			// Erreur ?
		}
		else if(id instanceof IdVar) {
			Yaka.yvm.lireEnt(((IdVar) id).getOffset());
		}
	}
	
	public void ecrire() {
		eType expressionType = Yaka.expression.type();
		
		if (expressionType == eType.BOOLEEN) {
			Yaka.yvm.ecrireBool();
		}
		else if (expressionType == eType.ENTIER) {
			Yaka.yvm.ecrireEnt();
		}
	}
	
	public void ecrire(String chaine) {
		Yaka.yvm.ecrireChaine(chaine);
	}
	
	public void aLaLigne() {
		Yaka.yvm.aLaLigne();
	}
}
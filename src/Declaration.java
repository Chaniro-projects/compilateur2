public class Declaration implements Constante {
	private String identDeclaration;
	private int offset;
	
	
	public Declaration() {
		this.effacer();
	}
	
	
	public void setIdentDeclaration(String identDeclaration) {
		this.identDeclaration = identDeclaration;
	}
	
	public void createConstInt(int v) {
		if (Yaka.tabIdent.existeLocaux(this.identDeclaration)) {
			System.out.println("Erreur : l'ident '" + this.identDeclaration + "' existe déjà (ligne : " + Yaka.token.beginLine + ").");
		}
		
		Yaka.tabIdent.rangeLocaux(this.identDeclaration, new IdConst(this.identDeclaration, eType.ENTIER, v));
	}
	
	public void createConstBool(int b) {
		if (Yaka.tabIdent.existeLocaux(this.identDeclaration)) {
			System.out.println("Erreur : l'ident '" + this.identDeclaration + "' existe déjà (ligne : " + Yaka.token.beginLine + ").");
		}
		
		Yaka.tabIdent.rangeLocaux(this.identDeclaration, new IdConst(this.identDeclaration, eType.BOOLEEN, b));
	}
	
	public void createConstIdent(String ident) {
		if(!Yaka.tabIdent.existeLocaux(ident)) {
			System.out.println("Erreur: l'ident '" + ident + "' n'existe pas (ligne : " + Yaka.token.beginLine + ").");
		}
		else {
			IdConst id = (IdConst) Yaka.tabIdent.chercheLocaux(ident);
			if (id.getType() == Constante.eType.BOOLEEN) {
				createConstBool(id.getValeur());
			}
			else {
				createConstInt(id.getValeur());
			}
		}
	}
	
	public void createVar(String ident, eType type) {
		if (Yaka.tabIdent.existeLocaux(ident) || Yaka.tabIdent.existeGlobaux(ident)) {
			System.out.println("Erreur: l'ident '" + ident + "' existe deja (ligne:" + Yaka.token.beginLine + ").");
		}
		
		this.offset -= 2;
		Yaka.tabIdent.rangeLocaux(ident, new IdVar(ident, type, this.offset));
	}
	
	public int getVariable() {
		return Math.abs(this.offset);
	}
	
	public void effacer() {
		this.offset = 0;
	}
}
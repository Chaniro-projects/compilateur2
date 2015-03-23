public class Declaration implements Constante {
	private String lastIdent;
	private eType lastType;
	private int offset;
	
	public Declaration() {
		this.offset = 0;
	}
	
	public void createConstInt(int v) {
		if (Yaka.tabIdent.existeIdentLocaux(this.lastIdent)) {
			System.out.println("Erreur : l'ident '" + this.lastIdent + "' existe déjà (ligne : " + Yaka.token.beginLine + ").");
		}
		
		Yaka.tabIdent.rangeIdentLocaux(this.lastIdent, new IdConst(this.lastIdent, eType.ENTIER, v));
	}
	
	public void createConstBool(int b) {
		if (Yaka.tabIdent.existeIdentLocaux(this.lastIdent)) {
			System.out.println("Erreur : l'ident '" + this.lastIdent + "' existe déjà (ligne : " + Yaka.token.beginLine + ").");
		}
		
		Yaka.tabIdent.rangeIdentLocaux(this.lastIdent, new IdConst(this.lastIdent, eType.BOOLEEN, b));
	}
	
	public void createConstIdent(String ident) {
		if(!Yaka.tabIdent.existeIdentLocaux(ident)) {
			System.out.println("Erreur: l'ident '" + ident + "' n'existe pas (ligne : " + Yaka.token.beginLine + ").");
		}
		else {
			IdConst id = (IdConst) Yaka.tabIdent.chercheIdent(ident);
			if (id.getType() == Constante.eType.BOOLEEN) {
				createConstBool(id.getValeur());
			}
			else {
				createConstInt(id.getValeur());
			}
		}
	}
	
	public void createVar(String name) {
		if (Yaka.tabIdent.existeIdentLocaux(name)) {
			System.out.println("Erreur: l'ident '" + name + "' existe deja (ligne:" + Yaka.token.beginLine + ").");
		}
		
		this.offset -= 2;
		Yaka.tabIdent.rangeIdentLocaux(name, new IdVar(name, this.lastType, this.offset));
	}
	
	public void setLastIdent(String lastIdent) {
		this.lastIdent = lastIdent;
	}
	
	public void setLastType(eType lastType) {
		this.lastType = lastType;
	}
	
	public int getVariable() {
		return Math.abs(this.offset);
	}
}
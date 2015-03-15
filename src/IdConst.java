public class IdConst extends Ident {
	private int valeur;
	
	
	public IdConst(String nom, eType type, int valeur) {
		super(nom, type);
		this.valeur = valeur;
	}
	
	
	public int getValeur() {
		return this.valeur;
	}
}
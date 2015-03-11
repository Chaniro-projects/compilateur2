public class Ident implements Constante {
	protected String nom;
	protected eType type;
	protected int valeur;
	
	public Ident(String nom, eType type){
		this.nom = nom;
		this.type = type;
	}

	public String getNom() {
		return nom;
	}

	public eType getType() {
		return type;
	}

	public int getValeur() {
		return valeur;
	}
}

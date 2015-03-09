public class Ident implements Constante {
	private String nom;
	private eType type;
	
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
}

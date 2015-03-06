public class Ident {
	private String nom;
	private Constante.eType type;
	
	public Ident(String nom, Constante.eType type){
		this.nom = nom;
		this.type = type;
	}

	public String getNom() {
		return nom;
	}

	public Constante.eType getType() {
		return type;
	}
}

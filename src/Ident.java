
public class Ident {
	private String nom;
	private eType type;
	public static enum eType {
		BOOLEEN,
		ENTIER,
	}
	
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

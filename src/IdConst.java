
public class IdConst extends Ident implements Constante{

	private int valeur;
	
	public IdConst(String nom, eType type, int valeur) {
		super(nom, type);
		this.valeur = valeur;
		// TODO Auto-generated constructor stub
	}

	public int getValeur() {
		return valeur;
	}

}


public class IdVar extends Ident {
	
	private int offset;
	
	public IdVar(String nom, eType type, int offset) {
		super(nom, type);
		this.offset = offset;
		// TODO Auto-generated constructor stub
	}

	public int getValeur() {
		return offset;
	}
}

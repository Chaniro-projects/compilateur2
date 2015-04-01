public class IdVar extends Ident {
	private int offset;
	
	
	public IdVar(String nom, eType type, int offset) {
		super(nom, type);
		this.offset = offset;
	}
	
	
	public int getOffset() {
		return this.offset;
	}
	
	public int setOffset(int offset) {
		return this.offset = offset;
	}
}
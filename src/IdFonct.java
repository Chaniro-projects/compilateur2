import java.util.Stack;

public class IdFonct extends Ident {
	private Stack<eType> typeParametres;
	
	
	public IdFonct(String nom, eType type) {
		super(nom, type);
		this.typeParametres = new Stack<eType>();
	}
	
	public Stack<eType> getTypeParametres() {
		return this.typeParametres;
	}
	
	public void addTypeParametre(eType type) {
		this.typeParametres.push(type);
	}
	
	public int nbParametres() {
		return this.typeParametres.size();
	}
}
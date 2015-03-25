import java.util.Stack;

public class IdFonct extends Ident {
	private Stack<eType> arguments;
	
	
	public IdFonct(String nom, eType type) {
		super(nom, type);
		this.arguments = new Stack<eType>();
	}
	
	
	public Stack<eType> getArguments() {
		return this.arguments;
	}
	
	
	public void addArguments(eType argument) {
		this.arguments.push(argument);
	}
	
	public int nbArguments() {
		return this.arguments.size();
	}
}
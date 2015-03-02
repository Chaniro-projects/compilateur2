import java.util.*;


public class Expression {
	
	private Stack<Ident.eType> types;
	private Stack<Character> operateurs;
	
	public Expression(){
		operateurs = new Stack<Character>();
		types = new Stack<Ident.eType>();
	}
	
	public void ajoutType(Ident.eType type){
		types.add(type);
	}
	
	public void ajoutOp(Character c){
		operateurs.add(c);
	}
}

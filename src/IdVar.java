
public class IdVar extends Ident implements Constante{
	
	public IdVar(String nom, eType type, int offset) {
		super(nom, type);
		this.valeur = offset;
	}
}

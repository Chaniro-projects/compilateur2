import java.util.*;


public class TabIdent {
	private HashMap<String, Ident> table;
	
	public TabIdent(){
		table = new HashMap<String, Ident>();
	}
	
	
	public Ident chercheIdent(String clef)
	{
		return table.get(clef);
	}
	
	public boolean existeIdent(String clef)
	{
		return table.containsKey(clef);
	}
	
	public void rangeIdent(String clef, Ident id){
		if(!existeIdent(clef)){
			table.put(clef, id);
		}
	}
}

import java.util.*;


public class TabIdent {
	private LinkedHashMap<String, Ident> table;
	
	public TabIdent(){
		table = new LinkedHashMap<String, Ident>();
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

	public LinkedHashMap<String, Ident> getTable() {
		return table;
	}

	public void setTable(LinkedHashMap<String, Ident> table) {
		this.table = table;
	}
}

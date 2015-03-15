import java.util.LinkedHashMap;

public class TabIdent {
	private LinkedHashMap<String, Ident> table;
	
	public TabIdent() {
		this.table = new LinkedHashMap<String, Ident>();
	}
	
	
	public Ident chercheIdent(String clef) {
		return this.table.get(clef);
	}
	
	public boolean existeIdent(String clef) {
		return this.table.containsKey(clef);
	}
	
	public void rangeIdent(String clef, Ident id) {
		if (!this.existeIdent(clef)) {
			this.table.put(clef, id);
		}
	}
}
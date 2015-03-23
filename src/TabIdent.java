import java.util.LinkedHashMap;
import java.util.Map;

public class TabIdent {
	private LinkedHashMap<String, Ident> globaux;
	private LinkedHashMap<String, Ident> locaux;
	
	public TabIdent() {
		this.globaux = new LinkedHashMap<String, Ident>();
		this.locaux = new LinkedHashMap<String, Ident>();
	}
	
	public Ident chercheIdent(String clef) {
		if (this.locaux.containsKey(clef)) {
			return this.locaux.get(clef);
		}
		else {
			return this.globaux.get(clef);
		}
	}
	
	public boolean existeIdentLocaux(String clef) {
		return this.locaux.containsKey(clef);
	}
	
	public boolean existeIdentGlobaux(String clef) {
		return this.globaux.containsKey(clef);
	}
	
	public void rangeIdentLocaux(String clef, Ident id) {
		if (!this.existeIdentLocaux(clef)) {
			this.locaux.put(clef, id);
		}
	}
	
	public void rangeIdentGlobaux(String clef, Ident id) {
		if (!this.existeIdentGlobaux(clef)) {
			this.globaux.put(clef, id);
		}
	}
	
	public String toString() {
		
		String str = "GLOBAUX\n";
		// Globaux
		for(Map.Entry<String, Ident> var : globaux.entrySet()) {
			str += var + "\n";
		}
		
		str += "\n\nLOCAUX\n";
		// Locaux
		for(Map.Entry<String, Ident> var : locaux.entrySet()) {
			str += var + "\n";
		}
		
		return str;
	}
}
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TabIdent {
	private LinkedHashMap<String, Ident> globaux;
	private LinkedHashMap<String, Ident> locaux;
	
	
	public TabIdent() {
		this.globaux = new LinkedHashMap<String, Ident>();
		this.locaux = new LinkedHashMap<String, Ident>();
	}
	
	
	public Ident chercheLocaux(String clef) {
		return this.locaux.get(clef);
	}
	
	public boolean existeLocaux(String clef) {
		return this.locaux.containsKey(clef);
	}
	
	public void rangeLocaux(String clef, Ident id) {
		if (!this.existeLocaux(clef)) {
			this.locaux.put(clef, id);
		}
	}
	
	public void effacerLocaux() {
		this.locaux.clear();
	}
	
	public Ident chercheGlobaux(String clef) {
		return this.globaux.get(clef);
	}
	
	public boolean existeGlobaux(String clef) {
		return this.globaux.containsKey(clef);
	}
	
	public void rangeGlobaux(String clef, Ident id) {
		if (!this.existeGlobaux(clef)) {
			this.globaux.put(clef, id);
		}
	}
	
	public void setOffsetParametresFonctionCourante(int nbParametres) {
		int placeRetourEtAncienBp = 4;
		
		Set<Entry<String, Ident>> set = this.locaux.entrySet();
		Iterator<Entry<String, Ident>> it = set.iterator();
		while (it.hasNext()) {
			Map.Entry<String, Ident> entree = it.next();
			IdVar id = (IdVar) entree.getValue();
			id.setOffset(2 * nbParametres + placeRetourEtAncienBp - 2 * id.getOffset());
		}
	}
}
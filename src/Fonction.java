import java.util.Stack;

public class Fonction implements Constante {
	private eType fonctionCouranteType;
	private IdFonct fonctionCourante;
	
	private Stack<IdFonct> fonctionsAppelees;
	private Stack<Stack<eType>> fonctionsAppeleesParametres;
	
	public Fonction() {
		this.fonctionsAppelees = new Stack<IdFonct>();
		this.fonctionsAppeleesParametres = new Stack<Stack<eType>>();
	}
	
	public void setFonctionCouranteType(eType type) {
		this.fonctionCouranteType = type;
	}
	
	public void setFonctionCourante(String ident) {
		this.fonctionCourante = new IdFonct(ident, this.fonctionCouranteType);
	}
}

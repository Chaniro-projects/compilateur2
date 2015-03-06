import java.io.*;

public class YVM {
	private OutputStream fo;
	
	public YVM(String nom) {
		this.fo = Ecriture.ouvrir(nom);
	}
	
	public void fermer() {
		Ecriture.fermer(fo);
	}
	
	
	public void iadd() {
		Ecriture.ecrireStringln(fo, "iadd");
	}
	
	public void isub() {
		Ecriture.ecrireStringln(fo, "isub");
	}

	public void imul() {
		Ecriture.ecrireStringln(fo, "imul");
	}
	
	public void idiv() {
		Ecriture.ecrireStringln(fo, "idiv");
	}
	
	public void inot() {
		Ecriture.ecrireStringln(fo, "inot");
	}
	
	public void ineg() {
		Ecriture.ecrireStringln(fo, "ineg");
	}
	
	public void ior() {
		Ecriture.ecrireStringln(fo, "ior");
	}
	
	public void iand() {
		Ecriture.ecrireStringln(fo, "iand");
	}
	
	public void iinf() {
		Ecriture.ecrireStringln(fo, "iinf");
	}
	
	public void isup() {
		Ecriture.ecrireStringln(fo, "isup");
	}
	
	public void iinfegal() {
		Ecriture.ecrireStringln(fo, "iinfegal");
	}
	
	public void isupegal() {
		Ecriture.ecrireStringln(fo, "isupegal");
	}
	
	public void iegal() {
		Ecriture.ecrireStringln(fo, "iegal");
	}
	
	public void idiff() {
		Ecriture.ecrireStringln(fo, "idiff");
	}
	
	public void iload(int offset) {
		Ecriture.ecrireStringln(fo, "iload " + offset);
	}
	
	public void istore(int offset) {
		Ecriture.ecrireStringln(fo, "istore " + offset);
	}
	
	public void iconst(int valeur) {
		Ecriture.ecrireStringln(fo, "iconst " + valeur);
	}
	
	public void ifeq() {
		Ecriture.ecrireStringln(fo, "ifeq");
	}
	
	public void igoto() {
		Ecriture.ecrireStringln(fo, "goto");
	}
	
	public void ouvrePrinc(int variable) {
		Ecriture.ecrireStringln(fo, "ouvrePrinc " + 2 * variable);
	}
	
	public void entete() {
		Ecriture.ecrireStringln(fo, "entete");
	}
	
	public void queue() {
		Ecriture.ecrireStringln(fo, "queue");
	}
}

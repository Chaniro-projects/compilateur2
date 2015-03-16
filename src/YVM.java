import java.io.*;
import java.util.Stack;

public class YVM implements Constante {
	protected OutputStream fo;
	
	
	public YVM() {
		this.fo = System.out;
	}
	
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
	
	public void entete() {
		Ecriture.ecrireStringln(fo, "entete");
	}
	
	public void ouvrePrinc(int variable) {
		Ecriture.ecrireStringln(fo, "ouvrePrinc " + variable);
	}
	
	public void queue() {
		Ecriture.ecrireStringln(fo, "queue");
	}
	
	public void aLaLigne() {
		Ecriture.ecrireStringln(fo, "aLaLigne");
	}
	
	public void ecrireEnt() {
		Ecriture.ecrireStringln(fo, "ecrireEnt");
	}
	
	public void lireEnt(int offset) {
		Ecriture.ecrireStringln(fo, "lireEnt " + offset);
	}
	
	public void ecrireChaine(String chaine) {
		Ecriture.ecrireStringln(fo, "ecrireChaine " + chaine + "");
	}
	
	public void ecrireBool() {
		Ecriture.ecrireStringln(fo, "ecrireBool");
	}
	
	public void faireIteration() {
		Ecriture.ecrireStringln(fo, "FAIRE" + Yaka.iteration.lastElement() + ":");
	}
	
	public void faitIteration() {
		Ecriture.ecrireStringln(fo, "FAIT" + Yaka.iteration.lastElement() + ":");
	}
	
	public void iffaux() {
		Ecriture.ecrireStringln(fo, "iffaux FAIT" + Yaka.iteration.lastElement());
	}
	
	public void igoto(String etiquette) {
		Ecriture.ecrireStringln(fo, "goto " + etiquette);
	}
}
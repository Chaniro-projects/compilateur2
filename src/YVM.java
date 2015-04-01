import java.io.*;

public class YVM implements Constante {
	protected OutputStream fo;
	
	
	public YVM() {
		this.fo = System.out;
	}
	
	public YVM(String nom) {
		this.fo = Ecriture.ouvrir(nom);
	}
	
	
	public void fermer() {
		Ecriture.fermer(this.fo);
	}
	
	
	public void iadd() {
		Ecriture.ecrireStringln(this.fo, "iadd");
	}
	
	public void isub() {
		Ecriture.ecrireStringln(this.fo, "isub");
	}
	
	public void imul() {
		Ecriture.ecrireStringln(this.fo, "imul");
	}
	
	public void idiv() {
		Ecriture.ecrireStringln(this.fo, "idiv");
	}
	
	public void inot() {
		Ecriture.ecrireStringln(this.fo, "inot");
	}
	
	public void ineg() {
		Ecriture.ecrireStringln(this.fo, "ineg");
	}
	
	public void ior() {
		Ecriture.ecrireStringln(this.fo, "ior");
	}
	
	public void iand() {
		Ecriture.ecrireStringln(this.fo, "iand");
	}
	
	public void iinf() {
		Ecriture.ecrireStringln(this.fo, "iinf");
	}
	
	public void isup() {
		Ecriture.ecrireStringln(this.fo, "isup");
	}
	
	public void iinfegal() {
		Ecriture.ecrireStringln(this.fo, "iinfegal");
	}
	
	public void isupegal() {
		Ecriture.ecrireStringln(this.fo, "isupegal");
	}
	
	public void iegal() {
		Ecriture.ecrireStringln(this.fo, "iegal");
	}
	
	public void idiff() {
		Ecriture.ecrireStringln(this.fo, "idiff");
	}
	
	public void iload(int offset) {
		Ecriture.ecrireStringln(this.fo, "iload " + offset);
	}
	
	public void istore(int offset) {
		Ecriture.ecrireStringln(this.fo, "istore " + offset);
	}
	
	public void iconst(int valeur) {
		Ecriture.ecrireStringln(this.fo, "iconst " + valeur);
	}
	
	public void entete() {
		Ecriture.ecrireStringln(this.fo, "entete");
	}
	
	public void ouvrePrinc(int variable) {
		Ecriture.ecrireStringln(this.fo, "ouvrePrinc " + variable);
	}
	
	public void queue() {
		Ecriture.ecrireStringln(this.fo, "queue");
	}
	
	public void aLaLigne() {
		Ecriture.ecrireStringln(this.fo, "aLaLigne");
	}
	
	public void ecrireEnt() {
		Ecriture.ecrireStringln(this.fo, "ecrireEnt");
	}
	
	public void lireEnt(int offset) {
		Ecriture.ecrireStringln(this.fo, "lireEnt " + offset);
	}
	
	public void ecrireChaine(String chaine) {
		Ecriture.ecrireStringln(this.fo, "ecrireChaine " + chaine);
	}
	
	public void ecrireBool() {
		Ecriture.ecrireStringln(this.fo, "ecrireBool");
	}
	
	public void etiquette(String etiquette) {
		Ecriture.ecrireStringln(this.fo, etiquette + ":");
	}
	
	public void iffaux(String etiquette) {
		Ecriture.ecrireStringln(this.fo, "iffaux " + etiquette);
	}
	
	public void igoto(String etiquette) {
		Ecriture.ecrireStringln(this.fo, "goto " + etiquette);
	}
	
	public void ouvreBloc(int variable) {
		Ecriture.ecrireStringln(this.fo, "ouvbloc " + variable);
	}
	
	public void fermeBloc(int variable) {
		Ecriture.ecrireStringln(this.fo, "fermebloc " + variable);
	}
	
	public void ireturn(int offset) {
		Ecriture.ecrireStringln(this.fo, "ireturn " + offset);
	}
	
	public void reserveRetour() {
		Ecriture.ecrireStringln(this.fo, "reserveRetour");
	}
	
	public void call(String etiquette) {
		Ecriture.ecrireStringln(this.fo, "call " + etiquette);
	}
}
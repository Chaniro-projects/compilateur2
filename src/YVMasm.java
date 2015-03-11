public class YVMasm extends YVM implements Constante {
	public YVMasm(String nom) {
		super(nom);
	}
	
	public YVMasm() {
		super();
	}
	
	public void fermer() {
		Ecriture.fermer(fo);
	}
	
	public void iadd() {
		Ecriture.ecrireString(fo, ";");
		super.iadd();
		Ecriture.ecrireStringln(fo, "pop bx\npop ax\nadd ax,bx\npush ax\n");
	}
	
	public void isub() {
		Ecriture.ecrireString(fo, ";");
		super.isub();
		Ecriture.ecrireStringln(fo, "pop bx\npop ax\nsub ax,bx\npush ax\n");
	}

	public void imul() {
		Ecriture.ecrireString(fo, ";");
		super.imul();
		Ecriture.ecrireStringln(fo, "pop bx\npop ax\nimul bx\npush ax\n");
	}
	
	public void idiv() {
		Ecriture.ecrireString(fo, ";");
		super.idiv();
		Ecriture.ecrireStringln(fo, "pop bx\npop ax\ncwd\nidiv bx\npush ax\n");
	}
	
	public void inot() {
		Ecriture.ecrireString(fo, ";");
		super.inot();
		Ecriture.ecrireStringln(fo, "pop ax\ncmp ax,0\njne $+6\npush -1\njmp $+4push 0\n");
	}
	
	public void ineg() {
		Ecriture.ecrireString(fo, ";");
		super.ineg();
		Ecriture.ecrireStringln(fo, "pop bx\nmov ax,0\nsub ax,bx\npush ax\n");
	}
	
	public void ior() {
		Ecriture.ecrireString(fo, ";");
		super.ior();
		Ecriture.ecrireStringln(fo, "pop bx\npox ax\nor ax,bx\npush ax\n");
	}
	
	public void iand() {
		Ecriture.ecrireString(fo, ";");
		super.iand();
		Ecriture.ecrireStringln(fo, "pop bx\npox ax\nand ax,bx\npush ax\n");
	}
	
	public void iinf() {
		Ecriture.ecrireString(fo, ";");
		super.iinf();
		Ecriture.ecrireStringln(fo, "pop bx\npop ax\ncpm ax,bx\njge $+6\npush -1\njmp $+4\npush 0\n");
	}
	
	public void isup() {
		Ecriture.ecrireString(fo, ";");
		super.isup();
		Ecriture.ecrireStringln(fo, "pop bx\npop ax\ncpm ax,bx\njle $+6\npush -1\njmp $+4\npush 0\n");
	}
	
	public void iinfegal() {
		Ecriture.ecrireString(fo, ";");
		super.iinfegal();
		Ecriture.ecrireStringln(fo, "pop bx\npop ax\ncpm ax,bx\njg $+6\npush -1\njmp $+4\npush 0\n");
	}
	
	public void isupegal() {
		Ecriture.ecrireString(fo, ";");
		super.isupegal();
		Ecriture.ecrireStringln(fo, "pop bx\npop ax\ncpm ax,bx\njl $+6\npush -1\njmp $+4\npush 0\n");
	}
	
	public void iegal() {
		Ecriture.ecrireString(fo, ";");
		super.iegal();
		Ecriture.ecrireStringln(fo, "pop bx\npop ax\ncpm ax,bx\njne $+6\npush -1\njmp $+4\npush 0\n");
	}
	
	public void idiff() {
		Ecriture.ecrireString(fo, ";");
		super.idiff();
		Ecriture.ecrireStringln(fo, "pop bx\npop ax\ncpm ax,bx\nje $+6\npush -1\njmp $+4\npush 0\n");
	}
	
	public void iload(int offset) {
		Ecriture.ecrireString(fo, ";");
		super.iload(offset);
		Ecriture.ecrireStringln(fo, "push word ptr [bp" + offset + "]\n");
	}
	
	public void istore(int offset) {
		Ecriture.ecrireString(fo, ";");
		super.istore(offset);
		Ecriture.ecrireStringln(fo, "pop ax\nmov word ptr [bp" + offset + "],ax\n");
	}
	
	public void iconst(int valeur) {
		Ecriture.ecrireString(fo, ";");
		super.iconst(valeur);
		Ecriture.ecrireStringln(fo, "push " + valeur + "\n");
	}
	
	// Revoir le fonctionnement de ifeq et igoto
	public void ifeq(String etiquette) {
		Ecriture.ecrireString(fo, ";");
		super.ifeq(etiquette);
		Ecriture.ecrireString(fo, "ifeq " + etiquette + "\n");
	}
	
	public void igoto(String etiquette) {
		Ecriture.ecrireString(fo, ";");
		super.igoto(etiquette);
		Ecriture.ecrireStringln(fo, "jmp " + etiquette + "\n");
	}
	
	public void ouvrePrinc(int variable) {
		Ecriture.ecrireString(fo, ";");
		super.ouvrePrinc(variable);
		Ecriture.ecrireStringln(fo, "mov bp,sp\nsub sp," + 2 * variable + "\n");
	}
	
	public void entete(){
		Ecriture.ecrireString(fo, ";");
		super.entete();
		Ecriture.ecrireStringln(fo,".model SMALL\n.586\n");
	}
	
	public void queue() {
		Ecriture.ecrireString(fo, ";");
		super.queue();
		Ecriture.ecrireStringln(fo, "nop\nEXITCODE\nend debut");
	}
}

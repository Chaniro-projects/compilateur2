public class YVMasm extends YVM {
	private int nbMessage;
	
	
	public YVMasm() {
		super();
		this.nbMessage = 0;
	}
	
	public YVMasm(String nom) {
		super(nom);
		this.nbMessage = 0;
	}
	
	
	public void iadd() {
		Ecriture.ecrireString(fo, "\t;");
		super.iadd();
		Ecriture.ecrireStringln(fo, "\tpop bx\n\tpop ax\n\tadd ax,bx\n\tpush ax\n");
	}
	
	public void isub() {
		Ecriture.ecrireString(fo, "\t;");
		super.isub();
		Ecriture.ecrireStringln(fo, "\tpop bx\n\tpop ax\n\tsub ax,bx\n\tpush ax\n");
	}
	
	public void imul() {
		Ecriture.ecrireString(fo, "\t;");
		super.imul();
		Ecriture.ecrireStringln(fo, "\tpop bx\n\tpop ax\n\timul bx\n\tpush ax\n");
	}
	
	public void idiv() {
		Ecriture.ecrireString(fo, "\t;");
		super.idiv();
		Ecriture.ecrireStringln(fo, "\tpop bx\n\tpop ax\n\tcwd\n\tidiv bx\n\tpush ax\n");
	}
	
	public void inot() {
		Ecriture.ecrireString(fo, "\t;");
		super.inot();
		Ecriture.ecrireStringln(fo, "\tpop ax\n\tcmp ax,0\n\tjne $+6\n\tpush -1\n\tjmp $+4push 0\n");
	}
	
	public void ineg() {
		Ecriture.ecrireString(fo, "\t;");
		super.ineg();
		Ecriture.ecrireStringln(fo, "\tpop bx\n\tmov ax,0\n\tsub ax,bx\n\tpush ax\n");
	}
	
	public void ior() {
		Ecriture.ecrireString(fo, "\t;");
		super.ior();
		Ecriture.ecrireStringln(fo, "\tpop bx\n\tpop ax\n\tor ax,bx\n\tpush ax\n");
	}
	
	public void iand() {
		Ecriture.ecrireString(fo, "\t;");
		super.iand();
		Ecriture.ecrireStringln(fo, "\tpop bx\n\tpop ax\n\tand ax,bx\n\tpush ax\n");
	}
	
	public void iinf() {
		Ecriture.ecrireString(fo, "\t;");
		super.iinf();
		Ecriture.ecrireStringln(fo, "\tpop bx\n\tpop ax\n\tcmp ax,bx\n\tjge $+6\n\tpush -1\n\tjmp $+4\n\tpush 0\n");
	}
	
	public void isup() {
		Ecriture.ecrireString(fo, "\t;");
		super.isup();
		Ecriture.ecrireStringln(fo, "\tpop bx\n\tpop ax\n\tcmp ax,bx\n\tjle $+6\n\tpush -1\n\tjmp $+4\n\tpush 0\n");
	}
	
	public void iinfegal() {
		Ecriture.ecrireString(fo, "\t;");
		super.iinfegal();
		Ecriture.ecrireStringln(fo, "\tpop bx\n\tpop ax\n\tcmp ax,bx\n\tjg $+6\n\tpush -1\n\tjmp $+4\n\tpush 0\n");
	}
	
	public void isupegal() {
		Ecriture.ecrireString(fo, "\t;");
		super.isupegal();
		Ecriture.ecrireStringln(fo, "\tpop bx\n\tpop ax\n\tcmp ax,bx\n\tjl $+6\n\tpush -1\n\tjmp $+4\n\tpush 0\n");
	}
	
	public void iegal() {
		Ecriture.ecrireString(fo, "\t;");
		super.iegal();
		Ecriture.ecrireStringln(fo, "\tpop bx\n\tpop ax\n\tcmp ax,bx\n\tjne $+6\n\tpush -1\n\tjmp $+4\n\tpush 0\n");
	}
	
	public void idiff() {
		Ecriture.ecrireString(fo, "\t;");
		super.idiff();
		Ecriture.ecrireStringln(fo, "\tpop bx\n\tpop ax\n\tcmp ax,bx\n\tje $+6\n\tpush -1\n\tjmp $+4\n\tpush 0\n");
	}
	
	public void iload(int offset) {
		Ecriture.ecrireString(fo, "\t;");
		super.iload(offset);
		Ecriture.ecrireStringln(fo, "\tpush word ptr [bp" + offset + "]\n");
	}
	
	public void istore(int offset) {
		Ecriture.ecrireString(fo, "\t;");
		super.istore(offset);
		Ecriture.ecrireStringln(fo, "\tpop ax\n\tmov word ptr [bp" + offset + "],ax\n");
	}
	
	public void iconst(int valeur) {
		Ecriture.ecrireString(fo, "\t;");
		super.iconst(valeur);
		Ecriture.ecrireStringln(fo, "\tpush word ptr " + valeur + "\n");
	}
	
	public void entete(){
		Ecriture.ecrireString(fo, ";");
		super.entete();
		Ecriture.ecrireStringln(fo, "extrn lirent:proc, ecrent:proc\nextrn ecrbool:proc\nextrn ecrch:proc, ligsuiv:proc");
		Ecriture.ecrireStringln(fo, ".model SMALL\n.586\n\n.CODE\ndebut:\n\tSTARTUPCODE\n");
	}
	
	public void ouvrePrinc(int variable) {
		Ecriture.ecrireString(fo, "\t;");
		super.ouvrePrinc(variable);
		Ecriture.ecrireStringln(fo, "\tmov bp,sp\n\tsub sp," + variable + "\n");
	}
	
	public void queue() {
		Ecriture.ecrireString(fo, "\t;");
		super.queue();
		Ecriture.ecrireStringln(fo, "\tnop\n\tEXITCODE\n\tend debut");
	}
	
	public void aLaLigne() {
		Ecriture.ecrireString(fo, "\t;");
		super.aLaLigne();
		Ecriture.ecrireStringln(fo, "\tcall ligsuiv\n");
	}
	
	public void ecrireEnt() {
		Ecriture.ecrireString(fo, "\t;");
		super.ecrireEnt();
		Ecriture.ecrireStringln(fo, "\tcall ecrent\n");
	}
	
	public void lireEnt(int offset) {
		Ecriture.ecrireString(fo, "\t;");
		super.lireEnt(offset);
		Ecriture.ecrireStringln(fo, "\tlea dx,[bp" + offset + "]\n\tpush dx\n\tcall lirent\n");
	}
	
	public void ecrireChaine(String chaine) {
		Ecriture.ecrireString(fo, "\t;");
		super.ecrireChaine(chaine);
		Ecriture.ecrireStringln(fo, ".DATA\nmess" + this.nbMessage + " DB \"" + chaine.substring(1, chaine.length() - 1) + "$\"\n.CODE\n\tlea dx,mess" + this.nbMessage + "\n\tpush dx\n\tcall ecrch\n");
		this.nbMessage++;
	}
	
	public void ecrireBool() {
		Ecriture.ecrireString(fo, "\t;");
		super.ecrireBool();
		Ecriture.ecrireStringln(fo, "\tcall ecrbool\n");
	}
	
	public void faireIteration() {
		super.faireIteration();
	}
	
	public void faitIteration() {
		super.faireIteration();
	}
	
	public void iffaux() {
		Ecriture.ecrireString(fo, "\t;");
		super.iffaux();
		Ecriture.ecrireStringln(fo, "\tpop ax\n\tcmpax,0\n\tje FAIT" + Yaka.iteration.lastElement() + "\n");
	}
	
	public void igoto(String etiquette) {
		Ecriture.ecrireString(fo, "\t;");
		super.igoto(etiquette);
		Ecriture.ecrireStringln(fo, "jmp " + etiquette);
	}
}
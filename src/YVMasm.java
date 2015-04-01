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
		Ecriture.ecrireString(this.fo, "\t;");
		super.iadd();
		Ecriture.ecrireStringln(this.fo, "\tpop bx\n\tpop ax\n\tadd ax,bx\n\tpush ax\n");
	}
	
	public void isub() {
		Ecriture.ecrireString(this.fo, "\t;");
		super.isub();
		Ecriture.ecrireStringln(this.fo, "\tpop bx\n\tpop ax\n\tsub ax,bx\n\tpush ax\n");
	}
	
	public void imul() {
		Ecriture.ecrireString(this.fo, "\t;");
		super.imul();
		Ecriture.ecrireStringln(this.fo, "\tpop bx\n\tpop ax\n\timul bx\n\tpush ax\n");
	}
	
	public void idiv() {
		Ecriture.ecrireString(this.fo, "\t;");
		super.idiv();
		Ecriture.ecrireStringln(this.fo, "\tpop bx\n\tpop ax\n\tcwd\n\tidiv bx\n\tpush ax\n");
	}
	
	public void inot() {
		Ecriture.ecrireString(this.fo, "\t;");
		super.inot();
		Ecriture.ecrireStringln(this.fo, "\tpop ax\n\tcmp ax,0\n\tjne $+6\n\tpush -1\n\tjmp $+4push 0\n");
	}
	
	public void ineg() {
		Ecriture.ecrireString(this.fo, "\t;");
		super.ineg();
		Ecriture.ecrireStringln(this.fo, "\tpop bx\n\tmov ax,0\n\tsub ax,bx\n\tpush ax\n");
	}
	
	public void ior() {
		Ecriture.ecrireString(this.fo, "\t;");
		super.ior();
		Ecriture.ecrireStringln(this.fo, "\tpop bx\n\tpop ax\n\tor ax,bx\n\tpush ax\n");
	}
	
	public void iand() {
		Ecriture.ecrireString(this.fo, "\t;");
		super.iand();
		Ecriture.ecrireStringln(this.fo, "\tpop bx\n\tpop ax\n\tand ax,bx\n\tpush ax\n");
	}
	
	public void iinf() {
		Ecriture.ecrireString(this.fo, "\t;");
		super.iinf();
		Ecriture.ecrireStringln(this.fo, "\tpop bx\n\tpop ax\n\tcmp ax,bx\n\tjge $+6\n\tpush -1\n\tjmp $+4\n\tpush 0\n");
	}
	
	public void isup() {
		Ecriture.ecrireString(this.fo, "\t;");
		super.isup();
		Ecriture.ecrireStringln(this.fo, "\tpop bx\n\tpop ax\n\tcmp ax,bx\n\tjle $+6\n\tpush -1\n\tjmp $+4\n\tpush 0\n");
	}
	
	public void iinfegal() {
		Ecriture.ecrireString(this.fo, "\t;");
		super.iinfegal();
		Ecriture.ecrireStringln(this.fo, "\tpop bx\n\tpop ax\n\tcmp ax,bx\n\tjg $+6\n\tpush -1\n\tjmp $+4\n\tpush 0\n");
	}
	
	public void isupegal() {
		Ecriture.ecrireString(this.fo, "\t;");
		super.isupegal();
		Ecriture.ecrireStringln(this.fo, "\tpop bx\n\tpop ax\n\tcmp ax,bx\n\tjl $+6\n\tpush -1\n\tjmp $+4\n\tpush 0\n");
	}
	
	public void iegal() {
		Ecriture.ecrireString(this.fo, "\t;");
		super.iegal();
		Ecriture.ecrireStringln(this.fo, "\tpop bx\n\tpop ax\n\tcmp ax,bx\n\tjne $+6\n\tpush -1\n\tjmp $+4\n\tpush 0\n");
	}
	
	public void idiff() {
		Ecriture.ecrireString(this.fo, "\t;");
		super.idiff();
		Ecriture.ecrireStringln(this.fo, "\tpop bx\n\tpop ax\n\tcmp ax,bx\n\tje $+6\n\tpush -1\n\tjmp $+4\n\tpush 0\n");
	}
	
	public void iload(int offset) {
		Ecriture.ecrireString(this.fo, "\t;");
		super.iload(offset);
		Ecriture.ecrireStringln(this.fo, "\tpush word ptr [bp" + ((offset >= 0) ? "+" : "") + offset + "]\n");
	}
	
	public void istore(int offset) {
		Ecriture.ecrireString(this.fo, "\t;");
		super.istore(offset);
		Ecriture.ecrireStringln(this.fo, "\tpop ax\n\tmov word ptr [bp" + ((offset >= 0) ? "+" : "") + offset + "],ax\n");
	}
	
	public void iconst(int valeur) {
		Ecriture.ecrireString(this.fo, "\t;");
		super.iconst(valeur);
		Ecriture.ecrireStringln(this.fo, "\tpush word ptr " + valeur + "\n");
	}
	
	public void entete(){
		Ecriture.ecrireString(this.fo, ";");
		super.entete();
		Ecriture.ecrireStringln(this.fo, "extrn lirent:proc, ecrent:proc\nextrn ecrbool:proc\nextrn ecrch:proc, ligsuiv:proc");
		Ecriture.ecrireStringln(this.fo, ".model SMALL\n.586\n\n.CODE\n");
	}
	
	public void ouvrePrinc(int variable) {
		Ecriture.ecrireString(this.fo, "\t;");
		super.ouvrePrinc(variable);
		Ecriture.ecrireStringln(this.fo, "\tmov bp,sp\n\tsub sp," + variable + "\n");
	}
	
	public void queue() {
		Ecriture.ecrireString(this.fo, "\t;");
		super.queue();
		Ecriture.ecrireStringln(this.fo, "\tnop\n\tEXITCODE\n\tend");
	}
	
	public void aLaLigne() {
		Ecriture.ecrireString(this.fo, "\t;");
		super.aLaLigne();
		Ecriture.ecrireStringln(this.fo, "\tcall ligsuiv\n");
	}
	
	public void ecrireEnt() {
		Ecriture.ecrireString(this.fo, "\t;");
		super.ecrireEnt();
		Ecriture.ecrireStringln(this.fo, "\tcall ecrent\n");
	}
	
	public void lireEnt(int offset) {
		Ecriture.ecrireString(this.fo, "\t;");
		super.lireEnt(offset);
		Ecriture.ecrireStringln(this.fo, "\tlea dx,[bp" + ((offset >= 0) ? "+" : "") + offset + "]\n\tpush dx\n\tcall lirent\n");
	}
	
	public void ecrireChaine(String chaine) {
		Ecriture.ecrireString(this.fo, "\t;");
		super.ecrireChaine(chaine);
		Ecriture.ecrireStringln(this.fo, ".DATA\nmess" + this.nbMessage + " DB \"" + chaine.substring(1, chaine.length() - 1) + "$\"\n.CODE\n\tlea dx,mess" + this.nbMessage + "\n\tpush dx\n\tcall ecrch\n");
		this.nbMessage++;
	}
	
	public void ecrireBool() {
		Ecriture.ecrireString(this.fo, "\t;");
		super.ecrireBool();
		Ecriture.ecrireStringln(this.fo, "\tcall ecrbool\n");
	}
	
	public void etiquette(String etiquette) {
		if (etiquette == "main") {
			Ecriture.ecrireStringln(this.fo, "debut:\n\tSTARTUPCODE\n");
		}
		super.etiquette(etiquette);
	}
	
	public void iffaux(String etiquette) {
		Ecriture.ecrireString(this.fo, "\t;");
		super.iffaux(etiquette);
		Ecriture.ecrireStringln(this.fo, "\tpop ax\n\tcmp ax,0\n\tje " + etiquette + "\n");
	}
	
	public void igoto(String etiquette) {
		Ecriture.ecrireString(this.fo, "\t;");
		super.igoto(etiquette);
		Ecriture.ecrireStringln(this.fo, "\tjmp " + etiquette + "\n");
	}
	
	public void ouvreBloc(int variable) {
		Ecriture.ecrireString(this.fo, "\t;");
		super.ouvreBloc(variable);
		Ecriture.ecrireStringln(this.fo, "\tenter " + variable + ",0\n");
	}
	
	public void fermeBloc(int variable) {
		Ecriture.ecrireString(this.fo, "\t;");
		super.fermeBloc(variable);
		Ecriture.ecrireStringln(this.fo, "\tleave\n\tret " + variable + "\n");
	}
	
	public void ireturn(int offset) {
		Ecriture.ecrireString(this.fo, "\t;");
		super.ireturn(offset);
		Ecriture.ecrireStringln(this.fo, "\tpop ax\n\tmov [bp" + ((offset >= 0) ? "+" : "") + offset + "],ax\n");
	}
	
	public void reserveRetour() {
		Ecriture.ecrireString(this.fo, "\t;");
		super.reserveRetour();
		Ecriture.ecrireStringln(this.fo, "\tsub sp,2\n");
	}
	
	public void call(String etiquette) {
		Ecriture.ecrireString(this.fo, "\t;");
		super.call(etiquette);
		Ecriture.ecrireStringln(this.fo, "\tcall " + etiquette + "\n");
	}
}
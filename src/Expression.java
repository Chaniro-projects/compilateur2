import java.util.Stack;

public class Expression implements Constante {
	private Stack<eType> types;
	private Stack<eOperande> operateurs;
	
	
	public Expression() {
		this.operateurs = new Stack<eOperande>();
		this.types = new Stack<eType>();
	}
	
	
	public void ajoutType(eType type, int v) {
		this.types.push(type);
		Yaka.yvm.iconst(v);
	}
	
	public void ajoutTypeFromVar(String ident) {
		if (!Yaka.tabIdent.existeIdentLocaux(ident)) {
			System.out.println("Erreur: l'ident '" + ident + "' n'existe pas (ligne : " + Yaka.token.beginLine + ").");
			this.types.push(eType.ERREUR);
		}
		else {
			Ident id = Yaka.tabIdent.chercheIdent(ident);
			this.types.push(id.getType());
			
			if(id instanceof IdConst) {
				Yaka.yvm.iconst(((IdConst) id).getValeur());
			}
			else if(id instanceof IdVar) {
				Yaka.yvm.iload(((IdVar) id).getOffset());
			}
		}
	}
	
	public void ajoutOperateur(eOperande c) {
		this.operateurs.push(c);
	}
	
	public void evaluation() {
		eType type1 = types.pop();
		eOperande op = operateurs.pop();
		
		if (op == eOperande.NEG) {
			if (controleOperateur(op, type1)) Yaka.yvm.ineg();
		}
		else if(op == eOperande.NOT) {
			if (controleOperateur(op, type1)) Yaka.yvm.inot();
		}
		else
		{
			eType type2 = types.pop();
			if (type1 != type2) {
				types.push(eType.ERREUR);
			}
			else {
				switch (op) {
					case ADD: if (controleOperateur(op, type1)) Yaka.yvm.iadd();	break;
					case SUB: if (controleOperateur(op, type1)) Yaka.yvm.isub(); break;
					case MUL: if (controleOperateur(op, type1)) Yaka.yvm.imul();	break;
					case DIV: if (controleOperateur(op, type1)) Yaka.yvm.idiv(); break;
					case INF: if (controleOperateur(op, type1)) Yaka.yvm.iinf();	break;
					case INFEGAL: if (controleOperateur(op, type1)) Yaka.yvm.iinfegal();	break;
					case SUP: if (controleOperateur(op, type1)) Yaka.yvm.isup(); break;
					case SUPEGAL: if (controleOperateur(op, type1)) Yaka.yvm.isupegal(); break;
					case EGAL: if (controleOperateur(op, type1)) Yaka.yvm.iegal(); break;
					case DIFF: if (controleOperateur(op, type1)) Yaka.yvm.idiff(); break;
					case AND: if (controleOperateur(op, type1)) Yaka.yvm.iand(); break;
					case OR: if (controleOperateur(op, type1)) Yaka.yvm.ior(); break;
					default: this.types.push(eType.ERREUR); break;
				}
			}
		}
	}
	
	public boolean controleOperateur(eOperande op, eType type) {
		switch(op) {
			case ADD:
			case SUB:
			case MUL:
			case DIV:
				if (type == eType.ENTIER) {
					types.push(eType.ENTIER);
					return true;
				}
				else if (type == eType.BOOLEEN) {
					types.push(eType.ERREUR);
					System.out.println("Erreur : problème de type (ligne : " + Yaka.token.beginLine + ").");
					return false;
				}
				break;
			case INF:
			case INFEGAL:
			case SUP:
			case SUPEGAL:
				if (type == eType.ENTIER) {
					types.push(eType.BOOLEEN);
					return true;
				} else if (type == eType.BOOLEEN) {
					types.push(eType.ERREUR);
					System.out.println("Erreur : problème de type (ligne : " + Yaka.token.beginLine + ").");
					return false;
				}
				break;
			case EGAL:
			case DIFF:
				if (type == eType.ENTIER) {
					types.push(eType.BOOLEEN);
					return true;
				}
				else if (type == eType.BOOLEEN) {
					types.push(eType.BOOLEEN);
					return true;
				}
				break;
			case AND:
			case OR:
				if (type == eType.ENTIER) {
					System.out.println("Erreur : problème de type (ligne : " + Yaka.token.beginLine + ").");
					types.push(eType.ERREUR);
					return false;
				}
				else if (type == eType.BOOLEEN) {
					types.push(eType.BOOLEEN);
					return true;
				}
				break;
			case NOT:
				if(type == eType.BOOLEEN) {
					types.push(eType.BOOLEEN);
					return true;
				}
				else {
					types.push(eType.ERREUR);
					System.out.println("Erreur : problème de type (ligne : " + Yaka.token.beginLine + ").");
					return false;
				}
			case NEG:
				if(type == eType.ENTIER) {
					types.push(eType.ENTIER);
					return true;
				}
				else {
					types.push(eType.ERREUR);
					System.out.println("Erreur : problème de type (ligne : " + Yaka.token.beginLine + ").");
					return false;
				}
		}
		
		return false;
	}
	
	public eType type() {
		return this.types.pop();
	}
}
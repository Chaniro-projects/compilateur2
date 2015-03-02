import java.util.*;


public class Expression {

    public static enum eOperande {
        PLUS,
        MOINS,
        MULTIPLIER,
        DIVISER,
        INF,
        INFEGAL,
        SUP,
        SUPEGAL,
        EGAL,
        DIFF,
        ET,
        OU
    }
	
	private Stack<Ident.eType> types;
	private Stack<eOperande> operateurs;
	
	public Expression(){
		operateurs = new Stack<eOperande>();
		types = new Stack<Ident.eType>();
	}
	
	public void ajoutType(Ident.eType type){
		types.add(type);
	}
	
	public void ajoutOp(eOperande c){
		operateurs.add(c);
	}

    public void controleType() {
        Ident.eType type1 = types.pop(), type2 = types.pop();

        if(type1 != type2)
            types.push(Ident.eType.ERREUR);
        else {
            eOperande op = operateurs.pop();

            switch (op) {
                case PLUS:
                case MOINS:
                case DIVISER:
                case MULTIPLIER:
                    if (type1 == Ident.eType.ENTIER)
                        types.push(Ident.eType.ENTIER);
                    if (type1 == Ident.eType.BOOLEEN)
                        types.push(Ident.eType.ERREUR);
                    break;

                case INF:
                case INFEGAL:
                case SUP:
                case SUPEGAL:
                    if (type1 == Ident.eType.ENTIER)
                        types.push(Ident.eType.BOOLEEN);
                    if (type1 == Ident.eType.BOOLEEN)
                        types.push(Ident.eType.ERREUR);
                    break;

                case EGAL:
                case DIFF:
                    if (type1 == Ident.eType.ENTIER)
                        types.push(Ident.eType.BOOLEEN);
                    if (type1 == Ident.eType.BOOLEEN)
                        types.push(Ident.eType.BOOLEEN);
                    break;

                case ET:
                case OU:
                    if (type1 == Ident.eType.ENTIER)
                        types.push(Ident.eType.ERREUR);
                    if (type1 == Ident.eType.BOOLEEN)
                        types.push(Ident.eType.BOOLEEN);
                    break;
            }
        }
    }
}

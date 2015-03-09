import java.util.*;


public class Expression implements Constante {

    
	
	private Stack<eType> types;
	private Stack<eOperande> operateurs;
	
	public Expression(){
		operateurs = new Stack<eOperande>();
		types = new Stack<eType>();
	}
	
	public void ajoutType(eType type){
		types.add(type);
	}
	
	public void ajoutOp(eOperande c){
		operateurs.add(c);
	}

    public void evaluation(int line) { // Rajouter "line" dans la grammaire"
    	eType type1 = types.pop(), type2 = types.pop();
    	eOperande op = operateurs.pop();

        if(type1 != type2)
            types.push(eType.ERREUR);
        else {
            switch (op) {
                case PLUS:
                case MOINS:
                case DIVISER:
                case MULTIPLIER:
                    if (type1 == eType.ENTIER)
                        types.push(eType.ENTIER);
                    else if (type1 == eType.BOOLEEN)
                        types.push(eType.ERREUR);
                    	System.out.println("Erreur à la ligne " + line + ".");
                    break;

                case INF:
                case INFEGAL:
                case SUP:
                case SUPEGAL:
                    if (type1 == eType.ENTIER)
                        types.push(eType.BOOLEEN);
                    else if (type1 == eType.BOOLEEN)
                        types.push(eType.ERREUR);
                    	System.out.println("Erreur à la ligne " + line + ".");
                    break;

                case EGAL:
                case DIFF:
                    if (type1 == eType.ENTIER)
                        types.push(eType.BOOLEEN);
                    else if (type1 == eType.BOOLEEN)
                        types.push(eType.BOOLEEN);
                    break;

                case ET:
                case OU:
                    if (type1 == eType.ENTIER)
                        types.push(eType.ERREUR);
                    else if (type1 == eType.BOOLEEN)
                        types.push(eType.BOOLEEN);
                    break;
            }
        }
    }
    
    private void controleOp(eOperande op, eType type, int line) {
    	if (type == eType.ENTIER) {
            types.push(eType.ENTIER);
            Yaka.yvm.iop(op);
    	}
        else if (type == eType.BOOLEEN) {
            types.push(eType.ERREUR);
        	System.out.println("Erreur à la ligne " + line + ".");
        }
    }
}

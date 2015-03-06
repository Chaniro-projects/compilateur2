import java.util.*;


public class Expression {

    
	
	private Stack<Constante.eType> types;
	private Stack<Constante.eOperande> operateurs;
	
	public Expression(){
		operateurs = new Stack<Constante.eOperande>();
		types = new Stack<Constante.eType>();
	}
	
	public void ajoutType(Constante.eType type){
		types.add(type);
	}
	
	public void ajoutOp(Constante.eOperande c){
		operateurs.add(c);
	}

    public void evaluation(int line) { // Rajouter "line" dans la grammaire"
    	Constante.eType type1 = types.pop(), type2 = types.pop();
    	Constante.eOperande op = operateurs.pop();

        if(type1 != type2)
            types.push(Constante.eType.ERREUR);
        else {
            switch (op) {
                case PLUS:
                case MOINS:
                case DIVISER:
                case MULTIPLIER:
                    if (type1 == Constante.eType.ENTIER)
                        types.push(Constante.eType.ENTIER);
                    else if (type1 == Constante.eType.BOOLEEN)
                        types.push(Constante.eType.ERREUR);
                    	System.out.println("Erreur à la ligne " + line + ".");
                    break;

                case INF:
                case INFEGAL:
                case SUP:
                case SUPEGAL:
                    if (type1 == Constante.eType.ENTIER)
                        types.push(Constante.eType.BOOLEEN);
                    else if (type1 == Constante.eType.BOOLEEN)
                        types.push(Constante.eType.ERREUR);
                    	System.out.println("Erreur à la ligne " + line + ".");
                    break;

                case EGAL:
                case DIFF:
                    if (type1 == Constante.eType.ENTIER)
                        types.push(Constante.eType.BOOLEEN);
                    else if (type1 == Constante.eType.BOOLEEN)
                        types.push(Constante.eType.BOOLEEN);
                    break;

                case ET:
                case OU:
                    if (type1 == Constante.eType.ENTIER)
                        types.push(Constante.eType.ERREUR);
                    else if (type1 == Constante.eType.BOOLEEN)
                        types.push(Constante.eType.BOOLEEN);
                    break;
            }
        }
    }
    
    private void controleOp(Constante.eOperande op, Constante.eType type, int line) {
    	if (type == Constante.eType.ENTIER) {
            types.push(Constante.eType.ENTIER);
            Yaka.yvm.iop(op);
    	}
        else if (type == Constante.eType.BOOLEEN) {
            types.push(Constante.eType.ERREUR);
        	System.out.println("Erreur à la ligne " + line + ".");
        }
    }
}

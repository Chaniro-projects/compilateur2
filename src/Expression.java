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

    public void controleType() {
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
                    break;

                case INF:
                case INFEGAL:
                case SUP:
                case SUPEGAL:
                    if (type1 == Constante.eType.ENTIER)
                        types.push(Constante.eType.BOOLEEN);
                    else if (type1 == Constante.eType.BOOLEEN)
                        types.push(Constante.eType.ERREUR);
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
}

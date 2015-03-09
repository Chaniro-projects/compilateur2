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

    public void evaluation(int line) { // Rajout er "line" dans la grammaire"
    	eType type1 = types.pop(), type2 = types.pop();
    	eOperande op = operateurs.pop();

        if(type1 != type2)
            types.push(eType.ERREUR);
        else {
            switch (op) {
                case PLUS:		 if (controleOp(op, type1, line)) Yaka.yvm.iadd(); break;
                case MOINS: 	 if (controleOp(op, type1, line)) Yaka.yvm.isub(); break;
                case DIVISER: 	 if (controleOp(op, type1, line)) Yaka.yvm.idiv(); break;
                case MULTIPLIER: if (controleOp(op, type1, line)) Yaka.yvm.imul(); break;

                case INF: 		 if (controleOp(op, type1, line)) Yaka.yvm.iinf(); break;
                case INFEGAL: 	 if (controleOp(op, type1, line)) Yaka.yvm.iinfegal(); break;
                case SUP: 		 if (controleOp(op, type1, line)) Yaka.yvm.isup(); break;
                case SUPEGAL: 	 if (controleOp(op, type1, line)) Yaka.yvm.isupegal(); break;

                case EGAL: 		 if (controleOp(op, type1, line)) Yaka.yvm.iegal(); break;
                case DIFF: 		 if (controleOp(op, type1, line)) Yaka.yvm.idiff(); break;
                   
                case ET: 		 if (controleOp(op, type1, line)) Yaka.yvm.iand(); break;
                case OU: 		 if (controleOp(op, type1, line)) Yaka.yvm.ior(); break;
                    
            }
        }
    }
    
    
public boolean controleOp(eOperande op, eType type, int line) {
    switch(op){
    
    case PLUS:
    case MOINS:
    case DIVISER:
    case MULTIPLIER:
    	if (type == eType.ENTIER) {
            types.push(eType.ENTIER);
            return true;
    	}
        else if (type == eType.BOOLEEN) {
            types.push(eType.ERREUR);
        	System.out.println("Erreur à la ligne " + line + ".");
        }
    	return false;
    
    case INF:
    case INFEGAL:
    case SUP:
    case SUPEGAL:
    	 if (type == eType.ENTIER) {
             types.push(eType.BOOLEEN);
    	 return true;
    	 } else if (type == eType.BOOLEEN){
             types.push(eType.ERREUR);
         	System.out.println("Erreur à la ligne " + line + ".");
    	 }
         return false;
    
    case EGAL:
    case DIFF:
        if (type == eType.ENTIER){
            types.push(eType.BOOLEEN);
            return true;
        }
        else if (type == eType.BOOLEEN){
            types.push(eType.BOOLEEN);
            return false;
        }
    case ET:
    case OU:
        if (type == eType.ENTIER){
            types.push(eType.ERREUR);
            return true;
        }
        else if (type == eType.BOOLEEN){
            types.push(eType.BOOLEEN);
            return true;
        }
    } return false;
}

}

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
    	eType type1 = types.pop();

    	eOperande op = operateurs.pop();
		if(op == eOperande.NEG) {
			if (controleOp(op, type1, line))
				Yaka.yvm.ineg();
		}
		else if(op == eOperande.NOT) {
			if (controleOp(op, type1, line))
				Yaka.yvm.inot();
		}
		else
		{
			eType type2 = types.pop();
			if (type1 != type2)
				types.push(eType.ERREUR);
			else {
				switch (op) {
					case PLUS:
						if (controleOp(op, type1, line)) Yaka.yvm.iadd();
						break;
					case MOINS:
						if (controleOp(op, type1, line)) Yaka.yvm.isub();
						break;
					case DIVISER:
						if (controleOp(op, type1, line)) Yaka.yvm.idiv();
						break;
					case MULTIPLIER:
						if (controleOp(op, type1, line)) Yaka.yvm.imul();
						break;

					case INF:
						if (controleOp(op, type1, line)) Yaka.yvm.iinf();
						break;
					case INFEGAL:
						if (controleOp(op, type1, line)) Yaka.yvm.iinfegal();
						break;
					case SUP:
						if (controleOp(op, type1, line)) Yaka.yvm.isup();
						break;
					case SUPEGAL:
						if (controleOp(op, type1, line)) Yaka.yvm.isupegal();
						break;

					case EGAL:
						if (controleOp(op, type1, line)) Yaka.yvm.iegal();
						break;
					case DIFF:
						if (controleOp(op, type1, line)) Yaka.yvm.idiff();
						break;

					case ET:
						if (controleOp(op, type1, line)) Yaka.yvm.iand();
						break;
					case OU:
						if (controleOp(op, type1, line)) Yaka.yvm.ior();
						break;

				}
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
	        	System.out.println("Erreur a la ligne " + line + ".");
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
	    	 } else if (type == eType.BOOLEEN){
	             types.push(eType.ERREUR);
	         	System.out.println("Erreur a la ligne " + line + ".");
	         	return false;
	    	 }
	         break;
	    case EGAL:
	    case DIFF:
	        if (type == eType.ENTIER){
	            types.push(eType.BOOLEEN);
	            return true;
	        }
	        else if (type == eType.BOOLEEN){
	            types.push(eType.BOOLEEN);
	            return true;
	        }
	        break;
	    case ET:
	    case OU:
	        if (type == eType.ENTIER){
				System.out.println("Erreur a la ligne " + line + ".");
	            types.push(eType.ERREUR);
	            return false;
	        }
	        else if (type == eType.BOOLEEN){
	            types.push(eType.BOOLEEN);
	            return true;
	        }
		case NOT:
			if(type == eType.BOOLEEN){
				types.push(eType.BOOLEEN);
				return true;
			}
			else {
				types.push(eType.ERREUR);
				System.out.println("Erreur a la ligne " + line + ".");
				return false;
			}
		case NEG:
			if(type == eType.ENTIER){
				types.push(eType.ENTIER);
				return true;
			}
			else {
				types.push(eType.ERREUR);
				System.out.println("Erreur a la ligne " + line + ".");
				return false;
			}

		}
    
    	return false;
	}
}

import java.util.Stack;

public class Condition implements Constante {
	protected int nbConditions;
	protected Stack<Integer> conditions;
	
	
	public Condition() {
		this.nbConditions = 0;
		this.conditions = new Stack<Integer>();
	}
	
	
	public void si() {
		this.conditions.push(++this.nbConditions);
	}
	
	public void verifierExpression() {
		eType expressionType = Yaka.expression.type();
		
		if (expressionType == eType.BOOLEEN) {
			Yaka.yvm.iffaux("SINON" + this.conditions.lastElement());
		}
		else {
			System.out.println("Erreur : une condition attend une expression booleenne (ligne : " + Yaka.token.beginLine + ").");
		}
	}
	
	public void igoto() {
		Yaka.yvm.igoto("FSI" + this.conditions.lastElement());
	}
	
	public void sinon() {
		Yaka.yvm.etiquette("SINON" + this.conditions.lastElement());
	}
	
	public void fsi() {
		Yaka.yvm.etiquette("FSI" + this.conditions.lastElement());
		this.conditions.pop();
	}
}
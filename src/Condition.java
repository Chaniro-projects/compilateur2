import java.util.Stack;

public class Condition implements Constante {
	protected int nbConditions;
	protected Stack<Integer> conditions;
	protected Stack<Boolean> sinon;
	
	public Condition() {
		this.nbConditions = 0;
		this.conditions = new Stack<Integer>();
		this.sinon = new Stack<Boolean>();
	}
	
	public void si() {
		this.sinon.push(false);
		this.conditions.push(++this.nbConditions);
	}
	
	public void verifierExpression() {
		eType expressionType = Yaka.expression.type();
		
		if (expressionType == eType.BOOLEEN)
			Yaka.yvm.iffaux("SINON" + this.conditions.lastElement());
		else
			System.out.println("Erreur : une condition attend une expression booleenne (ligne : " + Yaka.token.beginLine + ").");
	}
	
	public void igoto() {
		Yaka.yvm.igoto("FSI" + this.conditions.lastElement());
	}
	
	public void sinon() {
		this.sinon.pop();
		this.sinon.push(true);
		Yaka.yvm.etiquette("SINON" + this.conditions.lastElement());
	}
	
	public void fsi() {
		if(!this.sinon.pop())
			Yaka.yvm.etiquette("SINON" + this.conditions.lastElement());
		Yaka.yvm.etiquette("FSI" + this.conditions.pop());
	}
}

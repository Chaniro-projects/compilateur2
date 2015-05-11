import java.util.Stack;

public class Iteration implements Constante {
	protected int nbIterations;
	protected Stack<Integer> iterations;
	
	
	public Iteration() {
		this.nbIterations = 0;
		this.iterations = new Stack<Integer>();
	}
	
	
	public void faire() {
		this.iterations.push(++this.nbIterations);
		Yaka.yvm.etiquette("FAIRE" + this.iterations.lastElement());
	}
	
	public void verifierExpression() {
		eType expressionType = Yaka.expression.type();
		
		if (expressionType == eType.BOOLEEN) {
			Yaka.yvm.iffaux("FAIT" + this.iterations.lastElement());
		}
		else {
			System.out.println("Erreur : une iteration attend une expression booleenne (ligne : " + Yaka.token.beginLine + ").");
		}
	}
	
	public void igoto() {
		Yaka.yvm.igoto("FAIRE" + this.iterations.lastElement());
	}
	
	public void fait() {
		Yaka.yvm.etiquette("FAIT" + this.iterations.lastElement());
		this.iterations.pop();
	}
}
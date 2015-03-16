import java.util.Stack;

public class Iteration implements Constante {
	protected int nbIterations;
	protected Stack<Integer> iterations;
	
	public Iteration() {
		this.nbIterations = 0;
		this.iterations = new Stack<Integer>();
	}
	
	public void verifierExpression() {
		eType expressionType = Yaka.expression.type();
		
		this.iterations.push(this.nbIterations++);
		
		if (expressionType == eType.BOOLEEN) {
			Yaka.yvm.faireIteration();
			Yaka.yvm.iffaux();
		}
		else {
			System.out.println("Erreur : une itération attend une expression booleenne (ligne : " + Yaka.token.beginLine + ").");
		}
	}
	
	public void fait() {
		Yaka.yvm.igoto("FAIT" + this.iterations.lastElement());
		Yaka.yvm.faitIteration();
		this.iterations.pop();
	}
	
	public Integer lastElement() {
		return this.iterations.lastElement();
	}
}

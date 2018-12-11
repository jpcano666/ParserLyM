package calculator;

public class MathExp {
	
	int exp;

	public MathExp(int a, String operation, int b) {
		if(operation.equals('/')) exp = (a / b);
		else if(operation.equals('*')) exp = (a * b);
		else if(operation.equals('+')) exp = (a + b);
		else if(operation.equals('-')) exp = (a - b);
		else if(operation.equals('%')) exp = (a % b);
	}
	
	public int getExp() {
		return exp;
	}
}

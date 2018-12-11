package calculator;

public class MathExp {
	
	private int exp;
	
	private String name1;
	
	private String name2;
	
	private String operator;
	
	private Operator oper;
	
	public MathExp(String p1, String p2, String op)
	{
		if(op.equals("+"))
		{
			oper = new Add(p1, p2);
		}
		else if(op.equals("-"))
		{
			oper = new Sub(p1, p2);
		}
		else if(op.equals("*"))
		{
			oper = new Mul(p1, p2);
		}
		
		String a = "Hola";
	}

	public MathExp(int a, String operation, int b) 
	{
		if(operation.equals('/')) exp = (a / b);
		else if(operation.equals('*')) exp = (a * b);
		else if(operation.equals('+')) exp = (a + b);
		else if(operation.equals('-')) exp = (a - b);
		else if(operation.equals('%')) exp = (a % b);
	}
	
	public int getExp() 
	{
		return exp;
	}
	
	
}

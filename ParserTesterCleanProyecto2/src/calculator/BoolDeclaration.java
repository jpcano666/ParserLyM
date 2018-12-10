package calculator;

public class BoolDeclaration
{
	boolean comp;
	
	public BoolDeclaration(int a, int b, String comparator)
	{
		comp = Boolean.getBoolean(a + comparator + b);
	}
	
	public BoolDeclaration(boolean a, boolean b, String comparator)
	{
		comp = Boolean.getBoolean(a + comparator + b);
	}
	
	public boolean getComp()
	{
		return comp;
	}

}

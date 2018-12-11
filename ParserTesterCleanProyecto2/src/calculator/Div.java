package calculator;

import java.math.BigDecimal;

public class Div implements Operator
{
	
	private BigDecimal sum;
	BigDecimal prim;
	BigDecimal seg;
	
	
	public Div(String p1, String p2)
	{
		prim = new BigDecimal(p1);
		 seg = new BigDecimal(p1);
	}

	@Override
	public int execute() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get() {
		// TODO Auto-generated method stub
		return sum.intValue();
	}

}

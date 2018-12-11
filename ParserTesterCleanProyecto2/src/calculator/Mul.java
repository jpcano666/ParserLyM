package calculator;

import java.math.BigDecimal;

public class Mul implements Operator
{
	
	private BigDecimal sum;
	BigDecimal prim;
	BigDecimal seg;
	
	
	public Mul(String p1, String p2)
	{
		prim = new BigDecimal(p1);
		 seg = new BigDecimal(p2);
	}
	@Override
	public int execute() 
	{
		// TODO Auto-generated method stub
		sum = prim.multiply(seg);
		return 0;
	}

	@Override
	public int get() {
		// TODO Auto-generated method stub
		return sum.intValue();
	}

}

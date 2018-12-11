package calculator;

import java.math.BigDecimal;

public class Sub implements Operator
{
	private BigDecimal sum;
	BigDecimal prim;
	BigDecimal seg;
	
	
	
	public Sub(String param1, String param2)
	{
		prim = new BigDecimal(param1);
		 seg = new BigDecimal(param2);
	}

	@Override
	public int execute()
	{
		return 0;
	}

	@Override
	public int get() 
	{
		// TODO Auto-generated method stub
		return sum.intValue();
	}

}

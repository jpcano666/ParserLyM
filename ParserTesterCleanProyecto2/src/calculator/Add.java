package calculator;

import java.math.BigDecimal;

public class Add implements Operator
{
	private BigDecimal sum;
	BigDecimal prim;
	BigDecimal seg;
	
	public Add(String param1, String param2)
	{
		 prim = new BigDecimal(param1);
		 seg = new BigDecimal(param2);
	}

	@Override
	public int execute() 
	{
		sum = prim.add(seg);
		return 0;
	}

	@Override
	public int get() {
		// TODO Auto-generated method stub
		return sum.intValue();
	}
}

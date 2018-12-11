package calculator;

import java.util.*;

public class VarDef
{
	private HashMap<String, Integer> table;
	public VarDef(String name, int value)
	{
		table.put(name, value);
	}

	public int getValue(String a)
	{
		try
		{
			return table.get(a);
		}
		catch(Exception e)
		{
			return 0;
		}
	}
	
	public boolean contains(String a)
	{
		return table.containsKey(a);
	}
	
	public boolean exists(String a)
	{
		return table.get(a) != null;
	}
}

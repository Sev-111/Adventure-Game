import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Item 
{
	private String name;
	private String desc;
	private short offense;
	private short defense;
	private double value;
									//constructors
	
	public Item()
	{
		
	}
	
	public Item(String n, String d, Short of, Short def, Double v)
	{
		name = n;
		desc = d;
		offense = of;
		defense = def;
		value = v;
	}
	
	
									//getters
	public String getName()
	{
		return name;
	}
	
	public String getDesc()
	{
		return desc;
	}
	
	public short getof()
	{
		return offense;
	}
	
	public short getdef()
	{
		return defense;
	}
	
	public double getvalue()
	{
		return value;
	}
	
	
	//load items method
	public String loadItems(String itemFile, Map m, Character[] p)
	{
		try
		{
			FileReader fr = new FileReader(itemFile);
			BufferedReader br = new BufferedReader(fr);
			
			//place to store info
			String line;
			String splitBy = ",";
			String[] data;
			
			while((line = br.readLine()) != null)
			{
				data = line.split(splitBy);
				
				int a = Integer.parseInt(data[0]);
				int b = Integer.parseInt(data[1]);
				String name = data[2];
				String desc = data[3];
				short o = Short.parseShort(data[4]);
				short d = Short.parseShort(data[5]);
				double v = Double.parseDouble(data[6]);
				
				Item i = new Item(name, desc, o, d, v);
				
				if(a < 0)
				{
					//character b gets item
					p[b].inventory.add(i);
					//p[b].armwith(i);
					
				}
				else
				{
					//character a gets item
					p[a].inventory.add(i);
				}
			}
			br.close();
		}
		catch(IOException e)
		{
			System.out.println("File Error: " + itemFile);
		}
		
		finally
		{
			System.out.println("Items Loaded from " + itemFile + " Succesfully!");
		}
		return itemFile;
	}
	
}

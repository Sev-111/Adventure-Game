import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Character
{
	static int count = 0;
	
	String name;
	String description;
	int xpos;
	int ypos;
	String race;
	String cClass;
	int hitPoints;
	int strength;
	int intelligence;
	int dexterity;
	int armor;
	boolean moveable;
	boolean combative;
	
	//inventory
	protected ArrayList<Item> inventory = new ArrayList<Item>();
	
	// public ArrayList<Item> getInventory()
	// {
	// 	return inventory;
	// }
	
	public abstract boolean move(Character[] profile, Map m);
	
	protected static void moveNPCs(Character[] profile, Map m )
	{
		for (int x = 1; x <= count; x++)
		{
			profile[x].move(profile, m);					//some issue here dont understand
		}
	}
	
	protected boolean isHere(Character c)
	{
		if((xpos == c.xpos) && (ypos == c.ypos))
		{
			return true;
		}
		return false;
	}
	
	protected static void showNPCs(Character[] profile)
	{
		for (int x = 1; x <= count; x++)
		{
			if (profile[0].isHere(profile[x]))
			{
				System.out.println(profile[x].name + " has appeared." );
			}
		}
	}
	
	//constructor
	public Character()
	{
		
	}
	
	public Character(String n, String d, int x, int y, boolean m, boolean c, int hp, int s, int i, int dex, int a)
	{
		name = n;
		description = d;
		xpos = x;
		ypos = y;
		moveable = m;
		combative = c;
		hitPoints = hp;
		strength = s;
		intelligence = i;
		dexterity = dex;
		armor = a;
		
	}
	
	public void getItem(String itemName, MapBlock here)
	{
		//remove item from mapBlock, add to player inventory
		inventory.add(here.removeItem(itemName));
		
	}
	
	public void dropItem(String itemName, MapBlock here)
	{
		//remove item from player inventory and drop item on the ground
		//inventory.remove(here.addItem(itemName));
		for (Item item : inventory)
		{
			if (item.getName().equals(itemName))
			{
				inventory.remove(item);
				here.addItem(item);
				break;
			}
		}
	}
	
	public static void initChars(Character[] profile, String fileName) 
	{
				try
				{
					FileReader fr = new FileReader(fileName);
					BufferedReader br = new BufferedReader(fr);
					
					String line;
					String splitBy = ",";
					String [] data;
					
					while ((line = br.readLine())!= null)
					{
						data = line.split(splitBy);
						
						int xpos = Integer.parseInt(data[0]);
						int ypos = Integer.parseInt(data[1]);
						String name = data[2];
						String description = data[3];
				
						/*
						race;
						class;
						 */
						int hitpoints =  Integer.parseInt(data[6]);
						int strength =  Integer.parseInt(data[7]);
						int dexterity = Integer.parseInt(data[8]);
						int intelligence = Integer.parseInt(data[9]);
						int armor = Integer.parseInt(data[10]);
						int pType = Integer.parseInt(data[11]);
						boolean combative = (Integer.parseInt(data[12]) > 0)?true:false;
						
						switch (pType)
						{
						case 0:
							//immoveable
							Immoveable i = new Immoveable(name,description,xpos,ypos,combative, hitpoints, strength, dexterity, intelligence, armor);
							profile[++count] = i;
							break;
						case 1:
							//moveable
							Moveable m = new Moveable(name,description,xpos,ypos,combative, hitpoints, strength, dexterity, intelligence, armor);
							profile[++count] = m;
							break;
						case 2:
							//player
							Player p = new Player(name,description,xpos,ypos, hitpoints, strength, dexterity, intelligence, armor);
							profile[0] = p;
							break;
						default:
							System.out.println("Bad Character Type" + pType);
						break;
						
						}
					}
					
					br.close();
					
					
					/*
					 * Item i = new Item();
					 * 
					 * Character.inventory.add(i);
					 * Character.inventory.remove(Character.inventory.get());
					 */
					 
					
					
				}
				catch(IOException e)
				{
					System.out.println("File Error: " + fileName);
				}
	}
}

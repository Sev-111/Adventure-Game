import java.util.ArrayList;

public class MapBlock 					//mapblock constructor
{
		private String title;
		private String description;
		private int N;
		private int S;
		private int E;
		private int W;
		
	// private boolean seen = false;
	
	public int count;
	
	ArrayList<Item> itemsHere = new ArrayList<Item>();
	
	 public MapBlock() //constructor
	 {
		 title = "VOID";
		 description = "VOID";
		 N=0;
		 S=0;
		 E=0;
		 W=0;
		 
	 }
	 
	 public MapBlock (String t, String d, int n, int s, int e, int w)
	 {
		 title = t;
		 description = d;
		 N = n;
		 S = s;
		 E = e;
		 W = w;
		
	 }
	 
	 public boolean go(Direction d)
	 {
		 switch(d)
		 {
		 case Direction.NORTH:
			 if (N == 1)
			 {
				return true; 
			 }
			 break;
		 case Direction.SOUTH:
			 if (S == 1)
			 {
				return true; 
			 }
			 break;
		 case Direction.EAST:
			 if (E == 1)
			 {
				return true; 
			 }
			 break;
		 case Direction.WEST:
			 if (W == 1)
			 {
				return true; 
			 }
			 break;
			 
		 }
		 return false;
	 }
	 
	 //getters
	 
	 public String getTitle()
	 {
		 return title;
	 }
	 
	 public String getDescription()
	 {
		 return description;
	 }
	 
	 public int getN()
	 {
		 return N;
	 }
	 public int getS()
	 {
		 return S;
	 }
	 public int getE()
	 {
		 return E;
	 }
	 public int getW()
	 {
		 return W;
	 }
	 
	 @Override
	 public String toString()
	 {
		 return String.format("You have arrived at: \n%s\n%s", title, description );
	 }

	 public void showItems() 
	 {
		for(int x = 0; x < itemsHere.size(); x++)
		{
			System.out.println("There is a" + itemsHere.get(x).getName() + "here");
		}
		
	 }

	 public Item removeItem(String i)				//removes item from ground "mapblock" and adds it to player inventory
	 {
		for(int x = 0; x < itemsHere.size(); x++)
		{
			if(itemsHere.get(x).getName().equalsIgnoreCase(i))
			{
				System.out.println("you now have the" + itemsHere.get(x).getName());
				return itemsHere.remove(x);
			}
		}
		System.out.println("There is no " + i + "here");
		return null;
	 }
	 
	 public void addItem(Item item)
	 {
		 itemsHere.add(item);
	 }
	 
}

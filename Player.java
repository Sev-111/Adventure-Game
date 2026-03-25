
import java.util.Scanner;


public class Player extends Character
{

	Scanner scan = new Scanner(System.in);
	
	public Player(String n, String d, int x, int y, int hp, int s, int i, int dex, int a) 
	{
		super(n, d, x, y, true, true, hp, s, i, dex, a);
		
		System.out.println("player " + name + " Created");
	}
	
	
	@Override
	public boolean move(Character[] profile, Map m)
	{
		MapBlock here = m.map[xpos][ypos];
		
		System.out.println(here);
		here.showItems();  				 //showitemshere
		Character.moveNPCs(profile,m);
		showNPCs(profile);
		
		
		String response = prompt();		//creates response and sets it equal to player.prompt();
		
		char command = response.toUpperCase().charAt(0);
		String[] data = response.split(" ",2);
		String obj = " ";
		
		if(data.length > 1)
		{
			obj = data[1]; 
			// take the other words after command 
		}
		
		switch(command)
		{
		case 'I':
			
			break;
		case 'N':
			if (here.go(Direction.NORTH))
			{
				ypos--;
			}
			else
			{
				System.out.print("Sorry the path is blocked");
			}
			break;
		case 'S':
			if (here.go(Direction.SOUTH))
			{
				ypos++;
			}
			else
			{
				System.out.print("Sorry the path is blocked");
			}
			break;
		case 'E':
			if (here.go(Direction.EAST))
			{
				xpos++;
			}
			else
			{
				System.out.print("Sorry the path is blocked");
			}
			break;
		case 'W':
			if (here.go(Direction.WEST))
			{
				xpos--;
			}
			else
			{
				System.out.print("Sorry the path is blocked");
			}
			break;
		case 'Q': 	//Quit game
			return false;
		case 'G': 	//Get
			here.removeItem(obj);
			System.out.println("Picking up " + obj);
			break;
		case 'D': 	//Drop
			dropItem(obj, here);
			System.out.println("Dropping " + obj);
			break;
		default:
			System.out.print("Not a valid command");
			break;
		}
		return moveable;
		
	}
	
	private String prompt()
	{
		System.out.print("\nN - to move North\nS - to move south\nE - to move East\nW - to move west\nG (Item Name) - to pickup item\nD (Item Name) - to Drop an item\nQ - Press to quit\nWhat will you do?: ");
		return scan.nextLine();
	}
	
	public void showItems()
	 {
		for(int x = 0; x < inventory.size(); x++)
		{
			System.out.println("There is a" + inventory.get(x).getName() + "here");
		}
		
	 }
}


public class Immoveable extends Character
{

	public Immoveable(String n, String d, int x, int y, boolean c, int hp, int s, int i, int dex, int a) 
	{
		super(n, d, x, y, false, c, hp, s, i, dex, a);
		
		System.out.println("Immoveable Character " + name + " created");
	}
	
	public void move(Map m)
	{
		//nothing here
		//i don't Move anywhere 
	}

	@Override
	public boolean move(Character[] profile, Map m) {
		boolean stillAlive = true;
		
		return stillAlive;
	}
}

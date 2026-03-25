
// import java.io.BufferedReader;
// import java.io.FileReader;
// import java.io.File;


public class Adventure 
{
	public static void main (String[] args) 
	{
		int maxX = 10;
		int maxY = 10;
		int numChars = 20;
		
		
		
		
		String mapFile = "../data/map.csv";
		String CharFile = "../data/characters.csv";
		String itemFile = "../data/items.csv";
		
		
		Map map = new Map(maxX, maxY, mapFile);
		Character[] profile = new Character[numChars];
		
		System.out.println(map);
		
		//System.out.println(MapBlock.count);
		
		//System.out.println(map.map[xpos][ypos]);
		
		Character.initChars(profile,CharFile);
		Item item = new Item();
		item.loadItems(itemFile, map, profile);
		
		Player player = (Player)profile[0];
		
		//start game
		Boolean playing = true;
		while(playing)
		{
			playing = player.move(profile, map);
			
			
		}
			
		System.out.println("Your expedition has come to an end wanderer");
		
		
		try {
			Thread.sleep(5000);					// 5000 miliseconds = 5 seconds
		} catch (InterruptedException e) {
		}
		
	}
	
}
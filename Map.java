
import java.io.BufferedReader;
import java.io.FileReader;
// import java.io.File;
import java.io.IOException;
public class Map 
{

	int maxX;
	int maxY;
	
	MapBlock[][] map;
	
	public Map(int X, int Y, String fileName) 
	{
		maxX = X;
		maxY = Y;
		
		map = new MapBlock[X][Y];
		
		for (int x=0; x < maxX; x++ )
		{
			for (int y = 0 ; y < maxY; y++) 
			{
				map[x][y] = new MapBlock();
				
			}
			
		}
		
		try
		{
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			
			String line;
			String splitBy = ",";
			String[] data;
			
			while ((line = br.readLine())!= null)
			{
				data = line.split(splitBy);
				
				int xpos = Integer.parseInt(data[0]);
				int ypos = Integer.parseInt(data[1]);
				String title = data[2];
				String description = data[3];
				int n = Integer.parseInt(data[4]);
				int s = Integer.parseInt(data[5]);
				int e = Integer.parseInt(data[6]);
				int w = Integer.parseInt(data[7]);
				
				map[xpos][ypos] = new MapBlock(title, description, n,s,e,w);
				
			}
			
			br.close();
		}
		catch(IOException e)
		{
			System.out.println("File Error: " + fileName);
		}
		
	}
	@Override
	public String toString()
	{
		char full = '\u2588';
		char empty = '\u2591';
		
		String out = "MAP:\n";
		
		for(int y =0; y < maxY; y++)
		{
			for(int x = 0; x < maxX; x++)
			{
				if(map[x][y].getTitle().equals("VOID")) 
				{
					for (int c = 1; c <= 3; c++)
					{
						out += empty;
					}
				
				}
				else
				{
					for (int c = 1; c <= 3; c++)
					{
						out += full;
					}

				}
			}
			out += "\n";
		}
		return out;
		
	}
}







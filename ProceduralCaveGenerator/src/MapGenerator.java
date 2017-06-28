import java.util.Random;

public class MapGenerator {
	
	public final int WALL = 1;
	public final int VOID = 0;
	
	public final char WALL_REPRESENTATION = '*';
	public final char VOID_REPRESENTATION = ' ';
	
	public int width;
	public int height;
	
	public String seed;
	public boolean useRandomSeed;
	
	public int randomFillPercent; 
	int[][] map;
	
	public MapGenerator() {
		width = 30;
		height = 50;
		useRandomSeed = true;
		seed = "0123";
		randomFillPercent = 47;
	}
	
	public void start() {
		generateMap();
	}
	
	public void generateMap() {
		map = new int[width][height];
		randomFillMap();
		
		for(int i = 0; i < 5; i++) {
			smoothMap();
		}
	}
	
	public void smoothMap() {
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				int neighbourWall = getSourroundingWallCount(i,j);
				
				if(neighbourWall > 4)
					map[i][j] = WALL;
				else if (neighbourWall < 4)
					map[i][j] = VOID;
			}
		}
	}
	
	public int getSourroundingWallCount(int x, int y) {
		int wall = 0;
		for(int i = x -1; i <= x+1; i++) {
			for(int j = y -1; j <= y+1; j++) {
				if(i >= 0 && i < width && j >= 0 && j < height) {
					if(i != x || j != y)
						wall = wall + map[i][j];
				} else {
					wall++;
				}
			}
		}
		return wall;
	}
	
	public void randomFillMap() {
		if (useRandomSeed)
			seed = Long.toString(System.currentTimeMillis());
		
		Random rand = new Random(Long.parseLong(seed));
		
		for(int i = 0; i < width; i++){
			for(int j = 0; j < height; j++) {
				if(i == 0 || i == width-1 || j == 0 || j==height-1)
					map[i][j] = WALL;
				else {
					if(rand.nextInt(101) < randomFillPercent)
						map[i][j] = WALL;
					else 
						map[i][j] = VOID;
				}
			}
		}
	}
	
	void printMap() {
		for(int i = 0; i < width; i++){
			for(int j = 0; j < height; j++) {
				if(map[i][j] == WALL)
					System.out.print(WALL_REPRESENTATION);
				else
					System.out.print(VOID_REPRESENTATION);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		MapGenerator map = new MapGenerator();
		map.start();
		map.printMap();
	}
}

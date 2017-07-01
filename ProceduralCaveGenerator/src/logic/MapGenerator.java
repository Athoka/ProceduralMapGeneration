package logic;

import java.util.Random;

public class MapGenerator {
	
		public final int WALL = 1;
		public final int VOID = 0;
		
		public final char WALL_REPRESENTATION = '*';
		public final char VOID_REPRESENTATION = ' ';
		
		public int width;
		public int height;
		public long seed;
		public boolean useRandomSeed;
		public int steps;
		public int randomFillPercent; 
		int[][] map;
		
		public MapGenerator() {
			width = 30;
			height = 50;
			useRandomSeed = true;
			seed = 123;
			randomFillPercent = 47;
			steps = 5;
		}
		
		public MapGenerator(int width, int height, boolean randomSeed, int seed, int steps, int filledPercent) {
			this.width = width;
			this.height = height;
			this.useRandomSeed = randomSeed;
			this.seed = seed;
			this.steps = steps;
			this.randomFillPercent = filledPercent;
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
				seed = System.currentTimeMillis();
			
			Random rand = new Random(seed);
			
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
		
		public String toString() {
			
			String mapa = "";
			
			for(int i = 0; i < width; i++){
				for(int j = 0; j < width; j++) {
					if(map[i][j] == WALL)
						mapa += WALL_REPRESENTATION;
					else
						mapa += VOID_REPRESENTATION;
				}
				mapa += "\n";
			}
				
			
			return mapa;
		}
		
		public void printMap() {
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
}

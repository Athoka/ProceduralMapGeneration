package logic;

import java.util.Random;

public class GeneradorMapa {
	
	public final int PARED = 1;
	public final int VACIO = 0;
	
	public final char REPRESENTACION_PARED = '*';
	public final char REPRESENTACION_VACIO = ' ';
	
	public int ancho;
	public int alto;
	public long semilla;
	public boolean semillaRandom;
	public int vueltas;
	public int porcentajeRelleno; 
	int[][] mapa;
	
	public GeneradorMapa(int an, int al, boolean rand, int sem, int pasos, int porcentaje) {
		this.ancho = an;
		this.alto = al;
		this.semillaRandom = rand;
		this.semilla = sem;
		this.vueltas = pasos;
		this.porcentajeRelleno = porcentaje;
	}

	
	public void generarMapa() {
		mapa = new int[ancho][alto];
		inicializarMapa();
		
		for(int i = 0; i < vueltas; i++) {
			suavizarMapa();
		}
	}
	
	private void suavizarMapa() {
		for(int i = 0; i < ancho; i++) {
			for(int j = 0; j < alto; j++) {
				int paredesVecinas = getNumeroParedesVecinas(i,j);
				
				if(paredesVecinas > 4)
					mapa[i][j] = PARED;
				else if (paredesVecinas < 4)
					mapa[i][j] = VACIO;
			}
		}
	}
	
	private int getNumeroParedesVecinas(int x, int y) {
		int paredes = 0;
		for(int i = x - 1; i <= x+1; i++) {
			for(int j = y -1; j <= y+1; j++) {
				if(i >= 0 && i < ancho && j >= 0 && j < alto) {
					if(i != x || j != y)
						paredes = paredes + mapa[i][j];
				} else {
					paredes++;
				}
			}
		}
		return paredes;
	}
	
	private void inicializarMapa() {
		if (semillaRandom)
			semilla = System.currentTimeMillis();
		
		Random rand = new Random(semilla);
		
		for(int i = 0; i < ancho; i++){
			for(int j = 0; j < alto; j++) {
				if(i == 0 || i == ancho-1 || j == 0 || j==alto-1)
					mapa[i][j] = PARED;
				else {
					if(rand.nextInt(101) < porcentajeRelleno)
						mapa[i][j] = PARED;
					else 
						mapa[i][j] = VACIO;
				}
			}
		}
	}
	
	public String toString() {
		
		String mapaAux = "";
		
		for(int i = 0; i < ancho; i++){
			for(int j = 0; j < ancho; j++) {
				if(mapa[i][j] == PARED)
					mapaAux += REPRESENTACION_PARED;
				else
					mapaAux += REPRESENTACION_VACIO;
			}
			mapaAux += "\n";
		}
		
		return mapaAux;
	}
}

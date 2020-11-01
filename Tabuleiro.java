package batalhanaval;
import java.util.Random;

public class Tabuleiro {

	private int linhas = 10;
	private int colunas = 10;
	private int[][] tabuleiro = new int[linhas][colunas];
	private int dois = 0, tres = 0, quatro = 0, cinco = 0, seis = 0;
	
	Tabuleiro(){
		zeraTabuleiro();
		random();
	}
	
	public void random() {
		
		posicionarDestruidor();
		posicionarSubmarino();
		posicionarCruzador();
		posicionarNavio();
		posicionarPortaAv();
		
		
		System.out.println("foram posicionados aleatoriamente no tabuleiro.");
		
	}

	private void zeraTabuleiro() {
		
		for(int i = 0; i<10; i++) {
			for(int j = 0; j<10; j++) {
				
				tabuleiro[i][j] = 0;
			}
		}
	}
	
	public int verifica(int i, int j, int caso, int dir) {
				
		if(caso == 6) {caso = 3;}		
		if(dir == 0) { //VERTICAL
			for(int x = 0; x<caso; x++) {
				if(tabuleiro[i+x][j] != 0) {
					return 1;
				}
			}
		}else if(dir == 1) { //HORIZONTAL
			for(int x = 0; x<caso; x++) {
				if(tabuleiro[i][j+x] != 0) {
					return 1;
				}
			}	
		}
		return 0;
					
	}
	
	public void vertical(int i, int j, int caso, int dir) {
		int y = 0;
		if(caso == 6) {caso = 3; y = 3;}		

		for(int x = 0; x<caso; x++) {
			tabuleiro[i+x][j] = caso+y;
			
		}
	
	
	}

	public void horizontal(int i, int j, int caso, int dir) {
	 int y = 0;
		if(caso == 6) {caso = 3; y = 3;}		

			for(int x = 0; x<caso; x++) {
				tabuleiro[i][j+x] = caso+y;
			
			}
	
	}

	
	public void posicionarSubmarino() { 
		Random random = new Random();	
		int caso = 6;
		boolean aux = false;

		do {
			
			int i = random.nextInt(7); 
			int j = random.nextInt(7); 
			int dir = random.nextInt(3);
			if(verifica(i, j, caso, dir) == 0) {
				
				if(dir == 0) {
					vertical(i,j, caso, dir);
					aux = true;
				}else if(dir == 1) {
					horizontal(i, j, caso, dir);
					aux = true;
				}
				
			}
			
		}while(aux != true);
	}
	public void posicionarDestruidor() { 
		Random random = new Random();	
		boolean aux = false;
		int caso = 2;
		do {
			
			int i = random.nextInt(7); 
			int j = random.nextInt(7); 
			int dir = random.nextInt(3);
			if(verifica(i, j, caso, dir) == 0) {
				
				if(dir == 0) {
					vertical(i,j, caso, dir);
					aux = true;
				}else if(dir == 1) {
					horizontal(i, j, caso, dir);
					aux = true;
				}
				
			}
			
		}while(aux != true);
	}
	
	public void posicionarCruzador() { 
		Random random = new Random();
		boolean aux = false;
		int caso = 3;
		do {
			
			int i = random.nextInt(7); 
			int j = random.nextInt(7); 
			int dir = random.nextInt(3);
			if(verifica(i, j, caso, dir) == 0) {
				
				if(dir == 0) {
					vertical(i,j, caso, dir);
					aux = true;
				}else if(dir == 1) {
					horizontal(i, j, caso, dir);
					aux = true;
				}
				
			}
		}while(aux != true);
	}
	
	public void posicionarNavio() { 
		Random random = new Random();
		boolean aux = false;
		int caso = 4;
		do {
			
			int i = random.nextInt(6); 
			int j = random.nextInt(6); 
			int dir = random.nextInt(3);
			if(verifica(i, j, caso, dir) == 0) {
				
				if(dir == 0) {
					vertical(i,j, caso, dir);
					aux = true;
				}else if(dir == 1) {
					horizontal(i, j, caso, dir);
					aux = true;
				}
				
			}
			
		}while(aux != true);
	}
	
	public void posicionarPortaAv() { 
		Random random = new Random();
		boolean aux = false;
		int caso = 5; 
		do {
			
			int i = random.nextInt(5); 
			int j = random.nextInt(5); 
			int dir = random.nextInt(3);
			if(verifica(i, j, caso, dir) == 0) {
						
				if(dir == 0) {
					vertical(i,j, caso, dir);
					aux = true;
				}else if(dir == 1) {
					horizontal(i, j, caso, dir);
					aux = true;
				}
				
			}
			
		}while(aux != true);
	}
	
	public int atingido(int i, int j) {
		int caso;
		if(tabuleiro[i][j] == 0) {
			System.out.println("\t> Você atingiu a água. Espere sua próxima jogada! :)\n");
			tabuleiro[i][j] = 1; 
			return 0;
			
		}else if(tabuleiro[i][j] == 1){
			System.out.println("\t>> Você já atirou aí! Tente novamente.\n");
			return 1;
			
		}else if(tabuleiro[i][j]   > 6){
		
			System.out.println("\t>> Essa parte já foi atingida!\n");
			printD();
			return 1;
		}else{
			caso = tabuleiro[i][j];
			System.out.println("\t> Fogo!");
			switch(caso) {
				case 2:
					System.out.println("\t> Você atingiu um destruidor! (2 casas)\n");
					tabuleiro[i][j] = caso+10; 
					dois += 1;
					if(dois == 2) {
						System.out.println("\tVocê afundou um destruidor!");
					}
					printD();
					return 0;
				case 3:
					System.out.println("\t> Você atingiu um cruzador! (3 casas)\n");
					tabuleiro[i][j] = caso+10; 
					tres += 1;
					if(tres == 3) {
						System.out.println("\tVocê afundou um cruzador!");

					}
					printD();
					return 0;
				case 4: 
					System.out.println("\t> Você atingiu um navio de guerra! (4 casas)\n");
					tabuleiro[i][j] = caso+10; 
					quatro += 1;
					if(quatro == 4) {
						System.out.println("\tVocê afundou um navio de guerra!");

					}
					printD();
					return 0;
				case 5:
					System.out.println("\t> Você atingiu um porta-aviões! (5 casas)\n");
					tabuleiro[i][j] = caso+10; 
					cinco += 1;
					if(cinco == 5) {
						System.out.println("\tVocê afundou um porta-aviões!");

					}
					printD();	
					return 0;
				case 6:
					System.out.println("\t> Você atingiu um submarino! (3 casas)\n");
					tabuleiro[i][j] = caso+10; 
					seis++;
					if(seis == 3) {
						System.out.println("\tVocê afundou um submarino!");

					}
					printD();
					return 0;
			}
			
		}
		return 0;
	}
	
	public int verificaGanhador() { //Verifica o tabuleiro inteiro;
		int aux = 0;
		for(int i = 0; i<10; i++) {
			for(int j = 0; j<10; j++) {
				if(tabuleiro[i][j] >  11) {
					aux++;
				}
			}
		}
	 aux++;
		return aux;
	}
	
	
	public void printD() {
		
		for(int i = 0; i<10; i++) {
			for(int j = 0; j<10; j++) {
				if(tabuleiro[i][j]   > 6){
					System.out.print("X | ");

				}else {
				System.out.print("  | ");
				}
				if(j == 9) {
					System.out.println("\n"); 
				}
			}
		}
	}
	
	
}

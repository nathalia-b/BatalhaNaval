package batalhanaval;
import java.util.Scanner;
public class Jogador {

	public Tabuleiro tabuleiro;
	private int id, x, y;
	private String nome;
	private Scanner ler = new Scanner(System.in); 
	
	
	Jogador(){
		escolhe();
	}
	
	Jogador(int id){
		
		System.out.print("\nJogador " + id + ": Seus navios tamb�m ");
		setId(id);
		tabuleiro = new Tabuleiro(); 
		System.out.print("Qual o seu nome?  ");
		this.nome = ler.next();
		
	}
	
	private void escolhe() {
		do {
		System.out.print("Que jogador voc� deseja ser? (1 ou 2?)    ");
		this.id = ler.nextInt();
		System.out.print("Qual o seu nome?    ");
		this.nome = ler.next();
		setId(id);
		if(id != 1 && id != 2) {
			System.out.println("Op��o de jogador inv�lida. Por favor, tente novamente");
		}
		}while(id != 1 && id != 2);
		System.out.print("Ok, jogador " + id + ". Seus navios ");

		tabuleiro = new Tabuleiro();
	}
	public void indicaVez(int i) {
		if(i == 0) {
			System.out.println(" Jogador " + id + ", ainda � a sua vez! Tente novamente.");
		}else {
		System.out.println("\tJogador " + id + ", � a sua vez!");
		}
	}
	public void setCoordenadas() {
		int a = 1;		
			do {
			indicaVez(a);
			System.out.println("Por favor, " + nome.toUpperCase() + ", indique onde quer atirar (x,y de 0 a 9)");
			
			this.x = ler.nextInt();
			this.y = ler.nextInt(); 
			if(x >= 10 || y >= 10) {
				erro(x, y);
				a = 0;
			}
			}while(x >= 10 || y >= 10);
				
	}
	public void erro(int i, int j) {
		System.out.print("N�o existe posi��o ("+i+","+j+") no tabuleiro." );
	}
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	private void setId(int id){
		this.id = id; 
	}
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
}

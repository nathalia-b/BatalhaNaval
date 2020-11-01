package batalhanaval;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Jogo jogo = new Jogo();
		Scanner ler = new Scanner(System.in);
		int opt, a = 0;
	
		do {
			jogo.menu(a);
			opt = ler.nextInt();
			switch(opt) {
				case 1:
				jogo  = new Jogo(0);
				if(jogo.iniciaPartida()) {
				a = 1;
				}
				break;
				case 2: 
				jogo.howTo();
				break;
				
				case 3:
				jogo.bye(0);
				break;
				
				default:
				System.out.println("Opção inválida. Tente novamente.");
			}
			
		}while(opt != 3);
		
	}

}

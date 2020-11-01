package batalhanaval;

public class Jogo {

private Jogador jogador1;
private Jogador jogador2;
public int id;

Jogo(){
	
};
Jogo(int x){
	
	jogador1 = new Jogador(); 
	
	if(jogador1.getId() == 1) {
		jogador2 = new Jogador(2);
	}else if(jogador1.getId() == 2) {
		jogador2 = new Jogador(1);}else {
			System.out.println("Opção inválida");
		}
	
}
public boolean iniciaPartida() {
	System.out.println("\n\t>> Iniciando partida...\n");
	int c = 0;
	boolean a = false;
	
	while(a == false){
		if(jogador1.tabuleiro.verificaGanhador() > 17) {
			System.out.println("Poxa, " + jogador1.getNome().toUpperCase() + ". :(");
			System.out.println((jogador2.getNome()).toUpperCase() + " venceu. Parabéns!!");
			
			a = true;
			
			
		}else if(jogador2.tabuleiro.verificaGanhador() > 17 ) {
			System.out.println("Poxa, " + jogador2.getNome().toUpperCase() + ". :(");
			System.out.println(jogador1.getNome().toUpperCase() + " venceu. Parabéns!!");
			a = true;
			
		}else {
			if(c % 2 == 0) {
				jogada(jogador1, jogador1.getId());
			}else {
				jogada(jogador2, jogador2.getId());
	
			}
			if(c == 20 || c == 40 || c == 60 || c == 75) {
				System.out.println("_______________________________________________________________");
				System.out.println("Navios atingidos por " + jogador1.getNome().toUpperCase() + " até agora: ");
				jogador2.tabuleiro.printD(); 
				System.out.println("Navios antigidos por " + jogador2.getNome().toUpperCase() + " até agora: ");
				jogador1.tabuleiro.printD(); 
				System.out.println("_______________________________________________________________");

			}
			c++;
		}
		
	};
	bye(1);
	return a;
}	

public void jogada(Jogador jogador, int id) {
	boolean aux = false;
	if(id == 1) {
		do {
			jogador1.setCoordenadas(); 
			if(jogador2.tabuleiro.atingido(jogador1.getX(), jogador1.getY()) != 1) {
				aux = true;
			}
			
		}while(aux == false);
		
	}else {
		do {
			jogador2.setCoordenadas(); 
			if(jogador1.tabuleiro.atingido(jogador2.getX(), jogador2.getY()) != 1) {
				aux = true;
			}
		}while(aux == false);
		
	}
}
public void menu(int a) {
	System.out.println("\n\t\tSelecione a opção desejada:");
	if(a == 0) {System.out.println("\t1. Iniciar jogo\n\t2.Como jogar\n\t3.Sair");
	}else {System.out.println("\t1. Tentar novamente\n\t2.Como jogar\n\t3.Sair");
	}
	
	
}

public void howTo() {
	System.out.print("\nO objetivo do jogo é afundar todos os navios do oponente. ");
	System.out.print("Cada jogador tem cinco navios:\n\t>Um destruidor, com 2 quadrados;\n\t>Um submarino, com 3 quadrados;\n");
	System.out.print("\t>Um cruzador, com 3 quadrados;\n\t>Um navio de guerra, com 4 quadrados;\n\t>Um porta-aviões, com 5 quadrados;\n");
	System.out.print("O jogador deve indicar a linha e a coluna em que deseja atirar, indo do 0 ao 9.\n"
			+ "Quando um navio for atingido, a palavra >Fogo!< será impressa na tela, juntamente com o tipo do navio;\n"
			+ "O primeiro jogador que afundar todos os navios adversários, será o ganhador.\n");
	
}

public void bye(int a) {
	if(a == 1) {
		System.out.println("\nFim de jogo. Até a próxima! :)");

	}else {
		System.out.println("\nOk! Programa encerrado. Até a próxima ;)");
	}
}


}

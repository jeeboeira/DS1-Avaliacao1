package JogoDaVelha;

import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Bem-vindo ao Jogo da Velha!");

        // Coleta nomes e times dos jogadores
        System.out.print("Nome do jogador 1: ");
        String nome1 = scan.nextLine();
        System.out.print("Escolha o time (X/O): ");
        //chama a ferramenta escolhe time, para receber apenas X ou O.
        char time1 = Ferramentas.escolheTime(scan.next().charAt(0));

        System.out.print("Nome do jogador 2: ");
        String nome2 = scan.next();
        char time2 = (time1 == 'X') ? 'O' : 'X';
        System.out.printf("Seu time é o: %s%n", time2);

        //Cria os jogadores e inicia uma partida
        Jogador j1 = new Jogador(nome1, time1);
        Jogador j2 = new Jogador(nome2, time2);
        Jogo jogo = new Jogo();

        //Rotina padrão do jogo
        boolean continuar = true;
        while (continuar) {
            jogo.novoJogo();
            boolean fimDoJogo = false;
            while (!fimDoJogo) {
                //Aqui coloco if j1,j2 em relação aos jogos jogados
                //Terminar um jogo pra ver se tenho contador
                //Esse fim do jogo vai retornar true para fazer a condição desse while
                fimDoJogo = j1.joga(jogo, j1, j2) || j2.joga(jogo, j1, j2);
                jogo.atualizaTela();
            }
            continuar = Ferramentas.desejaContinuar();
        }
    }
}

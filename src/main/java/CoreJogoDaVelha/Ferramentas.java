package CoreJogoDaVelha;

import java.util.Scanner;

public class Ferramentas {
    static Scanner scan = new Scanner(System.in);

    public static Jogador[] inicializaJogadores() {
        // Coleta nomes e times dos jogadores
        System.out.print("Nome do jogador 1: ");
        String nome1 = scan.nextLine();
        System.out.print("Escolha o time (X/O): ");
        //chama a ferramenta escolhe time, para receber apenas X ou O.
        char time1 = escolheTime(scan.next().charAt(0));

        System.out.print("Nome do jogador 2: ");
        String nome2 = scan.next();
        char time2 = (time1 == 'X') ? 'O' : 'X';
        System.out.printf("Seu time é o: %s%n", time2);

        //Cria os jogadores
        Jogador j1 = new Jogador(nome1, time1);
        Jogador j2 = new Jogador(nome2, time2);

        return new Jogador[]{j1, j2};
    }

    public static char escolheTime(char time){
        switch (time){
            case 'X': case 'x':
                return 'X';
            //break;
            case 'O': case 'o':
                return 'O';
            //break;
            default:
                System.out.println("Opção inválida, escolha X ou O");
                escolheTime(scan.next().charAt(0));
        }
        return 0;
    }

    public static boolean desejaContinuar() {
        System.out.println("Deseja jogar novamente? (s/n)");
        String resposta = scan.next();
        if (resposta.equalsIgnoreCase("s")) {
            return true;
        } else {
            System.out.println("Fim de jogo!");
            return false; // O jogo encerra
        }
    }
}

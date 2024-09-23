package JogoDaVelha;

import Teste.Jogador;
import Teste.Jogo;

import java.util.Scanner;

public class Ferramentas {
    static Scanner scan = new Scanner(System.in);

    // Ferramenta escolhe time, recebe apenas X ou O ou indica o erro e entra em recursão.
    public static char escolheTime(char time){
        switch (time){
            case 'X': case 'x':
                return 'X';
            case 'O': case 'o':
                return 'O';
            default:
                System.out.println("Opção inválida, escolha X ou O");
                escolheTime(scan.next().charAt(0));
        }
        return 0;
    }

    public static void CriaJogadores() {
        //Coleta o nome do Jogador 1
        System.out.println("Nome do Jogador 1: ");
        String nome1 = scan.next();

        //Chama a ferramenta escolhe time, que recebe apenas X ou O.
        System.out.println("Escolha o time (X/O): ");
        char time1 = Ferramentas.escolheTime(scan.next().charAt(0));

        //Coleta o nome do Jogador 2
        System.out.println("Nome do Jogador 2: ");
        String nome2 = scan.next();

        //Realiza operação ternária para verificar o time restante
        char time2 = (time1 == 'X') ? 'O' : 'X';
        System.out.printf("Seu time é o: %s%n", time2);

        //Cria os jogadores
        Jogador j1 = new Jogador(nome1, time1);
        Jogador j2 = new Jogador(nome2, time2);
    }
}

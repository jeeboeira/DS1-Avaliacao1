package Teste;

import java.util.Scanner;

public class Ferramentas {
    static Scanner scan = new Scanner(System.in);

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
        return resposta.equalsIgnoreCase("s");
    }
}

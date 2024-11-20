package NewModes;

import java.util.Scanner;

public class GameModeHelper {
    static Scanner scan = new Scanner(System.in);

    public static void menuLoop(boolean continuePlaying) {
        // Menu Principal
        while (continuePlaying) {
            System.out.println("Bem Vindos ao jogo da Velha!");
            System.out.println("Escolha um modo de Jogo:");
            System.out.println("1. Jogar Local");
            System.out.println("2. Jogar Online");
            System.out.println("3. Criar Servidor");
            System.out.println("4. Sair");

            try {
                int choice = scan.nextInt();
                if (choice == 4) {
                    System.out.println("Finalizando Aplicação...");
                    continuePlaying = false;
                } else {
                    GameMode mode = GameModeFactory.getGameMode(choice);
                    mode.start();
                }
            } catch (Exception e) {
                System.out.println("Opção inválida, tente novamente.");
                scan.next();
            }
        }
    }


    public static boolean continuePlaying() {
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

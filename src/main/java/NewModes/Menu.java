package NewModes;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean continuePlaying = true;

        // Main menu loop
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
                    continuePlaying = false;
                    System.out.println("Finalizando Aplicação...");
                } else {
                    GameMode mode = GameModeFactory.getGameMode(choice);
                    mode.start();
                }
            } catch (Exception e) {
                System.out.println("Opção inválida, tente novamente.");
                scan.next();
            }
        }
        scan.close();
    }
}

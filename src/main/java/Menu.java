// Autor: Jessé de Oliveira Boeira 07 out 2024

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Bem-vindo ao Jogo da Velha!");
            System.out.println("Escolha o modo de jogo: ");
            System.out.println("1. Jogar Local");
            System.out.println("2. Jogar Online");
            System.out.println("3. Criar Servidor para jogo remoto");
            System.out.println("4. Sair");

            int escolha = scan.nextInt();

            switch (escolha) {
                case 1:
                    jogarLocal();
                    break;
                case 2:
                    jogarOnline();
                    break;
                case 3:
                    criarSevidor();
                    break;
                case 4:
                    continuar = false;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Escolha novamente.");
            }
        }
        scan.close();
    }

}

package JogoDaVelha;


import Teste.Jogo;

import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Bem-vindo ao Jogo da Velha!");

        // Recebe os nomes e times dos jogadores
        Ferramentas.CriaJogadores();
        // Inicia um jogo
        Jogo jogo = new Jogo();

    }
}

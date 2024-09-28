package JogoDaVelha;
ext

import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Bem-vindo ao Jogo da Velha!");

        // Recebe os nomes e times dos jogadores
        Ferramentas.CriaJogadores();
        // Inicia um jogo
        Jogo jogo = new Jogo();

        boolean continuar = true;
        while (continuar) {
            jogo.novoJogo();
            boolean fimDoJogo = false;
            while (!fimDoJogo) {
                fimDoJogo = j1.joga(jogo) || j2.joga(jogo);
                jogo.atualizaTela();
            }
            continuar = Ferramentas.desejaContinuar();
        }
    }
}

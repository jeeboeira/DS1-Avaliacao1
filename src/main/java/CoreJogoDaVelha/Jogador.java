package CoreJogoDaVelha;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Jogador implements InterfaceJogador{
    static Scanner scan = new Scanner(System.in);

    final String nome;
    final char time;
    private int vitorias; // Contador de vitórias

    //construtor do jogador
    public Jogador(String nome, char time) {
        this.nome = nome;
        this.time = time;
        this.vitorias = 0;
    }

    //Get
    public String getNome()     {return nome;}
    public char   getTime()     {return time;}
    public int    getVitorias() {return vitorias;}

    // Metodo para incrementar as vitórias
    public void incrementaVitorias() {
        vitorias++;
    }

    // Função core que trata as jogadas
    @Override
    public boolean joga(Jogo game) {
        boolean jogadaValida = false;

        // Continua pedindo entrada até que o jogador faça uma jogada válida
        while (!jogadaValida) {
            try {
                System.out.println(getNome() + ", escolha uma posição (0-8): ");
                int posicao = scan.nextInt();  // Lê a posição

                // Valida a jogada
                if (posicao < 0 || posicao > 8) {
                    System.out.println("Posição inválida! Escolha entre 0 e 8.");
                } else if (!game.fazerJogada(posicao, getTime())) {
                    System.out.println("Posição já ocupada! Escolha outra posição.");
                } else {
                    jogadaValida = true;  // Jogada válida, sai do loop
                }
            } catch (InputMismatchException e) {
                // Captura erro se a entrada não for um número e limpa o scanner
                System.out.println("Entrada inválida! Digite um número entre 0 e 8.");
                scan.next();  // Limpa o buffer do scanner para evitar loop
            }
        }
        // Após fazer a jogada, verifica se o jogo terminou
        return game.ehFimDoJogo();
    }

    @Override
    public void comemora() {System.out.println("Parabéns " + nome + "! Você ganhou.");}

    @Override
    public String toString() {
        return "Jogador{" +
                "nome='" + nome + '\'' +
                ", time=" + time +
                '}';
    }
}

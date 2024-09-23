package Teste;

import java.util.Scanner;



public class Jogador implements InterfaceJogador {
    private String nome;
    private char time;

    static Scanner scan = new Scanner(System.in);

    public Jogador(String nome, char time) {
        this.nome = nome;
        this.time = time;
    }


    public String getNome() {
        return nome;
    }

    public char getTime() {
        return time;
    }


    @Override
    public boolean joga(Jogo jogo) {
        System.out.printf("%s, escolha uma posição (0-8): ", nome);
        int posicao = scan.nextInt();
        if (jogo.fazerJogada(posicao, time)) {
            if (jogo.ehFimDoJogo()) {
                if (jogo.temVencedor(null, null) != null) {
                    System.out.println(nome + " venceu!");
                    return true;
                } else {
                    System.out.println("Empate!");
                    return true;
                }
            }
            return false;
        } else {
            System.out.println("Posição inválida. Tente novamente.");
            return joga(jogo);
        }
    }

    @Override
    public void comemora() {
        System.out.println("Parabéns " + nome + "! Você ganhou.");
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "nome='" + nome + '\'' +
                ", time=" + time +
                '}';
    }
}

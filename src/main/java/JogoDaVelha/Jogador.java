package JogoDaVelha;

import java.util.Scanner;

public class Jogador implements InterfaceJogador{
    static Scanner scan = new Scanner(System.in);

    private String nome;
    private char time;

    //construtor do jogador
    public Jogador(String nome, char time) {
        this.nome = nome;
        this.time = time;
    }

    //Get
    public String getNome() {return nome;}
    public char getTime() {return time;}


    //Função core que trata as jogadas
    @Override
    public boolean joga(Jogo game, Jogador j1, Jogador j2) {
        System.out.printf("%s, escolha uma posição (0-8): ", nome);
        int posicao = scan.nextInt();
        if (game.fazerJogada(posicao, time)) {  //Chama fazerJogada para validar a posição da jogada no array
            if (game.ehFimDoJogo()) {           //Chama ehFimDoJogo para verificar se já tem um vencedor ou empate
                if (game.temVencedor(j1, j2) != null) {
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
            return joga(game, j1, j2);
        }
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

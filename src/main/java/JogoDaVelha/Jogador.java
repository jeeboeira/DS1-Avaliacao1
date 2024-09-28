package JogoDaVelha;

import java.util.Scanner;

public class Jogador implements InterfaceJogador{
    static Scanner scan = new Scanner(System.in);

    private String nome;
    private char time;

    //construtor
    public Jogador(String nome, char time) {
        this.nome = nome;
        this.time = time;
    }

    //Get
    public String getNome() {return nome;}
    public char getTime() {return time;}


    @Override
    public boolean joga(Jogo game) {
        System.out.printf("%s, escolha uma posição (0-8): ", nome);
        int posicao = scan.nextInt();
        if (game.fazerJogada(posicao, time)) {
            if (game.ehFimDoJogo()) {
                if (game.temVencedor(null, null) != null) {
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
            return joga(game);
        }
    }

    @Override
    public void comemora() {

    }
}

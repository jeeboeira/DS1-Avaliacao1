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
        return false;
    }

    @Override
    public void comemora() {

    }
}

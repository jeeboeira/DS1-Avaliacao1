package JogoDaVelha;

public class Jogo implements InterfaceJogo{
    private char[] tabuleiro;
    private int    jogadas;

    //Construtor do jogo
    public Jogo() {
        this.tabuleiro = new char[9];
        novoJogo();
    }

    //Reinicia o tabuleiro
    @Override
    public void novoJogo() {
        for (int i = 0; i < 9; i++){
            tabuleiro[i] = ' ';
        }
        jogadas = 0;
    }

    @Override
    public Jogador temVencedor(Jogador j1, Jogador j2) {
        return null;
    }

    @Override
    public void atualizaTela() {

    }

    @Override
    public boolean ehEmpate() {
        return false;
    }

    @Override
    public boolean ehFimDoJogo() {
        return false;
    }
    public boolean fazerJogada(int posicao,char time){return false;}
}


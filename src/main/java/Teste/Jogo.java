package Teste;

public class Jogo implements InterfaceJogo{
    private char[] tabuleiro;
    private int jogadas;

    public Jogo() {
        this.tabuleiro = new char[9];
        novoJogo();
    }

    @Override
    public void novoJogo() {
        for (int i = 0; i < 9; i++) {
            tabuleiro[i] = ' ';
        }
        jogadas = 0;
    }

    @Override
    public Jogador temVencedor(Jogador j1, Jogador j2) {
        int[][] combinacoesVitoria = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                {0, 4, 8}, {2, 4, 6}
        };
        for (int[] combinacao : combinacoesVitoria) {
            if (tabuleiro[combinacao[0]] != ' ' &&
                    tabuleiro[combinacao[0]] == tabuleiro[combinacao[1]] &&
                    tabuleiro[combinacao[0]] == tabuleiro[combinacao[2]]) {
                return tabuleiro[combinacao[0]] == j1.getTime() ? j1 : j2;
            }
        }
        return null;
    }

    @Override
    public boolean ehEmpate() {
        return jogadas == 9 && temVencedor(null, null) == null;
    }

    @Override
    public boolean ehFimDoJogo() {
        return temVencedor(null, null) != null || ehEmpate();
    }

    @Override
    public void atualizaTela() {
        System.out.println(tabuleiro[0] + "|" + tabuleiro[1] + "|" + tabuleiro[2]);
        System.out.println("-----");
        System.out.println(tabuleiro[3] + "|" + tabuleiro[4] + "|" + tabuleiro[5]);
        System.out.println("-----");
        System.out.println(tabuleiro[6] + "|" + tabuleiro[7] + "|" + tabuleiro[8]);
    }

    public boolean fazerJogada(int posicao, char time) {
        if (tabuleiro[posicao] == ' ') {
            tabuleiro[posicao] = time;
            jogadas++;
            return true;
        }
        return false;
    }

}

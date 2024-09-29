package JogoDaVelha;

public class Jogo implements InterfaceJogo{
    private char[] tabuleiro;
    private int    jogadas;
    // Adicione os jogadores como atributos da classe
    private Jogador j1;
    private Jogador j2;

    //Construtor do jogo
    public Jogo(Jogador jogador1, Jogador jogador2) {
        this.tabuleiro = new char[9];
        this.j1 = jogador1;
        this.j2 = jogador2;
        novoJogo();
    }


    // Getter para j1
    public Jogador getJ1() {
        return j1;
    }

    // Getter para j2
    public Jogador getJ2() {
        return j2;
    }
    //Limpa o tabuleiro
    @Override
    public void novoJogo() {
        for (int i = 0; i < 9; i++){
            tabuleiro[i] = ' ';
        }
        jogadas = 0;
    }

    //Condições de vitória
    @Override
    public Jogador temVencedor(Jogador j1, Jogador j2) { //PRECISO TRAZER OS J1 E J2 PARA CÁ
        int[][] combinacoesVitoria = { //Seta todas as condições de vitória possíveis
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                {0, 4, 8}, {2, 4, 6}
        };
        for (int[] combinacao : combinacoesVitoria) { //Testa as condições de vitórias com o tabuleiro
            if (tabuleiro[combinacao[0]] != ' ' &&
                    tabuleiro[combinacao[0]] == tabuleiro[combinacao[1]] &&
                    tabuleiro[combinacao[0]] == tabuleiro[combinacao[2]]) {
                return tabuleiro[combinacao[0]] == j1.getTime() ? j1 : j2;
            }
        }
        return null;
    }

    @Override
    public void atualizaTela() {
        System.out.println(tabuleiro[0] + "|" + tabuleiro[1] + "|" + tabuleiro[2]);
        System.out.println("-----");
        System.out.println(tabuleiro[3] + "|" + tabuleiro[4] + "|" + tabuleiro[5]);
        System.out.println("-----");
        System.out.println(tabuleiro[6] + "|" + tabuleiro[7] + "|" + tabuleiro[8]);
    }

    @Override
    public boolean ehEmpate() {return jogadas == 9 && temVencedor(this.j1, this.j2) == null;}

    //verifica que tem um vencedor ou é empate para encerrar o jogo
    @Override
    public boolean ehFimDoJogo() {return temVencedor(this.j1, this.j2) != null || ehEmpate();}

    //Valida a posição da jogada no array
    public boolean fazerJogada(int posicao, char time) {
        if (tabuleiro[posicao] == ' ') {
            tabuleiro[posicao] = time;
            jogadas++;
            return true;
        }
        return false;
    }
}


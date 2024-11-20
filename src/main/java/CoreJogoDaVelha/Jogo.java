package CoreJogoDaVelha;

import rmi.UDPComm;

import java.util.Scanner;

public class Jogo implements InterfaceJogo{
    final char[] tabuleiro;
    private int    jogadas;
    final Jogador j1;
    final Jogador j2;

    //Construtor do jogo
    public Jogo(Jogador jogador1, Jogador jogador2) {
        this.tabuleiro = new char[9];
        this.j1 = jogador1;
        this.j2 = jogador2;
        novoJogo();
    }

    public Jogador getJ1() {return j1;}

    public Jogador getJ2() {return j2;}

    //Limpa o tabuleiro
    @Override
    public void novoJogo() {
        for (int i = 0; i < 9; i++){
            tabuleiro[i] = ' ';
        }
        jogadas = 0;
    }

    public void realizarPartida(Jogador j1, Jogador j2, boolean j1Inicia) {
        boolean fimDoJogo = false;

        //Realiza cada turno do jogo
        while (!fimDoJogo) {
            try {
                if (j1Inicia) {
                    fimDoJogo = j1.joga(this);    // Jogador 1 faz a jogada
                    atualizaTela();                     // Atualiza a tela após a jogada do jogador 1
                    if (!fimDoJogo) {                   // Verifica se o jogo ainda não terminou
                        fimDoJogo = j2.joga(this);// Jogador 2 faz a jogada
                        atualizaTela();                 // Atualiza a tela após a jogada do jogador 2
                    }
                } else {
                    fimDoJogo = j2.joga(this);    // Jogador 2 faz a jogada
                    atualizaTela();                     // Atualiza a tela após a jogada do jogador 2
                    if (!fimDoJogo) {                   // Verifica se o jogo ainda não terminou
                        fimDoJogo = j1.joga(this);// Jogador 1 faz a jogada
                        atualizaTela();                 // Atualiza a tela após a jogada do jogador 1
                    }
                }
            } catch (IllegalArgumentException e) {
                // Captura exceções de jogadas inválidas e informa ao jogador
                System.out.println("Jogada inválida: " + e.getMessage());
            } catch (Exception e) {
                // Captura qualquer outra exceção inesperada
                System.out.println("Ocorreu um erro durante a jogada: " + e.getMessage());
            }
        }
    }

    // Valida a posição da jogada no array
    public boolean fazerJogada(int posicao, char time) {
        if (tabuleiro[posicao] == ' ') {
            tabuleiro[posicao] = time;
            jogadas++;
            return true;
        }
        return false;
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

    //verifica se tem um vencedor ou é empate para encerrar o jogo
    @Override
    public boolean ehFimDoJogo() {return temVencedor(this.j1, this.j2) != null || ehEmpate();}

    @Override
    public boolean ehEmpate() {return jogadas == 9 && temVencedor(this.j1, this.j2) == null;}

    // Após o jogo terminar, verifica quem ganhou e contabiliza as vitórias
    public void exibirResultado(Jogador j1, Jogador j2) {
        Jogador vencedor = temVencedor(j1, j2);
        if (vencedor != null) {
            vencedor.incrementaVitorias();
            vencedor.comemora();
        } else if (ehEmpate()) {
            System.out.println("O jogo terminou em empate!");
        }
        System.out.println("Placar");
        System.out.println(j1.nome +": "+ j1.getVitorias() +" | "+ j2.nome +": "+ j2.getVitorias());

    }

    @Override
    public void atualizaTela() {
        System.out.println(tabuleiro[0] + "|" + tabuleiro[1] + "|" + tabuleiro[2]);
        System.out.println("-----");
        System.out.println(tabuleiro[3] + "|" + tabuleiro[4] + "|" + tabuleiro[5]);
        System.out.println("-----");
        System.out.println(tabuleiro[6] + "|" + tabuleiro[7] + "|" + tabuleiro[8]);
    }

    public static void startGame(Jogo jogo, UDPComm comm, boolean minhaVez) {
        Scanner scanner = new Scanner(System.in);

        while (!jogo.ehFimDoJogo()) {
            if (minhaVez) {
                jogo.atualizaTela();
                System.out.print("Escolha uma posição (0-8): ");
                int posicao = scanner.nextInt();

                // Atualiza localmente e envia jogada
                if (jogo.fazerJogada(posicao, jogo.getJ2().getTime())) {
                    comm.sendMsg(String.valueOf(posicao));
                    minhaVez = false;
                } else {
                    System.out.println("Posição inválida, tente novamente.");
                }
            } else {
                System.out.println("Aguardando jogada do oponente...");
                String msg = comm.receiveMsg();
                int posicao = Integer.parseInt(msg);

                // Atualiza tabuleiro com jogada recebida
                jogo.fazerJogada(posicao, jogo.getJ1().getTime());
                minhaVez = true;
            }

            if (jogo.temVencedor(jogo.getJ1(), jogo.getJ2()) != null || jogo.ehEmpate()) {
                jogo.exibirResultado(jogo.getJ1(), jogo.getJ2());
                break;
            }
        }
    }
}


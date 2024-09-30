package JogoDaVelha;

public class Main {

    public static void main(String[] args) {
        System.out.println("Bem-vindo ao Jogo da Velha!");

        // Inicializa os jogadores
        Jogador[] jogadores = Ferramentas.inicializaJogadores();
        Jogador j1 = jogadores[0];
        Jogador j2 = jogadores[1];

        // Cria o jogo e define quem começa
        Jogo jogo = new Jogo(j1, j2);
        boolean j1Comeca = true;
        boolean continuar = true;

        // Rotina do jogo
        while (continuar) {
            jogo.novoJogo();
            jogo.realizarPartida(j1, j2, j1Comeca);
            jogo.exibirResultado(j1, j2);

            // Exibe o placar
            System.out.printf("Vitórias: %s: %d, %s: %d%n",
                    j1.getNome(), j1.getVitorias(),
                    j2.getNome(), j2.getVitorias());

            // Alterna o jogador que começa
            j1Comeca = !j1Comeca;

            continuar = Ferramentas.desejaContinuar();
        }
    }
}

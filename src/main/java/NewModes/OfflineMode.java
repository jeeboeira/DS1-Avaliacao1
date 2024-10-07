package NewModes;

import CoreJogoDaVelha.Ferramentas;
import CoreJogoDaVelha.Jogador;
import CoreJogoDaVelha.Jogo;

public class OfflineMode implements GameMode{
    @Override
    public void start() {
        Jogador[] jogadores = Ferramentas.inicializaJogadores();
        Jogo jogo = new Jogo(jogadores[0], jogadores[1]);

        boolean j1Comeca = true;
        boolean continuar = true;
        while (continuar) {
            jogo.novoJogo();
            jogo.realizarPartida(jogadores[0], jogadores[1], j1Comeca);
            jogo.exibirResultado(jogadores[0], jogadores[1]);

            j1Comeca = !j1Comeca;
            continuar = Ferramentas.desejaContinuar();
        }
    }
}

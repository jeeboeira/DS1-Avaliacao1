package NewModes;

import CoreJogoDaVelha.PlayersHelper;
import CoreJogoDaVelha.Jogador;
import CoreJogoDaVelha.Jogo;

public class OfflineMode implements GameMode{
    @Override
    public void start() {
        Jogador jogador1 = PlayersHelper.createPlayer1();
        Jogador jogador2 = PlayersHelper.createPlayer2(jogador1);
        Jogo jogo = new Jogo(jogador1, jogador2);

        boolean j1Comeca = true;
        boolean continuar = true;
        while (continuar) {
            jogo.novoJogo();
            jogo.realizarPartida(jogador1, jogador2, j1Comeca);
            jogo.exibirResultado(jogador1, jogador2);

            j1Comeca = !j1Comeca;
            continuar = GameModeHelper.continuePlaying();
        }
    }
}

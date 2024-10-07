package NewModes;

import CoreJogoDaVelha.Ferramentas;
import CoreJogoDaVelha.Jogador;

public class OnlineLocalMode implements GameMode {
    @Override
    public void start() {
        try {
            Jogador[] jogadores = Ferramentas.inicializaJogadores();
            //JogoDaVelhaServidor
        }
    }
}

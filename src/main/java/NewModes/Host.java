package NewModes;

import CoreJogoDaVelha.PlayersHelper;
import CoreJogoDaVelha.Jogador;
import CoreJogoDaVelha.Jogo;
import rmi.UDPComm;

// Um jogador local, outro se conecta remotamente
public class Host {
    private static final int PORT = 1099;
    private String opponentHost;

    public void start() {
        try {
            System.out.println("Aguardando conexão do outro jogador...");
            UDPComm comm = new UDPComm(PORT);

            // Recebe mensagem inicial (time + nome do jogador remoto)
            String msg = comm.receiveMsg();
            System.out.println("Conexão recebida de " + comm.getHost());
            opponentHost = comm.getHost();

            // Extrai informações do jogador remoto
            char timeRemoto = msg.charAt(0);
            String nomeRemoto = msg.substring(1);
            Jogador jogador1 = new Jogador(nomeRemoto, timeRemoto);

            // Cria o jogador local
            Jogador jogador2 = PlayersHelper.createPlayer2(jogador1);

            // Inicializa o jogo
            Jogo jogo = new Jogo(jogador1, jogador2);
            Jogo.startGame(jogo, comm, true);

        } catch (Exception e) {
            System.out.println("Erro ao iniciar como host: " + e.getMessage());
        }
    }
}
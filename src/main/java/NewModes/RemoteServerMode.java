package NewModes;

import CoreJogoDaVelha.Jogador;
import rmi.JogoDaVelhaServidor;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

// Cria um servidor remoto
public class RemoteServerMode implements GameMode {

    @Override
    public void start() {
        try {
            Jogador player1 = new Jogador("Player 1", 'X');
            Jogador player2 = new Jogador("Player 2", 'O');

            JogoDaVelhaServidor server = new JogoDaVelhaServidor(player1, player2);

            // Create and bind the RMI registry to allow remote connections
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("JogoDaVelha", server);

            System.out.println("Servidor RMI criado. Jogadores remotos podem se conectar agora.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

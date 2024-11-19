package NewModes;

import CoreJogoDaVelha.Ferramentas;
import CoreJogoDaVelha.Jogador;
import rmi.JogoDaVelhaServidor;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

// Um jogador local, outro se conecta remotamente
public class OnlineLocalMode implements GameMode {

    @Override
    public void start() {
        try {
            // Inicializa os jogadores
            Jogador[] jogadores = Ferramentas.inicializaJogadores();
            JogoDaVelhaServidor server = new JogoDaVelhaServidor(jogadores[0], new Jogador("Player 2", 'O'));

            // Cria o registro RMI
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("JogoDaVelha", server);

            System.out.println("Server created. Player 2 can now connect.");

            // Main game loop
            boolean continuePlaying = true;
            Scanner scan = new Scanner(System.in);

            while (continuePlaying) {
                System.out.println("Aguardando jogada do adversário....");

                //Jogador 1
                System.out.println("Escolha uma posição (0-8): ");
                int position = scan.nextInt();
                server.fazerJogada(position, jogadores[0].getNome());

                //Verifica condições de fim
                if (server.ehFimdoJogo()) {
                    if (server.temVencedor() != null) {
                        System.out.println(server.temVencedor().getNome() + "Você venceu!");
                    }else {
                        System.out.println("Empate!");
                    }

                    System.out.println(server.obterPlacar());

                    // Verifica se jogadores querem continuar
                    continuePlaying = Ferramentas.desejaContinuar();
                    if (continuePlaying) {
                        server.iniciarNovoJogo();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package rmi;

import NewModes.GameModeHelper;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Player2Client {
    public static void main(String[] args) {
        try {
            //Conecta ao servidor RMI
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            JogoDaVelhaRMI game = (JogoDaVelhaRMI) registry.lookup("JogoDaVelha");

            Scanner scan = new Scanner(System.in);

            boolean continuePlaying = true;
            while (continuePlaying) {
                System.out.println("Choose a position (0-8): ");
                int position = scan.nextInt();

                //Player 2 faz a jogada
                game.fazerJogada(position, "Player 2");

                if (game.ehFimdoJogo()) {
                    if (game.temVencedor() != null) {
                        System.out.println(game.temVencedor().getNome() + " Você venceu!");
                    } else {
                        System.out.println("Empate");
                    }

                    System.out.println(game.obterPlacar());

                    // Perguntar se o Player 2 deseja continuar
                    continuePlaying = GameModeHelper.continuePlaying();
                    if (continuePlaying) {
                        game.iniciarNovoJogo();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

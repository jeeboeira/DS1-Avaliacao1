package rmi;

import CoreJogoDaVelha.Jogador;
import CoreJogoDaVelha.Jogo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;

public class JogoDaVelhaServidor extends UnicastRemoteObject implements JogoDaVelhaRMI {
    private final Jogo jogo;
    private boolean vezDoPlayer1 = true;

    public JogoDaVelhaServidor (Jogador j1, Jogador j2) throws RemoteException {
        this.jogo = new Jogo(j1, j2);
    }

    @Override
    public synchronized void fazerJogada(int posicao, String nomeJogador) throws RemoteException {
        if (vezDoPlayer1 && nomeJogador.equals(jogo.getJ1().getNome())) {
            // Player 1 faz a jogada
            jogo.fazerJogada(posicao, jogo.getJ1().getTime());
            vezDoPlayer1 = false;  // Passa a vez para o Player 2
        } else if (!vezDoPlayer1 && nomeJogador.equals(jogo.getJ2().getNome())) {
            // Player 2 faz a jogada
            jogo.fazerJogada(posicao, jogo.getJ2().getTime());
            vezDoPlayer1 = true;  // Passa a vez para o Player 1
        } else {
            System.out.println("Não é a sua vez!");
        }

        // Verificar se o jogo acabou após a jogada
        if (ehFimdoJogo()) {
            temVencedor();
        }
    }

    @Override
    public String obterTabuleiro() throws RemoteException {
        return "";
    }

    @Override
    public boolean ehFimdoJogo() throws RemoteException {
        return jogo.ehFimDoJogo();
    }

    @Override
    public Jogador temVencedor() throws RemoteException {
        return jogo.temVencedor(jogo.getJ1(), jogo.getJ2());
    }

    @Override
    public void iniciarNovoJogo() throws RemoteException {
        jogo.novoJogo();
    }

    @Override
    public String obterPlacar() throws RemoteException {
        return String.format("Vitórias: %s: %d, %s: %d",
                jogo.getJ1().getNome(), jogo.getJ1().getVitorias(),
                jogo.getJ2().getNome(), jogo.getJ2().getVitorias());
    }

    @Override
    public String obterInformacoesDoServidor() throws RemoteException {
        return "Data e Hora: " + LocalDateTime.now() + "\nSistema Operacional: " + System.getProperty("os.name");
    }
}

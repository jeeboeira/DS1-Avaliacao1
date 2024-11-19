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
    public JogoDaVelhaServidor(Jogador j1, Jogador j2) throws RemoteException {
        jogo = new Jogo(j1, j2); //Inicializa o jogo com dois jogadores
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
    public boolean fazerJogada(int posicao, char time) throws RemoteException {
        return jogo.fazerJogada(posicao, time); // Metodo remoto para fazer uma jogada
    }

    @Override
    public boolean ehFimDoJogo() throws RemoteException {
        return jogo.ehFimDoJogo(); // Verifica se o jogo terminou
    }

    @Override
    public String obterTabuleiro() throws RemoteException {
        // Retorna o tabuleiro do jogo em uma string formatada
        StringBuilder tabuleiro = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            tabuleiro.append(jogo.tabuleiro[i]);
            if ((i +1) % 3 == 0) tabuleiro.append("\n");
            else tabuleiro.append("|");
        }
        return tabuleiro.toString();
    }

    @Override
    }

    @Override
    public String obterInformacoesDoServidor() throws RemoteException {
        return "Data e Hora: " + LocalDateTime.now() + "\nSistema Operacional: " + System.getProperty("os.name");
    }
}

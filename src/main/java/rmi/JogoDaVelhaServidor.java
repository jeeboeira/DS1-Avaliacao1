package rmi;

import JogoDaVelha.Jogador;
import JogoDaVelha.Jogo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;

public class JogoDaVelhaServidor extends UnicastRemoteObject implements JogoDaVelhaRMI {
    private Jogo jogo; // O objeto do jogo que mantém o estado

    public JogoDaVelhaServidor(Jogador j1, Jogador j2) throws RemoteException {
        jogo = new Jogo(j1, j2); //Inicializa o jogo com dois jogadores
    }

    @Override
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
    public Jogador temVencedor() throws RemoteException {
        return jogo.temVencedor(jogo.j1, jogo.j2); // Retorna o vencedor, se houver
    }

    @Override
    public String obterInformacoesDoServidor() throws RemoteException {
        // Metodo remoto que retorna informações do servidor
        return "Data e Hora: " + LocalDateTime.now() + "\nSistema Operacional: " + System.getProperty("os.name");
    }
}

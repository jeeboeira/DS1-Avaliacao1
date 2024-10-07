package rmi;

import JogoDaVelha.Jogador;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface JogoDaVelhaRMI extends Remote {
    boolean fazerJogada(int posicao, char time) throws RemoteException;
    boolean ehFimDoJogo() throws RemoteException;
    String obterTabuleiro() throws RemoteException;
    Jogador temVencedor() throws RemoteException;
    String obterInformacoesDoServidor() throws RemoteException;
}

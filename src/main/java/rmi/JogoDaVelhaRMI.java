package rmi;

import CoreJogoDaVelha.Jogador;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface JogoDaVelhaRMI extends Remote {
    void fazerJogada(int posicao, String nomeJogador) throws RemoteException;
//    String obterTabuleiro() throws RemoteException;
    boolean ehFimdoJogo() throws RemoteException;
    boolean fazerJogada(int posicao, char time) throws RemoteException;
    boolean ehFimDoJogo() throws RemoteException;
    String obterTabuleiro() throws RemoteException;
    Jogador temVencedor() throws RemoteException;
    void iniciarNovoJogo() throws RemoteException;
    String obterPlacar() throws RemoteException;
    String obterInformacoesDoServidor() throws RemoteException;


}

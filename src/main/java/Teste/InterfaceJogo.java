package Teste;

public interface InterfaceJogo {

    void novoJogo();
    public Jogador temVencedor(Jogador j1, Jogador j2);
    public boolean ehEmpate();
    public boolean ehFimDoJogo();
    public void atualizaTela();
}

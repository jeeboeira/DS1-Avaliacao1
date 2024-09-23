package JogoDaVelha;

public interface InterfaceJogo {
    public Jogador temVencedor  (Jogador j1, Jogador j2);
    public void    novoJogo     ();
    public void    atualizaTela ();
    public boolean ehEmpate     ();
    public boolean ehFimDoJogo  ();
}

package JogoDaVelha;

import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Bem-vindo ao Jogo da Velha!");

        // Coleta nomes e times dos jogadores
        System.out.print("Nome do jogador 1: ");
        String nome1 = scan.nextLine();
        System.out.print("Escolha o time (X/O): ");
        //chama a ferramenta escolhe time, para receber apenas X ou O.
        char time1 = Ferramentas.escolheTime(scan.next().charAt(0));

        System.out.print("Nome do jogador 2: ");
        String nome2 = scan.next();
        char time2 = (time1 == 'X') ? 'O' : 'X';
        System.out.printf("Seu time é o: %s%n", time2);

        //Cria os jogadores e inicia uma partida
        Jogador j1 = new Jogador(nome1, time1);
        Jogador j2 = new Jogador(nome2, time2);
        Jogo jogo = new Jogo(j1, j2);

        // Flag para alternar quem começa a partida
        boolean j1Comeca = true;

        //Rotina padrão do jogo
        boolean continuar = true;
        while (continuar) {
            jogo.novoJogo();
            boolean fimDoJogo = false;
            while (!fimDoJogo) {
                //Aqui coloco if j1,j2 em relação aos jogos jogados
                //Terminar um jogo pra ver se tenho contador
                //Esse fim do jogo vai retornar true para fazer a condição desse while
                // Alterna a vez de iniciar
                if (j1Comeca) {
                    fimDoJogo = j1.joga(jogo);
                    jogo.atualizaTela(); // Atualiza a tela após a jogada do jogador 1
                    if (!fimDoJogo) { // Verifica se o jogo ainda não terminou
                        fimDoJogo = j2.joga(jogo);
                        jogo.atualizaTela(); // Atualiza a tela após a jogada do jogador 2
                    }
                } else {
                    fimDoJogo = j2.joga(jogo);
                    jogo.atualizaTela(); // Atualiza a tela após a jogada do jogador 2
                    if (!fimDoJogo) { // Verifica se o jogo ainda não terminou
                        fimDoJogo = j1.joga(jogo);
                        jogo.atualizaTela(); // Atualiza a tela após a jogada do jogador 1
                    }
                }
            }
            // Após o jogo terminar, verifica quem ganhou e contabiliza as vitórias
            Jogador vencedor = jogo.temVencedor(j1, j2);
            if (vencedor != null) {
                vencedor.incrementaVitorias();
                System.out.println(vencedor.getNome() + " venceu!");
            } else if (jogo.ehEmpate()) { // Verifica se houve um empate
                System.out.println("O jogo terminou em empate!");
            }
            // Exibe o placar de vitórias
            System.out.printf("Vitórias: %s: %d, %s: %d%n",
                    j1.getNome(), j1.getVitorias(),
                    j2.getNome(), j2.getVitorias());

            // Alterna o jogador que começa na próxima partida
            j1Comeca = !j1Comeca;
            continuar = Ferramentas.desejaContinuar();
        }
    }
}

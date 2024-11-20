package NewModes;


import java.util.Scanner;

public class OnlineMode implements GameMode{
    private boolean isHost;

    @Override
    public void start() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Escolha um opção:");
        System.out.println("1. Ser o host");
        System.out.println("2. Conectar a outro jogador");
        int choice = scan.nextInt();

        if (choice == 1){
            new Host().start();
        } else if (choice == 2) {
            new Player2().start();
        }else{
            System.out.println("Opção inválida.");
            start();
        }
    }
}

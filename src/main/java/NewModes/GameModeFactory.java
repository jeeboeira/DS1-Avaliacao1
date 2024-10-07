package NewModes;

public class GameModeFactory {

    public static GameMode getGameMode(int option) {
        switch (option) {
            case 1:
                return new OfflineMode();
            case 2:
                return new OnlineLocalMode();
            case 3:
                return new RemoteServerMode();
            default:
                throw new IllegalArgumentException("Opção inválida");
        }
    }
}

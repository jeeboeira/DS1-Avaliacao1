module com.example.ds1avaliacao1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.rmi;

    // Exporta o pacote rmi para permitir que o java.rmi tenha acesso às classes remotas
    exports rmi to java.rmi;
    exports CoreJogoDaVelha;

    opens com.example.ds1avaliacao1 to javafx.fxml;
    exports com.example.ds1avaliacao1;
}
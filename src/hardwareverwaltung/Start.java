package hardwareverwaltung;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.time.LocalDate;

public class Start extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Drucker d1 = new Drucker(
                "S001",
                "HP DeskJet 2630",
                "HP",
                "ok",
                12,
                LocalDate.of(2018, 11, 11),
                "Tintenstrahldrucker",
                true,
                "A4"
        );

        String s = "Lieferdatum: " + d1.getLieferdatum() + "\nGarantieende: " + d1.berechneGarantieende();
        Alert nachricht = new Alert(Alert.AlertType.INFORMATION, s);

        nachricht.setResizable(true);
        nachricht.onShownProperty().addListener(e -> {
            Platform.runLater(() -> nachricht.setResizable(false));
        });

        nachricht.showAndWait();

        d1.drucken(150);
        d1.drucken(100);

        d1.wechsleBetriebsmittel(2000);
        d1.drucken(1000);

        Alert nachricht2 = new Alert(Alert.AlertType.INFORMATION, d1.toString());

        /*
            Dies ist notwendig unter Linux und der Oberflaeche KDE,
            damit ein Fehler behoben wird beim anzeigen des Fensters.
         */
        nachricht2.setResizable(true);
        nachricht2.onShownProperty().addListener(e -> {
            Platform.runLater(() -> nachricht2.setResizable(false));
        });

        nachricht2.showAndWait();
    }
}

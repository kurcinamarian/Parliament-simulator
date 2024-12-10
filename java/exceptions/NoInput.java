package exceptions;

import javafx.scene.control.Alert;

/**
 * Výnimka pre chýbajúci vstup.
 */
public class NoInput extends Exception{
    /**
     * Metóda pre zobrazenie upozornenia o chýbajúcom vstupe.
     */
    public void alert(){
        // Vytvorenie nového dialógového okna pre chybu
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Nespravny vstup");
        alert.setHeaderText(null);
        alert.setContentText("Chybajuce parametre");
        // Zobrazenie dialógového okna a čakanie na jeho zatvorenie
        alert.showAndWait();
    }
}

package exceptions;

import javafx.scene.control.Alert;
/**
 * Výnimka pre chýbajúci parlament.
 */
public class NoParliament extends Exception{
    /**
     * Metóda pre zobrazenie upozornenia o chýbajúcom parlamente.
     */
    public void alert(){
        // Vytvorenie nového dialógového okna pre chybu
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Chybajuci parlament");
        alert.setHeaderText(null);
        alert.setContentText("Parlament este nebol vytvoreny");
        // Zobrazenie dialógového okna a čakanie na jeho zatvorenie
        alert.showAndWait();
    }
}

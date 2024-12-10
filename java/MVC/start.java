package MVC;

import GUI.voting_GUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import voting.*;

/**
 * Trieda start slúži na spustenie aplikácie a inicializáciu hlavných komponentov rozhrania.
 */
public class start extends Application {
    /**
     * Hlavná metóda main, ktorá spúšťa aplikáciu.
     *
     * @param args Argumenty príkazového riadku.
     */
    public static void main(String[] args) {
        launch(args);
    }
    /**
     * Metóda start inicializuje a spúšťa aplikáciu.
     *
     * @param stage Hlavné okno aplikácie.
     */
    public void start(Stage stage){
        stage.setTitle("Parlament simulator");
        //Vytvorenie modelu,viewera a controllera
        parliament model = new parliament();
        voting_GUI view = new voting_GUI();
        controller controller = new controller(model,view);
        //Nastavenie scény
        stage.setScene(new Scene(view.layout(),800,400));
        stage.show();
        view.ButtonListener(controller);
    }
}

package MVC;
import GUI.voting_GUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import voting.parliament;

public class start extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage stage){
        stage.setTitle("Volba");
        parliament model = new parliament();
        voting_GUI view = new voting_GUI();
        controller controller = new controller(model,view);
        stage.setScene(new Scene(view.layout(),800,400));
        stage.show();
        view.ButtonListener(controller);
    }
}

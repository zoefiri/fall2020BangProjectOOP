package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

public class FinishController {
    public Button btnQuit;
    public Button btnGo;
    public Slider sliderBots;

    public void handleQuit(ActionEvent actionEvent) {
        ((Stage)btnQuit.getScene().getWindow()).close();
    }

    public void handleGo(ActionEvent actionEvent) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Game.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load()));
        stage.setTitle("Bang! The Dice Game");
        GameController gc = loader.getController();
        gc.init((int)sliderBots.getValue());
        stage.show();
        ((Stage)btnQuit.getScene().getWindow()).close();
    }
}

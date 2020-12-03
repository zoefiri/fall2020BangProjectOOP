package Fall2020OOPProject3.UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

public class StartController {
    public Button btnPlay;
    public Slider sliderBots;
    public CheckBox cbExpOS;
    public CheckBox cbExpUoA;

    private int bots;

    public void handlePlay(ActionEvent actionEvent) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Game.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load()));
        stage.setTitle("Bang! The Dice Game");
        GameController gc = loader.getController();
        gc.init((int)sliderBots.getValue(), cbExpOS.isSelected(), cbExpUoA.isSelected());
        stage.show();
        ((Stage)btnPlay.getScene().getWindow()).close();
    }
}

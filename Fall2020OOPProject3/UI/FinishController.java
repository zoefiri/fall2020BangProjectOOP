package Fall2020OOPProject3.UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FinishController {
    public Button btnQuit;
    public Button btnGo;
    public Slider sliderBots;
    public CheckBox cbExpOS;
    public CheckBox cbExpUoA;
    public Text txtWin;

    public void init(String winners, boolean playerWin) {
        if (playerWin)
            txtWin.setText("Congratulations! " + winners + " win.");
        else
            txtWin.setText("Better luck next time! " + winners + " win.");

    }

    public void handleQuit(ActionEvent actionEvent) {
        ((Stage)btnQuit.getScene().getWindow()).close();
    }

    public void handleGo(ActionEvent actionEvent) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Game.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load()));
        stage.setTitle("Bang! The Dice Game");
        GameController gc = loader.getController();
        gc.init((int)sliderBots.getValue(), cbExpOS.isSelected(), cbExpUoA.isSelected());
        stage.show();
        ((Stage)btnQuit.getScene().getWindow()).close();
    }
}

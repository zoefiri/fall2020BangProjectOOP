package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javax.xml.soap.Text;

public class GameController {
    public Button btnTemp;

    public void init(int b) {
        System.out.println("Create game with " + b + " bots.");
        this.btnTemp.setText(String.valueOf(b));
    }


    public void handleTemp(ActionEvent actionEvent) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Finish.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load()));
        stage.setTitle("Bang! The Dice Game");
        FinishController gc = loader.getController();
        stage.show();
        ((Stage)btnTemp.getScene().getWindow()).close();
    }
}

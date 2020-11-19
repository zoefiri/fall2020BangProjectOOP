package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

import javax.xml.soap.Text;

public class GameController {
    public int bots;

    public Polygon polyOct;
    private static final String tableURL = "/UI/table.jpg";

    public void init(int b) {
        this.bots = b;
        Image table = new Image(tableURL);
        polyOct.setFill(new ImagePattern(table));
    }


    public void handleTemp(ActionEvent actionEvent) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Finish.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load()));
        stage.setTitle("Bang! The Dice Game");
        FinishController gc = loader.getController();
        stage.show();
        ((Stage)polyOct.getScene().getWindow()).close();
    }
}

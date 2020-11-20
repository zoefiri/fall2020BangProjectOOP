package Fall2020OOPProject3.UI;

import Fall2020OOPProject3.Player;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javax.xml.soap.Text;
import java.util.ArrayList;
import java.util.Random;

public class GameController {
    public Rectangle rectPlayer;
    public Circle circPlayer1;
    public Circle circPlayer2;
    public Circle circPlayer3;
    public Circle circPlayer4;
    public Circle circPlayer5;
    public Circle circPlayer6;
    public Circle circPlayer7;
    public Circle circPlayer8;
    public Circle circPlayer9;

    public Rectangle rectBot1;
    public Circle circBot11;
    public Circle circBot12;
    public Circle circBot13;
    public Circle circBot14;
    public Circle circBot15;
    public Circle circBot16;
    public Circle circBot17;
    public Circle circBot18;
    public Circle circBot19;

    public Rectangle rectBot2;
    public Circle circBot21;
    public Circle circBot22;
    public Circle circBot23;
    public Circle circBot24;
    public Circle circBot25;
    public Circle circBot26;
    public Circle circBot27;
    public Circle circBot28;
    public Circle circBot29;

    public Rectangle rectBot3;
    public Circle circBot31;
    public Circle circBot32;
    public Circle circBot33;
    public Circle circBot34;
    public Circle circBot35;
    public Circle circBot36;
    public Circle circBot37;
    public Circle circBot38;
    public Circle circBot39;

    public Rectangle rectBot4;
    public Circle circBot41;
    public Circle circBot42;
    public Circle circBot43;
    public Circle circBot44;
    public Circle circBot45;
    public Circle circBot46;
    public Circle circBot47;
    public Circle circBot48;
    public Circle circBot49;

    public Rectangle rectBot5;
    public Circle circBot51;
    public Circle circBot52;
    public Circle circBot53;
    public Circle circBot54;
    public Circle circBot55;
    public Circle circBot56;
    public Circle circBot57;
    public Circle circBot58;
    public Circle circBot59;

    public Rectangle rectBot6;
    public Circle circBot61;
    public Circle circBot62;
    public Circle circBot63;
    public Circle circBot64;
    public Circle circBot65;
    public Circle circBot66;
    public Circle circBot67;
    public Circle circBot68;
    public Circle circBot69;

    public Rectangle rectBot7;
    public Circle circBot71;
    public Circle circBot72;
    public Circle circBot73;
    public Circle circBot74;
    public Circle circBot75;
    public Circle circBot76;
    public Circle circBot77;
    public Circle circBot78;
    public Circle circBot79;

    public Polygon polyOct;
    public Button btnRoll;

    //private int bots;
    private ArrayList<Player> players = new ArrayList<Player>();
    private static final String tableURL = "/Fall2020OOPProject3/UI/table.jpg";
    private static final String tempURL = "/Fall2020OOPProject3/UI/temp.png";
    private static final String noneURL = "/Fall2020OOPProject3/UI/none.png";


    public void init(int b) {
        //this.bots = b;
        for (int i = 0; i < b; i++) {
            int pickChar = new Random().nextInt(Player.Character.values().length);
            int pickRole = new Random().nextInt(Player.Role.values().length);
            players.add(new Player(Player.Character.values()[pickChar], Player.Role.values()[pickRole]));
        }
        Image temp = new Image(tempURL);
        Image table = new Image(tableURL);
        Image none = new Image(noneURL);

        rectPlayer.setFill(new ImagePattern(temp));
        polyOct.setFill(new ImagePattern(table));

        // set fill for bot seats
        Rectangle[] rectChars = {this.rectBot1, this.rectBot2, this.rectBot3, this.rectBot4, this.rectBot5, this.rectBot6, this.rectBot7};
        for (int i = 0; i < players.size(); i++) {
            rectChars[i].setFill(new ImagePattern(temp));
        }
        // set fill for non-player or non-bot seats
        for (int i = players.size(); i < rectChars.length; i++) {
            rectChars[i].setFill(new ImagePattern(none));
        }
    }

    /**
     * Handle the pressing of the roll button.
     *
     * @param actionEvent the action event of pressing the roll button
     */
    public void handleRoll(ActionEvent actionEvent) {

    }


    /**
    public void handleTemp(ActionEvent actionEvent) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Finish.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load()));
        stage.setTitle("Bang! The Dice Game");
        FinishController gc = loader.getController();
        stage.show();
        ((Stage)polyOct.getScene().getWindow()).close();
    }
     */
}

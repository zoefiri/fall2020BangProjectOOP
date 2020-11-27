package Fall2020OOPProject3.UI;

import Fall2020OOPProject3.Player;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

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
    
    
    //Die images from Roll tab
    public ImageView imgDie1;
    public ImageView imgDie2;
    public ImageView imgDie3;
    public ImageView imgDie4;
    public ImageView imgDie5;

    //Button for rolling from Roll tab
    public Button btnRoll;
    public TableView discoveredRolesTable;

    //private int bots;
    private ArrayList<Player> players = new ArrayList<Player>();

    // ImagePatterns for filling
    private static final ImagePattern imgpatTemp = new ImagePattern(new Image("/Fall2020OOPProject3/UI/art/temp.png"));
    private static final ImagePattern imgpatTable = new ImagePattern(new Image("/Fall2020OOPProject3/UI/art/table.jpg"));
    private static final ImagePattern imgpatNone = new ImagePattern(new Image("/Fall2020OOPProject3/UI/art/none.png"));
    private static final ImagePattern imgpatArrow = new ImagePattern(new Image("/Fall2020OOPProject3/UI/art/arrow.png"));

    /**
     * Initialize the Game.fxml stage
     *
     * @param b the number of bots with which to start the game
     */
    public void init(int b) {
        /*
            set up "Players" tab of "Game.fxml"
                Fill character cards
                Fill Arrows
                Fill table
         */
        Rectangle[] rectChars = {this.rectPlayer, this.rectBot1, this.rectBot2, this.rectBot3, this.rectBot4, this.rectBot5, this.rectBot6, this.rectBot7};
        // assign characters
        for (int i = 0; i < b+1; i++) {
            int pickChar = new Random().nextInt(Player.Character.values().length);
            int pickRole = new Random().nextInt(Player.Role.values().length);
            players.add(new Player(Player.Character.values()[pickChar], Player.Role.values()[pickRole]));
            rectChars[i].setFill(new ImagePattern(new Image("/Fall2020OOPProject3/UI/art/characters/" + Player.Character.values()[pickChar].toString() + ".png")));
        }
        // set fill for table
        this.polyOct.setFill(imgpatTable);
        // set fill for non-player or non-bot seats
        for (int i = players.size(); i < rectChars.length; i++) {
            rectChars[i].setFill(imgpatNone);
            rectChars[i].setStroke(Color.TRANSPARENT);
        }
        updArrows();


        /*
         * Assign lambda listeners for each image which set let the player toggle their locked/unlocked state
         * e.g. if(player == activeCharacter && this_die_unlockable) toggleLocked(); or something like this
         */
        
        //showcase for reactive imageViews
        EventHandler<MouseEvent> mouseListener = (MouseEvent e) ->{
            if(e.getSource() instanceof ImageView) {
                ImageView tempDieImageView = (ImageView) e.getSource();
                tempDieImageView.setImage(new Image("file:src/Fall2020OOPProject3/UI/table.jpg"));
            }
        };
        //assign listener to all images
        imgDie1.setOnMouseClicked(mouseListener);
        imgDie2.setOnMouseClicked(mouseListener);
        imgDie3.setOnMouseClicked(mouseListener);
        imgDie4.setOnMouseClicked(mouseListener);
        imgDie5.setOnMouseClicked(mouseListener);
    }

    /**
     * Update arrow art to reflect the number of arrows held by each player or bot
     *
     */
    private void updArrows() {
        Circle[] play = {this.circPlayer1, this.circPlayer2, this.circPlayer3, this.circPlayer4, this.circPlayer5, this.circPlayer6, this.circPlayer7, this.circPlayer8, this.circPlayer9};
        Circle[] bot1 = {this.circBot11, this.circBot12, this.circBot13, this.circBot14, this.circBot15, this.circBot16, this.circBot17, this.circBot18, this.circBot19};
        Circle[] bot2 = {this.circBot21, this.circBot22, this.circBot23, this.circBot24, this.circBot25, this.circBot26, this.circBot27, this.circBot28, this.circBot29};
        Circle[] bot3 = {this.circBot31, this.circBot32, this.circBot33, this.circBot34, this.circBot35, this.circBot36, this.circBot37, this.circBot38, this.circBot39};
        Circle[] bot4 = {this.circBot41, this.circBot42, this.circBot43, this.circBot44, this.circBot45, this.circBot46, this.circBot47, this.circBot48, this.circBot49};
        Circle[] bot5 = {this.circBot51, this.circBot52, this.circBot53, this.circBot54, this.circBot55, this.circBot56, this.circBot57, this.circBot58, this.circBot59};
        Circle[] bot6 = {this.circBot61, this.circBot62, this.circBot63, this.circBot64, this.circBot65, this.circBot66, this.circBot67, this.circBot68, this.circBot69};
        Circle[] bot7 = {this.circBot71, this.circBot72, this.circBot73, this.circBot74, this.circBot75, this.circBot76, this.circBot77, this.circBot78, this.circBot79};
        Circle[][] arrows = {play, bot1, bot2, bot3, bot4, bot5, bot6, bot7};

        // set fill to none for all arrows
        for (int i = 0; i < arrows.length; i++) {
            for (int j = 0; j < arrows[i].length; j++) {
                arrows[i][j].setFill(imgpatNone);
            }
        }
        // set fill to arrow for all arrows which exist
        for (int i = 0; i < this.players.size(); i++) {
            for (int j = 0; j < this.players.get(i).getCurrentArrows(); j++) {
                arrows[i][j].setFill(imgpatArrow);
            }
        }
    }

    /**
     * Handle the pressing of the roll button.
     *
     * @param actionEvent the action event of pressing the roll button
     */
    public void handleRoll(ActionEvent actionEvent) {
        //should call game field -> player -> roll e.g. game.roll(Character.CHAR1); and then updates the images 
        //for each of the die faces. 
    }


    /*
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

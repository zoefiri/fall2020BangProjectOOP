package Fall2020OOPProject3.UI;

import Fall2020OOPProject3.Die;
import Fall2020OOPProject3.Game;

import Fall2020OOPProject3.Player;
import Fall2020OOPProject3.VanillaDie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

import java.io.PrintStream;
import java.util.ArrayList;


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
    public ImageView[] imgDie;
    

    //Button for rolling from Roll tab
    public Button btnRoll;
    public TextArea historyTextArea;
    public TableView discoveredRolesTable;
    public TableColumn colCharacter;
    public TableColumn colHealth;
    public TableColumn colRole;


    // Game instance
    private Game game;
    private ArrayList<Player> playersOLD;
    public Button endTurnButton;
    
    private ColorAdjust black;
    private ColorAdjust white;

    // ImagePatterns for filling
    private static final ImagePattern imgpatTable = new ImagePattern(new Image("/Fall2020OOPProject3/UI/art/table.jpg"));
    private static final ImagePattern imgpatNone = new ImagePattern(new Image("/Fall2020OOPProject3/UI/art/none.png"));
    private static final ImagePattern imgpatArrow = new ImagePattern(new Image("/Fall2020OOPProject3/UI/art/arrow.png"));
    private static final ImagePattern imgpatDead = new ImagePattern(new Image("/Fall2020OOPProject3/UI/art/characters/dead.png"));


    /**
     * Initialize the Game.fxml stage
     *
     * @param bots the number of bots with which to start the game
     * @param exp1 Old Saloon expansion enabled
     * @param exp2 Undead or Alive expansion enabled
     */
    public void init(int bots, boolean exp1, boolean exp2) {

        System.setOut(new PrintStream(System.out) {
            public void println(String s) {
                historyTextArea.appendText(s + System.lineSeparator());
            }

            public void println() {
                historyTextArea.appendText(System.lineSeparator());
                historyTextArea.setScrollTop(Double.MAX_VALUE);
            }

            public void print(String s) {
                historyTextArea.appendText(s);
                historyTextArea.setScrollTop(Double.MAX_VALUE);
            }
        });

        // set up discovered roles table
        colCharacter.setCellValueFactory(new PropertyValueFactory<>("character"));
        colHealth.setCellValueFactory(new PropertyValueFactory<>("CurrentHPMask"));
        colRole.setCellValueFactory((new PropertyValueFactory<>("RoleMask")));

        game = new Game(bots, exp1, exp2);      // set up game
        playersOLD = game.players;              // set up old players list
        polyOct.setFill(imgpatTable);           // set up table
        updPlayers();                           // set up player character cards
        updArrows();                            // set up arrows

        imgDie = new ImageView[]{imgDie1, imgDie2, imgDie3, imgDie4, imgDie5};

        black = new ColorAdjust();
        black.setHue(-1);
        black.setSaturation(.25);
        white = new ColorAdjust();
        white.setHue(0);

        /*
         * Assign lambda listeners for each image which set let the player toggle their locked/unlocked state
         * e.g. if(player == activeCharacter && this_die_unlockable) toggleLocked(); or something like this
         */
        EventHandler<MouseEvent> mouseListener = (MouseEvent e) -> {
            //ImageView tempDieImageView = (ImageView) e.getSource();
            //tempDieImageView.setImage(new Image("file:src/Fall2020OOPProject3/UI/table.jpg"));
            if (e.getSource() instanceof ImageView) {
                Die d = new VanillaDie();
                /*
                if (e.getSource() == imgDie1) d = game2.dice[0];
                if (e.getSource() == imgDie2) d = game2.dice[1];
                if (e.getSource() == imgDie3) d = game2.dice[2];
                if (e.getSource() == imgDie4) d = game2.dice[3];
                if (e.getSource() == imgDie5) d = game2.dice[4];*/
                for (int i = 0; i < imgDie.length; i++) {
                    if (e.getSource() == imgDie[i]) {
                        d = game.dice[i];
                        break;
                    }
                }
                d.toggleLocked();
                if (d.isLocked()) ((ImageView) e.getSource()).setEffect(black);
                else ((ImageView) e.getSource()).setEffect(white);
            }
        };
        //assign listener to all images
        imgDie1.setOnMouseClicked(mouseListener);
        imgDie2.setOnMouseClicked(mouseListener);
        imgDie3.setOnMouseClicked(mouseListener);
        imgDie4.setOnMouseClicked(mouseListener);
        imgDie5.setOnMouseClicked(mouseListener);

        endTurnButton.setOnMouseClicked(e -> {
            updPlayers();
            //TODO player resolve
            for (int i = 1; i < game.players.size() && !game.gameOver; i++) {
                System.out.println();
                System.out.println(game.players.get(i).getCharacter() + "'s turn");
                game.takeComputerTurn(game.players.get(i));
                updPlayers();
            }
            rollCount = 1;
            System.out.println();
            historyTextArea.appendText("");
        });
    }
        

    /**
     * Update Players and Roles and Details tabs to reflect players still alive
     *
     */
    private void updPlayers() {
        Rectangle[] rectChars = {this.rectPlayer, this.rectBot1, this.rectBot2, this.rectBot3, this.rectBot4, this.rectBot5, this.rectBot6, this.rectBot7};
        discoveredRolesTable.getItems().clear();
        for (int i = 0; i < game.players.size(); i++) {
            discoveredRolesTable.getItems().add(game.players.get(i));
            rectChars[i].setFill(new ImagePattern(new Image("/Fall2020OOPProject3/UI/art/characters/" + game.players.get(i).getCharacter().toString() + ".png")));
        }
        for (int i = 0; i < game.playersDead.size(); i++) {
            discoveredRolesTable.getItems().add(game.playersDead.get(i));
        }
        for (int i = game.players.size(); i < rectChars.length; i++) {
            rectChars[i].setFill(imgpatNone);
            rectChars[i].setStroke(Color.TRANSPARENT);
        }


        /*
        int j = 0;
        for (int i = 0; i < playersOLD.size(); i++) {
            if (game.players.get(i) != null) {
                if (playersOLD.get(j) != game.players.get(i)) {
                    j++;
                    rectChars[i].setFill(imgpatDead);
                }
                else {
                    rectChars[i].setFill(new ImagePattern(new Image("/Fall2020OOPProject3/UI/art/characters/" + game.players.get(i).getCharacter().toString() + ".png")));
                    try {
                        discoveredRolesTable.getItems().remove(i);
                    } catch (IndexOutOfBoundsException e) {}
                }
            }
            else
                rectChars[i].setFill(imgpatDead);
            j++;
        }
        for (Player p : game.players)
            discoveredRolesTable.getItems().add(p);
         */
        /*
        discoveredRolesTable.getItems().removeAll();
        for (int i = 0; i < game.players.size(); i++) {
            if (game.players.get(i).isEliminated()) {
                rectChars[i].setFill(imgpatDead);
            }
            else {
                rectChars[i].setFill(new ImagePattern(new Image("/Fall2020OOPProject3/UI/art/characters/" + game.players.get(i).getCharacter().toString() + ".png")));
            }
            discoveredRolesTable.getItems().add(game.players.get(i));
        }
        for (int i = game.players.size(); i < rectChars.length; i++) {
            rectChars[i].setFill(imgpatNone);
            rectChars[i].setStroke(Color.TRANSPARENT);
        }

         */
        //discoveredRolesTable.setItems(data); //.addAll(game.players.get(i).getCharacter().toString(), game.players.get(i).getCurrentHP(), game.players.get(i).getRole());
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
        for (Circle[] arrow : arrows)
            for (Circle circle : arrow)
                circle.setFill(imgpatNone);

        // set fill to arrow for all arrows which exist
        for (int i = 0; i < game.players.size(); i++) {
            for (int j = 0; j < game.players.get(i).getCurrentArrows(); j++) {
                arrows[i][j].setFill(imgpatArrow);
            }
        }
    }

    int rollCount = 1;
    /**
     * Handle the pressing of the roll button.
     *
     * @param actionEvent the action event of pressing the roll button
     */
    public void handleRoll(ActionEvent actionEvent) {
        //should call game field -> player -> roll e.g. game.roll(Character.CHAR1); and then updates the images 
        //for each of the die faces.
        historyTextArea.appendText("");
        
        //TODO update DIE PICTURES
        if(rollCount==1) {
            game.rollDice(new boolean[]{true, true, true, true, true}, game.players.get(0));
        }
        else if(rollCount == 2){
            boolean[] rolls = new boolean[5];
            for(int i = 0; i < game.dice.length; i++)
                rolls[i] = !game.dice[i].isLocked();

            game.rollDice(rolls, game.players.get(0));
        }
        else if(rollCount== 3){
            boolean[] rolls = new boolean[5];
            for(int i = 0; i < game.dice.length; i++)
                rolls[i] = !game.dice[i].isLocked();

            game.rollDice(rolls, game.players.get(0));
            resolveDice();
            return;
        }
        for(int i = 0; i< imgDie.length; i++){
            if (game.dice[i].isLocked())
                imgDie[i].setEffect(black);
            else imgDie[i].setEffect(white);
        }
        if(rollCount >=1 && rollCount <3 ) rollCount++;

        int numDynamite = 0;
        for (Die d : game.dice) {
            if (d.getCurrentFace() == Die.Face.DYNAMITE) {
                numDynamite++;
                d.setLocked(true);
            }
        }
        
        if(numDynamite >= 3) {
            resolveDice();
            return;
        }
    }
    
    public void resolveDice(){
        Player player = game.players.get(0);
        for(Die d: game.dice) {
            d.setUnlockable(false);
            d.setLocked(true);
        }
        int numDynamite = 0;
        for (Die d : game.dice) {
            if (d.getCurrentFace() == Die.Face.DYNAMITE) numDynamite++;
        }
        if(numDynamite >= 3) {
            System.out.println("Dynamite blew up in " + game.players.get(0) + "'s face!");
            player.removeHP(1);
            if (player.isEliminated()) {
                game.handleElim(player);
                return;
            }
        }
        
        for(Die.Face f: game.getDiceFaces()){
            if (f == Die.Face.SHOOT1) {
                if(player.getCharacter() == Player.Character.CALAMITY_JANET) {
                    Player[] targets = new Player[] {
                            game.players.get(Math.floorMod((player.getSeatPosition()-1), game.numPlayers)),
                            game.players.get(Math.floorMod((player.getSeatPosition()+1), game.numPlayers)),
                            game.players.get(Math.floorMod((player.getSeatPosition()-2), game.numPlayers)),
                            game.players.get(Math.floorMod((player.getSeatPosition()+2), game.numPlayers))
                    };
                    //TODO player choice, listener
                }
                else {
                    Player[] targets = new Player[] {
                            game.players.get(Math.floorMod((player.getSeatPosition()-1), game.numPlayers)),
                            game.players.get(Math.floorMod((player.getSeatPosition()+1), game.numPlayers))
                    };
                    //TODO player choice, listener
                }
            }
            if (f == Die.Face.SHOOT2) {
                if(player.getCharacter() == Player.Character.CALAMITY_JANET) {
                    Player[] targets = new Player[] {
                            game.players.get(Math.floorMod((player.getSeatPosition()-1), game.numPlayers)),
                            game.players.get(Math.floorMod((player.getSeatPosition()+1), game.numPlayers)),
                            game.players.get(Math.floorMod((player.getSeatPosition()-2), game.numPlayers)),
                            game.players.get(Math.floorMod((player.getSeatPosition()+2), game.numPlayers))
                    };
                    //TODO player choice, listener
                }
                else {
                    Player[] targets = new Player[] {
                            game.players.get(Math.floorMod((player.getSeatPosition()-2), game.numPlayers)),
                            game.players.get(Math.floorMod((player.getSeatPosition()+2), game.numPlayers))
                    };
                    //TODO player choice, listener
                }
            }
        }

        for(Die.Face f : game.getDiceFaces()) {
            if (f == Die.Face.BEER) {
                player.addHP(1);
                System.out.println(player + " healed themself");
            }
        }

        int numGat = 0;
        for(Die.Face f : game.getDiceFaces()) {
            if (f == Die.Face.GATLING) {
                numGat++;
            }
        }

        if (numGat >= 3) {
            System.out.println(player + " fired the gatling gun");
            for (int i = 0; i < game.players.size(); i++) {
                if (game.players.get(i) != player) {
                    game.players.get(i).removeHP(1);
                    if (game.players.get(i).isEliminated()) game.handleElim(game.players.get(i));
                }
            }
        }
                
        
        for(Die d: game.dice){
            d.setUnlockable(true);
            d.setLocked(false);
        }
        rollCount = -1;
        
    }

    /**
     * Handle human player rolling shoot
     *
     * @param player the human player
     * @param numS the type of shoot face on the die
     */
    public void handleDieShoot(Player player, int numS) {
        if (player.getCharacter().toString().equals("Calamity Janet")) {
            // check 1, 2 left, 1, 2 right
        }
        else if (player.getCharacter().toString().equals("Rose Doolan")) {
            if (numS == 1) {
                // check 1, 2 left; 1, 2 right
            }
            else if (numS == 2) {
                // check 2, 3 left; 2, 3 right
            }
        }
        else {
            if (numS == 1) {
                // check 1 left; 1 right

            }
            else if (numS == 2) {
                // check 2 left; 2 right

            }
        }
        /*
        if (s == 1) {
            this.rectBot1.setOnMouseClicked(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent t) {
                    game.players.get(0).shootPlayer(game.players.get(1));
                }
            });
        }*/
    }

    /**
     * Handle human player rolling beer
     *
     * @param player the human player
     */
    public void handleDieBeer(Player player) {
        player.addHP(1);
        System.out.println(player.getCharacter().toString() + " healed themself");
    }

    /**
     * Handle human player rolling gatling
     *
     * @param player the human player
     * @param numG the number of gatling rolled
     */
    public void handleDieGatling(Player player, int numG) {
        if (numG >= 3) {
            System.out.println(player.getCharacter().toString() + " fired the gatling gun");
            for (Player p : game.players) {
                if (p != player) {
                    p.removeHP(1);
                    if (p.isEliminated()) game.handleElim(p);
                }
            }
        }
    }

    /*  USED TO LOAD FINAL
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

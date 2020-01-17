package kont2018;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;


public class DiceController {
	  
    private DiceScorer singleValue, straight, nothing;
  
    @FXML
    public void initialize() {
        SingleValue singel = new SingleValue(6,50);
        Straight straight = new Straight(100);
        Nothing nothing = new Nothing(5, 1000, straight, singel);
        
    }
  
    @FXML private TextField dieValuesInput;
    @FXML private Label scoreOutput;
    @FXML private Label diceOutput;
  
    // helper method for parsing die values input
    private Dice getDiceInput() {
        Collection<Integer> dieValues = new ArrayList<>();
        for (String dieValue : dieValuesInput.getText().split(" ")) {
            ??? parse and add die value
        }
        ??? return new Dice instances
    }
  
    // helper method for
    private void runDiceScorer(DiceScorer scorer) {
        ??? get DiceScore object by calling scorer's getScore method
        if (score != null) {
            ??? show output
        } else {
            ??? show output
        }
    }
  
    @FXML
    public void testSingleValue() {
        ??? use SingleValue implementation
    }
  
    @FXML
    public void testStraight() {
        ??? use Straight implementation
    }
  
    @FXML
    public void testNothing() {
        ??? use Nothing implementation
    }
}
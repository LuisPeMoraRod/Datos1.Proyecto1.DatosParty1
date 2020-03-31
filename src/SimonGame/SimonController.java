package SimonGame;

/**
 * The SimonController class allows to control the events and elements that belongs to the SimonGUI
 * @author Monica Waterhouse
 * @version 13.0.2
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.awt.*;

public class SimonController {

    int round = 1;

    @FXML
    Stage primaryStage;
    Button buttonPressed;
    int colorCode;



    public void closeWindow(MouseEvent mouseEvent) {
        /**
         *  This method is used to close the Simon Game window
         * @param mouseEvent allows to close the window by clicking the image
         */

        primaryStage = (Stage)((ImageView)mouseEvent.getSource()).getScene().getWindow();
        primaryStage.close();

    }


    public void pressButton(ActionEvent actionEvent) {

        buttonPressed = (Button)actionEvent.getSource();
        String buttonID = buttonPressed.getId();

        if (buttonID.equals("btn_Pink")){

            buttonPressed.setStyle("-fx-background-color: #CC3366; ");

        }

        else if (buttonID.equals("btn_Purple")) {

            buttonPressed.setStyle("-fx-background-color: #9B59B6; ");

        }

        else if (buttonID.equals("btn_Green")) {

            buttonPressed.setStyle("-fx-background-color: #CDDC39; ");

        }

        else if(buttonID.equals("btn_Orange")) {

            buttonPressed.setStyle("-fx-background-color: #FFA000; ");

        }

        else if(buttonID.equals("btn_Blue")) {

            buttonPressed.setStyle("-fx-background-color: #00ACC1; ");

        }
    }
}


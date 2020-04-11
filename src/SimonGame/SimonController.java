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
import java.util.concurrent.TimeUnit;

import java.util.ArrayList;
import java.util.Random;

import java.awt.*;
import java.lang.reflect.Array;

public class SimonController {

    @FXML
    Stage primaryStage;
    Button buttonPressed;
    String[] buttonColors = new String[]{"btn_Pink", "btn_Purple", "btn_Green", "btn_Orange", "btn_Blue"};
    Button btn_Pink;
    Button btn_Purple;
    Button btn_Green;
    Button btn_Blue;
    Button btn_Orange;


    public void closeWindow(MouseEvent mouseEvent) {
        /**
         *  This method is used to close the Simon Game window
         * @param mouseEvent allows to close the window by clicking the image
         */

        primaryStage = (Stage)((ImageView)mouseEvent.getSource()).getScene().getWindow();
        primaryStage.close();

    }

    public String pickColor(String[] buttonColors){

        Random colorPlace = new Random();
        int colorSelected = colorPlace.nextInt(4);
        String colorName = buttonColors[colorSelected];
        return colorName;

    }

    public ArrayList<String> flashColors(String colorName, ArrayList<String> pattern) throws InterruptedException {

        pattern.add(colorName);
        String color;

        for (int i=0; i < pattern.size(); i++){
            color = pattern.get(i);

            if (color.equals("btn_Pink")){

                btn_Pink.setStyle("-fx-background-color: #CC3366; ");
                TimeUnit.SECONDS.sleep(1);
                btn_Pink.setStyle("-fx-background-color: #96274c; ");


            }

            else if (color.equals("btn_Purple")) {

                btn_Purple.setStyle("-fx-background-color: #9B59B6; ");
                TimeUnit.SECONDS.sleep(1);
                btn_Purple.setStyle("-fx-background-color: #6f4082; ");

            }

            else if (color.equals("btn_Green")) {

                btn_Green.setStyle("-fx-background-color: #CDDC39; ");
                TimeUnit.SECONDS.sleep(1);
                btn_Green.setStyle("-fx-background-color: #7d8622; ");

            }

            else if(color.equals("btn_Orange")) {

                btn_Orange.setStyle("-fx-background-color: #FFA000; ");
                TimeUnit.SECONDS.sleep(1);
                btn_Orange.setStyle("-fx-background-color: #9d6202; ");

            }

            else if(color.equals("btn_Blue")) {

                btn_Blue.setStyle("-fx-background-color: #00ACC1; ");
                TimeUnit.SECONDS.sleep(1);
                btn_Blue.setStyle("-fx-background-color: #005c64; ");

            }

        }

        return pattern;

    }


    public void pressButton(ActionEvent actionEvent, ArrayList<String> buttonsClicked) throws InterruptedException {

        buttonPressed = (Button)actionEvent.getSource();
        String buttonID = buttonPressed.getId();

        if (buttonID.equals("btn_Pink")){

            buttonPressed.setStyle("-fx-background-color: #CC3366; ");
            buttonsClicked.add("btn_Pink");
            TimeUnit.SECONDS.sleep(1);
            buttonPressed.setStyle("-fx-background-color: #96274c; ");

        }

        else if (buttonID.equals("btn_Purple")) {

            buttonPressed.setStyle("-fx-background-color: #9B59B6; ");
            buttonsClicked.add("btn_Purple");
            TimeUnit.SECONDS.sleep(1);
            buttonPressed.setStyle("-fx-background-color: #6f4082; ");

        }

        else if (buttonID.equals("btn_Green")) {

            buttonPressed.setStyle("-fx-background-color: #CDDC39; ");
            buttonsClicked.add("btn_Green");
            TimeUnit.SECONDS.sleep(1);
            buttonPressed.setStyle("-fx-background-color: #7d8622; ");

        }

        else if(buttonID.equals("btn_Orange")) {

            buttonPressed.setStyle("-fx-background-color: #FFA000; ");
            buttonsClicked.add("btn_Orange");
            TimeUnit.SECONDS.sleep(1);
            buttonPressed.setStyle("-fx-background-color: #9d6202; ");

        }

        else if(buttonID.equals("btn_Blue")) {

            buttonPressed.setStyle("-fx-background-color: #00ACC1; ");
            buttonsClicked.add("btn_Blue");
            TimeUnit.SECONDS.sleep(1);
            buttonPressed.setStyle("-fx-background-color: #005c64; ");

        }
    }
}


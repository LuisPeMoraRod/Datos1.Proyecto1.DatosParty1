package SimonGame;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SimonController {

    @FXML
    ImageView btn_Close;
    Stage primaryStage;

    public void closeWindow(MouseEvent mouseEvent) {
        /**
         *  This method is used to close the Simon Game window
         */

        primaryStage = (Stage)((ImageView)mouseEvent.getSource()).getScene().getWindow();
        primaryStage.close();


    }
}

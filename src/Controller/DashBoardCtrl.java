package Controller;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashBoardCtrl {
    @FXML
    public ImageView imgCars;
    @FXML
    public ImageView imgSale;
    @FXML
    public ImageView imgProfit;
    @FXML
    public Label lblMenu;
    @FXML
    public AnchorPane root;
    @FXML
    public Label lblDescription;

    public void initialize(URL url, ResourceBundle rb) {
        FadeTransition fadeIn = new FadeTransition(Duration.millis(1000), root);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
    }

    @FXML
    private void playMouseExitAnimation(MouseEvent event) {
        if (event.getSource() instanceof ImageView){
            ImageView icon = (ImageView) event.getSource();
            ScaleTransition scaleT =new ScaleTransition(Duration.millis(100), icon);
            scaleT.setToX(1);
            scaleT.setToY(1);
            scaleT.play();

            icon.setEffect(null);
            lblMenu.centerShapeProperty();
            lblMenu.setText("Welcome");
            lblMenu.centerShapeProperty();
            lblDescription.setText("Please select one of above main operations to proceed");
        }
    }

    @FXML
    private void playMouseEnterAnimation(MouseEvent event) {
        if (event.getSource() instanceof ImageView){
            ImageView icon = (ImageView) event.getSource();

            switch(icon.getId()){
                case "imgCars":
                    lblMenu.setText("New Cars");
                    lblDescription.setText("Click to add, edit, delete, search or view CarDto Details");
                    break;
                case "imgSale":
                    lblMenu.setText("Sale Car");
                    lblDescription.setText("Click to search Cars in Sale");
                    break;
                case "imgProfit":
                    lblMenu.setText("View Sales");
                    lblDescription.setText("Click to view Sales");
                    break;
            }

            ScaleTransition scaleT =new ScaleTransition(Duration.millis(100), icon);
            scaleT.setToX(1.2);
            scaleT.setToY(1.2);
            scaleT.play();

            DropShadow glow = new DropShadow();
            glow.setColor(Color.CORNFLOWERBLUE);
            glow.setWidth(20);
            glow.setHeight(20);
            glow.setRadius(20);
            icon.setEffect(glow);
        }
    }


    @FXML
    private void navigate(MouseEvent event) throws IOException {
        if (event.getSource() instanceof ImageView){
            ImageView icon = (ImageView) event.getSource();

            Parent root = null;

            switch(icon.getId()){
                case "imgCars":
                    root = FXMLLoader.load(this.getClass().getResource("/Views/NewCar.fxml"));
                    break;
                case "imgSale":
                    root = FXMLLoader.load(this.getClass().getResource("/Views/BillCar.fxml"));
                    break;
                case "imgProfit":
                    root = FXMLLoader.load(this.getClass().getResource("/Views/ViewSale.fxml"));
                    break;
            }

            if (root != null){
                Scene subScene = new Scene(root);
                Stage primaryStage = (Stage) this.root.getScene().getWindow();
                primaryStage.setScene(subScene);
                primaryStage.centerOnScreen();

//                TranslateTransition tt = new TranslateTransition(Duration.millis(350), subScene.getRoot());
//                tt.setFromX(-subScene.getWidth());
//                tt.setToX(0);
//                tt.play();

            }
        }
    }

}


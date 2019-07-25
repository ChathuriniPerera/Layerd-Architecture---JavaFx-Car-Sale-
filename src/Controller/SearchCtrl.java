package Controller;

import Bo.BoFactory;
import Bo.BoTypes;
import Bo.Custom.CarBo;
import Bo.Custom.CarModelBo;
import Bo.Custom.OwnerBo;
import Bo.Custom.impl.CarBoimpl;
import Dto.CarDto;
import Dto.CarModelDto;
import Dto.OwnerDto;
import Entity.CarModel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.AppInitializer;

import java.io.IOException;
import java.util.Optional;

public class SearchCtrl {
    @FXML public AnchorPane root;
    @FXML public JFXTextField txtSearch;
    @FXML public JFXButton btnsearch;
    @FXML public Label lblECnumber;
    @FXML public Label lblDistance;
    @FXML public Label lblCarNumber;
    @FXML public Label lblColour;
    @FXML public Label lblOname;
    @FXML public Label lblMname;
    @FXML public Label lblPrice;
    @FXML public Label lbloid;
    @FXML public Label lblocontact;
    @FXML public Label lbloaddress;

    private CarBo carBo = BoFactory.getInstance().getBO(BoTypes.CAR);
    private OwnerBo ownerBo = BoFactory.getInstance().getBO(BoTypes.OWNER);

    public void btnsearch_onAction(ActionEvent actionEvent) {
        //String ECnumber = txtSearch.getText();
        CarDto getcarbyID = null;
        try {
            getcarbyID = carBo.getCarById(txtSearch.getText());
            lblECnumber.setText(getcarbyID.getEcnumber());
            lblMname.setText(getcarbyID.getMname());
            lblDistance.setText(getcarbyID.getDistance());
            lblCarNumber.setText(getcarbyID.getNumber());
            lblColour.setText(getcarbyID.getColour());
            lblPrice.setText(getcarbyID.getPrice());


            OwnerDto getOwner = ownerBo.getOwnerById(txtSearch.getText());
            lblOname.setText(getOwner.getOname());
            lbloid.setText(getOwner.getOid());
            lblocontact.setText(getOwner.getOcontact());
            lbloaddress.setText(getOwner.getOaddress());
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,"Check!!  Engine or Chassis Number Incorrect",ButtonType.OK).showAndWait();
        }
    }



    public void btnbuy_onAction(MouseEvent mouseEvent) throws IOException {
        if (lblECnumber.getText().equals("")||lblMname.getText().equals("")||lblCarNumber.getText().equals("")||lblDistance.getText().equals("")||lblColour.getText().equals("")||lblPrice.getText().equals("")||lblOname.getText().equals("")){
            Alert confirm = new Alert(Alert.AlertType.WARNING, "You Can't Leave Empty Fields", ButtonType.OK);
            Optional<ButtonType> buttonType=confirm.showAndWait();
            if(buttonType.get()==ButtonType.OK){
                return;
            }
        }
        //AppInitializer.navigateToBill(root, (Stage) this.root.getScene().getWindow());
    }
}

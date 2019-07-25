package Controller;

import Bo.BoFactory;
import Bo.BoTypes;
import Bo.Custom.CarBo;
import Bo.Custom.OwnerBo;
import Bo.Custom.impl.CarBoimpl;
import Dto.CarDto;
import Dto.OwnerDto;
import JDBC.DBconnection;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.cell.PropertyValueFactory;
import main.AppInitializer;

import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import util.CarTM;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class NewCarCtrl implements Initializable {

    Connection connection = DBconnection.getInstance().getConnection();

    @FXML public JFXComboBox cmbModelName;
    @FXML public AnchorPane root;
    @FXML public JFXTextField txtEngine;
    @FXML public JFXTextField txtCnum;
    @FXML public JFXTextField txtPrice;
    @FXML public JFXTextField txtBname;
    @FXML public JFXTextField txtDistance;
    @FXML public JFXTextField txtColor;
    @FXML public TableView<CarTM>tblCar;
    @FXML public JFXButton btnSave;
    @FXML public JFXTextField txtOcontact;
    @FXML public JFXTextField txtOname;
    @FXML public JFXTextField txtOaddress;
    @FXML public JFXTextField txtOid;
    @FXML public JFXButton btnFind;

    private CarBo carBo = BoFactory.getInstance().getBO(BoTypes.CAR);
    private OwnerBo ownerBo = BoFactory.getInstance().getBO(BoTypes.OWNER);

    public void btnAddNew_OnAction(ActionEvent actionEvent) {
        btnSave.setVisible(true);
        //btnSave.setText("Save");
        txtEngine.clear();
        txtBname.clear();
        cmbModelName.getSelectionModel().clearSelection();
        txtDistance.clear();
        txtPrice.clear();
        txtCnum.clear();
        txtOid.clear();
        txtColor.clear();
        txtOname.clear();
        txtOcontact.clear();
        txtOaddress.clear();
        tblCar.getSelectionModel().clearSelection();
    }

    public void initialize(URL url, ResourceBundle rb){
        //Get Car Model Name to combo box
        ArrayList carmodle = new ArrayList();
        try {
            PreparedStatement pstm = connection.prepareStatement("SELECT Mname FROM carmodle");
            ResultSet rst = pstm.executeQuery();
            while (rst.next()) {
                cmbModelName.getItems().add(rst.getString("Mname"));
            }
            ObservableList obsl = FXCollections.observableArrayList(carmodle);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //GEt Brand Name For Selected Item
        cmbModelName.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String Mname) {
                try{
                    PreparedStatement pstm = connection.prepareStatement("SELECT * FROM carmodle WHERE Mname=?");
                    pstm.setString(1,Mname);
                    ResultSet rst = pstm.executeQuery();
                    if (rst.next()){
                        String Brand = rst.getString("Brand");
                        txtBname.setText(Brand);
                    }
                }catch (SQLException ex){
                    ex.printStackTrace();
                }
            }
        });
        //import data for coloumns

        tblCar.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("ecnumber"));
        tblCar.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("number"));
        tblCar.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("distance"));
        tblCar.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("color"));
        tblCar.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("price"));
        tblCar.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("model"));

        //btnSave.setDisable(true);

        try {
            List<CarDto> allcars = carBo.getAllCar();
            for(CarDto car : allcars){
                tblCar.getItems().add(new CarTM(car.getMname(),car.getEcnumber(),car.getNumber(),car.getDistance(),car.getColour(),car.getPrice()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Get table data to text fields
        tblCar.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<util.CarTM>() {
            @Override
            public void changed(ObservableValue<? extends util.CarTM> observable, util.CarTM oldValue, util.CarTM newCar) {
                btnSave.setText("Update");
                if (newCar == null) {
                    return;
                }

                cmbModelName.getSelectionModel().select((Object) newCar.getModel());
                txtEngine.setText(newCar.getEcnumber());
                txtCnum.setText(newCar.getNumber());
                txtDistance.setText(newCar.getDistance());
                txtColor.setText(newCar.getColor());
                txtPrice.setText(newCar.getPrice());

                txtEngine.setEditable(false);
            }
        });
    }

    @FXML
    private void navigateToHome(MouseEvent event) throws IOException {
        AppInitializer.navigateToHome(root, (Stage) this.root.getScene().getWindow());
    }

    public void btnSave_OnAction(ActionEvent actionEvent) {
        if (txtEngine.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Engine & Chassis numbers are empty", ButtonType.OK).showAndWait();
            txtEngine.requestFocus();
            return;
        } else if (txtColor.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Colour is empty", ButtonType.OK).showAndWait();
            txtColor.requestFocus();
            return;
        } else if (txtDistance.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Distance is empty", ButtonType.OK).showAndWait();
            txtDistance.requestFocus();
            return;
        } else if (txtCnum.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Vehical Number is empty", ButtonType.OK).showAndWait();
            txtCnum.requestFocus();
            return;
        } else if (txtBname.getText().equals("") || txtPrice.getText().equals("")) {
            new Alert(Alert.AlertType.ERROR, "Brand Name or Year Should not empty", ButtonType.OK).showAndWait();
            cmbModelName.requestFocus();
            return;
        } else if (txtOname.getText().equals("")||txtOid.getText().equals("")||txtOcontact.getText().equals("")||txtOaddress.getText().equals("")) {
            new Alert(Alert.AlertType.ERROR, "Owner Details Should Be Filed ", ButtonType.OK).showAndWait();
            btnFind.requestFocus();
            return;
        }
        if (tblCar.getSelectionModel().isEmpty()) {
            // New
            ObservableList<CarTM> car = tblCar.getItems();
            for (CarTM carTM : car) {
                if (carTM.getEcnumber().equals(txtEngine.getText())) {
                    new Alert(Alert.AlertType.ERROR, "Duplicate Engine/ Chassis Number").showAndWait();
                    txtEngine.requestFocus();
                    return;
                }
            }
            //Save New Car
            try {
                boolean result = (boolean) carBo.saveCar(new CarDto(cmbModelName.getValue().toString(), txtEngine.getText(), txtCnum.getText(), txtDistance.getText(), txtColor.getText(),txtPrice.getText()));
                //ownerBo.saveOwner(new OwnerDto(txtOid.getText(), txtOname.getText(), txtOcontact.getText(), txtOaddress.getText(),txtEngine.getText()));

                if (result) {

                    CarTM carTM = new CarTM(cmbModelName.getValue().toString(),txtEngine.getText(), txtCnum.getText(),txtDistance.getText(), txtColor.getText(),txtPrice.getText());

                    new Alert(Alert.AlertType.INFORMATION, "Car has been saved successfully", ButtonType.OK).showAndWait();
                    //tblCar.getItems().add(carTM);
                    //tblCar.scrollTo(carTM);
                } else {
                    new Alert(Alert.AlertType.ERROR, "Failed to save the Car", ButtonType.OK).showAndWait();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            // Update
            try {
                boolean result = carBo.updateCar(new CarDto(cmbModelName.getValue().toString(),txtEngine.getText(), txtCnum.getText(),txtDistance.getText(), txtColor.getText(),txtPrice.getText()));

                if (result){
                    CarTM selectedItem = tblCar.getSelectionModel().getSelectedItem();
                    selectedItem.setEcnumber(txtEngine.getText());
                    selectedItem.setNumber(txtCnum.getText());
                    selectedItem.setDistance(txtDistance.getText());
                    selectedItem.setColor(txtColor.getText());
                    selectedItem.setModel(cmbModelName.getValue().toString());
                    tblCar.refresh();
                    new Alert(Alert.AlertType.INFORMATION, "Car Details updated successfully", ButtonType.OK).showAndWait();
                }else{
                    new Alert(Alert.AlertType.ERROR,"Failed to update the Car Details, try again").show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public void btnFind_onAction(ActionEvent actionEvent) {
        try {
            OwnerDto ownerById = ownerBo.getOwnerById(txtEngine.getText());
            txtOid.setText(ownerById.getOid());
            txtOid.setEditable(false);
            txtOname.setText(ownerById.getOname());
            txtOcontact.setText(ownerById.getOcontact());
            txtOaddress.setText(ownerById.getOaddress());

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Invalid Engine/Chassis Number", ButtonType.OK).showAndWait();
        }
    }
}

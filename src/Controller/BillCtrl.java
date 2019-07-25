package Controller;

import Bo.BoFactory;
import Bo.BoTypes;
import Bo.Custom.*;
import Dto.*;
import JDBC.DBconnection;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.AppInitializer;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BillCtrl implements Initializable {

    @FXML public JFXComboBox cmbbrand;
    Connection connection = DBconnection.getInstance().getConnection();
    @FXML public AnchorPane root;
    @FXML public JFXTextField txtBillid;
    @FXML public JFXTextField txtCname;
    @FXML public JFXTextField txtCnic;
    @FXML public JFXTextField txtCnumber;
    @FXML public JFXTextArea txtCaddress;

    @FXML public JFXTextField txtdistance;
    @FXML public JFXTextField txtCarNumber;
    @FXML public JFXTextField txtECnum;
    @FXML public JFXTextField txtbrand;
    @FXML public JFXTextField txtmname;
    @FXML public JFXTextField txtColour;
    @FXML public JFXTextField txtprice;
    @FXML public JFXTextField txtOCumber;
    @FXML public JFXTextField txtOname;
    @FXML public JFXTextField txtOID;
    @FXML public JFXTextField txtAddress;
    @FXML public JFXTextField txtDate;
    public JFXButton btnsearch;

    private CarBo carBo = BoFactory.getInstance().getBO(BoTypes.CAR);
    private CarModelBo carModelBo = BoFactory.getInstance().getBO(BoTypes.MODEL);
    private OwnerBo ownerBo = BoFactory.getInstance().getBO(BoTypes.OWNER);
    private CustomerBo customerBo = BoFactory.getInstance().getBO(BoTypes.CUSTOMER);
    private SaleBo saleBo = BoFactory.getInstance().getBO(BoTypes.SALE);


    public void btnClear(ActionEvent actionEvent) {
        txtCnic.clear();
        txtCaddress.clear();
        txtCname.clear();
        txtCnumber.clear();
    }


    public void navigateToHome(MouseEvent mouseEvent) throws IOException {
        AppInitializer.navigateToHome(root, (Stage) this.root.getScene().getWindow());
    }

    public void btnOrder_onAction(ActionEvent actionEvent) {
        try {
            boolean result = customerBo.saveCustomer(new CustomerDto(txtCnic.getText(), txtCname.getText(), txtCnumber.getText(), txtAddress.getText()));
            saleBo.saveSale(new SaleDto(txtBillid.getText(), txtDate.getText(),txtprice.getText(),txtCnic.getText(),txtECnum.getText()));
            if (result) {
                new Alert(Alert.AlertType.INFORMATION, "Customer has been saved successfully", ButtonType.OK).showAndWait();
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to save the Customer", ButtonType.OK).showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtDate.setText(LocalDate.now().toString());
        try {
            txtBillid.setText(genarateBillID());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ArrayList brand = new ArrayList();
        try {
            PreparedStatement pstm = connection.prepareStatement("SELECT Brand FROM carmodle");
            ResultSet rst = pstm.executeQuery();
            while (rst.next()) {
                cmbbrand.getItems().add(rst.getString("Brand"));
            }
            ObservableList obsl = FXCollections.observableArrayList(brand);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void btnsearch_onAction(ActionEvent actionEvent) {
        CarDto getcarbyID = null;
        try {
            getcarbyID = carBo.getCarById(txtECnum.getText());
            txtmname.setText(getcarbyID.getMname());
            txtdistance.setText(getcarbyID.getDistance());
            txtCarNumber.setText(getcarbyID.getNumber());
            txtColour.setText(getcarbyID.getColour());
            txtprice.setText(getcarbyID.getPrice());


            OwnerDto getOwner = ownerBo.getOwnerById(txtECnum.getText());
            txtOname.setText(getOwner.getOname());
            txtOID.setText(getOwner.getOid());
            txtOCumber.setText(getOwner.getOcontact());
            txtAddress.setText(getOwner.getOaddress());

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,"Check!!...Engine or Chassis Number Incorrect", ButtonType.OK).showAndWait();
        }
    }

    private String genarateBillID() throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT Bid FROM sale ORDER BY Bid DESC LIMIT 1");
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            int bid = rs.getInt(1);
            return bid+ 1 + "";
        }
        return 1 + "";
    }
    public void cmbbrand_onAction(ActionEvent actionEvent) {
    }
}

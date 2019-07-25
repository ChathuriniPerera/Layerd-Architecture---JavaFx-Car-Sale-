package Controller;

import Bo.BoFactory;
import Bo.BoTypes;
import Bo.Custom.CarBo;
import Bo.Custom.SaleBo;
import Dto.CarDto;
import Dto.SaleDto;
import JDBC.DBconnection;
import com.jfoenix.controls.JFXComboBox;
import com.sun.scenario.effect.impl.prism.PrImage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.AppInitializer;
import util.SalesTM;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ViewSaleCtrl implements Initializable {

    Connection connection = DBconnection.getInstance().getConnection();
    public JFXComboBox cmbmname;
    public TableView<SalesTM> tblSaledetail;
    public AnchorPane root;

    private CarBo carBo = BoFactory.getInstance().getBO(BoTypes.CAR);
    private SaleBo saleBo =BoFactory.getInstance().getBO(BoTypes.SALE);

    public void navigateToHome(MouseEvent mouseEvent) throws IOException {
        AppInitializer.navigateToHome(root, (Stage) this.root.getScene().getWindow());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList carBo = new ArrayList();
        try {
            PreparedStatement pstm = connection.prepareStatement("SELECT carmodle_Mname FROM car");
            ResultSet rst = pstm.executeQuery();
            while (rst.next()) {
                cmbmname.getItems().add(rst.getString("carmodle_Mname"));
            }
            ObservableList obsl = FXCollections.observableArrayList(carBo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void btnSearchonACtion(ActionEvent actionEvent) throws SQLException {
        tblSaledetail.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("bid"));
        tblSaledetail.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("date"));
        tblSaledetail.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("price"));
        tblSaledetail.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("custnic"));
        tblSaledetail.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("ecnumber"));


        /*try {
            List<SaleDto> allsale = saleBo.getCarById(cmbmname.getValue().toString());
            for(SaleDto sale : allsale){
                tblSaledetail.getItems().add(new SalesTM(sale.getBid(),sale.getBdate(),sale.getNumber(),car.getDistance(),car.getColour(),car.getPrice()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/

    }
}

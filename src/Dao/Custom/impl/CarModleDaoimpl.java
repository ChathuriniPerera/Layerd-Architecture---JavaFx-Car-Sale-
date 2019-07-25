package Dao.Custom.impl;

import Dao.CrudUtil;
import Dao.Custom.CarModelDao;
import Entity.CarModel;
import JDBC.DBconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CarModleDaoimpl implements CarModelDao {
    public boolean savemodel(CarModel carModel)throws Exception{
        Connection connection= DBconnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO carmodle VALUE (?,?)");
        pstm.setObject(1,carModel.getMname());
        pstm.setObject(2,carModel.getBrand());
        return pstm.executeUpdate()>0;
    }
//**
    @Override
    public boolean save(CarModel carModel) throws Exception {
        return CrudUtil.execute("INSERT INTO carmodle VALUE (?,?)", carModel.getMname(),carModel.getBrand());
    }
//**
    public boolean update(CarModel carModel)throws Exception{
        return CrudUtil.execute("UPDATE carmodle SET Mname=?, Brand=? WHERE Mname=?", carModel.getMname(),carModel.getBrand());
    }
//**
    @Override
    public boolean delete(String Mname) throws Exception {
        return CrudUtil.execute("DELETE FROM carmodle WHERE Mname=?",Mname);
    }
//**
    @Override
    public List<CarModel> findAll() throws Exception {
        ResultSet resultSet=CrudUtil.execute("SELECT * FROM carmodle");
        List<CarModel> allModel = new ArrayList<>();
        while (resultSet.next()){
            allModel.add(new CarModel(resultSet.getString(1),
                    resultSet.getString(2)));
        }
        return allModel;
    }
//**
    @Override
    public CarModel find(String Mname) throws Exception {
        ResultSet resultSet= CrudUtil.execute("SELECT * FROM carmodle WHERE Mname=?",Mname);

        if(resultSet.next()){
            return new CarModel(resultSet.getString(1),
                    resultSet.getString(2));
        }
        return null;
    }

    /*public List<CarModel> searchallmodel()throws Exception{
        Connection connection = DBconnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT*FROM carmodle");
        ResultSet rst = pstm.executeQuery();
        List<CarModel> allmodels = new ArrayList<>();
        while (rst.next()){
            allmodels.add(new CarModel(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3)));
        }
        return allmodels;
    }

    public CarModel searchmodel(String Mname) throws Exception{
        Connection connection = DBconnection.getInstance().getConnection();
        PreparedStatement pstm=connection.prepareStatement("SELECT * FROM carmodle WHERE Mname");
        //pstm.setObject(1,Mname);
        ResultSet rst = pstm.executeQuery();
        if (rst.next()) {
            return new CarModel(
                    Mname,
                    rst.getString(2),
                    rst.getString(3));
        }
        return null;
    }*/

}

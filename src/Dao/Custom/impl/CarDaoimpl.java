package Dao.Custom.impl;

import Dao.CrudUtil;
import Dao.Custom.CarDao;
import Entity.Car;
import JDBC.DBconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDaoimpl implements CarDao {
//**
    @Override
    public boolean save(Car car) throws Exception {
        return CrudUtil.execute("INSERT INTO car VALUE (?,?,?,?,?,?)", car.getEcnumber(),car.getNumber(),car.getDistance(),car.getColor(),car.getPrice(),car.getMname());
    }
//**
    public boolean update(Car car) throws Exception {
        return CrudUtil.execute("UPDATE car SET Vnumber=?, Distance=?, Color=?, price=? WHERE ECNumber=?",car.getNumber(),car.getDistance(),car.getColor(),car.getPrice(),car.getEcnumber());
    }

    @Override
    public boolean delete(String ecnumber) throws Exception {
        return CrudUtil.execute("DELETE FROM Customer WHERE ecnumber=?",ecnumber);
    }
//**
    @Override
    public List<Car> findAll() throws Exception {
        ResultSet resultSet=CrudUtil.execute("SELECT * FROM car");
        List<Car> allCars = new ArrayList<>();
        while (resultSet.next()){
            allCars.add(new Car(resultSet.getString("ECNumber"),
                    resultSet.getString("Vnumber"),
                    resultSet.getString("Distance"),
                    resultSet.getString("Color"),
                    resultSet.getString("price"),
                    resultSet.getString("carmodle_Mname")));
        }
            return allCars;
    }
//**
    @Override
    public Car find(String ecnumber) throws Exception {
        ResultSet resultSet= CrudUtil.execute("SELECT * FROM car WHERE ecnumber=?",ecnumber);
        if(resultSet.next()){
            return new Car(resultSet.getString("ECNumber"),
                    resultSet.getString("Vnumber"),
                    resultSet.getString("Distance"),
                    resultSet.getString("Color"),
                    resultSet.getString("price"),
                    resultSet.getString("carmodle_Mname"));
        }
        return null;
    }
}

package Dao.Custom.impl;

import Dao.CrudUtil;
import Dao.Custom.CarSaleDao;
import Entity.Sale;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CarSaleDaoimpl implements CarSaleDao {
    @Override
    public boolean save(Sale sale) throws Exception {
        return CrudUtil.execute("INSERT INTO sale VALUE (?,?,?,?,?)", sale.getBid(),sale.getBdate(),sale.getBprice(),sale.getCustnic(),sale.getEcnumber());
    }

    @Override
    public boolean update(Sale sale) throws Exception {
        return CrudUtil.execute("UPDATE sale SET Bdate=?, Bprice=?, Cnic=?, E&CNumber=? WHERE Mname=?", sale.getBid(),sale.getBdate(),sale.getBprice(),sale.getCustnic(),sale.getEcnumber());
    }

    @Override
    public boolean delete(String Bid) throws Exception {
        return CrudUtil.execute("DELETE FROM sale WHERE Bid=?",Bid);
    }

    @Override
    public List<Sale> findAll() throws Exception {
        ResultSet resultSet=CrudUtil.execute("SELECT * FROM sale");
        List<Sale> allCars = new ArrayList<>();
        while (resultSet.next()){
            allCars.add(new Sale(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5)));
        }
        return allCars;
    }

    @Override
    public Sale find(String Bid) throws Exception {
        ResultSet resultSet= CrudUtil.execute("SELECT * FROM sale WHERE Bid=?",Bid);

        if(resultSet.next()){
            return new Sale(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5));
        }
        return null;
    }
}

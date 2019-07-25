package Dao.Custom.impl;

import Dao.CrudUtil;
import Dao.Custom.CustomerDao;
import Entity.Customer;
import Entity.Sale;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoimpl implements CustomerDao {
    @Override
    public boolean save(Customer customer) throws Exception {
        return CrudUtil.execute("INSERT INTO customer VALUES (?,?,?,?)", customer.getCustnic(),customer.getCname(),customer.getCustcontact(),customer.getCustaddress());
    }

    @Override
    public boolean update(Customer customer) throws Exception {
        return CrudUtil.execute("UPDATE customer SET Cname=?, Ccontact=?, Caddress=? WHERE Cnic=?", customer.getCname(),customer.getCustcontact(),customer.getCustaddress(),customer.getCustnic());
    }

    @Override
    public boolean delete(String Cnic) throws Exception {
        return CrudUtil.execute("DELETE FROM customer WHERE Cnic=?",Cnic);
    }

    @Override
    public List<Customer> findAll() throws Exception {
        ResultSet resultSet=CrudUtil.execute("SELECT * FROM customer");
        List<Customer> allcustomers = new ArrayList<>();
        while (resultSet.next()){
            allcustomers.add(new Customer(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4)));
        }
        return allcustomers;
    }

    @Override
    public Customer find(String Cnic) throws Exception {
        ResultSet resultSet= CrudUtil.execute("SELECT * FROM customer WHERE Cnic=?",Cnic);

        if(resultSet.next()){
            return new Customer(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4));
        }
        return null;
    }
}

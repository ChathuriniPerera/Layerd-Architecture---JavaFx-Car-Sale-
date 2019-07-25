package Dao.Custom.impl;

import Dao.CrudUtil;
import Dao.Custom.OwnerDao;
import Entity.Owner;
import JDBC.DBconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class OwnerDaoimpl implements OwnerDao {
    @Override
    public boolean save(Owner owner) throws Exception {
        return CrudUtil.execute("INSERT INTO owner VALUE (?,?,?,?,?)", owner.getOid(),owner.getOname(),owner.getOcontact(),owner.getOaddress(),owner.getEcnumber());
    }

    @Override
    public boolean update(Owner owner) throws Exception {
        return CrudUtil.execute("UPDATE owner SET Oname=?,Ocontact=?,Oaddress=?,car_ECNumber=? WHERE OID=?", owner.getOid(),owner.getOname(),owner.getOcontact(),owner.getOaddress(),owner.getEcnumber());
    }

    @Override
    public boolean delete(String entityId) throws Exception {
        return false;
    }

    @Override
    public List<Owner> findAll() throws Exception {
        return null;
    }

    @Override
    public Owner find(String ecnumber) throws Exception {
        ResultSet resultSet= CrudUtil.execute("SELECT * FROM owner WHERE car_ECNumber=?",ecnumber);

        if(resultSet.next()){
            return new Owner(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5));
        }
        return null;
    }
}

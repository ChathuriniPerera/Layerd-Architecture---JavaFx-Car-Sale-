package Dao;

//import Dao.Custom.CarModleDaoimpl;
//import Dao.Custom.CarSaleDaoimpl;
import Dao.Custom.impl.*;

public class DaoFactory {

    private static DaoFactory daoFactory;

    private DaoFactory(){

    }

    public static DaoFactory getInstance(){
        if (daoFactory == null){
            daoFactory = new DaoFactory();
        }
        return daoFactory;
    }

    public <T extends SuperDao> T getDAO(DaoTypes daoType){
        switch (daoType){
            case CAR:
                return (T) new CarDaoimpl();
            case MODEL:
                return (T) new CarModleDaoimpl();
            case SALE:
                return (T) new CarSaleDaoimpl();
            case CUSTOMER:
                return (T) new CustomerDaoimpl();
            case OWNER:
                return (T) new OwnerDaoimpl();
            default:
                return null;
        }
    }
}

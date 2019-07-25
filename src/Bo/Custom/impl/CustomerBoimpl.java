package Bo.Custom.impl;

import Bo.Custom.CarBo;
import Bo.Custom.CustomerBo;
import Dao.Custom.CustomerDao;
import Dao.DaoFactory;
import Dao.DaoTypes;
import Dto.CustomerDto;
import Entity.Customer;

import java.util.List;

public class CustomerBoimpl implements CustomerBo {
    private CustomerDao customerDao = DaoFactory.getInstance().getDAO(DaoTypes.CUSTOMER);

    @Override
    public List<CustomerDto> getAllCar() throws Exception {
        return null;
    }

    @Override
    public boolean saveCustomer(CustomerDto dto) throws Exception {
        return customerDao.save(new Customer(dto.getCnic(), dto.getCname(), dto.getCaddress(),dto.getContact()));
    }

    @Override
    public boolean updateCustomer(CustomerDto dto) throws Exception {
        return false;
    }

    @Override
    public boolean removeCustomer(String id) throws Exception {
        return false;
    }

    @Override
    public CustomerDto getCarById(String id) throws Exception {
        return null;
    }
}

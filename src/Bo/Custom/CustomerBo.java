package Bo.Custom;

import Bo.SuperBO;
import Dto.CustomerDto;

import java.util.List;

public interface CustomerBo extends SuperBO {
    public List<CustomerDto> getAllCar() throws Exception;

    public boolean saveCustomer(CustomerDto dto)  throws Exception;

    public boolean updateCustomer(CustomerDto dto)throws Exception;

    public boolean removeCustomer(String id)throws Exception;

    public CustomerDto getCarById(String id)throws Exception;
}

package Bo.Custom;

import Bo.SuperBO;
import Dto.SaleDto;

import java.util.List;

public interface SaleBo extends SuperBO {
    public List<SaleDto> getAllSale() throws Exception;

    public boolean saveSale(SaleDto dto)  throws Exception;

    public boolean updateSale(SaleDto dto)throws Exception;

    public boolean removeSale(String id)throws Exception;

    public SaleDto getCarById(String id)throws Exception;
}

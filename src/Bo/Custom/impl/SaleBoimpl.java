package Bo.Custom.impl;

import Bo.Custom.CarBo;
import Bo.Custom.SaleBo;
import Dao.Custom.CarDao;
import Dao.Custom.CarSaleDao;
import Dao.DaoFactory;
import Dao.DaoTypes;
import Dto.SaleDto;
import Entity.Sale;

import java.util.List;
import java.util.stream.Collectors;

public class SaleBoimpl implements SaleBo {
    private CarSaleDao carSaleDao = DaoFactory.getInstance().getDAO(DaoTypes.SALE);

    @Override
    public List<SaleDto> getAllSale() throws Exception {
        return carSaleDao.findAll().stream().map(sale -> new SaleDto(sale.getBid(),sale.getBdate(), sale.getBprice(), sale.getCustnic(), sale.getEcnumber())).collect(Collectors.toList());
    }

    @Override
    public boolean saveSale(SaleDto dto) throws Exception {
        return carSaleDao.save(new Sale(dto.getBid(), dto.getBdate(), dto.getBprice(), dto.getCustnic(), dto.getEcnumber()));
    }

    @Override
    public boolean updateSale(SaleDto dto) throws Exception {
        return carSaleDao.update(new Sale(dto.getBid(), dto.getBdate(), dto.getBprice(), dto.getCustnic(), dto.getEcnumber()));
    }

    @Override
    public boolean removeSale(String id) throws Exception {
        return carSaleDao.delete(id);
    }

    @Override
    public SaleDto getCarById(String id) throws Exception {
        Sale sale = carSaleDao.find(id);
        return new SaleDto(sale.getBid(), sale.getBdate(), sale.getBprice(), sale.getCustnic(), sale.getEcnumber());
    }
}

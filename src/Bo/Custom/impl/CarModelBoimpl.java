package Bo.Custom.impl;

import Bo.Custom.CarModelBo;
//import Dao.Custom.CarModleDaoimpl;
import Dao.Custom.CarModelDao;
import Dao.DaoFactory;
import Dao.DaoTypes;
import Dto.CarModelDto;
import Entity.CarModel;

import java.util.List;
import java.util.stream.Collectors;

public class CarModelBoimpl implements CarModelBo {
    private CarModelDao carModelDao = DaoFactory.getInstance().getDAO(DaoTypes.MODEL);

    @Override
    public List<CarModelDto> getAllModel() throws Exception {
        return carModelDao.findAll().stream().map(carModel -> new CarModelDto(carModel.getMname(), carModel.getBrand())).collect(Collectors.toList());
    }

    @Override
    public boolean saveCarModel(CarModelDto dto) throws Exception {
        return carModelDao.save(new CarModel(dto.getMname(), dto.getBrand()));
    }

    @Override
    public boolean updateCarModel(CarModelDto dto) throws Exception {
        return carModelDao.update(new CarModel(dto.getMname(), dto.getBrand()));
    }

    @Override
    public boolean removeCarModel(String id) throws Exception {
        return carModelDao.delete(id);
    }

    @Override
    public CarModelDto getModelById(String id) throws Exception {
        CarModel carModel = carModelDao.find(id);
        return new CarModelDto(carModel.getMname(), carModel.getBrand());
    }







   /* public List<CarModelDto> getallmodel()throws Exception{
        CarModleDaoimpl carModleDaoimpl = new CarModleDaoimpl();
        List<CarModel> carModels= carModleDaoimpl.searchallmodel();
        List<CarModelDto> dtos = new ArrayList<>();
        for (CarModel carModel : carModels){
            CarModelDto dto= new CarModelDto(carModel.getMname(),carModel.getBrand(),carModel.getYear());
            dtos.add(dto);
        }
        return dtos;
    }

    public CarModel searchmodel(CarModelDto dto) throws Exception{
        CarModleDaoimpl carmodle = new CarModleDaoimpl();
        return carmodle.searchmodel(String.valueOf(new CarModel(dto.getBrand(),dto.getMname(),dto.getYear())));
    }*/

}

package Bo.Custom.impl;

import Bo.Custom.CarBo;
//import Dao.Custom.CarDaoimpl;
import Dao.Custom.CarDao;
import Dao.DaoFactory;
import Dao.DaoTypes;
import Dto.CarDto;
import Entity.Car;

import java.util.List;
import java.util.stream.Collectors;

public class CarBoimpl implements CarBo {
    private CarDao carDao = DaoFactory.getInstance().getDAO(DaoTypes.CAR);

    @Override
    public List<CarDto> getAllCar() throws Exception {
        return carDao.findAll().stream().map(car -> new CarDto(car.getMname(),car.getEcnumber(), car.getNumber(), car.getDistance(), car.getColor(), car.getPrice())).collect(Collectors.toList());
    }

    @Override
    public boolean saveCar(CarDto dto) throws Exception {
        return carDao.save(new Car(dto.getMname(),dto.getEcnumber(), dto.getDistance(), dto.getColour(), dto.getNumber(),dto.getPrice()));
    }

    @Override
    public boolean updateCar(CarDto dto) throws Exception {
        return carDao.update(new Car(dto.getMname(),dto.getEcnumber(), dto.getDistance(), dto.getColour(), dto.getNumber(),dto.getPrice()));
    }

    @Override
    public boolean removeCar(String id) throws Exception {
        return carDao.delete(id);
    }

    @Override
    public CarDto getCarById(String id) throws Exception {
        Car car = carDao.find(id);
        return new CarDto(car.getMname(), car.getEcnumber(), car.getNumber(), car.getDistance(), car.getColor(),car.getPrice());
    }
}

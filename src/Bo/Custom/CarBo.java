package Bo.Custom;

import Bo.SuperBO;
import Dto.CarDto;

import java.util.List;

public interface CarBo extends SuperBO {
    public List<CarDto> getAllCar() throws Exception;

    public boolean saveCar(CarDto dto)  throws Exception;

    public boolean updateCar(CarDto dto)throws Exception;

    public boolean removeCar(String id)throws Exception;

    public CarDto getCarById(String id)throws Exception;
}

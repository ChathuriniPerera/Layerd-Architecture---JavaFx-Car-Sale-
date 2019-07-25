package Bo.Custom;

import Bo.SuperBO;
import Dto.CarModelDto;

import java.util.List;

public interface CarModelBo extends SuperBO {
    public List<CarModelDto> getAllModel() throws Exception;

    public boolean saveCarModel(CarModelDto dto)  throws Exception;

    public boolean updateCarModel(CarModelDto dto)throws Exception;

    public boolean removeCarModel(String id)throws Exception;

    public CarModelDto getModelById(String id)throws Exception;
}

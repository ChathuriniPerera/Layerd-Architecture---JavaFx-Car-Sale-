package Bo.Custom;

import Bo.SuperBO;
import Dto.OwnerDto;

import java.util.List;

public interface OwnerBo extends SuperBO {
    public List<OwnerDto> getAllOwner() throws Exception;

    public boolean saveOwner(OwnerDto dto)  throws Exception;

    public boolean updateOwner(OwnerDto dto)throws Exception;

    public boolean removeOwner(String id)throws Exception;

    public OwnerDto getOwnerById(String id)throws Exception;
}

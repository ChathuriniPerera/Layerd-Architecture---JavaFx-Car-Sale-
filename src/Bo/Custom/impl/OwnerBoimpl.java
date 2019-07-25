package Bo.Custom.impl;

import Bo.Custom.CarBo;
import Bo.Custom.OwnerBo;
import Dao.Custom.OwnerDao;
import Dao.DaoFactory;
import Dao.DaoTypes;
import Dto.OwnerDto;
import Entity.Owner;

import java.util.List;

public class OwnerBoimpl implements OwnerBo {
    private OwnerDao ownerDao = DaoFactory.getInstance().getDAO(DaoTypes.OWNER);

    @Override
    public List<OwnerDto> getAllOwner() throws Exception {
        return null;
    }

    @Override
    public boolean saveOwner(OwnerDto dto) throws Exception {
        return ownerDao.save(new Owner(dto.getOid(), dto.getOname(), dto.getOcontact(), dto.getOaddress(), dto.getEcnumber()));
    }

    @Override
    public boolean updateOwner(OwnerDto dto) throws Exception {
        return false;
    }

    @Override
    public boolean removeOwner(String id) throws Exception {
        return false;
    }

    @Override
    public OwnerDto getOwnerById(String ecnumber) throws Exception {
        Owner owner = ownerDao.find(ecnumber);
        return new OwnerDto(owner.getOid(), owner.getOname(), owner.getOcontact(), owner.getOaddress(), owner.getEcnumber());
    }
}

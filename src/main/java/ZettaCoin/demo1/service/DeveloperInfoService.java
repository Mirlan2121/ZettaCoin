package ZettaCoin.demo1.service;


import ZettaCoin.demo1.entity.DeveloperInfo;
import ZettaCoin.demo1.model.devInfo.DeveloperInfoModel;
import ZettaCoin.demo1.model.devInfo.DeveloperInfoUpdateModel;

import java.util.List;


public interface DeveloperInfoService  {

    DeveloperInfo save (DeveloperInfoModel developerInfoModel);

    DeveloperInfo getById(Long id);

    List<DeveloperInfo> getAllDev ();

    DeveloperInfo getByName(String name);

    DeveloperInfo getBySerName(String serName);

    DeveloperInfo getUpdateDeveloperInfo(DeveloperInfoUpdateModel infoUpdateModel);

    DeveloperInfo deleteDevInfo();


}

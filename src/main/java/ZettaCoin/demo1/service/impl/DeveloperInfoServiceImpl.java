package ZettaCoin.demo1.service.impl;

import ZettaCoin.demo1.entity.Developer;
import ZettaCoin.demo1.entity.DeveloperInfo;
import ZettaCoin.demo1.model.devInfo.DeveloperInfoModel;
import ZettaCoin.demo1.model.devInfo.DeveloperInfoUpdateModel;
import ZettaCoin.demo1.reposistory.DeveloperInfoRepository;
import ZettaCoin.demo1.reposistory.DeveloperRepository;
import ZettaCoin.demo1.service.DeveloperInfoService;
import ZettaCoin.demo1.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeveloperInfoServiceImpl implements DeveloperInfoService {

    @Autowired
    private DeveloperInfoRepository developerInfoRepository;

    @Autowired
    private DeveloperRepository developerRepository;

    @Autowired
    private DeveloperService developerService;


    @Override
    public DeveloperInfo save(DeveloperInfoModel developerInfoModel) {
        DeveloperInfo developerInfo = new DeveloperInfo();
        developerInfo.setName(developerInfoModel.getName());
        developerInfo.setSerName(developerInfoModel.getSerName());
        developerInfo.setDateOfBirth(developerInfoModel.getDateOfBirth());
        developerInfo.setImages(developerInfoModel.getImages());
        developerInfo.setPhone(developerInfoModel.getPhone());
        developerInfo.setEmail(developerInfoModel.getEmail());
        developerInfo.setDeveloper(developerService.getCurrentDeveloper());
        return developerInfoRepository.save(developerInfo);
    }

    @Override
    public DeveloperInfo getById(Long id) {
        return developerInfoRepository.findById(id).orElse(null);
    }

    @Override
    public List<DeveloperInfo> getAllDev() {
        return developerInfoRepository.findAll();
    }

    @Override
    public DeveloperInfo getByName(String name) {
        return developerInfoRepository.findByName(name).orElse(null);

    }

    @Override
    public DeveloperInfo getBySerName(String serName) {
        return developerInfoRepository.findBySerName(serName).orElse(null);
    }

    @Override
    public DeveloperInfo getUpdateDeveloperInfo(DeveloperInfoUpdateModel infoUpdateModel) {
        DeveloperInfo developerInfo = developerInfoRepository.findByName(infoUpdateModel.getName())
                .orElse(null);
        developerInfo.setName(infoUpdateModel.getName());
        developerInfo.setSerName(infoUpdateModel.getSerName());
        developerInfo.setImages(infoUpdateModel.getImage());

        return developerInfoRepository.save(developerInfo);
    }

    @Override
    public DeveloperInfo deleteDevInfo() {
        Developer developer = developerService.getCurrentDeveloper();
        DeveloperInfo developerInfo =developerInfoRepository.findByDeveloper(developer).orElseThrow(
                ()-> new IllegalArgumentException("Такого разработчик нет"));
        developerInfoRepository.delete(developerInfo);
        return developerInfo;
    }
}

package ZettaCoin.demo1.service.impl;

import ZettaCoin.demo1.enam.Checkbox;
import ZettaCoin.demo1.entity.Developer;
import ZettaCoin.demo1.entity.MetaData;
import ZettaCoin.demo1.model.meta.MetaDataModel;
import ZettaCoin.demo1.model.meta.MetaDataUpdateModel;
import ZettaCoin.demo1.reposistory.CompanyRepository;
import ZettaCoin.demo1.reposistory.MetaDateRepository;
import ZettaCoin.demo1.service.CompanyService;
import ZettaCoin.demo1.service.CurrentCompanyService;
import ZettaCoin.demo1.service.DeveloperService;
import ZettaCoin.demo1.service.MetaDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetaDataServiceImpl implements MetaDataService {

    @Autowired
    private MetaDateRepository metaDateRepository;

    @Autowired
    private DeveloperService developerService;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private MetaDataService metaDataService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private CurrentCompanyService currencyService;

    @Override
    public MetaData create(MetaDataModel metaDataModel) {
        Developer developer = developerService.getCurrentDeveloper();

        MetaData metaData = new MetaData();

        metaData.setChecked(Checkbox.NO);

        metaData.setCurrentCompany(currencyService.getById(metaDataModel.getCurrentCompany()));

        return null;
    }

    @Override
    public List<MetaData> getAll() {
        return metaDateRepository.findAll();
    }

    @Override
    public MetaData getById(Long id) {
        return metaDateRepository.findById(id).orElse(null);
    }

//    @Override
//    public MetaData getByDesiredId(Long id) {
//        return metaDateRepository.findByDesiredId(id).orElse(null);
//    }

    @Override
    public MetaData getUpdateMetaData(MetaDataUpdateModel metaDataUpdateModel) {
        Developer developer = developerService.getById(metaDataUpdateModel.getId());
        MetaData metaData = metaDateRepository.findById(metaDataUpdateModel.getId()).orElseThrow(
                () -> new IllegalArgumentException("Таких данных нету"));
        metaData.setChecked(Checkbox.NO);
        metaData.setDeveloper(developer);
        return metaDateRepository.save(metaData);
    }

    @Override
    public MetaData deleteMetaData(Long id) {
        MetaData metaData = metaDateRepository.findById(id).orElse(null);
        metaDateRepository.deleteById(id);
        return metaData;
    }
}

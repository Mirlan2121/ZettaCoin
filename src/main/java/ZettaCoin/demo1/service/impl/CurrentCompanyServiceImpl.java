package ZettaCoin.demo1.service.impl;

import ZettaCoin.demo1.entity.CurrentCompany;
import ZettaCoin.demo1.model.company.CurrentCompanyUpdateModel;
import ZettaCoin.demo1.reposistory.CurrentCompanyRepository;
import ZettaCoin.demo1.service.CurrentCompanyService;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrentCompanyServiceImpl implements CurrentCompanyService {
    @Autowired
    private CurrentCompanyRepository currentCompanyRepository;

    @Override
    public List<CurrentCompany> getAll() {
        return currentCompanyRepository.findAll();
    }

    @Override
    public CurrentCompany getById(Long id) {
        return currentCompanyRepository.findById(id).orElse(null);
    }

    @Override
    public CurrentCompany getByCompanyId(Long id) {
        return currentCompanyRepository.findByCompanyId(id).orElse(null);
    }

    @Override
    public CurrentCompany getByUpdateCurrentCompany(CurrentCompanyUpdateModel currentCompanyUpdateModel) {
        CurrentCompany currentCompany = currentCompanyRepository.findById(currentCompanyUpdateModel.getId())
                .orElse(null);
        currentCompany.setName(currentCompanyUpdateModel.getName());
//        currentCompany.setCompany(currentCompanyUpdateModel.getCompany());
        return null;
    }

}

package ZettaCoin.demo1.service.impl;

import ZettaCoin.demo1.entity.Company;
import ZettaCoin.demo1.entity.Developer;
import ZettaCoin.demo1.model.company.CompanyModel;
import ZettaCoin.demo1.model.company.CompanyUpdateModel;
import ZettaCoin.demo1.reposistory.CompanyRepository;
import ZettaCoin.demo1.reposistory.DeveloperRepository;
import ZettaCoin.demo1.service.CompanyService;
import ZettaCoin.demo1.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private DeveloperRepository developerRepository;

    @Autowired
    private DeveloperService developerService;


    @Override
    public Company create(CompanyModel companyModel) {
        Developer developer = developerService.getCurrentDeveloper();
        Company company = new Company();
        company.setName(companyModel.getName());
        company.setAddress(companyModel.getAddress());
        company.setPhone(companyModel.getPhone());
        company.setDescription(companyModel.getDescription());
        return companyRepository.save(company);
    }

    @Override
    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company getById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public Company getByAddress(String address) {
        return companyRepository.findByAddress(address).orElse(null);
    }

    @Override
    public Company getByName(String name) {
        return companyRepository.findByName(name).orElse(null);
    }

    @Override
    public Company getUpdateCompany(CompanyUpdateModel companyUpdateModel) {
        Company company = companyRepository.findById(companyUpdateModel.getId()).orElseThrow(
                () -> new IllegalArgumentException("Такой компании таким ID нету"));
        company.setName(companyUpdateModel.getName());
        company.setAddress(companyUpdateModel.getAddress());
        company.setPhone(companyUpdateModel.getPhone());
        company.setDescription(companyUpdateModel.getDescription());
        companyRepository.save(company);
        return company;
    }

    @Override
    public Company deleteCompany(Long id) {
        Company company =companyRepository.findById(id).orElse(null);
        companyRepository.delete(company);
        return company;
    }
}

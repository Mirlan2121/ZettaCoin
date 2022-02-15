package ZettaCoin.demo1.service;

import ZettaCoin.demo1.entity.Company;
import ZettaCoin.demo1.model.company.CompanyModel;
import ZettaCoin.demo1.model.company.CompanyUpdateModel;

import java.util.List;

public interface CompanyService {

    Company create (CompanyModel companyModel);

    List<Company> getAll();

    Company getById(Long id);

    Company getByAddress(String address);

    Company getByName(String name);

    Company getUpdateCompany(CompanyUpdateModel companyUpdateModel);

    Company deleteCompany(Long id);
}

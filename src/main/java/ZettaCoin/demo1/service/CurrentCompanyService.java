package ZettaCoin.demo1.service;

import ZettaCoin.demo1.entity.CurrentCompany;
import ZettaCoin.demo1.model.company.CurrentCompanyUpdateModel;

import java.util.List;

public interface CurrentCompanyService {

    List<CurrentCompany> getAll();

    CurrentCompany getById(Long id);

    CurrentCompany getByCompanyId(Long id);

    CurrentCompany getByUpdateCurrentCompany (CurrentCompanyUpdateModel currentCompanyUpdateModel);

}

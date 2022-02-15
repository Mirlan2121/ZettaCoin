package ZettaCoin.demo1.controller;

import ZettaCoin.demo1.entity.Company;
import ZettaCoin.demo1.model.company.CompanyModel;
import ZettaCoin.demo1.model.company.CompanyUpdateModel;
import ZettaCoin.demo1.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping("/create")
    public Company create(CompanyModel companyModel){
        return companyService.create(companyModel);
    }

    @GetMapping("/getAll")
    public List<Company> getAll (){
        return companyService.getAll();
    }

    @PostMapping("/getById/{id}")
    public Company getById(Long id){
        return companyService.getById(id);
    }

    @PostMapping("/getName/{name}")
    public Company getCompanyName (@PathVariable String name){
        return companyService.getByName(name);
    }

    @DeleteMapping("/delete/{id}")
    public Company deleteCompany(@PathVariable Long id){
        return companyService.deleteCompany(id);
    }

    @PostMapping("/getByAddress/{address}")
    public Company getByAddress(@PathVariable String address){
        return companyService.getByAddress(address);
    }

    @PostMapping("/updateCompany")
    public Company getUpdateCompany(CompanyUpdateModel companyUpdateModel){
        return companyService.getUpdateCompany(companyUpdateModel);

    }
}

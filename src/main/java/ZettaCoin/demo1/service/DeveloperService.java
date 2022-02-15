package ZettaCoin.demo1.service;

import ZettaCoin.demo1.entity.Developer;
import ZettaCoin.demo1.model.dev.DeveloperAuthModel;
import ZettaCoin.demo1.model.dev.DeveloperUpdateModel;

import java.util.List;

public interface DeveloperService {

    Developer create (Developer developer);

    Developer createAdmin(Developer developer);

    Developer getById(Long id);

    List<Developer> getAll();

    Developer deleteDeveloper(Developer developer);

    Developer getByLogin(String login);

    String getAuthorizationToken(DeveloperAuthModel developerAuthModel);

    Developer getCurrentDeveloper();

    Developer getUpdateDeveloper(DeveloperUpdateModel developerUpdateModel);

}

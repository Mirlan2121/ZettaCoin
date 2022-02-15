package ZettaCoin.demo1.service.impl;

import ZettaCoin.demo1.entity.Developer;
import ZettaCoin.demo1.entity.DeveloperRole;
import ZettaCoin.demo1.model.dev.DeveloperAuthModel;
import ZettaCoin.demo1.model.dev.DeveloperUpdateModel;
import ZettaCoin.demo1.reposistory.DeveloperRepository;
import ZettaCoin.demo1.reposistory.DeveloperRoleRepository;
import ZettaCoin.demo1.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;

@Service
public class DeveloperServiceImpl implements DeveloperService {

    @Autowired
    private DeveloperRepository developerRepository;

    @Autowired
    private DeveloperRoleRepository developerRoleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Developer create(Developer developer) {

        String encodePassword = passwordEncoder.encode(developer.getPassword());
        System.out.println(encodePassword);
        developer.setPassword(encodePassword);
        developer.setActive(1L);
        developerRepository.save(developer);

        DeveloperRole developerRole = new DeveloperRole();
        developerRole.setRoleName("ROLE_DEV");
        developerRole.setDeveloper(developer);
        developerRoleRepository.save(developerRole);
        return developer;
    }

    @Override
    public Developer createAdmin(Developer developer) {
        String encodePassword = passwordEncoder.encode(developer.getPassword());
        System.out.println(encodePassword);
        developer.setPassword(encodePassword);
        developer.setActive(1L);
        developerRepository.save(developer);

        DeveloperRole developerRole = new DeveloperRole();
        developerRole.setRoleName("ROLE_ADMIN");
        developerRole.setDeveloper(developer);
        developerRoleRepository.save(developerRole);
        return developer;
    }

    @Override
    public Developer getById(Long id) {
        return developerRepository.getById(id);
    }

    @Override
    public List<Developer> getAll() {
        return developerRepository.findAll();
    }

    @Override
    public Developer deleteDeveloper(Developer developer) {
        DeveloperRole developerRole = developerRoleRepository.findByDeveloper(developer).orElse(null);
        if (developerRole == null) {
            try {
                throw new Exception("Роли нет");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        developerRoleRepository.delete(developerRole);
        developerRepository.delete(developer);
        return developer;
    }

    @Override
    public Developer getByLogin(String login) {
        return developerRepository.findByLogin(login).orElse(null);
    }

    @Override
    public String getAuthorizationToken(DeveloperAuthModel developerAuthModel) {
        Developer developer =developerRepository.findByLogin(developerAuthModel.getLogin()).orElseThrow
                (() -> new IllegalArgumentException("Неверный пароль или логин"));
        boolean isPasswordMatches = passwordEncoder.matches(developerAuthModel.getPassword(), developer.getPassword());
        if (!isPasswordMatches){
        throw new IllegalArgumentException("Неверный пароль или логин");
        }
        String loginPasswordPair = developerAuthModel.getLogin() + ":" + developerAuthModel.getPassword();
        return "Basic" + new String(Base64.getEncoder().encode(loginPasswordPair.getBytes()));
    }

    @Override
    public Developer getCurrentDeveloper() {
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        return getByLogin(login);
    }

    @Override
    public Developer getUpdateDeveloper(DeveloperUpdateModel developerUpdateModel) {
        Developer developer = developerRepository.findById(developerUpdateModel.getId()).orElseThrow(()
        -> new IllegalArgumentException("Логин такого разработчика нет"));
        developer.setLogin(developerUpdateModel.getLogin());
        developer.setPassword(developerUpdateModel.getPassword());
        developer.setDeveloperInfo(developerUpdateModel.getDeveloperInfo());
        developer.setActive(developerUpdateModel.getActive());
        return developerRepository.save(developer);
    }
}

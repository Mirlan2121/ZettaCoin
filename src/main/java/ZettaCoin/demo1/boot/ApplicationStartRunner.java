package ZettaCoin.demo1.boot;


import ZettaCoin.demo1.entity.Developer;
import ZettaCoin.demo1.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartRunner implements CommandLineRunner {


    @Autowired
    private DeveloperService developerService;

    @Override
    public void run(String... args) throws Exception {
        if(developerService.getByLogin("admin") == null) {
            Developer admin = new Developer();
            admin.setLogin("admin");
            admin.setPassword("1234");
            admin.setDeveloperInfo("Администратор");
            admin.setActive(1L);
            developerService.createAdmin(admin);
        }
    }
}

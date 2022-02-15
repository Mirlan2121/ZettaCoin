package ZettaCoin.demo1.controller;

import ZettaCoin.demo1.entity.Developer;
import ZettaCoin.demo1.model.dev.DeveloperAuthModel;
import ZettaCoin.demo1.model.dev.DeveloperUpdateModel;
import ZettaCoin.demo1.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Dev")
public class DeveloperController {

    @Autowired
    private DeveloperService developerService;

    @PostMapping("/create")
    public Developer create(@RequestBody Developer developer) {
        return developerService.create(developer);
    }

    @GetMapping("/getAll")
    public List<Developer> getAllDeveloper() {
        return developerService.getAll();
    }

    @GetMapping("/getById/{id}")
    public Developer getByIDDev(@PathVariable Long id) {
        return developerService.getById(id);
    }

    @GetMapping("/get-current")
    public Developer getCurrentDeveloper() {
        return developerService.getCurrentDeveloper();
    }

    @DeleteMapping("/deleteDev")
    public Developer deleteDeveloper() {
        return developerService.deleteDeveloper(developerService.getCurrentDeveloper());
    }

    @PostMapping("/updateDev")
    public Developer updateDeveloper(@RequestBody DeveloperUpdateModel developerUpdateModel) {
        return developerService.getUpdateDeveloper(developerUpdateModel);
    }

    @PostMapping("/sing-in")
    public ResponseEntity<String> singIn(@RequestBody DeveloperAuthModel developerAuthModel) {
        return ResponseEntity.ok(developerService.getAuthorizationToken(developerAuthModel));
    }

}

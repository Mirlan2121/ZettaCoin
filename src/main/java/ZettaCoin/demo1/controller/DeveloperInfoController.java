package ZettaCoin.demo1.controller;

import ZettaCoin.demo1.entity.DeveloperInfo;
import ZettaCoin.demo1.model.devInfo.DeveloperInfoModel;
import ZettaCoin.demo1.model.devInfo.DeveloperInfoUpdateModel;
import ZettaCoin.demo1.service.DeveloperInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/DevInfo")
public class DeveloperInfoController {

    @Autowired
    private DeveloperInfoService developerInfoService;

    @PostMapping("/create")
    public DeveloperInfo create(DeveloperInfoModel developerInfo) {
        return developerInfoService.save(DeveloperInfoModel.builder().build());
    }

    @GetMapping("/getAllDevInfo")
    public List<DeveloperInfo> getDevices() {
        return developerInfoService.getAllDev();
    }

    @GetMapping("/getByIDDevInfo/{id}")
    public DeveloperInfo getByID(Long id) {
        return developerInfoService.getById(id);
    }

    @DeleteMapping("/deleteDevInfo")
    public DeveloperInfo deleteByID() {
        return developerInfoService.deleteDevInfo();
    }

    @PostMapping("/DevInfoName{Name}")
    public DeveloperInfo getByName(@PathVariable String name){
        return developerInfoService.getByName(name);
    }

    @PostMapping("/DevInfoSerName/{serName}")
    public DeveloperInfo getBySerName(@PathVariable String serName){
        return developerInfoService.getBySerName(serName);
    }

    @PostMapping("/updateDevInfo")
    public DeveloperInfo updateDevInfo(@RequestBody DeveloperInfoUpdateModel developerInfoModel){
    return developerInfoService.getUpdateDeveloperInfo(developerInfoModel);
    }

}

package ZettaCoin.demo1.controller;


import ZettaCoin.demo1.entity.MetaData;
import ZettaCoin.demo1.model.meta.MetaDataModel;
import ZettaCoin.demo1.model.meta.MetaDataUpdateModel;
import ZettaCoin.demo1.service.MetaDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/MetaData")
public class MetaDataController {

    @Autowired
    private MetaDataService metaDataService;

    @PostMapping("/create")
    public MetaData create(MetaDataModel metaData) {
        return metaDataService.create(metaData);
    }
    @GetMapping("/getAll")
    public List<MetaData> getAll (){
        return  metaDataService.getAll();
    }
    @GetMapping("/getById/{id}")
    public MetaData getById(@PathVariable Long id){
        return metaDataService.getById(id);
    }
    @PostMapping("/getMetaDataUpdate")
    public MetaData getMetaDataUpdate (MetaDataUpdateModel metaDataUpdateModel){
        return metaDataService.getUpdateMetaData(metaDataUpdateModel);
    }
    @DeleteMapping("/delete")
    public MetaData delete (@PathVariable Long id){
        return metaDataService.deleteMetaData(id);
    }
//    @GetMapping("/getByDesiredId/{id}")
//    public MetaData getByDesiredId (@PathVariable Long id){
//        return  metaDataService.getByDesiredId(id);
//    }
}

package ZettaCoin.demo1.service;

import ZettaCoin.demo1.entity.MetaData;
import ZettaCoin.demo1.model.meta.MetaDataModel;
import ZettaCoin.demo1.model.meta.MetaDataUpdateModel;

import java.util.List;

public interface MetaDataService {

    List<MetaData> getAll ();

    MetaData create (MetaDataModel metaDataModel);

    MetaData getById(Long id);

//    MetaData getByDesiredId(Long id);

    MetaData getUpdateMetaData (MetaDataUpdateModel metaDataUpdateModel);

    MetaData deleteMetaData(Long id);


}

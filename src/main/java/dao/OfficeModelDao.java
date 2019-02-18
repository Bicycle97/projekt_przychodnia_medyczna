package dao;

import model.OfficeModel;

import java.util.List;

public interface OfficeModelDao {

    OfficeModel getOfficeInDatabase(String id);

    List<OfficeModel> getOfficeInDatabase(OfficeModel officeModel);
    void cleanUp();
}

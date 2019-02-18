package dao;



import model.OfficeModel;
import utils.MyEntityManagerFactory;

import javax.persistence.EntityManager;
import java.util.List;

public class OfficeModelDaoImpl implements OfficeModelDao{

    private EntityManager entityManager = MyEntityManagerFactory.getInstance().getEmFactory().createEntityManager();

    @Override
    public OfficeModel getOfficeInDatabase(String id) {
            List<OfficeModel> list = entityManager.
                    createQuery("Select e from OfficeModel e where e.number = :paramId")
                    .setParameter("paramId",id )
                    .getResultList();
            cleanUp();
            return list.get(0);
    }

    @Override
    public List<OfficeModel> getOfficeInDatabase(OfficeModel officeModel) {
        List<OfficeModel> list = entityManager.
                createQuery("Select o from OfficeModel o")
                .getResultList();
        cleanUp();
        return list;
    }

    @Override
    public void cleanUp() {
        entityManager.close();
    }
}

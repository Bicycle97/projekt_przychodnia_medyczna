package dao;

import model.MedicalHistoryModel;
import model.PatientModel;
import utils.MyEntityManagerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class MedicalHistoryDaoImpl implements MedicalHistoryDao {

    private EntityManager entityManager = MyEntityManagerFactory.getInstance().getEmFactory().createEntityManager();

    @Override
    public List<MedicalHistoryModel> getMedicalHistorySelectedPatientInDatabase(PatientModel patientModel) {
        List<MedicalHistoryModel> list = entityManager.
                createQuery("Select mh from MedicalHistoryModel mh where mh.patientModell =: patient ")
                .setParameter("patient", patientModel)
                .getResultList();
        cleanUp();
        return list;
    }

    @Override
    public void save(MedicalHistoryModel medicalHistoryModel) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(medicalHistoryModel);
        tx.commit();
    }

    @Override
    public void delete(MedicalHistoryModel medicalHistoryModel) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.remove(medicalHistoryModel);
        tx.commit();
    }

    @Override
    public void delete(PatientModel patientModel) {

        List<MedicalHistoryModel> list = entityManager.
                createQuery("Select v from MedicalHistoryModel v where v.patientModell = :patient")
                .setParameter("patient", patientModel)
                .getResultList();
        if (!list.isEmpty()) {
            list.forEach(singleMedicalHistory -> {
                delete(singleMedicalHistory);
            });
        }
    }

    @Override
    public void cleanUp() {
        entityManager.close();
    }
}

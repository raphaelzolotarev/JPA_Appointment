package be.intecbrussel.appointment.jpa.repository;
import be.intecbrussel.appointment.jpa.connection.EntityManagerProvider;
import be.intecbrussel.appointment.jpa.model.Appointment;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class AppointmentRepository {

    public boolean create(Appointment appointment) {
        EntityManager entityManager = EntityManagerProvider.getEntityManagerFactory().createEntityManager();

        try{
            entityManager.getTransaction().begin();
            entityManager.persist(appointment);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            return false;
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }


    public List<Appointment> read(int day) {
        EntityManager entityManager = EntityManagerProvider.getEntityManagerFactory().createEntityManager();

        try{
            Query query = entityManager.createQuery("Select a from Appointment a where day="+day);
            return query.getResultList();
        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            return new ArrayList<>();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }


    public boolean update(Appointment appointment, int newHour) {
        EntityManager entityManager = EntityManagerProvider.getEntityManagerFactory().createEntityManager();

        try{
            appointment.setHour(newHour);
            entityManager.getTransaction().begin();
            entityManager.merge(appointment);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            return false;
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }


    public boolean delete(Appointment appointment) {
        EntityManager entityManager = EntityManagerProvider.getEntityManagerFactory().createEntityManager();

        try{
            entityManager.getTransaction().begin();
            Appointment attachedAppointment = entityManager.merge(appointment);
            entityManager.remove(attachedAppointment);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            return false;
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }


    public boolean closeConnection(){
        try{
            EntityManagerProvider.shutdown();
            return true;
        } catch (Exception e){
            return false;
        }
    }


}

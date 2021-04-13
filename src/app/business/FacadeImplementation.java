/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.business;

import app.controller.constants.Constants;
import app.model.Acceptor;
import app.model.BloodGroup;
import app.model.Coombs;
import app.model.Country;
import app.model.Donor;
import app.model.ICell;
import app.model.IiCell;
import app.model.Liss;
import app.model.Slana;
import app.model.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FacadeImplementation implements Facade {

    @Override
    public User login(String username, String password) {
        if(username == null || username.isEmpty() || password == null || password.isEmpty()){
            return null;
        }
        EntityManager entityManager = getEntityManager();
        Query query = entityManager.createNamedQuery("User.findByUsernameAndPassword");
        query.setParameter("username", username);
        query.setParameter("password", password);
        try{
            User user = (User) query.getSingleResult();
            return user;
        }catch(NoResultException exception){
            System.err.format("Username does not exist: %s", username);
            return null;
        }catch(NonUniqueResultException exception){
            throw new RuntimeException(exception.getMessage());
        }
    }
    
    private EntityManager getEntityManager(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(Constants.PU_NAME);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager;
    }

    @Override
    public List<User> getAllUsers() {
        EntityManager entityManager = getEntityManager();
        Query query = entityManager.createNamedQuery("User.findAll");
        List<User> users = query.getResultList();
        return users;
    }

    @Override
    public List<Donor> getAllDonors() {
        EntityManager entityManager = getEntityManager();
        Query query = entityManager.createNamedQuery("Donor.findAll");
        List<Donor> donors = query.getResultList();
        return donors;    
    }

    @Override
    public List<Acceptor> getAllAcceptors() {
        EntityManager entityManager = getEntityManager();
        Query query = entityManager.createNamedQuery("Acceptor.findAll");
        List<Acceptor> acceptors = query.getResultList();
        return acceptors;    
    
    }

    @Override
    public Donor saveDonor(Donor donor) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(donor);
        entityManager.getTransaction().commit();
        return donor; 
    
    }

    @Override
    public Acceptor saveAcceptor(Acceptor acceptor) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(acceptor);
        entityManager.getTransaction().commit();
        return acceptor;
    }

    @Override
    public List<Country> getAllCountrys() {
        return getEntityManager()
                .createNamedQuery("Country.findAll")
                .getResultList();
    }

    @Override
    public List<ICell> getICell() {
        return getEntityManager()
                .createNamedQuery("ICell.findAll")
                .getResultList();
    }

    @Override
    public List<IiCell> getIICell() {
        return getEntityManager()
                .createNamedQuery("IiCell.findAll")
                .getResultList();
    }

    @Override
    public List<Slana> getSlana() {
        return getEntityManager()
                .createNamedQuery("Slana.findAll")
                .getResultList();
    }

    @Override
    public List<Coombs> getCoombs() {
        return getEntityManager()
                .createNamedQuery("Coombs.findAll")
                .getResultList();
    }

    @Override
    public List<Liss> getLiss() {
        return getEntityManager()
                .createNamedQuery("Liss.findAll")
                .getResultList();
    }

    @Override
    public List<BloodGroup> getBloodGroupe() {
        return getEntityManager()
                .createNamedQuery("BloodGroup.findAll")
                .getResultList();
    }

    

    


  
 



   
    
}

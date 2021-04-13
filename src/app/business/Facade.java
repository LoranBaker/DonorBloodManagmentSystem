/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.business;

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

/**
 *
 * @author loran
 */
public interface Facade {
    
    //Login method
    public User login(String username, String password);
    
    public List<User> getAllUsers();
    
    public List<Donor> getAllDonors();
    
    public List<Acceptor> getAllAcceptors();
    
    public Donor saveDonor(Donor donor);
    
    public Acceptor saveAcceptor(Acceptor acceptor);
    
    public List<Country> getAllCountrys();
    
    public List<ICell> getICell();
    
    public List<IiCell> getIICell();
    
    public List<Slana> getSlana();
    
    public List<Coombs> getCoombs();
    
    public List<Liss> getLiss();
    
    public List<BloodGroup> getBloodGroupe();
}

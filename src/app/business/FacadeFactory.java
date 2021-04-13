/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.business;

/**
 *
 * @author loran
 */
public class FacadeFactory {
    
    private static final Facade FACADE = new FacadeImplementation();

    public static Facade get_FACADE() {
        return FACADE;
    }
    
    
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller;

import app.DonorApplication;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;


/**
 *
 * @author loran
 */
public class FXMLSwitchController {
    private Pane view;
    
    
    public Pane getPage(String fileName){
        
        try{
            URL fileUrl = DonorApplication.class.getResource("/app/fxml/" + fileName + ".fxml");
            if(fileUrl == null){
            
                throw new java.io.FileNotFoundException("FXML file can't be found");
            }
            view = FXMLLoader.load(fileUrl);
        }catch(Exception e){
            System.out.println("No page" + fileName + "! please check FXML Loader");
        
        }
        return view;
    }
    
    
    
    
}

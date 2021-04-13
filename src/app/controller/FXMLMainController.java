/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller;

import app.controller.constants.Constants;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author loran
 */
public class FXMLMainController implements Initializable {
    @FXML
    private BorderPane mainPane;
    
    @FXML
    private Button LogOutID;
    
    Stage stage;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    
    }    
    
    @FXML
    void AddAcceptorHandleAction(ActionEvent event) {
        FXMLSwitchController object = new FXMLSwitchController();
        Pane view = object.getPage("AddAcceptor");
        mainPane.setCenter(view);
    }

    @FXML
    void AddDonorHandleAction(ActionEvent event) {
        FXMLSwitchController object = new FXMLSwitchController();
        Pane view = object.getPage("AddDonor");
        mainPane.setCenter(view);
    }

   

    @FXML
    void LogOutHandleAction(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle(Constants.ALERT_LOGOUT_TITLE);
        alert.setHeaderText(Constants.ALERT_LOGOUT_CONFIRMATION);

        if (alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) mainPane.getScene().getWindow();
            System.out.println("You succesfully logged out!");
            stage.close();
        }
 

    }

    @FXML
    void SearchAcceptorHandleAction(ActionEvent event) {
        FXMLSwitchController object = new FXMLSwitchController();
        Pane view = object.getPage("SearchAcceptor");
        mainPane.setCenter(view);
       
    }

    @FXML
    void SearchDonorHandleAction(ActionEvent event) {
        FXMLSwitchController object = new FXMLSwitchController();
        Pane view = object.getPage("SearchDonor");
        mainPane.setCenter(view);
    }

    @FXML
    void SettingsHandleAction(ActionEvent event) {
        FXMLSwitchController object = new FXMLSwitchController();
        Pane view = object.getPage("Settings");
        mainPane.setCenter(view);
    }
    
}

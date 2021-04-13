/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller;



import app.business.FacadeImplementation;
import app.controller.constants.Constants;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 *
 * @author loran
 */
public class LoginController implements Initializable {
    
    @FXML
    private BorderPane borderPane;

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Label loginMessageLabel;
   
    private List<app.model.User> listLogin = new ArrayList<>();
    
    private FacadeImplementation userFacade = new FacadeImplementation();
    
    Stage stage;
    
    private double xOffset = 0;
    private double yOffset = 0;
    
      @Override
    public void initialize(URL url, ResourceBundle rb) {
        listLogin = userFacade.getAllUsers();
        
        /*
        File logoFile = new File("images/logo.png");
        Image logoImage = new Image(logoFile.toURI().toString());
        logoImageView.setImage(logoImage);
        */
   
    }
    
    @FXML
    void loginActionButton(ActionEvent event) throws IOException {
        for(app.model.User user : listLogin){
         if(usernameTextField.getText().equals(user.getUsername())){
             if(passwordTextField.getText().equals(user.getPassword())){
                 Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource("app/fxml/FXMLMain.fxml"));
                 Scene scene = new Scene(parent);
                 
                 Stage stage = new Stage();
                 stage.initModality(Modality.APPLICATION_MODAL);
                 stage.setTitle(Constants.MAIN_TITLE);
                 stage.initStyle(StageStyle.UTILITY);
                 stage.setScene(scene);
                 stage.show();   
              
         }
         else {
             loginMessageLabel.setText(Constants.PASSWORD_INCORRECT);
         }
         }else {
            loginMessageLabel.setText(Constants.USERNAME_INCORRECT);
        }
    }
        
        usernameTextField.clear();
        passwordTextField.clear();
    }
    
    
 

    }

   
    
    


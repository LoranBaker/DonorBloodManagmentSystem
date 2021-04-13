/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller;

import app.business.FacadeFactory;
import app.model.Acceptor;
import app.model.BloodGroup;
import app.model.Coombs;
import app.model.Donor;
import app.model.ICell;
import app.model.IiCell;
import app.model.Liss;
import app.model.Slana;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author loran
 */
public class AddAcceptorController implements Initializable {
    @FXML
    private DatePicker datePicker;

    @FXML
    private TextField prezimeTextField;

    @FXML
    private TextField imeTextField;

    @FXML
    private ChoiceBox<Donor> donorIDChoiceBox;

    @FXML
    private ChoiceBox<BloodGroup> bloodGroupeChoiceBox;

    @FXML
    private TextField rhFaktorTextField;

    @FXML
    private TextField rhGenotipTextField;

    @FXML
    private ChoiceBox<ICell> ICellChoiceBox;
    @FXML
    private ChoiceBox<IiCell> IICellChoiceBox;

    @FXML
    private ChoiceBox<Slana> SlanaChoiceBox;

    @FXML
    private ChoiceBox<Liss> LissChoiceBox;

    @FXML
    private ChoiceBox<Coombs> CoombsChoiceBox;

    @FXML
    private TextField interakcijaPacijentaTextField;

    @FXML
    private TextField primjedbaTextField;

    @FXML
    private Button buttonSave;
    
    private ObservableList<Acceptor> observableListAcceptor;
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       ListDonorChoiceBox();
       ListICellChoiceBox();
       ListIICellChoiceBox();
       ListSlanaChoiceBox();
       ListCoombsChoiceBox();
       ListLissChoiceBox();
       ListBloodGroup();
      
      
       buttonSave.setOnAction(this::SaveHandleAction);
    }


    @FXML
      void SaveHandleAction(ActionEvent event) {
      Acceptor acceptor = new Acceptor();  
      acceptor.setDate(Date.valueOf(datePicker.getValue()));
      acceptor.setSurname(String.valueOf(prezimeTextField.getText()));
      acceptor.setName(String.valueOf(imeTextField.getText()));
      acceptor.setRhFaktor(String.valueOf(rhFaktorTextField.getText()));
      acceptor.setRhGenotip(String.valueOf(rhGenotipTextField.getText()));
      acceptor.setInteractionBetweenSerumPatient(String.valueOf(interakcijaPacijentaTextField.getText()));
      acceptor.setDescription(String.valueOf(primjedbaTextField.getText()));
      acceptor.setIdDonor(donorIDChoiceBox.getSelectionModel().getSelectedItem());
      acceptor.setIdICell(ICellChoiceBox.getSelectionModel().getSelectedItem());
      acceptor.setIdIICell(IICellChoiceBox.getSelectionModel().getSelectedItem());
      acceptor.setIdLiss(LissChoiceBox.getSelectionModel().getSelectedItem());
      acceptor.setIdCoombs(CoombsChoiceBox.getSelectionModel().getSelectedItem());
      acceptor.setIdSlana(SlanaChoiceBox.getSelectionModel().getSelectedItem());
      acceptor.setIdbloodGroupe(bloodGroupeChoiceBox.getSelectionModel().getSelectedItem());
      
      FacadeFactory.get_FACADE().saveAcceptor(acceptor);
      observableListAcceptor.add(acceptor);
      clearInputs();
      
      
      
    }
   
    private void ListDonorChoiceBox() {
        List<Donor> donors = FacadeFactory.get_FACADE().getAllDonors();
        ObservableList<Donor> observableDonorList = FXCollections.observableArrayList(donors);
        donorIDChoiceBox.setItems(observableDonorList);
        donorIDChoiceBox.getSelectionModel().select(0);
    }
    
    private void ListICellChoiceBox() {
        List<ICell> iCell = FacadeFactory.get_FACADE().getICell();
        ObservableList<ICell> observableICellList = FXCollections.observableArrayList(iCell);
        ICellChoiceBox.setItems(observableICellList);
        ICellChoiceBox.getSelectionModel().select(0);
    }
    private void ListIICellChoiceBox() {
        List<IiCell> iiCell = FacadeFactory.get_FACADE().getIICell();
        ObservableList<IiCell> observableIICellList = FXCollections.observableArrayList(iiCell);
        IICellChoiceBox.setItems(observableIICellList);
        IICellChoiceBox.getSelectionModel().select(0);
    }
    private void ListSlanaChoiceBox() {
        List<Slana> slana = FacadeFactory.get_FACADE().getSlana();
        ObservableList<Slana> observableSlanaList = FXCollections.observableArrayList(slana);
        SlanaChoiceBox.setItems(observableSlanaList);
        SlanaChoiceBox.getSelectionModel().select(0);
    }
    private void ListCoombsChoiceBox() {
        List<Coombs> coombs = FacadeFactory.get_FACADE().getCoombs();
        ObservableList<Coombs> observableCoombsList = FXCollections.observableArrayList(coombs);
        CoombsChoiceBox.setItems(observableCoombsList);
        CoombsChoiceBox.getSelectionModel().select(0);
    }
    private void ListLissChoiceBox() {
        List<Liss> liss = FacadeFactory.get_FACADE().getLiss();
        ObservableList<Liss> observableLissList = FXCollections.observableArrayList(liss);
        LissChoiceBox.setItems(observableLissList);
        LissChoiceBox.getSelectionModel().select(0);
    }
    
     private void ListBloodGroup() {
        List<BloodGroup> blooodGroupe = FacadeFactory.get_FACADE().getBloodGroupe();
        ObservableList<BloodGroup> observableBloodGroupeList = FXCollections.observableArrayList(blooodGroupe);
        bloodGroupeChoiceBox.setItems(observableBloodGroupeList);
        bloodGroupeChoiceBox.getSelectionModel().select(0);
    }
    
      private void clearInputs() {
        imeTextField.clear();
        prezimeTextField.clear();
        rhFaktorTextField.clear();
        rhGenotipTextField.clear();
        interakcijaPacijentaTextField.clear();
        primjedbaTextField.clear();
        
    }
      
      
   
    
     
    
}

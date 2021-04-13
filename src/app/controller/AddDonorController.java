/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller;


import app.business.FacadeFactory;
import app.model.Acceptor;
import app.model.BloodGroup;
import app.model.Country;
import app.model.Donor;
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
public class AddDonorController implements Initializable {

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextField prezimeTextField;

    @FXML
    private TextField imeOcaTextField;

    @FXML
    private TextField imeTextField;

    @FXML
    private TextField mjestoRadaTextField;

    
    @FXML
    private ChoiceBox<BloodGroup> bloodGroupeChoiceBox;

    @FXML
    private TextField regBrojTextField;

    @FXML
    private DatePicker birthDatePicker;

    @FXML
    private ChoiceBox<Country> adresaChoiceBox;

    @FXML
    private TextField dozaUzeteKrviTextField;

    @FXML
    private TextField brojBoceTextField;

    @FXML
    private ChoiceBox<Acceptor> idAcceptorChoiceBox;


    @FXML
    private TextField brojTelefonaTextField;

    @FXML
    private TextField opisTextField;

    @FXML
    private Button btnSave;

    private ObservableList<Donor> observableListDonor = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ListAcceptor();
        ListCountrys();
        ListBloodGroup();
        btnSave.setOnAction(this::SaveHandleAction);
    }

    @FXML
    void SaveHandleAction(ActionEvent event) {

        Donor donor = new Donor();
       // donor.setId(Integer.parseInt(IDTextField.getText()));
        donor.setName(imeTextField.getText());
        donor.setSurname(prezimeTextField.getText());
        donor.setIdBloodGroupe(bloodGroupeChoiceBox.getSelectionModel().getSelectedItem());
        donor.setBottleNumber(Integer.parseInt(brojBoceTextField.getText()));
        donor.setFatherName(imeOcaTextField.getText());
        donor.setDescription(opisTextField.getText());
        donor.setPhoneNumber(brojTelefonaTextField.getText());
        donor.setWorkPlace(mjestoRadaTextField.getText());
        donor.setRegistrationNumber(Integer.parseInt(regBrojTextField.getText()));
        donor.setDoseOfBloodTaken(Float.parseFloat(dozaUzeteKrviTextField.getText()));
        donor.setDate(Date.valueOf(datePicker.getValue()));
        donor.setDateOfBirth(Date.valueOf(birthDatePicker.getValue()));
        donor.setIdLocation(adresaChoiceBox.getSelectionModel().getSelectedItem());
        donor.setIdAcceptor(idAcceptorChoiceBox.getSelectionModel().getSelectedItem());
        FacadeFactory.get_FACADE().saveDonor(donor);
        observableListDonor.add(donor);
        clearInputs();

    }

    private void ListCountrys() {
        List<Country> countrys = FacadeFactory.get_FACADE().getAllCountrys();
        ObservableList<Country> observableCountryList = FXCollections.observableArrayList(countrys);
        adresaChoiceBox.setItems(observableCountryList);
        adresaChoiceBox.getSelectionModel().select(0);
    }
    
     private void ListAcceptor() {
        List<Acceptor> acceptors = FacadeFactory.get_FACADE().getAllAcceptors();
        ObservableList<Acceptor> observableAcceptorList = FXCollections.observableArrayList(acceptors);
        idAcceptorChoiceBox.setItems(observableAcceptorList);
        idAcceptorChoiceBox.getSelectionModel().select(0);
    }
      private void ListBloodGroup() {
        List<BloodGroup> blooodGroupe = FacadeFactory.get_FACADE().getBloodGroupe();
        ObservableList<BloodGroup> observableBloodGroupeList = FXCollections.observableArrayList(blooodGroupe);
        bloodGroupeChoiceBox.setItems(observableBloodGroupeList);
        bloodGroupeChoiceBox.getSelectionModel().select(0);
    }
    

    private void clearInputs() {
        imeOcaTextField.clear();
        prezimeTextField.clear();
        brojBoceTextField.clear();
        imeOcaTextField.clear();
        opisTextField.clear();
        mjestoRadaTextField.clear();
        brojTelefonaTextField.clear();
    }

   
}

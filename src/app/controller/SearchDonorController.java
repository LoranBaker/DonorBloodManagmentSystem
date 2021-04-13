/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller;

import app.business.FacadeFactory;
import app.model.Donor;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


/**
 * FXML Controller class
 *
 * @author loran
 */
public class SearchDonorController implements Initializable {
    @FXML
    private TableView<Donor> tvDonor;

    @FXML
    private TableColumn<Donor, Integer> collID;

    @FXML
    private TableColumn<Donor, Date> collDatum;

    @FXML
    private TableColumn<Donor, String> collPrezime;

    @FXML
    private TableColumn<Donor, String> collImeOca;

    @FXML
    private TableColumn<Donor, String> collIme;

    @FXML
    private TableColumn<Donor, String> collMjestoRada;

    @FXML
    private TableColumn<Donor, String> collKrvnaGrupa;

    @FXML
    private TableColumn<Donor, Integer> collRegBroj;

    @FXML
    private TableColumn<Donor, Date> collDatumRodjenja;

    @FXML
    private TableColumn<Donor, String> collAdresa;

    @FXML
    private TableColumn<Donor, Float> collDozaUzeteKrvi;

    @FXML
    private TableColumn<Donor, Integer> collBrojBoce;

    @FXML
    private TableColumn<Donor, String> collZakogaDajeKrv;

    @FXML
    private TableColumn<Donor, String> collBrojTelefona;
    
     @FXML
    private TextField SearchFilterField;

    @FXML
    private TableColumn<Donor, String> collOpis;
    
   private ObservableList<Donor> ObservableListDonor;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      DisplayDonors();
      SearchDonor();
       
}    
    
   void DisplayDonors(){
        try {
            ObservableListDonor = FXCollections.observableArrayList(FacadeFactory.get_FACADE().getAllDonors());
        } catch (Exception exception) {
            ObservableListDonor = FXCollections.observableArrayList();
        }
        collID.setCellValueFactory(new PropertyValueFactory<Donor, Integer>("id"));
        collDatum.setCellValueFactory(new PropertyValueFactory<Donor, Date>("date"));
        collPrezime.setCellValueFactory(new PropertyValueFactory<Donor, String>("surname"));
        collImeOca.setCellValueFactory(new PropertyValueFactory<Donor, String>("fatherName"));
        collIme.setCellValueFactory(new PropertyValueFactory<Donor, String>("name"));
        collMjestoRada.setCellValueFactory(new PropertyValueFactory<Donor, String>("workPlace"));
        collDatumRodjenja.setCellValueFactory(new PropertyValueFactory<Donor, Date>("dateOfBirth"));
        collRegBroj.setCellValueFactory(new PropertyValueFactory<Donor, Integer>("registrationNumber"));
        collDozaUzeteKrvi.setCellValueFactory(new PropertyValueFactory<Donor, Float>("doseOfBloodTaken"));
        collBrojBoce.setCellValueFactory(new PropertyValueFactory<Donor, Integer>("bottleNumber"));
        collBrojTelefona.setCellValueFactory(new PropertyValueFactory<Donor, String>("phoneNumber"));
        collOpis.setCellValueFactory(new PropertyValueFactory<Donor, String>("description"));
        collAdresa.setCellValueFactory(new PropertyValueFactory<Donor, String>("idLocation"));
        collZakogaDajeKrv.setCellValueFactory(new PropertyValueFactory<Donor, String>("idAcceptor"));
        collKrvnaGrupa.setCellValueFactory(new PropertyValueFactory<Donor, String>("idBloodGroupe"));
        
        
        tvDonor.setItems(ObservableListDonor);
        tvDonor.setEditable(true);
    }
    
    void SearchDonor(){
      // Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<Donor> filteredData = new FilteredList<>(ObservableListDonor, b -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		SearchFilterField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(donor -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
			
                        if (donor.getName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                            return true;
                        } else if (donor.getSurname().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                            return true;
                        }  else if (String.valueOf(donor.getId()).indexOf(lowerCaseFilter) != -1) {
                            return true;
                        }else if (String.valueOf(donor.getIdBloodGroupe()).indexOf(lowerCaseFilter) != -1) {
                            return true;
                        } else {
                            return false; // Does not match.
                        }
                    });
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Donor> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(tvDonor.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		tvDonor.setItems(sortedData);
    
    }
    
    
}

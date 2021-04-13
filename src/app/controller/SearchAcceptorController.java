/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller;

import app.business.FacadeFactory;

import app.model.Acceptor;

import java.net.URL;
import java.util.Date;

import java.util.ResourceBundle;

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
public class SearchAcceptorController implements Initializable {

    @FXML
    private TableView<Acceptor> tvAcceptor;

    @FXML
    private TableColumn<Acceptor, Integer> collID;

    @FXML
    private TableColumn<Acceptor, Date> collDatum;

    @FXML
    private TableColumn<Acceptor, String> collPrezime;

    @FXML
    private TableColumn<Acceptor, String> colIme;

    @FXML
    private TableColumn<Acceptor, String> colKoSaljeZaDavaoca;

    @FXML
    private TableColumn<Acceptor, String> collKrvaGrupa;

    @FXML
    private TableColumn<Acceptor, String> collRhFaktor;

    @FXML
    private TableColumn<Acceptor, String> collRhGenotip;

    @FXML
    private TableColumn<Acceptor, String> collCellI;

    @FXML
    private TableColumn<Acceptor, String> collCellII;


    @FXML
    private TableColumn<Acceptor, String> collSlana;

    @FXML
    private TableColumn<Acceptor, String> collLiss;

    @FXML
    private TableColumn<Acceptor, String> collCoombs;

    @FXML
    private TableColumn<Acceptor, String> collInterakcijaPacijenta;

    @FXML
    private TableColumn<Acceptor, String> colllPrimjedba;
    
    @FXML
    private TextField searchFilterField;
    
    
    
    private ObservableList<Acceptor> ObservableListAcceptor = FXCollections.observableArrayList();
    
   

  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      DisplayAcceptors();
      SearchAcceptor();
      
       
}    
    
    void DisplayAcceptors(){
        
         try {
            ObservableListAcceptor = FXCollections.observableArrayList(FacadeFactory.get_FACADE().getAllAcceptors());
        } catch (Exception exception) {
            ObservableListAcceptor = FXCollections.observableArrayList();
        }
        
        collID.setCellValueFactory(new PropertyValueFactory<Acceptor, Integer>("id"));
        collDatum.setCellValueFactory(new PropertyValueFactory<Acceptor, Date>("date"));
        collPrezime.setCellValueFactory(new PropertyValueFactory<Acceptor, String>("surname"));
        colIme.setCellValueFactory(new PropertyValueFactory<Acceptor, String>("name"));
        collRhFaktor.setCellValueFactory(new PropertyValueFactory<Acceptor, String>("rhFaktor"));
        collRhGenotip.setCellValueFactory(new PropertyValueFactory<Acceptor, String>("rhGenotip"));
        collInterakcijaPacijenta.setCellValueFactory(new PropertyValueFactory<Acceptor, String>("interactionBetweenSerumPatient"));
        colllPrimjedba.setCellValueFactory(new PropertyValueFactory<Acceptor, String>("description"));
        colKoSaljeZaDavaoca.setCellValueFactory(new PropertyValueFactory<Acceptor, String>("idDonor"));
        collCellI.setCellValueFactory(new PropertyValueFactory<Acceptor, String>("idICell"));
        collCellII.setCellValueFactory(new PropertyValueFactory<Acceptor, String>("idIICell"));
        collCoombs.setCellValueFactory(new PropertyValueFactory<Acceptor, String>("idCoombs"));
        collKrvaGrupa.setCellValueFactory(new PropertyValueFactory<Acceptor, String>("idbloodGroupe"));
        collLiss.setCellValueFactory(new PropertyValueFactory<Acceptor, String>("idLiss"));
        collSlana.setCellValueFactory(new PropertyValueFactory<Acceptor, String>("idSlana"));
      
        
         tvAcceptor.setItems(ObservableListAcceptor);
         tvAcceptor.setEditable(true);
    
    }
    
    void SearchAcceptor(){
  
        FilteredList<Acceptor> filteredData = new FilteredList<>(ObservableListAcceptor, b -> true);

		searchFilterField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(acceptor -> {
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
	
				String lowerCaseFilter = newValue.toLowerCase();
			
                        if (acceptor.getName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                            return true;
                        } else if (acceptor.getSurname().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                            return true;
                        }  else if (String.valueOf(acceptor.getId()).indexOf(lowerCaseFilter) != -1) {
                            return true;
                        }else if (String.valueOf(acceptor.getIdbloodGroupe()).indexOf(lowerCaseFilter) != -1) {
                            return true;
                        } else {
                            return false; 
                        }
                    });
		});
		

		SortedList<Acceptor> sortedData = new SortedList<>(filteredData);
		
		sortedData.comparatorProperty().bind(tvAcceptor.comparatorProperty());
		
		tvAcceptor.setItems(sortedData);
    
    }
    
    
   

    
}

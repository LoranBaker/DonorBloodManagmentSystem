/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author loran
 */
@Entity
@Table(name = "donor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Donor.findAll", query = "SELECT d FROM Donor d")
    , @NamedQuery(name = "Donor.findById", query = "SELECT d FROM Donor d WHERE d.id = :id")
    , @NamedQuery(name = "Donor.findByDate", query = "SELECT d FROM Donor d WHERE d.date = :date")
    , @NamedQuery(name = "Donor.findByWorkPlace", query = "SELECT d FROM Donor d WHERE d.workPlace = :workPlace")
    , @NamedQuery(name = "Donor.findByRegistrationNumber", query = "SELECT d FROM Donor d WHERE d.registrationNumber = :registrationNumber")
    , @NamedQuery(name = "Donor.findBySurname", query = "SELECT d FROM Donor d WHERE d.surname = :surname")
    , @NamedQuery(name = "Donor.findByFatherName", query = "SELECT d FROM Donor d WHERE d.fatherName = :fatherName")
    , @NamedQuery(name = "Donor.findByName", query = "SELECT d FROM Donor d WHERE d.name = :name")
    , @NamedQuery(name = "Donor.findByDateOfBirth", query = "SELECT d FROM Donor d WHERE d.dateOfBirth = :dateOfBirth")
    , @NamedQuery(name = "Donor.findByDoseOfBloodTaken", query = "SELECT d FROM Donor d WHERE d.doseOfBloodTaken = :doseOfBloodTaken")
    , @NamedQuery(name = "Donor.findByBottleNumber", query = "SELECT d FROM Donor d WHERE d.bottleNumber = :bottleNumber")
    , @NamedQuery(name = "Donor.findByIdAcceptor", query = "SELECT d FROM Donor d WHERE d.idAcceptor = :idAcceptor")
    , @NamedQuery(name = "Donor.findByDescription", query = "SELECT d FROM Donor d WHERE d.description = :description")
    , @NamedQuery(name = "Donor.findByPhoneNumber", query = "SELECT d FROM Donor d WHERE d.phoneNumber = :phoneNumber")})
public class Donor implements Serializable {

    @JoinColumn(name = "id_acceptor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Acceptor idAcceptor;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Column(name = "work_place")
    private String workPlace;
    @Basic(optional = false)
    @Column(name = "registration_number")
    private int registrationNumber;
    @Basic(optional = false)
    @Column(name = "surname")
    private String surname;
    @Basic(optional = false)
    @Column(name = "father_name")
    private String fatherName;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Basic(optional = false)
    @Column(name = "dose_of_blood_taken")
    private float doseOfBloodTaken;
    @Basic(optional = false)
    @Column(name = "bottle_number")
    private int bottleNumber;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "phone_number")
    private String phoneNumber;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Acceptor acceptor;
    @JoinColumn(name = "id_blood_groupe", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private BloodGroup idBloodGroupe;
    @JoinColumn(name = "id_location", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Country idLocation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDonor")
    private Collection<Acceptor> acceptorCollection;

    public Donor() {
    }

    public Donor(Integer id) {
        this.id = id;
    }

    public Donor(Integer id, Date date, String workPlace, int registrationNumber, String surname, String fatherName, String name, Date dateOfBirth, float doseOfBloodTaken, int bottleNumber, String description, String phoneNumber) {
        this.id = id;
        this.date = date;
        this.workPlace = workPlace;
        this.registrationNumber = registrationNumber;
        this.surname = surname;
        this.fatherName = fatherName;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.doseOfBloodTaken = doseOfBloodTaken;
        this.bottleNumber = bottleNumber;
        this.description = description;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public float getDoseOfBloodTaken() {
        return doseOfBloodTaken;
    }

    public void setDoseOfBloodTaken(float doseOfBloodTaken) {
        this.doseOfBloodTaken = doseOfBloodTaken;
    }

    public int getBottleNumber() {
        return bottleNumber;
    }

    public void setBottleNumber(int bottleNumber) {
        this.bottleNumber = bottleNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Acceptor getAcceptor() {
        return acceptor;
    }

    public void setAcceptor(Acceptor acceptor) {
        this.acceptor = acceptor;
    }

    public BloodGroup getIdBloodGroupe() {
        return idBloodGroupe;
    }

    public void setIdBloodGroupe(BloodGroup idBloodGroupe) {
        this.idBloodGroupe = idBloodGroupe;
    }

    public Country getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(Country idLocation) {
        this.idLocation = idLocation;
    }

    @XmlTransient
    public Collection<Acceptor> getAcceptorCollection() {
        return acceptorCollection;
    }

    public void setAcceptorCollection(Collection<Acceptor> acceptorCollection) {
        this.acceptorCollection = acceptorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Donor)) {
            return false;
        }
        Donor other = (Donor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  name + "[" + id + "]";
    }

    public Acceptor getIdAcceptor() {
        return idAcceptor;
    }

    public void setIdAcceptor(Acceptor idAcceptor) {
        this.idAcceptor = idAcceptor;
    }
    
    
    
}

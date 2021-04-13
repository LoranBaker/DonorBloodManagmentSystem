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
@Table(name = "acceptor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acceptor.findAll", query = "SELECT a FROM Acceptor a")
    , @NamedQuery(name = "Acceptor.findById", query = "SELECT a FROM Acceptor a WHERE a.id = :id")
    , @NamedQuery(name = "Acceptor.findByDate", query = "SELECT a FROM Acceptor a WHERE a.date = :date")
    , @NamedQuery(name = "Acceptor.findByName", query = "SELECT a FROM Acceptor a WHERE a.name = :name")
    , @NamedQuery(name = "Acceptor.findBySurname", query = "SELECT a FROM Acceptor a WHERE a.surname = :surname")
    , @NamedQuery(name = "Acceptor.findByRhFaktor", query = "SELECT a FROM Acceptor a WHERE a.rhFaktor = :rhFaktor")
    , @NamedQuery(name = "Acceptor.findByRhGenotip", query = "SELECT a FROM Acceptor a WHERE a.rhGenotip = :rhGenotip")
    , @NamedQuery(name = "Acceptor.findByInteractionBetweenSerumPatient", query = "SELECT a FROM Acceptor a WHERE a.interactionBetweenSerumPatient = :interactionBetweenSerumPatient")
    , @NamedQuery(name = "Acceptor.findByDescription", query = "SELECT a FROM Acceptor a WHERE a.description = :description")})
public class Acceptor implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAcceptor")
    private Collection<Donor> donorCollection;

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
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "surname")
    private String surname;
    @Basic(optional = false)
    @Column(name = "rh_faktor")
    private String rhFaktor;
    @Basic(optional = false)
    @Column(name = "rh_genotip")
    private String rhGenotip;
    @Basic(optional = false)
    @Column(name = "interaction_between_serum_patient")
    private String interactionBetweenSerumPatient;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "acceptor")
    private Donor donor;
    @JoinColumn(name = "id_bloodGroupe", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private BloodGroup idbloodGroupe;
    @JoinColumn(name = "id_coombs", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Coombs idCoombs;
    @JoinColumn(name = "id_donor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Donor idDonor;
    @JoinColumn(name = "id_ICell", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ICell idICell;
    @JoinColumn(name = "id_IICell", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private IiCell idIICell;
    @JoinColumn(name = "id_liss", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Liss idLiss;
    @JoinColumn(name = "id_slana", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Slana idSlana;

    public Acceptor() {
    }

    public Acceptor(Integer id) {
        this.id = id;
    }

    public Acceptor(Integer id, Date date, String name, String surname, String rhFaktor, String rhGenotip, String interactionBetweenSerumPatient, String description) {
        this.id = id;
        this.date = date;
        this.name = name;
        this.surname = surname;
        this.rhFaktor = rhFaktor;
        this.rhGenotip = rhGenotip;
        this.interactionBetweenSerumPatient = interactionBetweenSerumPatient;
        this.description = description;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRhFaktor() {
        return rhFaktor;
    }

    public void setRhFaktor(String rhFaktor) {
        this.rhFaktor = rhFaktor;
    }

    public String getRhGenotip() {
        return rhGenotip;
    }

    public void setRhGenotip(String rhGenotip) {
        this.rhGenotip = rhGenotip;
    }

    public String getInteractionBetweenSerumPatient() {
        return interactionBetweenSerumPatient;
    }

    public void setInteractionBetweenSerumPatient(String interactionBetweenSerumPatient) {
        this.interactionBetweenSerumPatient = interactionBetweenSerumPatient;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }

    public BloodGroup getIdbloodGroupe() {
        return idbloodGroupe;
    }

    public void setIdbloodGroupe(BloodGroup idbloodGroupe) {
        this.idbloodGroupe = idbloodGroupe;
    }

    public Coombs getIdCoombs() {
        return idCoombs;
    }

    public void setIdCoombs(Coombs idCoombs) {
        this.idCoombs = idCoombs;
    }

    public Donor getIdDonor() {
        return idDonor;
    }

    public void setIdDonor(Donor idDonor) {
        this.idDonor = idDonor;
    }

    public ICell getIdICell() {
        return idICell;
    }

    public void setIdICell(ICell idICell) {
        this.idICell = idICell;
    }

    public IiCell getIdIICell() {
        return idIICell;
    }

    public void setIdIICell(IiCell idIICell) {
        this.idIICell = idIICell;
    }

    public Liss getIdLiss() {
        return idLiss;
    }

    public void setIdLiss(Liss idLiss) {
        this.idLiss = idLiss;
    }

    public Slana getIdSlana() {
        return idSlana;
    }

    public void setIdSlana(Slana idSlana) {
        this.idSlana = idSlana;
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
        if (!(object instanceof Acceptor)) {
            return false;
        }
        Acceptor other = (Acceptor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name + "[" + id + "]";
    }

    @XmlTransient
    public Collection<Donor> getDonorCollection() {
        return donorCollection;
    }

    public void setDonorCollection(Collection<Donor> donorCollection) {
        this.donorCollection = donorCollection;
    }
    
}

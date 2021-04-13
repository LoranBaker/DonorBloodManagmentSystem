/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author loran
 */
@Entity
@Table(name = "coombs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Coombs.findAll", query = "SELECT c FROM Coombs c")
    , @NamedQuery(name = "Coombs.findById", query = "SELECT c FROM Coombs c WHERE c.id = :id")
    , @NamedQuery(name = "Coombs.findByName", query = "SELECT c FROM Coombs c WHERE c.name = :name")})
public class Coombs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCoombs")
    private Collection<Acceptor> acceptorCollection;

    public Coombs() {
    }

    public Coombs(Integer id) {
        this.id = id;
    }

    public Coombs(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        if (!(object instanceof Coombs)) {
            return false;
        }
        Coombs other = (Coombs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

     @Override
    public String toString() {
        return name;
    }
    
}

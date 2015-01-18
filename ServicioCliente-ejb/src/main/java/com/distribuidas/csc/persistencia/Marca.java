/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.persistencia;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Santiago
 */
@Entity
@Table(name = "marca")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Marca.findAll", query = "SELECT m FROM Marca m"),
    @NamedQuery(name = "Marca.findByIdMarca", query = "SELECT m FROM Marca m WHERE m.idMarca = :idMarca"),
    @NamedQuery(name = "Marca.findByNombreMarca", query = "SELECT m FROM Marca m WHERE m.nombreMarca = :nombreMarca"),
    @NamedQuery(name = "Marca.findByObservacionMarca", query = "SELECT m FROM Marca m WHERE m.observacionMarca = :observacionMarca"),
    @NamedQuery(name = "Marca.findByEstadoMarca", query = "SELECT m FROM Marca m WHERE m.estadoMarca = :estadoMarca")})
public class Marca implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_MARCA")
    private Integer idMarca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBRE_MARCA")
    private String nombreMarca;
    @Size(max = 60)
    @Column(name = "OBSERVACION_MARCA")
    private String observacionMarca;
    @Column(name = "ESTADO_MARCA")
    private Boolean estadoMarca;
    @OneToMany(mappedBy = "idMarca")
    private Collection<Modelo> modeloCollection;

    public Marca() {
    }

    public Marca(Integer idMarca) {
        this.idMarca = idMarca;
    }

    public Marca(Integer idMarca, String nombreMarca) {
        this.idMarca = idMarca;
        this.nombreMarca = nombreMarca;
    }

    public Integer getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Integer idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public String getObservacionMarca() {
        return observacionMarca;
    }

    public void setObservacionMarca(String observacionMarca) {
        this.observacionMarca = observacionMarca;
    }

    public Boolean getEstadoMarca() {
        return estadoMarca;
    }

    public void setEstadoMarca(Boolean estadoMarca) {
        this.estadoMarca = estadoMarca;
    }

    @XmlTransient
    public Collection<Modelo> getModeloCollection() {
        return modeloCollection;
    }

    public void setModeloCollection(Collection<Modelo> modeloCollection) {
        this.modeloCollection = modeloCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMarca != null ? idMarca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Marca)) {
            return false;
        }
        Marca other = (Marca) object;
        if ((this.idMarca == null && other.idMarca != null) || (this.idMarca != null && !this.idMarca.equals(other.idMarca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.distribuidas.csc.persistencia.Marca[ idMarca=" + idMarca + " ]";
    }
    
}

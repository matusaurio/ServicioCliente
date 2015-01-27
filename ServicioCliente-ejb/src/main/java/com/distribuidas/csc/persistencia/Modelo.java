/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Stephen
 */
@Entity
@Table(name = "modelo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modelo.findAll", query = "SELECT m FROM Modelo m"),
    @NamedQuery(name = "Modelo.findByIdModelo", query = "SELECT m FROM Modelo m WHERE m.idModelo = :idModelo"),
    @NamedQuery(name = "Modelo.findByNombreModelo", query = "SELECT m FROM Modelo m WHERE m.nombreModelo = :nombreModelo"),
    @NamedQuery(name = "Modelo.findByObservacionModelo", query = "SELECT m FROM Modelo m WHERE m.observacionModelo = :observacionModelo"),
    @NamedQuery(name = "Modelo.findByEstadoModelo", query = "SELECT m FROM Modelo m WHERE m.estadoModelo = :estadoModelo")})
public class Modelo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_MODELO")
    private Integer idModelo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBRE_MODELO")
    private String nombreModelo;
    @Size(max = 60)
    @Column(name = "OBSERVACION_MODELO")
    private String observacionModelo;
    @Column(name = "ESTADO_MODELO")
    private Boolean estadoModelo;
    @OneToMany(mappedBy = "idModelo")
    private List<Producto> productoList;
    @JoinColumn(name = "ID_MARCA", referencedColumnName = "ID_MARCA")
    @ManyToOne
    private Marca idMarca;

    public Modelo() {
    }

    public Modelo(Integer idModelo) {
        this.idModelo = idModelo;
    }

    public Modelo(Integer idModelo, String nombreModelo) {
        this.idModelo = idModelo;
        this.nombreModelo = nombreModelo;
    }

    public Integer getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Integer idModelo) {
        this.idModelo = idModelo;
    }

    public String getNombreModelo() {
        return nombreModelo;
    }

    public void setNombreModelo(String nombreModelo) {
        this.nombreModelo = nombreModelo;
    }

    public String getObservacionModelo() {
        return observacionModelo;
    }

    public void setObservacionModelo(String observacionModelo) {
        this.observacionModelo = observacionModelo;
    }

    public Boolean getEstadoModelo() {
        return estadoModelo;
    }

    public void setEstadoModelo(Boolean estadoModelo) {
        this.estadoModelo = estadoModelo;
    }

    @XmlTransient
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    public Marca getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Marca idMarca) {
        this.idMarca = idMarca;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idModelo != null ? idModelo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modelo)) {
            return false;
        }
        Modelo other = (Modelo) object;
        if ((this.idModelo == null && other.idModelo != null) || (this.idModelo != null && !this.idModelo.equals(other.idModelo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idModelo.toString();
    }
    
}

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
@Table(name = "empresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e"),
    @NamedQuery(name = "Empresa.findByIdEmpresa", query = "SELECT e FROM Empresa e WHERE e.idEmpresa = :idEmpresa"),
    @NamedQuery(name = "Empresa.findByNombreEmpresa", query = "SELECT e FROM Empresa e WHERE e.nombreEmpresa = :nombreEmpresa")})
public class Empresa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_EMPRESA")
    private Integer idEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBRE_EMPRESA")
    private String nombreEmpresa;
    @OneToMany(mappedBy = "idEmpresa")
    private List<Sucursal> sucursalList;
    @OneToMany(mappedBy = "idEmpresa")
    private List<SolicitudServicio> solicitudServicioList;
    @OneToMany(mappedBy = "idEmpresa")
    private List<Contacto> contactoList;
    @OneToMany(mappedBy = "idEmpresa")
    private List<ParteServicio> parteServicioList;
    @JoinColumn(name = "ID_CIUDAD", referencedColumnName = "ID_CIUDAD")
    @ManyToOne
    private Ciudad idCiudad;

    public Empresa() {
    }

    public Empresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Empresa(Integer idEmpresa, String nombreEmpresa) {
        this.idEmpresa = idEmpresa;
        this.nombreEmpresa = nombreEmpresa;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    @XmlTransient
    public List<Sucursal> getSucursalList() {
        return sucursalList;
    }

    public void setSucursalList(List<Sucursal> sucursalList) {
        this.sucursalList = sucursalList;
    }

    @XmlTransient
    public List<SolicitudServicio> getSolicitudServicioList() {
        return solicitudServicioList;
    }

    public void setSolicitudServicioList(List<SolicitudServicio> solicitudServicioList) {
        this.solicitudServicioList = solicitudServicioList;
    }

    @XmlTransient
    public List<Contacto> getContactoList() {
        return contactoList;
    }

    public void setContactoList(List<Contacto> contactoList) {
        this.contactoList = contactoList;
    }

    @XmlTransient
    public List<ParteServicio> getParteServicioList() {
        return parteServicioList;
    }

    public void setParteServicioList(List<ParteServicio> parteServicioList) {
        this.parteServicioList = parteServicioList;
    }

    public Ciudad getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Ciudad idCiudad) {
        this.idCiudad = idCiudad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpresa != null ? idEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.idEmpresa == null && other.idEmpresa != null) || (this.idEmpresa != null && !this.idEmpresa.equals(other.idEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idEmpresa.toString();
    }
    
}

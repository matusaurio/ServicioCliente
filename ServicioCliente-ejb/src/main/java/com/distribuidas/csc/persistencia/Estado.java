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
@Table(name = "estado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estado.findAll", query = "SELECT e FROM Estado e"),
    @NamedQuery(name = "Estado.findByIdEstadoSolicitudservicio", query = "SELECT e FROM Estado e WHERE e.idEstadoSolicitudservicio = :idEstadoSolicitudservicio"),
    @NamedQuery(name = "Estado.findByNombreEstadoSolicitudservicio", query = "SELECT e FROM Estado e WHERE e.nombreEstadoSolicitudservicio = :nombreEstadoSolicitudservicio")})
public class Estado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ESTADO_SOLICITUDSERVICIO")
    private Integer idEstadoSolicitudservicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBRE_ESTADO_SOLICITUDSERVICIO")
    private String nombreEstadoSolicitudservicio;
    @OneToMany(mappedBy = "idEstadoSolicitudservicio")
    private List<SolicitudServicio> solicitudServicioList;

    public Estado() {
    }

    public Estado(Integer idEstadoSolicitudservicio) {
        this.idEstadoSolicitudservicio = idEstadoSolicitudservicio;
    }

    public Estado(Integer idEstadoSolicitudservicio, String nombreEstadoSolicitudservicio) {
        this.idEstadoSolicitudservicio = idEstadoSolicitudservicio;
        this.nombreEstadoSolicitudservicio = nombreEstadoSolicitudservicio;
    }

    public Integer getIdEstadoSolicitudservicio() {
        return idEstadoSolicitudservicio;
    }

    public void setIdEstadoSolicitudservicio(Integer idEstadoSolicitudservicio) {
        this.idEstadoSolicitudservicio = idEstadoSolicitudservicio;
    }

    public String getNombreEstadoSolicitudservicio() {
        return nombreEstadoSolicitudservicio;
    }

    public void setNombreEstadoSolicitudservicio(String nombreEstadoSolicitudservicio) {
        this.nombreEstadoSolicitudservicio = nombreEstadoSolicitudservicio;
    }

    @XmlTransient
    public List<SolicitudServicio> getSolicitudServicioList() {
        return solicitudServicioList;
    }

    public void setSolicitudServicioList(List<SolicitudServicio> solicitudServicioList) {
        this.solicitudServicioList = solicitudServicioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoSolicitudservicio != null ? idEstadoSolicitudservicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estado)) {
            return false;
        }
        Estado other = (Estado) object;
        if ((this.idEstadoSolicitudservicio == null && other.idEstadoSolicitudservicio != null) || (this.idEstadoSolicitudservicio != null && !this.idEstadoSolicitudservicio.equals(other.idEstadoSolicitudservicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idEstadoSolicitudservicio.toString();
    }
    
}

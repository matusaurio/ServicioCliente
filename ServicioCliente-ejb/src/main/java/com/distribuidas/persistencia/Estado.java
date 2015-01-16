/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.persistencia;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sbenalcazar
 */
@Entity
@Table(name = "estado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estado.findAll", query = "SELECT e FROM Estado e"),
    @NamedQuery(name = "Estado.findByIdEstadoSolicitudservicio", query = "SELECT e FROM Estado e WHERE e.idEstadoSolicitudservicio = :idEstadoSolicitudservicio"),
    @NamedQuery(name = "Estado.findByNombreEstadoSolicitudservicio", query = "SELECT e FROM Estado e WHERE e.nombreEstadoSolicitudservicio = :nombreEstadoSolicitudservicio"),
    @NamedQuery(name = "Estado.findByFechaEstadoSolicitudservicio", query = "SELECT e FROM Estado e WHERE e.fechaEstadoSolicitudservicio = :fechaEstadoSolicitudservicio")})
public class Estado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ESTADO_SOLICITUDSERVICIO")
    private Integer idEstadoSolicitudservicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBRE_ESTADO_SOLICITUDSERVICIO")
    private String nombreEstadoSolicitudservicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_ESTADO_SOLICITUDSERVICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEstadoSolicitudservicio;
    @OneToMany(mappedBy = "idEstadoSolicitudservicio")
    private List<SolicitudServicio> solicitudServicioList;

    public Estado() {
    }

    public Estado(Integer idEstadoSolicitudservicio) {
        this.idEstadoSolicitudservicio = idEstadoSolicitudservicio;
    }

    public Estado(Integer idEstadoSolicitudservicio, String nombreEstadoSolicitudservicio, Date fechaEstadoSolicitudservicio) {
        this.idEstadoSolicitudservicio = idEstadoSolicitudservicio;
        this.nombreEstadoSolicitudservicio = nombreEstadoSolicitudservicio;
        this.fechaEstadoSolicitudservicio = fechaEstadoSolicitudservicio;
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

    public Date getFechaEstadoSolicitudservicio() {
        return fechaEstadoSolicitudservicio;
    }

    public void setFechaEstadoSolicitudservicio(Date fechaEstadoSolicitudservicio) {
        this.fechaEstadoSolicitudservicio = fechaEstadoSolicitudservicio;
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
        return "com.distribuidas.persistencia.Estado[ idEstadoSolicitudservicio=" + idEstadoSolicitudservicio + " ]";
    }
    
}

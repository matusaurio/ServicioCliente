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
@Table(name = "tipo_servicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoServicio.findAll", query = "SELECT t FROM TipoServicio t"),
    @NamedQuery(name = "TipoServicio.findByIdTipoServicioSolicitudservicio", query = "SELECT t FROM TipoServicio t WHERE t.idTipoServicioSolicitudservicio = :idTipoServicioSolicitudservicio"),
    @NamedQuery(name = "TipoServicio.findByNombreTipoServicioSolicitudservicio", query = "SELECT t FROM TipoServicio t WHERE t.nombreTipoServicioSolicitudservicio = :nombreTipoServicioSolicitudservicio"),
    @NamedQuery(name = "TipoServicio.findByObservacionTipoServicioSolicitudservicio", query = "SELECT t FROM TipoServicio t WHERE t.observacionTipoServicioSolicitudservicio = :observacionTipoServicioSolicitudservicio")})
public class TipoServicio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TIPO_SERVICIO_SOLICITUDSERVICIO")
    private Integer idTipoServicioSolicitudservicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBRE_TIPO_SERVICIO_SOLICITUDSERVICIO")
    private String nombreTipoServicioSolicitudservicio;
    @Size(max = 120)
    @Column(name = "OBSERVACION_TIPO_SERVICIO_SOLICITUDSERVICIO")
    private String observacionTipoServicioSolicitudservicio;
    @OneToMany(mappedBy = "idTipoServicioSolicitudservicio")
    private List<SolicitudServicio> solicitudServicioList;

    public TipoServicio() {
    }

    public TipoServicio(Integer idTipoServicioSolicitudservicio) {
        this.idTipoServicioSolicitudservicio = idTipoServicioSolicitudservicio;
    }

    public TipoServicio(Integer idTipoServicioSolicitudservicio, String nombreTipoServicioSolicitudservicio) {
        this.idTipoServicioSolicitudservicio = idTipoServicioSolicitudservicio;
        this.nombreTipoServicioSolicitudservicio = nombreTipoServicioSolicitudservicio;
    }

    public Integer getIdTipoServicioSolicitudservicio() {
        return idTipoServicioSolicitudservicio;
    }

    public void setIdTipoServicioSolicitudservicio(Integer idTipoServicioSolicitudservicio) {
        this.idTipoServicioSolicitudservicio = idTipoServicioSolicitudservicio;
    }

    public String getNombreTipoServicioSolicitudservicio() {
        return nombreTipoServicioSolicitudservicio;
    }

    public void setNombreTipoServicioSolicitudservicio(String nombreTipoServicioSolicitudservicio) {
        this.nombreTipoServicioSolicitudservicio = nombreTipoServicioSolicitudservicio;
    }

    public String getObservacionTipoServicioSolicitudservicio() {
        return observacionTipoServicioSolicitudservicio;
    }

    public void setObservacionTipoServicioSolicitudservicio(String observacionTipoServicioSolicitudservicio) {
        this.observacionTipoServicioSolicitudservicio = observacionTipoServicioSolicitudservicio;
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
        hash += (idTipoServicioSolicitudservicio != null ? idTipoServicioSolicitudservicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoServicio)) {
            return false;
        }
        TipoServicio other = (TipoServicio) object;
        if ((this.idTipoServicioSolicitudservicio == null && other.idTipoServicioSolicitudservicio != null) || (this.idTipoServicioSolicitudservicio != null && !this.idTipoServicioSolicitudservicio.equals(other.idTipoServicioSolicitudservicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idTipoServicioSolicitudservicio.toString();
    }
    
}

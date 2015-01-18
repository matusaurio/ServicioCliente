/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.persistencia;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Santiago
 */
@Entity
@Table(name = "detalle_solicitud_servicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleSolicitudServicio.findAll", query = "SELECT d FROM DetalleSolicitudServicio d"),
    @NamedQuery(name = "DetalleSolicitudServicio.findByIdDetalleSolicitudservicio", query = "SELECT d FROM DetalleSolicitudServicio d WHERE d.idDetalleSolicitudservicio = :idDetalleSolicitudservicio"),
    @NamedQuery(name = "DetalleSolicitudServicio.findByNombreDetalleSolicitudservicio", query = "SELECT d FROM DetalleSolicitudServicio d WHERE d.nombreDetalleSolicitudservicio = :nombreDetalleSolicitudservicio"),
    @NamedQuery(name = "DetalleSolicitudServicio.findByRutaDetalleSolicitudservicio", query = "SELECT d FROM DetalleSolicitudServicio d WHERE d.rutaDetalleSolicitudservicio = :rutaDetalleSolicitudservicio")})
public class DetalleSolicitudServicio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_DETALLE_SOLICITUDSERVICIO")
    private Integer idDetalleSolicitudservicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBRE_DETALLE_SOLICITUDSERVICIO")
    private String nombreDetalleSolicitudservicio;
    @Size(max = 1024)
    @Column(name = "RUTA_DETALLE_SOLICITUDSERVICIO")
    private String rutaDetalleSolicitudservicio;
    @JoinColumn(name = "ID_SOLICITUDSERVICIO", referencedColumnName = "ID_SOLICITUDSERVICIO")
    @ManyToOne
    private SolicitudServicio idSolicitudservicio;

    public DetalleSolicitudServicio() {
    }

    public DetalleSolicitudServicio(Integer idDetalleSolicitudservicio) {
        this.idDetalleSolicitudservicio = idDetalleSolicitudservicio;
    }

    public DetalleSolicitudServicio(Integer idDetalleSolicitudservicio, String nombreDetalleSolicitudservicio) {
        this.idDetalleSolicitudservicio = idDetalleSolicitudservicio;
        this.nombreDetalleSolicitudservicio = nombreDetalleSolicitudservicio;
    }

    public Integer getIdDetalleSolicitudservicio() {
        return idDetalleSolicitudservicio;
    }

    public void setIdDetalleSolicitudservicio(Integer idDetalleSolicitudservicio) {
        this.idDetalleSolicitudservicio = idDetalleSolicitudservicio;
    }

    public String getNombreDetalleSolicitudservicio() {
        return nombreDetalleSolicitudservicio;
    }

    public void setNombreDetalleSolicitudservicio(String nombreDetalleSolicitudservicio) {
        this.nombreDetalleSolicitudservicio = nombreDetalleSolicitudservicio;
    }

    public String getRutaDetalleSolicitudservicio() {
        return rutaDetalleSolicitudservicio;
    }

    public void setRutaDetalleSolicitudservicio(String rutaDetalleSolicitudservicio) {
        this.rutaDetalleSolicitudservicio = rutaDetalleSolicitudservicio;
    }

    public SolicitudServicio getIdSolicitudservicio() {
        return idSolicitudservicio;
    }

    public void setIdSolicitudservicio(SolicitudServicio idSolicitudservicio) {
        this.idSolicitudservicio = idSolicitudservicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleSolicitudservicio != null ? idDetalleSolicitudservicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleSolicitudServicio)) {
            return false;
        }
        DetalleSolicitudServicio other = (DetalleSolicitudServicio) object;
        if ((this.idDetalleSolicitudservicio == null && other.idDetalleSolicitudservicio != null) || (this.idDetalleSolicitudservicio != null && !this.idDetalleSolicitudservicio.equals(other.idDetalleSolicitudservicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.distribuidas.csc.persistencia.DetalleSolicitudServicio[ idDetalleSolicitudservicio=" + idDetalleSolicitudservicio + " ]";
    }
    
}

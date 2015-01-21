/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.persistencia;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Stephen
 */
@Entity
@Table(name = "solicitud_servicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SolicitudServicio.findAll", query = "SELECT s FROM SolicitudServicio s"),
    @NamedQuery(name = "SolicitudServicio.findByIdSolicitudservicio", query = "SELECT s FROM SolicitudServicio s WHERE s.idSolicitudservicio = :idSolicitudservicio"),
    @NamedQuery(name = "SolicitudServicio.findByCodigoSolicitudservicio", query = "SELECT s FROM SolicitudServicio s WHERE s.codigoSolicitudservicio = :codigoSolicitudservicio"),
    @NamedQuery(name = "SolicitudServicio.findByInconvenienteSolicitudservicio", query = "SELECT s FROM SolicitudServicio s WHERE s.inconvenienteSolicitudservicio = :inconvenienteSolicitudservicio"),
    @NamedQuery(name = "SolicitudServicio.findByObservacionSolicitudservicio", query = "SELECT s FROM SolicitudServicio s WHERE s.observacionSolicitudservicio = :observacionSolicitudservicio"),
    @NamedQuery(name = "SolicitudServicio.findByFechaCreacionSolicitudservicio", query = "SELECT s FROM SolicitudServicio s WHERE s.fechaCreacionSolicitudservicio = :fechaCreacionSolicitudservicio"),
    @NamedQuery(name = "SolicitudServicio.findByFechaAtencionSolicitudservicio", query = "SELECT s FROM SolicitudServicio s WHERE s.fechaAtencionSolicitudservicio = :fechaAtencionSolicitudservicio"),
    @NamedQuery(name = "SolicitudServicio.findByEstadoSolicitudservicio", query = "SELECT s FROM SolicitudServicio s WHERE s.estadoSolicitudservicio = :estadoSolicitudservicio")})
public class SolicitudServicio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_SOLICITUDSERVICIO")
    private Integer idSolicitudservicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "CODIGO_SOLICITUDSERVICIO")
    private String codigoSolicitudservicio;
    @Size(max = 120)
    @Column(name = "INCONVENIENTE_SOLICITUDSERVICIO")
    private String inconvenienteSolicitudservicio;
    @Size(max = 120)
    @Column(name = "OBSERVACION_SOLICITUDSERVICIO")
    private String observacionSolicitudservicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_CREACION_SOLICITUDSERVICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacionSolicitudservicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_ATENCION_SOLICITUDSERVICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAtencionSolicitudservicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO_SOLICITUDSERVICIO")
    private boolean estadoSolicitudservicio;
    @OneToMany(mappedBy = "idSolicitudservicio")
    private List<DetalleSolicitudServicio> detalleSolicitudServicioList;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario idUsuario;
    @JoinColumn(name = "ID_ESTADO_SOLICITUDSERVICIO", referencedColumnName = "ID_ESTADO_SOLICITUDSERVICIO")
    @ManyToOne
    private Estado idEstadoSolicitudservicio;
    @JoinColumn(name = "ID_TIPO_SERVICIO_SOLICITUDSERVICIO", referencedColumnName = "ID_TIPO_SERVICIO_SOLICITUDSERVICIO")
    @ManyToOne
    private TipoServicio idTipoServicioSolicitudservicio;
    @JoinColumn(name = "ID_PARTESERVICIO", referencedColumnName = "ID_PARTESERVICIO")
    @ManyToOne
    private ParteServicio idParteservicio;
    @OneToMany(mappedBy = "idSolicitudservicio")
    private List<ParteServicio> parteServicioList;

    public SolicitudServicio() {
    }

    public SolicitudServicio(Integer idSolicitudservicio) {
        this.idSolicitudservicio = idSolicitudservicio;
    }

    public SolicitudServicio(Integer idSolicitudservicio, String codigoSolicitudservicio, Date fechaCreacionSolicitudservicio, Date fechaAtencionSolicitudservicio, boolean estadoSolicitudservicio) {
        this.idSolicitudservicio = idSolicitudservicio;
        this.codigoSolicitudservicio = codigoSolicitudservicio;
        this.fechaCreacionSolicitudservicio = fechaCreacionSolicitudservicio;
        this.fechaAtencionSolicitudservicio = fechaAtencionSolicitudservicio;
        this.estadoSolicitudservicio = estadoSolicitudservicio;
    }

    public Integer getIdSolicitudservicio() {
        return idSolicitudservicio;
    }

    public void setIdSolicitudservicio(Integer idSolicitudservicio) {
        this.idSolicitudservicio = idSolicitudservicio;
    }

    public String getCodigoSolicitudservicio() {
        return codigoSolicitudservicio;
    }

    public void setCodigoSolicitudservicio(String codigoSolicitudservicio) {
        this.codigoSolicitudservicio = codigoSolicitudservicio;
    }

    public String getInconvenienteSolicitudservicio() {
        return inconvenienteSolicitudservicio;
    }

    public void setInconvenienteSolicitudservicio(String inconvenienteSolicitudservicio) {
        this.inconvenienteSolicitudservicio = inconvenienteSolicitudservicio;
    }

    public String getObservacionSolicitudservicio() {
        return observacionSolicitudservicio;
    }

    public void setObservacionSolicitudservicio(String observacionSolicitudservicio) {
        this.observacionSolicitudservicio = observacionSolicitudservicio;
    }

    public Date getFechaCreacionSolicitudservicio() {
        return fechaCreacionSolicitudservicio;
    }

    public void setFechaCreacionSolicitudservicio(Date fechaCreacionSolicitudservicio) {
        this.fechaCreacionSolicitudservicio = fechaCreacionSolicitudservicio;
    }

    public Date getFechaAtencionSolicitudservicio() {
        return fechaAtencionSolicitudservicio;
    }

    public void setFechaAtencionSolicitudservicio(Date fechaAtencionSolicitudservicio) {
        this.fechaAtencionSolicitudservicio = fechaAtencionSolicitudservicio;
    }

    public boolean getEstadoSolicitudservicio() {
        return estadoSolicitudservicio;
    }

    public void setEstadoSolicitudservicio(boolean estadoSolicitudservicio) {
        this.estadoSolicitudservicio = estadoSolicitudservicio;
    }

    @XmlTransient
    public List<DetalleSolicitudServicio> getDetalleSolicitudServicioList() {
        return detalleSolicitudServicioList;
    }

    public void setDetalleSolicitudServicioList(List<DetalleSolicitudServicio> detalleSolicitudServicioList) {
        this.detalleSolicitudServicioList = detalleSolicitudServicioList;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Estado getIdEstadoSolicitudservicio() {
        return idEstadoSolicitudservicio;
    }

    public void setIdEstadoSolicitudservicio(Estado idEstadoSolicitudservicio) {
        this.idEstadoSolicitudservicio = idEstadoSolicitudservicio;
    }

    public TipoServicio getIdTipoServicioSolicitudservicio() {
        return idTipoServicioSolicitudservicio;
    }

    public void setIdTipoServicioSolicitudservicio(TipoServicio idTipoServicioSolicitudservicio) {
        this.idTipoServicioSolicitudservicio = idTipoServicioSolicitudservicio;
    }

    public ParteServicio getIdParteservicio() {
        return idParteservicio;
    }

    public void setIdParteservicio(ParteServicio idParteservicio) {
        this.idParteservicio = idParteservicio;
    }

    @XmlTransient
    public List<ParteServicio> getParteServicioList() {
        return parteServicioList;
    }

    public void setParteServicioList(List<ParteServicio> parteServicioList) {
        this.parteServicioList = parteServicioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSolicitudservicio != null ? idSolicitudservicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolicitudServicio)) {
            return false;
        }
        SolicitudServicio other = (SolicitudServicio) object;
        if ((this.idSolicitudservicio == null && other.idSolicitudservicio != null) || (this.idSolicitudservicio != null && !this.idSolicitudservicio.equals(other.idSolicitudservicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.distribuidas.csc.persistencia.SolicitudServicio[ idSolicitudservicio=" + idSolicitudservicio + " ]";
    }
    
}

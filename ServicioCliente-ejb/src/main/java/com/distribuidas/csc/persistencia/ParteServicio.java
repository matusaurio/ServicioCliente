/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.persistencia;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "parte_servicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParteServicio.findAll", query = "SELECT p FROM ParteServicio p"),
    @NamedQuery(name = "ParteServicio.findByIdParteservicio", query = "SELECT p FROM ParteServicio p WHERE p.idParteservicio = :idParteservicio"),
    @NamedQuery(name = "ParteServicio.findByFechaInicioParteservicio", query = "SELECT p FROM ParteServicio p WHERE p.fechaInicioParteservicio = :fechaInicioParteservicio"),
    @NamedQuery(name = "ParteServicio.findByFechaFinParteservicio", query = "SELECT p FROM ParteServicio p WHERE p.fechaFinParteservicio = :fechaFinParteservicio"),
    @NamedQuery(name = "ParteServicio.findByTotalHorasParteservicio", query = "SELECT p FROM ParteServicio p WHERE p.totalHorasParteservicio = :totalHorasParteservicio"),
    @NamedQuery(name = "ParteServicio.findByEstadoParteservicio", query = "SELECT p FROM ParteServicio p WHERE p.estadoParteservicio = :estadoParteservicio"),
    @NamedQuery(name = "ParteServicio.findByFirmaParteservicio", query = "SELECT p FROM ParteServicio p WHERE p.firmaParteservicio = :firmaParteservicio"),
    @NamedQuery(name = "ParteServicio.findByFechaFirmaParteservicio", query = "SELECT p FROM ParteServicio p WHERE p.fechaFirmaParteservicio = :fechaFirmaParteservicio"),
    @NamedQuery(name = "ParteServicio.findBySugerenciaParteservicio", query = "SELECT p FROM ParteServicio p WHERE p.sugerenciaParteservicio = :sugerenciaParteservicio"),
    @NamedQuery(name = "ParteServicio.findByObservacionParteservicio", query = "SELECT p FROM ParteServicio p WHERE p.observacionParteservicio = :observacionParteservicio")})
public class ParteServicio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PARTESERVICIO")
    private Integer idParteservicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_INICIO_PARTESERVICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicioParteservicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_FIN_PARTESERVICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinParteservicio;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTAL_HORAS_PARTESERVICIO")
    private BigDecimal totalHorasParteservicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO_PARTESERVICIO")
    private boolean estadoParteservicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FIRMA_PARTESERVICIO")
    private boolean firmaParteservicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_FIRMA_PARTESERVICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFirmaParteservicio;
    @Size(max = 120)
    @Column(name = "SUGERENCIA_PARTESERVICIO")
    private String sugerenciaParteservicio;
    @Size(max = 120)
    @Column(name = "OBSERVACION_PARTESERVICIO")
    private String observacionParteservicio;
    @JoinTable(name = "parteservicio_marcaverificacion", joinColumns = {
        @JoinColumn(name = "ID_PARTESERVICIO", referencedColumnName = "ID_PARTESERVICIO")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_MARCAVERIFICACION", referencedColumnName = "ID_MARCAVERIFICACION")})
    @ManyToMany
    private List<MarcaVerificacion> marcaVerificacionList;
    @OneToMany(mappedBy = "idParteservicio")
    private List<HorarioServicio> horarioServicioList;
    @OneToMany(mappedBy = "idParteservicio")
    private List<DetalleParteServicio> detalleParteServicioList;
    @OneToMany(mappedBy = "idParteservicio")
    private List<SolicitudServicio> solicitudServicioList;
    @JoinColumn(name = "ID_SOLICITUDSERVICIO", referencedColumnName = "ID_SOLICITUDSERVICIO")
    @ManyToOne
    private SolicitudServicio idSolicitudservicio;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario idUsuario;

    public ParteServicio() {
    }

    public ParteServicio(Integer idParteservicio) {
        this.idParteservicio = idParteservicio;
    }

    public ParteServicio(Integer idParteservicio, Date fechaInicioParteservicio, Date fechaFinParteservicio, BigDecimal totalHorasParteservicio, boolean estadoParteservicio, boolean firmaParteservicio, Date fechaFirmaParteservicio) {
        this.idParteservicio = idParteservicio;
        this.fechaInicioParteservicio = fechaInicioParteservicio;
        this.fechaFinParteservicio = fechaFinParteservicio;
        this.totalHorasParteservicio = totalHorasParteservicio;
        this.estadoParteservicio = estadoParteservicio;
        this.firmaParteservicio = firmaParteservicio;
        this.fechaFirmaParteservicio = fechaFirmaParteservicio;
    }

    public Integer getIdParteservicio() {
        return idParteservicio;
    }

    public void setIdParteservicio(Integer idParteservicio) {
        this.idParteservicio = idParteservicio;
    }

    public Date getFechaInicioParteservicio() {
        return fechaInicioParteservicio;
    }

    public void setFechaInicioParteservicio(Date fechaInicioParteservicio) {
        this.fechaInicioParteservicio = fechaInicioParteservicio;
    }

    public Date getFechaFinParteservicio() {
        return fechaFinParteservicio;
    }

    public void setFechaFinParteservicio(Date fechaFinParteservicio) {
        this.fechaFinParteservicio = fechaFinParteservicio;
    }

    public BigDecimal getTotalHorasParteservicio() {
        return totalHorasParteservicio;
    }

    public void setTotalHorasParteservicio(BigDecimal totalHorasParteservicio) {
        this.totalHorasParteservicio = totalHorasParteservicio;
    }

    public boolean getEstadoParteservicio() {
        return estadoParteservicio;
    }

    public void setEstadoParteservicio(boolean estadoParteservicio) {
        this.estadoParteservicio = estadoParteservicio;
    }

    public boolean getFirmaParteservicio() {
        return firmaParteservicio;
    }

    public void setFirmaParteservicio(boolean firmaParteservicio) {
        this.firmaParteservicio = firmaParteservicio;
    }

    public Date getFechaFirmaParteservicio() {
        return fechaFirmaParteservicio;
    }

    public void setFechaFirmaParteservicio(Date fechaFirmaParteservicio) {
        this.fechaFirmaParteservicio = fechaFirmaParteservicio;
    }

    public String getSugerenciaParteservicio() {
        return sugerenciaParteservicio;
    }

    public void setSugerenciaParteservicio(String sugerenciaParteservicio) {
        this.sugerenciaParteservicio = sugerenciaParteservicio;
    }

    public String getObservacionParteservicio() {
        return observacionParteservicio;
    }

    public void setObservacionParteservicio(String observacionParteservicio) {
        this.observacionParteservicio = observacionParteservicio;
    }

    @XmlTransient
    public List<MarcaVerificacion> getMarcaVerificacionList() {
        return marcaVerificacionList;
    }

    public void setMarcaVerificacionList(List<MarcaVerificacion> marcaVerificacionList) {
        this.marcaVerificacionList = marcaVerificacionList;
    }

    @XmlTransient
    public List<HorarioServicio> getHorarioServicioList() {
        return horarioServicioList;
    }

    public void setHorarioServicioList(List<HorarioServicio> horarioServicioList) {
        this.horarioServicioList = horarioServicioList;
    }

    @XmlTransient
    public List<DetalleParteServicio> getDetalleParteServicioList() {
        return detalleParteServicioList;
    }

    public void setDetalleParteServicioList(List<DetalleParteServicio> detalleParteServicioList) {
        this.detalleParteServicioList = detalleParteServicioList;
    }

    @XmlTransient
    public List<SolicitudServicio> getSolicitudServicioList() {
        return solicitudServicioList;
    }

    public void setSolicitudServicioList(List<SolicitudServicio> solicitudServicioList) {
        this.solicitudServicioList = solicitudServicioList;
    }

    public SolicitudServicio getIdSolicitudservicio() {
        return idSolicitudservicio;
    }

    public void setIdSolicitudservicio(SolicitudServicio idSolicitudservicio) {
        this.idSolicitudservicio = idSolicitudservicio;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idParteservicio != null ? idParteservicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParteServicio)) {
            return false;
        }
        ParteServicio other = (ParteServicio) object;
        if ((this.idParteservicio == null && other.idParteservicio != null) || (this.idParteservicio != null && !this.idParteservicio.equals(other.idParteservicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idParteservicio.toString();
    }
    
}

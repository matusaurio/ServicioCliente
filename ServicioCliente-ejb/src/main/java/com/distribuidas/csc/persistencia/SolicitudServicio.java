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
    @Size(min = 1, max = 120)
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
    @Column(name = "FECHA_ATENCION_SOLICITUDSERVICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAtencionSolicitudservicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO_SOLICITUDSERVICIO")
    private boolean estadoSolicitudservicio;
    @OneToMany(mappedBy = "idSolicitudservicio")
    private List<DetalleSolicitudServicio> detalleSolicitudServicioList;
    @JoinColumn(name = "ID_TIPO_SERVICIO_SOLICITUDSERVICIO", referencedColumnName = "ID_TIPO_SERVICIO_SOLICITUDSERVICIO")
    @ManyToOne
    private TipoServicio idTipoServicioSolicitudservicio;
    @JoinColumn(name = "ID_TECNICO", referencedColumnName = "ID_TECNICO")
    @ManyToOne
    private Tecnico idTecnico;
    @JoinColumn(name = "ID_SUCURSAL", referencedColumnName = "ID_SUCURSAL")
    @ManyToOne
    private Sucursal idSucursal;
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")
    @ManyToOne
    private Producto idProducto;
    @JoinColumn(name = "ID_MODELO", referencedColumnName = "ID_MODELO")
    @ManyToOne
    private Modelo idModelo;
    @JoinColumn(name = "ID_MARCA", referencedColumnName = "ID_MARCA")
    @ManyToOne
    private Marca idMarca;
    @JoinColumn(name = "ID_ESTADO_SOLICITUDSERVICIO", referencedColumnName = "ID_ESTADO_SOLICITUDSERVICIO")
    @ManyToOne
    private Estado idEstadoSolicitudservicio;
    @JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID_EMPRESA")
    @ManyToOne
    private Empresa idEmpresa;
    @JoinColumn(name = "ID_CONTACTO", referencedColumnName = "ID_CONTACTO")
    @ManyToOne
    private Contacto idContacto;
    @JoinColumn(name = "ID_CIUDAD", referencedColumnName = "ID_CIUDAD")
    @ManyToOne
    private Ciudad idCiudad;
    @JoinColumn(name = "ID_BODEGA", referencedColumnName = "ID_BODEGA")
    @ManyToOne
    private Bodega idBodega;
    @OneToMany(mappedBy = "idSolicitudservicio")
    private List<ParteServicio> parteServicioList;

    public SolicitudServicio() {
    }

    public SolicitudServicio(Integer idSolicitudservicio) {
        this.idSolicitudservicio = idSolicitudservicio;
    }

    public SolicitudServicio(Integer idSolicitudservicio, String inconvenienteSolicitudservicio, Date fechaCreacionSolicitudservicio, boolean estadoSolicitudservicio) {
        this.idSolicitudservicio = idSolicitudservicio;
        this.inconvenienteSolicitudservicio = inconvenienteSolicitudservicio;
        this.fechaCreacionSolicitudservicio = fechaCreacionSolicitudservicio;
        this.estadoSolicitudservicio = estadoSolicitudservicio;
    }

    public Integer getIdSolicitudservicio() {
        return idSolicitudservicio;
    }

    public void setIdSolicitudservicio(Integer idSolicitudservicio) {
        this.idSolicitudservicio = idSolicitudservicio;
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

    public TipoServicio getIdTipoServicioSolicitudservicio() {
        return idTipoServicioSolicitudservicio;
    }

    public void setIdTipoServicioSolicitudservicio(TipoServicio idTipoServicioSolicitudservicio) {
        this.idTipoServicioSolicitudservicio = idTipoServicioSolicitudservicio;
    }

    public Tecnico getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(Tecnico idTecnico) {
        this.idTecnico = idTecnico;
    }

    public Sucursal getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Sucursal idSucursal) {
        this.idSucursal = idSucursal;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public Modelo getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Modelo idModelo) {
        this.idModelo = idModelo;
    }

    public Marca getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Marca idMarca) {
        this.idMarca = idMarca;
    }

    public Estado getIdEstadoSolicitudservicio() {
        return idEstadoSolicitudservicio;
    }

    public void setIdEstadoSolicitudservicio(Estado idEstadoSolicitudservicio) {
        this.idEstadoSolicitudservicio = idEstadoSolicitudservicio;
    }

    public Empresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Contacto getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(Contacto idContacto) {
        this.idContacto = idContacto;
    }

    public Ciudad getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Ciudad idCiudad) {
        this.idCiudad = idCiudad;
    }

    public Bodega getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(Bodega idBodega) {
        this.idBodega = idBodega;
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
        return idSolicitudservicio.toString();
    }
    
}

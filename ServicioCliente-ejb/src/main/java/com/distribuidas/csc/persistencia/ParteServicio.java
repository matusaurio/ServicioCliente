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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "parte_servicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParteServicio.findAll", query = "SELECT p FROM ParteServicio p"),
    @NamedQuery(name = "ParteServicio.findByIdParteservicio", query = "SELECT p FROM ParteServicio p WHERE p.idParteservicio = :idParteservicio"),
    @NamedQuery(name = "ParteServicio.findByEstadoParteservicio", query = "SELECT p FROM ParteServicio p WHERE p.estadoParteservicio = :estadoParteservicio"),
    @NamedQuery(name = "ParteServicio.findByFirmaParteservicio", query = "SELECT p FROM ParteServicio p WHERE p.firmaParteservicio = :firmaParteservicio"),
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
    @Column(name = "ESTADO_PARTESERVICIO")
    private boolean estadoParteservicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FIRMA_PARTESERVICIO")
    private boolean firmaParteservicio;
    @Size(max = 120)
    @Column(name = "OBSERVACION_PARTESERVICIO")
    private String observacionParteservicio;
    @JoinTable(name = "parteservicio_marcaverificacion", joinColumns = {
        @JoinColumn(name = "ID_PARTESERVICIO", referencedColumnName = "ID_PARTESERVICIO")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_MARCAVERIFICACION", referencedColumnName = "ID_MARCAVERIFICACION")})
    @ManyToMany
    private List<MarcaVerificacion> marcaVerificacionList;
    @JoinColumn(name = "ID_TECNICO", referencedColumnName = "ID_TECNICO")
    @ManyToOne
    private Tecnico idTecnico;
    @JoinColumn(name = "ID_SOLICITUDSERVICIO", referencedColumnName = "ID_SOLICITUDSERVICIO")
    @ManyToOne
    private SolicitudServicio idSolicitudservicio;
    @JoinColumn(name = "ID_HORARIOSERVICIO", referencedColumnName = "ID_HORARIOSERVICIO")
    @ManyToOne
    private HorarioServicio idHorarioservicio;
    @JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID_EMPRESA")
    @ManyToOne
    private Empresa idEmpresa;
    @JoinColumn(name = "ID_DETALLE_PARTESERVICIO", referencedColumnName = "ID_DETALLE_PARTESERVICIO")
    @ManyToOne
    private DetalleParteServicio idDetalleParteservicio;
    @JoinColumn(name = "ID_CONTACTO", referencedColumnName = "ID_CONTACTO")
    @ManyToOne
    private Contacto idContacto;

    public ParteServicio() {
    }

    public ParteServicio(Integer idParteservicio) {
        this.idParteservicio = idParteservicio;
    }

    public ParteServicio(Integer idParteservicio, boolean estadoParteservicio, boolean firmaParteservicio) {
        this.idParteservicio = idParteservicio;
        this.estadoParteservicio = estadoParteservicio;
        this.firmaParteservicio = firmaParteservicio;
    }

    public Integer getIdParteservicio() {
        return idParteservicio;
    }

    public void setIdParteservicio(Integer idParteservicio) {
        this.idParteservicio = idParteservicio;
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

    public Tecnico getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(Tecnico idTecnico) {
        this.idTecnico = idTecnico;
    }

    public SolicitudServicio getIdSolicitudservicio() {
        return idSolicitudservicio;
    }

    public void setIdSolicitudservicio(SolicitudServicio idSolicitudservicio) {
        this.idSolicitudservicio = idSolicitudservicio;
    }

    public HorarioServicio getIdHorarioservicio() {
        return idHorarioservicio;
    }

    public void setIdHorarioservicio(HorarioServicio idHorarioservicio) {
        this.idHorarioservicio = idHorarioservicio;
    }

    public Empresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public DetalleParteServicio getIdDetalleParteservicio() {
        return idDetalleParteservicio;
    }

    public void setIdDetalleParteservicio(DetalleParteServicio idDetalleParteservicio) {
        this.idDetalleParteservicio = idDetalleParteservicio;
    }

    public Contacto getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(Contacto idContacto) {
        this.idContacto = idContacto;
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
    
    public String getEstadoParteServicioTxt() {
        String tmp;
        if("true".compareTo(String.valueOf(this.estadoParteservicio))==0)
            tmp = "Activo";
        else
            tmp = "Inactivo";
        return tmp;
    }
    
    public String getEstadoFirmaTxt() {
        String tmp;
        if("true".compareTo(String.valueOf(this.firmaParteservicio))==0)
            tmp = "FIRMADO";
        else
            tmp = "NO FIRMADO";
        return tmp;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.persistencia;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "detalle_parte_servicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleParteServicio.findAll", query = "SELECT d FROM DetalleParteServicio d"),
    @NamedQuery(name = "DetalleParteServicio.findByIdDetalleParteservicio", query = "SELECT d FROM DetalleParteServicio d WHERE d.idDetalleParteservicio = :idDetalleParteservicio"),
    @NamedQuery(name = "DetalleParteServicio.findByDescripcionDetalleParteservicio", query = "SELECT d FROM DetalleParteServicio d WHERE d.descripcionDetalleParteservicio = :descripcionDetalleParteservicio"),
    @NamedQuery(name = "DetalleParteServicio.findByCantidadDetalleParteservicio", query = "SELECT d FROM DetalleParteServicio d WHERE d.cantidadDetalleParteservicio = :cantidadDetalleParteservicio")})
public class DetalleParteServicio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_DETALLE_PARTESERVICIO")
    private Integer idDetalleParteservicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "DESCRIPCION_DETALLE_PARTESERVICIO")
    private String descripcionDetalleParteservicio;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD_DETALLE_PARTESERVICIO")
    private BigDecimal cantidadDetalleParteservicio;
    @JoinColumn(name = "ID_PARTESERVICIO", referencedColumnName = "ID_PARTESERVICIO")
    @ManyToOne
    private ParteServicio idParteservicio;

    public DetalleParteServicio() {
    }

    public DetalleParteServicio(Integer idDetalleParteservicio) {
        this.idDetalleParteservicio = idDetalleParteservicio;
    }

    public DetalleParteServicio(Integer idDetalleParteservicio, String descripcionDetalleParteservicio, BigDecimal cantidadDetalleParteservicio) {
        this.idDetalleParteservicio = idDetalleParteservicio;
        this.descripcionDetalleParteservicio = descripcionDetalleParteservicio;
        this.cantidadDetalleParteservicio = cantidadDetalleParteservicio;
    }

    public Integer getIdDetalleParteservicio() {
        return idDetalleParteservicio;
    }

    public void setIdDetalleParteservicio(Integer idDetalleParteservicio) {
        this.idDetalleParteservicio = idDetalleParteservicio;
    }

    public String getDescripcionDetalleParteservicio() {
        return descripcionDetalleParteservicio;
    }

    public void setDescripcionDetalleParteservicio(String descripcionDetalleParteservicio) {
        this.descripcionDetalleParteservicio = descripcionDetalleParteservicio;
    }

    public BigDecimal getCantidadDetalleParteservicio() {
        return cantidadDetalleParteservicio;
    }

    public void setCantidadDetalleParteservicio(BigDecimal cantidadDetalleParteservicio) {
        this.cantidadDetalleParteservicio = cantidadDetalleParteservicio;
    }

    public ParteServicio getIdParteservicio() {
        return idParteservicio;
    }

    public void setIdParteservicio(ParteServicio idParteservicio) {
        this.idParteservicio = idParteservicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleParteservicio != null ? idDetalleParteservicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleParteServicio)) {
            return false;
        }
        DetalleParteServicio other = (DetalleParteServicio) object;
        if ((this.idDetalleParteservicio == null && other.idDetalleParteservicio != null) || (this.idDetalleParteservicio != null && !this.idDetalleParteservicio.equals(other.idDetalleParteservicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.distribuidas.csc.persistencia.DetalleParteServicio[ idDetalleParteservicio=" + idDetalleParteservicio + " ]";
    }
    
}

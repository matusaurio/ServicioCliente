/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.persistencia;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Stephen
 */
@Entity
@Table(name = "horario_servicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HorarioServicio.findAll", query = "SELECT h FROM HorarioServicio h"),
    @NamedQuery(name = "HorarioServicio.findByIdHorarioservicio", query = "SELECT h FROM HorarioServicio h WHERE h.idHorarioservicio = :idHorarioservicio"),
    @NamedQuery(name = "HorarioServicio.findByInicioHorarioservicio", query = "SELECT h FROM HorarioServicio h WHERE h.inicioHorarioservicio = :inicioHorarioservicio"),
    @NamedQuery(name = "HorarioServicio.findByFinHorarioservicio", query = "SELECT h FROM HorarioServicio h WHERE h.finHorarioservicio = :finHorarioservicio"),
    @NamedQuery(name = "HorarioServicio.findByTotalHorarioservicio", query = "SELECT h FROM HorarioServicio h WHERE h.totalHorarioservicio = :totalHorarioservicio")})
public class HorarioServicio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_HORARIOSERVICIO")
    private Integer idHorarioservicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "INICIO_HORARIOSERVICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inicioHorarioservicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FIN_HORARIOSERVICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finHorarioservicio;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTAL_HORARIOSERVICIO")
    private BigDecimal totalHorarioservicio;
    @JoinColumn(name = "ID_PARTESERVICIO", referencedColumnName = "ID_PARTESERVICIO")
    @ManyToOne
    private ParteServicio idParteservicio;

    public HorarioServicio() {
    }

    public HorarioServicio(Integer idHorarioservicio) {
        this.idHorarioservicio = idHorarioservicio;
    }

    public HorarioServicio(Integer idHorarioservicio, Date inicioHorarioservicio, Date finHorarioservicio, BigDecimal totalHorarioservicio) {
        this.idHorarioservicio = idHorarioservicio;
        this.inicioHorarioservicio = inicioHorarioservicio;
        this.finHorarioservicio = finHorarioservicio;
        this.totalHorarioservicio = totalHorarioservicio;
    }

    public Integer getIdHorarioservicio() {
        return idHorarioservicio;
    }

    public void setIdHorarioservicio(Integer idHorarioservicio) {
        this.idHorarioservicio = idHorarioservicio;
    }

    public Date getInicioHorarioservicio() {
        return inicioHorarioservicio;
    }

    public void setInicioHorarioservicio(Date inicioHorarioservicio) {
        this.inicioHorarioservicio = inicioHorarioservicio;
    }

    public Date getFinHorarioservicio() {
        return finHorarioservicio;
    }

    public void setFinHorarioservicio(Date finHorarioservicio) {
        this.finHorarioservicio = finHorarioservicio;
    }

    public BigDecimal getTotalHorarioservicio() {
        return totalHorarioservicio;
    }

    public void setTotalHorarioservicio(BigDecimal totalHorarioservicio) {
        this.totalHorarioservicio = totalHorarioservicio;
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
        hash += (idHorarioservicio != null ? idHorarioservicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HorarioServicio)) {
            return false;
        }
        HorarioServicio other = (HorarioServicio) object;
        if ((this.idHorarioservicio == null && other.idHorarioservicio != null) || (this.idHorarioservicio != null && !this.idHorarioservicio.equals(other.idHorarioservicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idHorarioservicio.toString();
    }
    
}

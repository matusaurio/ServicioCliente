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
import javax.persistence.ManyToOne;
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
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuario.findByMailUsuario", query = "SELECT u FROM Usuario u WHERE u.mailUsuario = :mailUsuario"),
    @NamedQuery(name = "Usuario.findByPassUsuario", query = "SELECT u FROM Usuario u WHERE u.passUsuario = :passUsuario"),
    @NamedQuery(name = "Usuario.findByNombreUsuario", query = "SELECT u FROM Usuario u WHERE u.nombreUsuario = :nombreUsuario"),
    @NamedQuery(name = "Usuario.findByEstadoUsuario", query = "SELECT u FROM Usuario u WHERE u.estadoUsuario = :estadoUsuario")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_USUARIO")
    private Integer idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "MAIL_USUARIO")
    private String mailUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PASS_USUARIO")
    private String passUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBRE_USUARIO")
    private String nombreUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO_USUARIO")
    private boolean estadoUsuario;
    @JoinColumn(name = "ID_ROL", referencedColumnName = "ID_ROL")
    @ManyToOne
    private Rol idRol;
    @JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID_EMPRESA")
    @ManyToOne
    private Empresa idEmpresa;
    @OneToMany(mappedBy = "idUsuario")
    private List<SolicitudServicio> solicitudServicioList;
    @OneToMany(mappedBy = "idUsuario")
    private List<ParteServicio> parteServicioList;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Integer idUsuario, String mailUsuario, String passUsuario, String nombreUsuario, boolean estadoUsuario) {
        this.idUsuario = idUsuario;
        this.mailUsuario = mailUsuario;
        this.passUsuario = passUsuario;
        this.nombreUsuario = nombreUsuario;
        this.estadoUsuario = estadoUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getMailUsuario() {
        return mailUsuario;
    }

    public void setMailUsuario(String mailUsuario) {
        this.mailUsuario = mailUsuario;
    }

    public String getPassUsuario() {
        return passUsuario;
    }

    public void setPassUsuario(String passUsuario) {
        this.passUsuario = passUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public boolean getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(boolean estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public Rol getIdRol() {
        return idRol;
    }

    public void setIdRol(Rol idRol) {
        this.idRol = idRol;
    }

    public Empresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @XmlTransient
    public List<SolicitudServicio> getSolicitudServicioList() {
        return solicitudServicioList;
    }

    public void setSolicitudServicioList(List<SolicitudServicio> solicitudServicioList) {
        this.solicitudServicioList = solicitudServicioList;
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
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idUsuario.toString();
    }
    
    public String getEstadoUsuarioTxt() {
        String tmp;
        if("true".compareTo(String.valueOf(this.estadoUsuario))==0)
            tmp = "Activo";
        else
            tmp = "Inactivo";
        return tmp;
    }
}

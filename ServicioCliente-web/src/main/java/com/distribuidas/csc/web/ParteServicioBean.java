/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.web;

import com.distribuidas.csc.persistencia.Contacto;
import com.distribuidas.csc.persistencia.ParteServicio;
import com.distribuidas.csc.persistencia.SolicitudServicio;
import com.distribuidas.csc.persistencia.Tecnico;
import com.distribuidas.csc.servicio.ContactoServicio;
import com.distribuidas.csc.servicio.ParteServicioServicio;
import com.distribuidas.csc.servicio.SolicitudServicioServicio;
import com.distribuidas.csc.servicio.TecnicoServicio;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author Stephen
 */
@ManagedBean
@ViewScoped
public class ParteServicioBean {

    @EJB
    private ParteServicioServicio parteServicioServicio;
    @ManagedProperty(value = "#{solicitudServicio}")
    private SolicitudServicioBean solicitudServicio;
    
    @EJB
    private ContactoServicio contactoServicio;
    
    @EJB 
    private SolicitudServicioServicio solicitudServicioServicio;
    
    @EJB
    private TecnicoServicio tecnicoServicio;

    private List<ParteServicio> parteServicios;
    private List<Contacto> contactos;
    private List<SolicitudServicio> solicitudServicios;
    private List<Tecnico> tecnicos;
    private ParteServicio parteServicio;
    private ParteServicio parteServicioSeleccionado;

    private Boolean desplegarVista = false;
    private Boolean desplegarNuevo = false;

    private String tituloFormulario;
    private Boolean enNuevo;
    private Boolean enModificar;
    private Integer idSolicitud;

    private Boolean activarNuevo;
    private Boolean activarModificar;
    private Boolean activarEliminar;
    private Boolean activarCambiarEstado;

    @PostConstruct
    public void init() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
        this.idSolicitud = (Integer) session.getAttribute("idSolicitud");
        System.out.println(this.idSolicitud);
        this.parteServicios = this.parteServicioServicio.obtenerParteS(this.idSolicitud);
    }

    public void vista() {
        this.desplegarVista = true;
    }

    public void nuevo() {
        this.desplegarNuevo = true;
        this.enNuevo = true;
        this.enModificar = false;
        this.parteServicio = new ParteServicio();
    }

    public void guardar() {
        if (this.enNuevo) {
            this.parteServicioServicio.crear(this.parteServicio);
            this.desplegarNuevo = false;
            this.parteServicios.add(this.parteServicio);
            this.enNuevo = false;
        } else if (this.enModificar) {
            System.err.println("modificar");
            this.parteServicioServicio.actualizar(this.parteServicio);
            this.desplegarNuevo = false;
            this.enModificar = false;
        }
    }

    public void modificar() {
        this.enModificar = true;
        this.enNuevo = false;
        this.desplegarNuevo = true;
        this.parteServicio = this.parteServicioSeleccionado;
    }

    public void eliminar() {
        this.parteServicioServicio.eliminar(this.parteServicioSeleccionado);
        this.parteServicios.remove(this.parteServicioSeleccionado);
    }

    public void cancelar() {
        this.desplegarNuevo = false;
    }

    public void onRowSelect(SelectEvent event) {

    }

    public void onRowUnselect(UnselectEvent event) {

    }

    public SolicitudServicioBean getSolicitudServicio() {
        return solicitudServicio;
    }

    public void setSolicitudServicio(SolicitudServicioBean solicitudServicio) {
        this.solicitudServicio = solicitudServicio;
    }

    public Integer getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public List<ParteServicio> getParteServicios() {
        return parteServicios;
    }

    public ParteServicio getParteServicio() {
        return parteServicio;
    }

    public void setParteServicio(ParteServicio parteServicio) {
        this.parteServicio = parteServicio;
    }

    public ParteServicio getParteServicioSeleccionado() {
        return parteServicioSeleccionado;
    }

    public void setParteServicioSeleccionado(ParteServicio parteServicioSeleccionado) {
        this.parteServicioSeleccionado = parteServicioSeleccionado;
    }

    public Boolean getDesplegarVista() {
        return desplegarVista;
    }

    public void setDesplegarVista(Boolean desplegarVista) {
        this.desplegarVista = desplegarVista;
    }

    public Boolean getDesplegarNuevo() {
        return desplegarNuevo;
    }

    public void setDesplegarNuevo(Boolean desplegarNuevo) {
        this.desplegarNuevo = desplegarNuevo;
    }

    public String getTituloFormulario() {
        return tituloFormulario;
    }

    public void setTituloFormulario(String tituloFormulario) {
        this.tituloFormulario = tituloFormulario;
    }

    public Boolean getEnNuevo() {
        return enNuevo;
    }

    public void setEnNuevo(Boolean enNuevo) {
        this.enNuevo = enNuevo;
    }

    public Boolean getEnModificar() {
        return enModificar;
    }

    public void setEnModificar(Boolean enModificar) {
        this.enModificar = enModificar;
    }

    public Boolean getActivarNuevo() {
        return activarNuevo;
    }

    public void setActivarNuevo(Boolean activarNuevo) {
        this.activarNuevo = activarNuevo;
    }

    public Boolean getActivarModificar() {
        return activarModificar;
    }

    public void setActivarModificar(Boolean activarModificar) {
        this.activarModificar = activarModificar;
    }

    public Boolean getActivarEliminar() {
        return activarEliminar;
    }

    public void setActivarEliminar(Boolean activarEliminar) {
        this.activarEliminar = activarEliminar;
    }

    public Boolean getActivarCambiarEstado() {
        return activarCambiarEstado;
    }

    public void setActivarCambiarEstado(Boolean activarCambiarEstado) {
        this.activarCambiarEstado = activarCambiarEstado;
    }

    public List<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(List<Contacto> contactos) {
        this.contactos = contactos;
    }

    public List<SolicitudServicio> getSolicitudServicios() {
        return solicitudServicios;
    }

    public void setSolicitudServicios(List<SolicitudServicio> solicitudServicios) {
        this.solicitudServicios = solicitudServicios;
    }

    public List<Tecnico> getTecnicos() {
        return tecnicos;
    }

    public void setTecnicos(List<Tecnico> tecnicos) {
        this.tecnicos = tecnicos;
    }
    
    
    
}

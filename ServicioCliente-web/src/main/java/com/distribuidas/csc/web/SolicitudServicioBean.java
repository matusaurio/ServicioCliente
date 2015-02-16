/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.web;

import com.distribuidas.csc.persistencia.Bodega;
import com.distribuidas.csc.persistencia.Contacto;
import com.distribuidas.csc.persistencia.Estado;
import com.distribuidas.csc.persistencia.SolicitudServicio;
import com.distribuidas.csc.persistencia.Sucursal;
import com.distribuidas.csc.servicio.BodegaServicio;
import com.distribuidas.csc.servicio.ContactoServicio;
import com.distribuidas.csc.servicio.EstadoServicio;
import com.distribuidas.csc.servicio.SolicitudServicioServicio;
import com.distribuidas.csc.servicio.SucursalServicio;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author Stephen
 */
@ManagedBean
@ViewScoped
public class SolicitudServicioBean {
    
    @EJB
    private SolicitudServicioServicio solicitudServicioServicio;
    @EJB
    private SucursalServicio sucursalServicio;
    @EJB
    private BodegaServicio bodegaServicio;
    @EJB
    private ContactoServicio contactoServicio;
    @EJB
    private EstadoServicio estadoServicio;
    
    private List<Sucursal> sucursales;
    private List<Bodega> bodegas;
    private List<Contacto> contactos;
    private List<Estado> estados;

    private List<SolicitudServicio> solicitudServicios;
    private SolicitudServicio solicitudServicio;
    private SolicitudServicio solicitudServicioSeleccionada;

    private Boolean desplegarVista = false;
    private Boolean desplegarNuevo = false;
    private Boolean elegirTecnico = false;

    private String tituloFormulario;
    private Boolean enNuevo;
    private Boolean enModificar;

    private Boolean activarNuevo;
    private Boolean activarModificar;
    private Boolean activarEliminar;
    private Boolean activarCambiarEstado;
    
    Date fecha = new Date();
    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @PostConstruct
    public void init() {
        this.solicitudServicios = this.solicitudServicioServicio.obtenerTodos();
        this.estados = this.estadoServicio.obtenerTodos();
        this.sucursales = new ArrayList<>();
        this.bodegas = new ArrayList<>();
        this.estados = new ArrayList<>();
    }

    public void cargarSucursales(){
        System.out.println("CARGAR SUCURSALES");
        this.sucursales = this.sucursalServicio.obtenerSurcursalesE(this.solicitudServicio.getIdContacto().getIdEmpresa().getIdEmpresa());
    }
    
    public void cargarContactos(){
        System.out.println("CARGAR CONTACTOS");
        this.contactos = this.contactoServicio.obtenerContactosE(this.solicitudServicio.getIdEmpresa().getIdEmpresa());
    }
    
    public void cargarBodegas(){
        System.out.println("CARGAR BODEGAS");
        this.bodegas = this.bodegaServicio.obtenerBodegasS(this.solicitudServicio.getIdSucursal().getIdSucursal());
    }
    
    public void cargarTecnicos(){
        System.out.println("CARGAR TECNICOS");
        int aux = this.solicitudServicio.getIdEstadoSolicitudservicio().getIdEstadoSolicitudservicio();
        if((aux)==(2)){
            this.elegirTecnico = true;
        }
        else 
            this.elegirTecnico = false;
    }
    
    public void vista() {
        for(int i=0;i<this.solicitudServicios.size();i++){
            if(this.solicitudServicios.get(i).getIdEstadoSolicitudservicio().getIdEstadoSolicitudservicio().compareTo(3)==0)
                this.tituloFormulario = "Parte Servicio";
            else
                this.tituloFormulario = "Gestionar Servicio";
        }
        this.desplegarVista = true;
    }

    public void nuevo() {
        this.desplegarNuevo = true;
        this.enNuevo = true;
        this.enModificar = false;
        this.solicitudServicio = new SolicitudServicio();
        this.solicitudServicio.setFechaCreacionSolicitudservicio((this.fecha));
    }

    public void guardar() {
        if (this.enNuevo) {
            this.solicitudServicioServicio.crear(this.solicitudServicio);
            this.desplegarNuevo = false;
            this.solicitudServicios.add(this.solicitudServicio);
            this.enNuevo = false;
        } else if (this.enModificar) {
            System.err.println("modificar");
            this.solicitudServicioServicio.actualizar(this.solicitudServicio);
            this.desplegarNuevo = false;
            this.enModificar = false;
        }
    }

    public void modificar() {
        this.enModificar = true;
        this.enNuevo = false;
        this.desplegarNuevo = true;
        this.solicitudServicio = this.solicitudServicioSeleccionada;
    }

    public void eliminar() {
        this.solicitudServicioServicio.eliminar(this.solicitudServicioSeleccionada);
        this.solicitudServicios.remove(this.solicitudServicioSeleccionada);
    }

    public void cancelar() {
        this.desplegarNuevo = false;
    }

    public void onRowSelect(SelectEvent event) {

    }

    public void onRowUnselect(UnselectEvent event) {

    }

    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }

    public List<Contacto> getContactos() {
        return contactos;
    }

    public List<Sucursal> getSucursales() {
        return sucursales;
    }

    public List<Bodega> getBodegas() {
        return bodegas;
    }

    public List<SolicitudServicio> getSolicitudServicios() {
        return solicitudServicios;
    }

    public Boolean getElegirTecnico() {
        return elegirTecnico;
    }

    public void setElegirTecnico(Boolean elegirTecnico) {
        this.elegirTecnico = elegirTecnico;
    }

    public SolicitudServicio getSolicitudServicio() {
        return solicitudServicio;
    }

    public void setSolicitudServicio(SolicitudServicio solicitudServicio) {
        this.solicitudServicio = solicitudServicio;
    }
    
    public SolicitudServicio getSolicitudServicioSeleccionada() {
        return solicitudServicioSeleccionada;
    }

    public void setSolicitudServicioSeleccionada(SolicitudServicio solicitudServicioSeleccionada) {
        this.solicitudServicioSeleccionada = solicitudServicioSeleccionada;
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
    
}

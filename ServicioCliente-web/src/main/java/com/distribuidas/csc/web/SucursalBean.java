/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.web;

import com.distribuidas.csc.persistencia.Sucursal;
import com.distribuidas.csc.servicio.SucursalServicio;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author Stephen
 */
@ManagedBean
@ViewScoped
public class SucursalBean {
    
    private List<Sucursal> sucursales;
    private List<Sucursal> sucursalesE;
    private Sucursal sucursal;
    private Sucursal sucursalSeleccionada;
        
    private Boolean desplegarVista = false;
    private Boolean desplegarNuevo = false;
    
    private String tituloFormulario;
    private Integer codEmpresa;
    private Boolean enNuevo;
    private Boolean enModificar;
    
    
    private Boolean activarNuevo;
    private Boolean activarModificar;
    private Boolean activarEliminar;
    private Boolean activarCambiarEstado;
    
    @EJB
    private SucursalServicio sucursalServicio;
    
    @PostConstruct
    public void init(){
        this.sucursales = this.sucursalServicio.obtenerTodos();
        this.sucursalesE = this.sucursalServicio.obtenerSurcursalesE(this.codEmpresa);
    }
    
    public void cargarCombo(){
        System.out.println("Codigo empresa");
        System.out.println(codEmpresa);
        this.sucursalesE = this.sucursalServicio.obtenerSurcursalesE(this.codEmpresa);
    }
    
    public void vista(){
        this.desplegarVista = true;
    }
    
    public void nuevo(){
        this.desplegarNuevo = true;
        this.enNuevo = true;
        this.enModificar = false;
        this.sucursal = new Sucursal();
    }
    
    public void guardar() {
        if (this.enNuevo) {
            this.sucursalServicio.crear(this.sucursal);
            this.desplegarNuevo = false;
            this.sucursales.add(this.sucursal);
            this.enNuevo = false;
        } else if (this.enModificar) {
            System.err.println("modificar");
            this.sucursalServicio.actualizar(this.sucursal);
            this.desplegarNuevo = false;
            this.enModificar = false;
        }
    }

    public void modificar() {
        this.enModificar = true;
        this.enNuevo = false;
        this.desplegarNuevo = true;
        this.sucursal = this.sucursalSeleccionada;
    }

    public void eliminar() {
        this.sucursalServicio.eliminar(this.sucursalSeleccionada);
        this.sucursales.remove(this.sucursalSeleccionada);
    }

    public void cancelar() {
        this.desplegarNuevo = false;
    }

    public void onRowSelect(SelectEvent event) {

    }

    public void onRowUnselect(UnselectEvent event) {

    }

    public List<Sucursal> getSucursalesE() {
        return sucursalesE;
    }

    public void setSucursalesE(List<Sucursal> sucursalesE) {
        this.sucursalesE = sucursalesE;
    }

    public Integer getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(Integer codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    public List<Sucursal> getSucursales() {
        return sucursales;
    }


    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Sucursal getSucursalSeleccionada() {
        return sucursalSeleccionada;
    }

    public void setSucursalSeleccionada(Sucursal sucursalSeleccionada) {
        this.sucursalSeleccionada = sucursalSeleccionada;
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

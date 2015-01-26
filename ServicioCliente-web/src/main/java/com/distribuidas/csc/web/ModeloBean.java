/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.web;

import com.distribuidas.csc.persistencia.Modelo;
import com.distribuidas.csc.servicio.ModeloServicio;
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
public class ModeloBean {
    
    private List<Modelo> modelos;
    private Modelo modelo;
    private Modelo modeloSeleccionada;
    
    private Boolean desplegarVista = false;
    private Boolean desplegarNuevo = false;
    
    private String tituloFormulario;
    private Boolean enNuevo;
    private Boolean enModificar;
    
    
    private Boolean activarNuevo;
    private Boolean activarModificar;
    private Boolean activarEliminar;
    private Boolean activarCambiarEstado;
    
    @EJB
    private ModeloServicio modeloServicio;
    
    @PostConstruct
    public void init(){
        this.modelos = this.modeloServicio.obtenerTodos();
    }
    
    public void vista(){
        this.desplegarVista = true;
    }
    
    public void nuevo(){
        this.desplegarNuevo = true;
        this.modelo = new Modelo();
    }
    
    public void guardar() {
        if (this.enNuevo) {
            this.modeloServicio.crear(this.modelo);
            this.desplegarNuevo = false;
            this.modelos.add(this.modelo);
            this.enNuevo = false;
        } else if (this.enModificar) {
            System.err.println("modificar");
            this.modeloServicio.actualizar(this.modelo);
            this.desplegarNuevo = false;
            this.enModificar = false;
        }
    }

    public void modificar() {
        this.enModificar = true;
        this.enNuevo = false;
        this.desplegarNuevo = true;
        this.modelo = this.modeloSeleccionada;
    }

    public void eliminar() {
        this.modeloServicio.eliminar(this.modeloSeleccionada);
        this.modelos.remove(this.modeloSeleccionada);
    }

    public void cancelar() {
        this.desplegarNuevo = false;
    }

    public void onRowSelect(SelectEvent event) {

    }

    public void onRowUnselect(UnselectEvent event) {

    }

    public List<Modelo> getModelos() {
        return modelos;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Modelo getModeloSeleccionada() {
        return modeloSeleccionada;
    }

    public void setModeloSeleccionada(Modelo modeloSeleccionada) {
        this.modeloSeleccionada = modeloSeleccionada;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.web;

import com.distribuidas.csc.persistencia.Marca;
import com.distribuidas.csc.servicio.MarcaServicio;
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
public class MarcaBean {
    
    private List<Marca> marcas;
    private Marca marca;
    private Marca marcaSeleccionada;
    
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
    private MarcaServicio marcaServicio;
    
    @PostConstruct
    public void init(){
        this.marcas = this.marcaServicio.obtenerTodos();
    }
    
    public void vista(){
        this.desplegarVista = true;
    }
    
    public void nuevo(){
        this.desplegarNuevo = true;
        this.marca = new Marca();
    }
    
    public void guardar() {
        if (this.enNuevo) {
            this.marcaServicio.crear(this.marca);
            this.desplegarNuevo = false;
            this.marcas.add(this.marca);
            this.enNuevo = false;
        } else if (this.enModificar) {
            System.err.println("modificar");
            this.marcaServicio.actualizar(this.marca);
            this.desplegarNuevo = false;
            this.enModificar = false;
        }
    }

    public void modificar() {
        this.enModificar = true;
        this.enNuevo = false;
        this.desplegarNuevo = true;
        this.marca = this.marcaSeleccionada;
    }

    public void eliminar() {
        this.marcaServicio.eliminar(this.marcaSeleccionada);
        this.marcas.remove(this.marcaSeleccionada);
    }

    public void cancelar() {
        this.desplegarNuevo = false;
    }

    public void onRowSelect(SelectEvent event) {

    }

    public void onRowUnselect(UnselectEvent event) {

    }

    public List<Marca> getMarcas() {
        return marcas;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Marca getMarcaSeleccionada() {
        return marcaSeleccionada;
    }

    public void setMarcaSeleccionada(Marca marcaSeleccionada) {
        this.marcaSeleccionada = marcaSeleccionada;
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

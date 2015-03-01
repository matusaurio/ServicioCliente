/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.web;

import com.distribuidas.csc.persistencia.Modelo;
import com.distribuidas.csc.servicio.ModeloServicio;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Stephen
 */
@ManagedBean
@ViewScoped
public class ModeloBean extends EstadoBotones implements Serializable{
    
    private List<Modelo> modelos;
    private Modelo modelo;
    private Modelo modeloSeleccionada;
    
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
        this.enNuevo = true;
        this.enModificar = false;
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
}

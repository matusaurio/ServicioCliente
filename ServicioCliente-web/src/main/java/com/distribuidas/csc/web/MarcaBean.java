/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.web;

import com.distribuidas.csc.persistencia.Marca;
import com.distribuidas.csc.servicio.MarcaServicio;
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
public class MarcaBean extends EstadoBotones implements Serializable{

    private List<Marca> marcas;
    private Marca marca;
    private Marca marcaSeleccionada;

    @EJB
    private MarcaServicio marcaServicio;

    @PostConstruct
    public void init() {
        this.marcas = this.marcaServicio.obtenerTodos();
    }

    public void vista() {
        this.desplegarVista = true;
    }

    public void nuevo() {
        this.desplegarNuevo = true;
        this.enNuevo = true;
        this.enModificar = false;
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
}

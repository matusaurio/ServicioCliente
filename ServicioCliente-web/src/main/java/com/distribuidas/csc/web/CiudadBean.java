/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.web;

import com.distribuidas.csc.persistencia.Ciudad;
import com.distribuidas.csc.servicio.CiudadServicio;
import java.io.Serializable;
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
public class CiudadBean extends EstadoBotones implements Serializable {

    private List<Ciudad> ciudades;
    private Ciudad ciudad;
    private Ciudad ciudadSeleccionada;

    @EJB
    private CiudadServicio ciudadServicio;

    @PostConstruct
    public void init() {
        this.ciudades = this.ciudadServicio.obtenerTodos();
    }

    public void vista() {
        this.desplegarVista = true;
    }

    public void nuevo() {
        this.desplegarNuevo = true;
        this.enNuevo = true;
        this.enModificar = false;
        this.ciudad = new Ciudad();
    }

    public void guardar() {
        if (this.enNuevo) {
            this.ciudadServicio.crear(this.ciudad);
            this.desplegarNuevo = false;
            this.ciudades.add(this.ciudad);
            this.enNuevo = false;
        } else if (this.enModificar) {
            this.ciudadServicio.actualizar(this.ciudad);
            this.desplegarNuevo = false;
            this.enModificar = false;
        }
    }

    public void modificar() {
        this.enModificar = true;
        this.enNuevo = false;
        this.desplegarNuevo = true;
        this.ciudad = this.ciudadSeleccionada;
    }

    public void eliminar() {
        this.ciudadServicio.eliminar(this.ciudadSeleccionada);
        this.ciudades.remove(this.ciudadSeleccionada);
    }

    public void cancelar() {
        this.desplegarNuevo = false;
    }

    public void onRowSelect(SelectEvent event) {
        this.activarModificar = true;
        this.activarEliminar = true;
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Ciudad getCiudadSeleccionada() {
        return ciudadSeleccionada;
    }

    public void setCiudadSeleccionada(Ciudad ciudadSeleccionada) {
        this.ciudadSeleccionada = ciudadSeleccionada;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.web;

import org.primefaces.event.UnselectEvent;

/**
 *
 * @author hendrix
 */
public class EstadoBotones {

    protected String tituloFormulario;

    protected Boolean activarNuevo;
    protected Boolean activarModificar = false;
    protected Boolean activarEliminar = false;
    protected Boolean activarCambiarEstado;

    protected Boolean enNuevo;
    protected Boolean enModificar;

    protected Boolean desplegarVista = false;
    protected Boolean desplegarNuevo = false;

    public void nuevoB() {
        this.enNuevo = true;
        this.desplegarNuevo = true;
        this.activarCambiarEstado = false;
        this.activarEliminar = false;
        this.activarNuevo = false;
        this.activarModificar = false;
    }

    public void modificarB() {
        this.enModificar = true;
        this.enNuevo = false;
        this.desplegarNuevo = true;
        this.activarCambiarEstado = false;
        this.activarEliminar = false;
        this.activarNuevo = false;
        this.activarModificar = false;
    }

    public void guardarB() {
        this.desplegarNuevo = false;
        this.enNuevo = false;
        this.enModificar = false;
    }

    public void cancelarB() {
        this.desplegarNuevo = false;
        this.enModificar = false;
        this.enNuevo = false;
        this.activarNuevo = true;
    }

    public void onRowUnselect(UnselectEvent event) {
        this.activarModificar = false;
        this.activarEliminar = false;
        this.activarCambiarEstado = false;
    }
    
    public Boolean getActivarNuevo() {
        return activarNuevo;
    }

    public Boolean getActivarModificar() {
        return activarModificar;
    }

    public Boolean getActivarEliminar() {
        return activarEliminar;
    }

    public Boolean getActivarCambiarEstado() {
        return activarCambiarEstado;
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

    public void registroSeleccionado() {
        this.activarModificar = true;
        this.activarEliminar = true;
        this.activarCambiarEstado = true;
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

    public void setActivarNuevo(Boolean activarNuevo) {
        this.activarNuevo = activarNuevo;
    }

    public void setActivarModificar(Boolean activarModificar) {
        this.activarModificar = activarModificar;
    }

    public void setActivarEliminar(Boolean activarEliminar) {
        this.activarEliminar = activarEliminar;
    }

    public void setActivarCambiarEstado(Boolean activarCambiarEstado) {
        this.activarCambiarEstado = activarCambiarEstado;
    }

}

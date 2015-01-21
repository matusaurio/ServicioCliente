/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.web;


import com.distribuidas.csc.persistencia.Ciudad;
import com.distribuidas.csc.servicio.CiudadServicio;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Stephen
 */
@ManagedBean
@ViewScoped
public class CiudadBean {
    
    private List<Ciudad> ciudades;
    private Ciudad ciudad;
    private Ciudad ciudadSeleccionada;
    
    private Boolean desplegarVista = false;
    private Boolean desplegarNuevo = false;
    
    private Boolean desplegarFormulario;
    private String tituloFormulario;
    private Boolean enNuevo;
    private Boolean enModificar;
    
    
    private Boolean activarNuevo;
    private Boolean activarModificar;
    private Boolean activarEliminar;
    private Boolean activarCambiarEstado;
    
    @EJB
    private CiudadServicio ciudadServicio;
    
    @PostConstruct
    public void init(){
        this.ciudades = this.ciudadServicio.obtenerTodos();
    }
    
    public void vista(){
        System.out.println("asdfasdfa");
        this.desplegarVista = true;
    }
    
    public void nuevo(){
        this.desplegarNuevo = true;
        this.ciudad = new Ciudad();
    }
    
    public void guardar(){
        this.ciudadServicio.crear(this.ciudad);
        this.desplegarNuevo = false;
        this.ciudades.add(this.ciudad);
    }
    
    public void cancelar(){
        this.desplegarNuevo = false;
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
    
    
    
}

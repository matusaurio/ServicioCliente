/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.web;



import com.distribuidas.csc.persistencia.Empresa;
import com.distribuidas.csc.servicio.EmpresaServicio;
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
public class EmpresaBean {
    
     private List<Empresa> empresas;
     private Empresa empresa;
     
     private Boolean desplegarVista = false;
    private Boolean desplegarNuevo = false;
    
    @EJB
    private EmpresaServicio empresaServicio;
    
    @PostConstruct
    public void init(){
        this.empresas = this.empresaServicio.obtenerTodos();
    }
    
    public void vista(){
        System.out.println("asdfasdfa");
        this.desplegarVista = true;
    }
    
    public void nuevo(){
        this.desplegarNuevo = true;
        this.empresa = new Empresa();
    }
    
    public void guardar(){
        this.empresaServicio.crear(this.empresa);
        this.desplegarNuevo = false;
        this.empresas.add(this.empresa);
    }
    
    public void cancelar(){
        this.desplegarNuevo = false;
    }

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.web;

import com.distribuidas.csc.persistencia.Bodega;
import com.distribuidas.csc.persistencia.Empresa;
import com.distribuidas.csc.persistencia.Sucursal;
import com.distribuidas.csc.servicio.BodegaServicio;
import com.distribuidas.csc.servicio.EmpresaServicio;
import com.distribuidas.csc.servicio.SucursalServicio;
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
public class BodegaBean {
    
    private List<Bodega> bodegas;
    private List<Sucursal> sucursales;
    private List<Empresa> empresas;
    
    private Bodega bodega;
    private Bodega bodegaSeleccionada;
    
    private Boolean desplegarVista = false;
    private Boolean desplegarNuevo = false;
    
    private String tituloFormulario;
    private Empresa codEmpresa;
    private Integer idEmpresa;
    private Boolean enNuevo;
    private Boolean enModificar;
    
    
    private Boolean activarNuevo;
    private Boolean activarModificar;
    private Boolean activarEliminar;
    private Boolean activarCambiarEstado;
    
    @EJB
    private BodegaServicio bodegaServicio;
    @EJB
    private SucursalServicio sucursalServicio;
    @EJB
    private EmpresaServicio empresaServicio;
    
    @PostConstruct
    public void init(){
        this.bodegas = this.bodegaServicio.obtenerTodos();
        this.empresas = this.empresaServicio.obtenerTodos();
    }
    
    public void vista(){
        this.desplegarVista = true;
    }
    
    public void nuevo(){
        this.desplegarNuevo = true;
        this.enNuevo = true;
        this.enModificar = false;
        this.bodega = new Bodega();
    }
    
    public void guardar() {
        if (this.enNuevo) {
            this.bodegaServicio.crear(this.bodega);
            this.desplegarNuevo = false;
            this.bodegas.add(this.bodega);
            this.enNuevo = false;
        } else if (this.enModificar) {
            System.err.println("modificar");
            this.bodegaServicio.actualizar(this.bodega);
            this.desplegarNuevo = false;
            this.enModificar = false;
        }
    }

    public void modificar() {
        this.enModificar = true;
        this.enNuevo = false;
        this.desplegarNuevo = true;
        this.bodega = this.bodegaSeleccionada;
        this.codEmpresa = this.bodegaSeleccionada.getIdSucursal().getIdEmpresa();
        cargarSucursales();
    }

    public void eliminar() {
        this.bodegaServicio.eliminar(this.bodegaSeleccionada);
        this.bodegas.remove(this.bodegaSeleccionada);
    }

    public void cancelar() {
        this.desplegarNuevo = false;
    }
    public void cargarSucursales(){
        this.sucursales = this.sucursalServicio.obtenerSurcursalesE(codEmpresa.getIdEmpresa());
    }

    public void onRowSelect(SelectEvent event) {

    }

    public void onRowUnselect(UnselectEvent event) {

    }

    public List<Sucursal> getSucursales() {
        return sucursales;
    }

    public void setSucursales(List<Sucursal> sucursales) {
        this.sucursales = sucursales;
    }

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<Empresa> empresas) {
        this.empresas = empresas;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public List<Bodega> getBodegas() {
        return bodegas;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }

    public Bodega getBodegaSeleccionada() {
        return bodegaSeleccionada;
    }

    public void setBodegaSeleccionada(Bodega bodegaSeleccionada) {
        this.bodegaSeleccionada = bodegaSeleccionada;
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

    public Empresa getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(Empresa codEmpresa) {
        this.codEmpresa = codEmpresa;
    }
    
    
    
}

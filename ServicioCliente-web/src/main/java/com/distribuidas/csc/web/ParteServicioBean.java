/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.web;

import com.distribuidas.csc.persistencia.Contacto;
import com.distribuidas.csc.persistencia.ParteServicio;
import com.distribuidas.csc.persistencia.Producto;
import com.distribuidas.csc.persistencia.SolicitudServicio;
import com.distribuidas.csc.persistencia.Sucursal;
import com.distribuidas.csc.persistencia.Tecnico;
import com.distribuidas.csc.servicio.ContactoServicio;
import com.distribuidas.csc.servicio.DetalleParteServicioServicio;
import com.distribuidas.csc.servicio.HorarioServicioServicio;
import com.distribuidas.csc.servicio.ParteServicioServicio;
import com.distribuidas.csc.servicio.ProductoServicio;
import com.distribuidas.csc.servicio.SolicitudServicioServicio;
import com.distribuidas.csc.servicio.SucursalServicio;
import com.distribuidas.csc.servicio.TecnicoServicio;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author Stephen
 */
@ManagedBean
@ViewScoped
public class ParteServicioBean implements Serializable {

    @EJB
    private ParteServicioServicio parteServicioServicio;
    @ManagedProperty(value = "#{solicitudServicio}")
    private SolicitudServicioBean solicitudServicio;

    @EJB
    private ContactoServicio contactoServicio;
    @EJB
    private HorarioServicioServicio horarioServicioServicio;
    @EJB
    private DetalleParteServicioServicio detalleParteServicioServicio;
    @EJB
    private SucursalServicio sucursalServicio;
    @EJB
    private ProductoServicio productoServicio;

    @EJB
    private SolicitudServicioServicio solicitudServicioServicio;

    @EJB
    private TecnicoServicio tecnicoServicio;

    private double totalHoras;
    private List<ParteServicio> parteServicios;
    private List<Sucursal> sucursales;
    private List<Producto> productos;
    private List<Contacto> contactos;
    private List<SolicitudServicio> solicitudServicios;
    private List<Tecnico> tecnicos;
    private ParteServicio parteServicio;
    private ParteServicio parteServicioSeleccionado;

    private Boolean desplegarVista = false;
    private Boolean desplegarNuevo = false;

    private String tituloFormulario;
    private Boolean enNuevo;
    private Boolean enModificar;
    private Boolean parteFirmado = true;
    private Integer idSolicitud;

    private Boolean activarNuevo;
    private Boolean activarModificar;
    private Boolean activarEliminar;
    private Boolean activarCambiarEstado;

    @PostConstruct
    public void init() {
        this.solicitudServicios = new ArrayList<>();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
        this.idSolicitud = (Integer) session.getAttribute("idSolicitud");
        System.out.println(this.idSolicitud);
        this.parteServicios = this.parteServicioServicio.obtenerParteS(this.idSolicitud);
        System.out.println(this.parteServicios.get(0));
        this.contactos = this.contactoServicio.obtenerContactosE(this.parteServicios.get(0).getIdEmpresa().getIdEmpresa());
        this.sucursales = this.sucursalServicio.obtenerSurcursalesE(this.parteServicios.get(0).getIdEmpresa().getIdEmpresa());
        this.productos = this.productoServicio.obtenerProductoB(this.parteServicios.get(0).getIdSolicitudservicio().getIdBodega().getIdBodega());
        this.tecnicos = this.tecnicoServicio.obtenerTodos();
        this.solicitudServicios.add(this.parteServicios.get(0).getIdSolicitudservicio());

        if (this.parteServicios.get(0).getFirmaParteservicio()) {
            parteFirmado = false;
        } else {
            parteFirmado = true;
        }
    }

    public void vista() {
        this.desplegarVista = true;
    }

    public String editar() {
        this.calcularHoras();
        this.parteServicios.get(0).getIdHorarioservicio().setTotalHorarioservicio(BigDecimal.valueOf(totalHoras));
        this.parteServicios.get(0).setFirmaParteservicio(true);
        this.horarioServicioServicio.actualizar(this.parteServicios.get(0).getIdHorarioservicio());
        this.detalleParteServicioServicio.actualizar(this.parteServicios.get(0).getIdDetalleParteservicio());
        this.parteServicioServicio.actualizar(this.parteServicios.get(0));
        return "parteServicio";
    }

    public void nuevo() {
        this.desplegarNuevo = true;
        this.enNuevo = true;
        this.enModificar = false;
        this.parteServicio = new ParteServicio();
    }

    public void guardar() {
        if (this.enNuevo) {
            this.parteServicioServicio.crear(this.parteServicio);
            this.desplegarNuevo = false;
            this.parteServicios.add(this.parteServicio);
            this.enNuevo = false;
        } else if (this.enModificar) {
            System.err.println("modificar");
            this.parteServicioServicio.actualizar(this.parteServicio);
            this.desplegarNuevo = false;
            this.enModificar = false;
        }
    }

    public void modificar() {
        this.enModificar = true;
        this.enNuevo = false;
        this.desplegarNuevo = true;
        this.parteServicio = this.parteServicioSeleccionado;
    }

    public void eliminar() {
        this.parteServicioServicio.eliminar(this.parteServicioSeleccionado);
        this.parteServicios.remove(this.parteServicioSeleccionado);
    }

    public void cancelar() {
        this.desplegarNuevo = false;
    }

    public void calcularHoras() {
        Date Fecha_Inicio = this.parteServicios.get(0).getIdHorarioservicio().getInicioHorarioservicio();
        Date Fecha_Fin = this.parteServicios.get(0).getIdHorarioservicio().getFinHorarioservicio();
        long dias = (Fecha_Fin.getTime() - Fecha_Inicio.getTime()) / (24 * 60 * 60 * 1000);
        long horas = (Fecha_Fin.getTime() - Fecha_Inicio.getTime()) / (60 * 60 * 1000) % 24;
        long minutos = (Fecha_Fin.getTime() - Fecha_Inicio.getTime()) / (60 * 1000) % 60;
        long segundos = (Fecha_Fin.getTime() - Fecha_Inicio.getTime()) / (1000) % 60;
        totalHoras = (dias * 24) + (horas) + (minutos / 60) + (segundos / 3600);

        System.out.println("Inicio: " + Fecha_Inicio.getTime());
        System.out.println("Fin: " + Fecha_Fin.getTime());
        System.out.println("Total dias: " + dias);
        System.out.println("Total horas: " + horas);
        System.out.println("Total minutos: " + minutos);
        System.out.println("Total segundos: " + segundos);
        System.out.println("Total: " + totalHoras);
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

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public SolicitudServicioBean getSolicitudServicio() {
        return solicitudServicio;
    }

    public void setSolicitudServicio(SolicitudServicioBean solicitudServicio) {
        this.solicitudServicio = solicitudServicio;
    }

    public Integer getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public List<ParteServicio> getParteServicios() {
        return parteServicios;
    }

    public ParteServicio getParteServicio() {
        return parteServicio;
    }

    public void setParteServicio(ParteServicio parteServicio) {
        this.parteServicio = parteServicio;
    }

    public ParteServicio getParteServicioSeleccionado() {
        return parteServicioSeleccionado;
    }

    public void setParteServicioSeleccionado(ParteServicio parteServicioSeleccionado) {
        this.parteServicioSeleccionado = parteServicioSeleccionado;
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

    public List<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(List<Contacto> contactos) {
        this.contactos = contactos;
    }

    public List<SolicitudServicio> getSolicitudServicios() {
        return solicitudServicios;
    }

    public void setSolicitudServicios(List<SolicitudServicio> solicitudServicios) {
        this.solicitudServicios = solicitudServicios;
    }

    public List<Tecnico> getTecnicos() {
        return tecnicos;
    }

    public void setTecnicos(List<Tecnico> tecnicos) {
        this.tecnicos = tecnicos;
    }

    public Boolean getParteFirmado() {
        return parteFirmado;
    }

    public void setParteFirmado(Boolean parteFirmado) {
        this.parteFirmado = parteFirmado;
    }

}

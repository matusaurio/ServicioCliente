/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.servicio;

import com.distribuidas.csc.dao.DetalleParteServicioFacade;
import com.distribuidas.csc.persistencia.DetalleParteServicio;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 *
 * @author Stephen
 */
@Stateless
@LocalBean
public class DetalleParteServicioServicio {
    
    @EJB
    private DetalleParteServicioFacade detalleParteServicioFacade;

    public List<DetalleParteServicio> obtenerTodos() {
        return this.detalleParteServicioFacade.findAll();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void crear(DetalleParteServicio detalleParteServicio) {
        this.detalleParteServicioFacade.create(detalleParteServicio);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void actualizar(DetalleParteServicio detalleParteServicio) {
        this.detalleParteServicioFacade.edit(detalleParteServicio);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void eliminar(DetalleParteServicio detalleParteServicio) {
        DetalleParteServicio detalleParteServicioTmp = this.detalleParteServicioFacade.find(detalleParteServicio.getIdDetalleParteservicio());
        if (detalleParteServicioTmp != null) {
            this.detalleParteServicioFacade.remove(detalleParteServicioTmp);
        }
    }
    
}

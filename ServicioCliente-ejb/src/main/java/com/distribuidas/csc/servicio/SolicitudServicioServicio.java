/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.servicio;

import com.distribuidas.csc.dao.SolicitudServicioFacade;
import com.distribuidas.csc.persistencia.SolicitudServicio;
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
public class SolicitudServicioServicio {
    @EJB
    private SolicitudServicioFacade solicitudServicioFacade;

    public List<SolicitudServicio> obtenerTodos() {
        return this.solicitudServicioFacade.findAll();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void crear(SolicitudServicio solicitudServicio) {
        this.solicitudServicioFacade.create(solicitudServicio);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void actualizar(SolicitudServicio solicitudServicio) {
        this.solicitudServicioFacade.edit(solicitudServicio);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void eliminar(SolicitudServicio solicitudServicio) {
        SolicitudServicio solicitudServicioTmp = this.solicitudServicioFacade.find(solicitudServicio.getIdSolicitudservicio());
        if (solicitudServicioTmp != null) {
            this.solicitudServicioFacade.remove(solicitudServicioTmp);
        }
    }
}

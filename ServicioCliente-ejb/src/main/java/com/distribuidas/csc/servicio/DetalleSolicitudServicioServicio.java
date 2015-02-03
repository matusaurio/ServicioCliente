/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.servicio;

import com.distribuidas.csc.dao.DetalleSolicitudServicioFacade;
import com.distribuidas.csc.persistencia.DetalleSolicitudServicio;
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
public class DetalleSolicitudServicioServicio {
    
    @EJB
    private DetalleSolicitudServicioFacade detalleSolicitudServicioFacade;

    public List<DetalleSolicitudServicio> obtenerTodos() {
        return this.detalleSolicitudServicioFacade.findAll();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void crear(DetalleSolicitudServicio detalleSolicitudServicio) {
        this.detalleSolicitudServicioFacade.create(detalleSolicitudServicio);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void actualizar(DetalleSolicitudServicio detalleSolicitudServicio) {
        this.detalleSolicitudServicioFacade.edit(detalleSolicitudServicio);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void eliminar(DetalleSolicitudServicio detalleSolicitudServicio) {
        DetalleSolicitudServicio detalleSolicitudServicioTmp = this.detalleSolicitudServicioFacade.find(detalleSolicitudServicio.getIdDetalleSolicitudservicio());
        if (detalleSolicitudServicioTmp != null) {
            this.detalleSolicitudServicioFacade.remove(detalleSolicitudServicioTmp);
        }
    }
    
}

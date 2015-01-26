/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.servicio;

import com.distribuidas.csc.dao.TipoServicioFacade;
import com.distribuidas.csc.persistencia.TipoServicio;
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
public class TipoServicioServicio {
    
    @EJB
    private TipoServicioFacade tipoServicioFacade;

    public List<TipoServicio> obtenerTodos() {
        return this.tipoServicioFacade.findAll();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void crear(TipoServicio tipoServicio) {
        this.tipoServicioFacade.create(tipoServicio);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void actualizar(TipoServicio tipoServicio) {
        this.tipoServicioFacade.edit(tipoServicio);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void eliminar(TipoServicio tipoServicio) {
        TipoServicio tipoServicioTmp = this.tipoServicioFacade.find(tipoServicio.getIdTipoServicioSolicitudservicio());
        if (tipoServicioTmp != null) {
            this.tipoServicioFacade.remove(tipoServicioTmp);
        }
    }
    
}

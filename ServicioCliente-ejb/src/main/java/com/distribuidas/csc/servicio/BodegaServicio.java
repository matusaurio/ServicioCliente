/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.servicio;

import com.distribuidas.csc.dao.BodegaFacade;
import com.distribuidas.csc.persistencia.Bodega;
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
public class BodegaServicio {
    
    @EJB
    private BodegaFacade bodegaFacade;

    public List<Bodega> obtenerTodos() {
        return this.bodegaFacade.findAll();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void crear(Bodega bodega) {
        this.bodegaFacade.create(bodega);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void actualizar(Bodega bodega) {
        this.bodegaFacade.edit(bodega);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void eliminar(Bodega bodega) {
        Bodega bodegaTmp = this.bodegaFacade.find(bodega.getIdBodega());
        if (bodegaTmp != null) {
            this.bodegaFacade.remove(bodegaTmp);
        }
    }
    
}

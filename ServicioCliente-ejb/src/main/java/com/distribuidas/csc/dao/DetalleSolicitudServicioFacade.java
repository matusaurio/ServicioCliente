/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.dao;

import com.distribuidas.csc.persistencia.DetalleSolicitudServicio;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Stephen
 */
@Stateless
public class DetalleSolicitudServicioFacade extends AbstractFacade<DetalleSolicitudServicio> {
    @PersistenceContext(unitName = "com.distribuidas_ServicioCliente-ejb_ejb_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleSolicitudServicioFacade() {
        super(DetalleSolicitudServicio.class);
    }
    
}

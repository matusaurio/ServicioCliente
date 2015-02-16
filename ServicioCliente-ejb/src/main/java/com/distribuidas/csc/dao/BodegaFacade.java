/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.dao;

import com.distribuidas.csc.persistencia.Bodega;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Stephen
 */
@Stateless
public class BodegaFacade extends AbstractFacade<Bodega> {
    @PersistenceContext(unitName = "com.distribuidas_ServicioCliente-ejb_ejb_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BodegaFacade() {
        super(Bodega.class);
    }
    
    public List<Bodega> findBySucursal(Integer codSucursal) {
        try{
        Query qry = this.em.createQuery(
                "SELECT obj FROM Bodega obj WHERE obj.idSucursal.idSucursal=?1");
        qry.setParameter(1, codSucursal);
        return qry.getResultList();
        }
        catch(Exception e)
        {
            
            System.out.println(e);
        }
        return null;
    }
    
}

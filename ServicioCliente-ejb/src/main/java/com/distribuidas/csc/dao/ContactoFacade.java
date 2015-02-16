/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.dao;

import com.distribuidas.csc.persistencia.Contacto;
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
public class ContactoFacade extends AbstractFacade<Contacto> {
    @PersistenceContext(unitName = "com.distribuidas_ServicioCliente-ejb_ejb_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContactoFacade() {
        super(Contacto.class);
    }
    
    public List<Contacto> findByEmpresa(Integer codEmpresa) {
        try{
        Query qry = this.em.createQuery(
                "SELECT obj FROM Contacto obj WHERE obj.idEmpresa.idEmpresa=?1");
        qry.setParameter(1, codEmpresa);
        return qry.getResultList();
        }
        catch(Exception e)
        {
            
            System.out.println(e);
        }
        return null;
    }
}

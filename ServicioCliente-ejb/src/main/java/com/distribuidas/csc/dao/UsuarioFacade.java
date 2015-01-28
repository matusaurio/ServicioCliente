/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.dao;

import com.distribuidas.csc.persistencia.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Stephen
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "com.distribuidas_ServicioCliente-ejb_ejb_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    public Usuario login(String email, String password) {
        Query qry = this.em.createQuery("SELECT u FROM Usuario u "
                                      + "WHERE u.mailUsuario=?1 AND u.passUsuario=?2");
        qry.setParameter(1, email);
        qry.setParameter(2, password);
        return qry.getResultList().isEmpty() ? null : (Usuario)qry.getSingleResult();
    }
}

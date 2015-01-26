/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.servicio;

import com.distribuidas.csc.dao.UsuarioFacade;
import com.distribuidas.csc.persistencia.Usuario;
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
public class UsuarioServicio {
    
    @EJB
    private UsuarioFacade usuarioFacade;

    public List<Usuario> obtenerTodos() {
        return this.usuarioFacade.findAll();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void crear(Usuario usuario) {
        this.usuarioFacade.create(usuario);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void actualizar(Usuario usuario) {
        this.usuarioFacade.edit(usuario);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void eliminar(Usuario usuario) {
        Usuario usuarioTmp = this.usuarioFacade.find(usuario.getIdUsuario());
        if (usuarioTmp != null) {
            this.usuarioFacade.remove(usuarioTmp);
        }
    }
    
}

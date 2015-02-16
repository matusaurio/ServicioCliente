/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.servicio;

import com.distribuidas.csc.dao.ContactoFacade;
import com.distribuidas.csc.persistencia.Contacto;
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
public class ContactoServicio {
    
    @EJB
    private ContactoFacade contactoFacade;
    
    public List<Contacto> obtenerTodos(){
        return this.contactoFacade.findAll();
    }
    
    public List<Contacto> obtenerContactosE(Integer codEmpresa){
        return this.contactoFacade.findByEmpresa(codEmpresa);
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void crear(Contacto contacto){
        this.contactoFacade.create(contacto);
    }
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void actualizar(Contacto contacto){
        this.contactoFacade.edit(contacto);
    }
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void eliminar(Contacto contacto){
        Contacto contactoTmp = this.contactoFacade.find(contacto.getIdContacto());
        if (contactoTmp!=null){
            this.contactoFacade.remove(contactoTmp);
        }
    }
    
}

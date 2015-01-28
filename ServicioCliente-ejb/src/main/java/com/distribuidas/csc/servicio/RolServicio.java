/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.servicio;

import com.distribuidas.csc.dao.RolFacade;
import com.distribuidas.csc.persistencia.Rol;
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
public class RolServicio {
    
    @EJB
    private RolFacade rolFacade;
    
    public List<Rol> obtenerTodos(){
        return this.rolFacade.findAll();
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void crear(Rol rol){
        this.rolFacade.create(rol);
    }
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void actualizar(Rol rol){
        this.rolFacade.edit(rol);
    }
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void eliminar(Rol rol){
        Rol rolTmp = this.rolFacade.find(rol.getIdRol());
        if (rolTmp!=null){
            this.rolFacade.remove(rolTmp);
        }
    }
    
}

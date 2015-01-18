/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.servicio;

import com.distribuidas.csc.DAO.CiudadFacade;
import com.distribuidas.csc.persistencia.Ciudad;
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
public class CiudadServicio {
    
    @EJB
    private CiudadFacade ciudadFacade;
    
    public List<Ciudad> obtenerTodos(){
        return this.ciudadFacade.findAll();
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void crear(Ciudad ciudad){
        this.ciudadFacade.create(ciudad);
    }
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void actualizar(Ciudad ciudad){
        this.ciudadFacade.edit(ciudad);
    }
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void eliminar(Ciudad ciudad){
        Ciudad ciudadTmp = this.ciudadFacade.find(ciudad.getIdCiudad());
        if (ciudadTmp!=null){
            this.ciudadFacade.remove(ciudadTmp);
        }
    }
}

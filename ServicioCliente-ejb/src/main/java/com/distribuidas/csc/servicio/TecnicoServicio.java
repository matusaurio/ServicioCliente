/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.servicio;

import com.distribuidas.csc.dao.TecnicoFacade;
import com.distribuidas.csc.persistencia.Tecnico;
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
public class TecnicoServicio {
    
    @EJB
    private TecnicoFacade tecnicoFacade;
    
    public List<Tecnico> obtenerTodos(){
        return this.tecnicoFacade.findAll();
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void crear(Tecnico tecnico){
        this.tecnicoFacade.create(tecnico);
    }
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void actualizar(Tecnico tecnico){
        this.tecnicoFacade.edit(tecnico);
    }
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void eliminar(Tecnico tecnico){
        Tecnico tecnicoTmp = this.tecnicoFacade.find(tecnico.getIdTecnico());
        if (tecnicoTmp!=null){
            this.tecnicoFacade.remove(tecnicoTmp);
        }
    }
    
}

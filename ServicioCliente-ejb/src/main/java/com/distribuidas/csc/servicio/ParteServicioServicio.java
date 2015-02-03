/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.servicio;

import com.distribuidas.csc.dao.ParteServicioFacade;
import com.distribuidas.csc.persistencia.ParteServicio;
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
public class ParteServicioServicio {
    
    @EJB
    private ParteServicioFacade parteServicioFacade;

    public List<ParteServicio> obtenerTodos() {
        return this.parteServicioFacade.findAll();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void crear(ParteServicio parteServicio) {
        this.parteServicioFacade.create(parteServicio);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void actualizar(ParteServicio parteServicio) {
        this.parteServicioFacade.edit(parteServicio);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void eliminar(ParteServicio parteServicio) {
        ParteServicio parteServicioTmp = this.parteServicioFacade.find(parteServicio.getIdParteservicio());
        if (parteServicioTmp != null) {
            this.parteServicioFacade.remove(parteServicioTmp);
        }
    }
    
}

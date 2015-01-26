/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.servicio;

import com.distribuidas.csc.dao.EstadoFacade;
import com.distribuidas.csc.persistencia.Estado;
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
public class EstadoServicio {
    @EJB
    private EstadoFacade estadoFacade;

    public List<Estado> obtenerTodos() {
        return this.estadoFacade.findAll();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void crear(Estado estado) {
        this.estadoFacade.create(estado);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void actualizar(Estado estado) {
        this.estadoFacade.edit(estado);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void eliminar(Estado estado) {
        Estado estadoTmp = this.estadoFacade.find(estado.getIdEstadoSolicitudservicio());
        if (estadoTmp != null) {
            this.estadoFacade.remove(estadoTmp);
        }
    }
}

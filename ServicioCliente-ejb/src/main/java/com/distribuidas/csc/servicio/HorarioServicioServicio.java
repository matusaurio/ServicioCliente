/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.servicio;

import com.distribuidas.csc.dao.HorarioServicioFacade;
import com.distribuidas.csc.persistencia.HorarioServicio;
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
public class HorarioServicioServicio {
    
    @EJB
    private HorarioServicioFacade horarioServicioFacade;

    public List<HorarioServicio> obtenerTodos() {
        return this.horarioServicioFacade.findAll();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void crear(HorarioServicio horarioServicio) {
        this.horarioServicioFacade.create(horarioServicio);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void actualizar(HorarioServicio horarioServicio) {
        this.horarioServicioFacade.edit(horarioServicio);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void eliminar(HorarioServicio horarioServicio) {
        HorarioServicio horarioServicioTmp = this.horarioServicioFacade.find(horarioServicio.getIdHorarioservicio());
        if (horarioServicioTmp != null) {
            this.horarioServicioFacade.remove(horarioServicioTmp);
        }
    }
    
}

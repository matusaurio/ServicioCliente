/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.servicio;

import com.distribuidas.csc.dao.MarcaVerificacionFacade;
import com.distribuidas.csc.persistencia.MarcaVerificacion;
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
public class MarcaVerificacionServicio {
    
    @EJB
    private MarcaVerificacionFacade marcaVerificacionFacade;

    public List<MarcaVerificacion> obtenerTodos() {
        return this.marcaVerificacionFacade.findAll();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void crear(MarcaVerificacion marcaVerificacion) {
        this.marcaVerificacionFacade.create(marcaVerificacion);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void actualizar(MarcaVerificacion marcaVerificacion) {
        this.marcaVerificacionFacade.edit(marcaVerificacion);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void eliminar(MarcaVerificacion marcaVerificacion) {
        MarcaVerificacion marcaVerificacionTmp = this.marcaVerificacionFacade.find(marcaVerificacion.getIdMarcaverificacion());
        if (marcaVerificacionTmp != null) {
            this.marcaVerificacionFacade.remove(marcaVerificacionTmp);
        }
    }
    
}

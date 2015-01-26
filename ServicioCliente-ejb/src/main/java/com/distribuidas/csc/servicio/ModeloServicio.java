/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.servicio;

import com.distribuidas.csc.dao.ModeloFacade;
import com.distribuidas.csc.persistencia.Modelo;
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
public class ModeloServicio {
    @EJB
    private ModeloFacade modeloFacade;

    public List<Modelo> obtenerTodos() {
        return this.modeloFacade.findAll();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void crear(Modelo modelo) {
        this.modeloFacade.create(modelo);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void actualizar(Modelo modelo) {
        this.modeloFacade.edit(modelo);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void eliminar(Modelo modelo) {
        Modelo modeloTmp = this.modeloFacade.find(modelo.getIdMarca());
        if (modeloTmp != null) {
            this.modeloFacade.remove(modeloTmp);
        }
    }
}

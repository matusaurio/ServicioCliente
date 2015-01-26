/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.servicio;

import com.distribuidas.csc.dao.MarcaFacade;
import com.distribuidas.csc.persistencia.Marca;
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
public class MarcaServicio {
    
    @EJB
    private MarcaFacade marcaFacade;

    public List<Marca> obtenerTodos() {
        return this.marcaFacade.findAll();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void crear(Marca marca) {
        this.marcaFacade.create(marca);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void actualizar(Marca marca) {
        this.marcaFacade.edit(marca);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void eliminar(Marca marca) {
        Marca marcaTmp = this.marcaFacade.find(marca.getIdMarca());
        if (marcaTmp != null) {
            this.marcaFacade.remove(marcaTmp);
        }
    }
    
}

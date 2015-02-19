/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.servicio;

import com.distribuidas.csc.dao.ProductoFacade;
import com.distribuidas.csc.persistencia.Producto;
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
public class ProductoServicio {
    
    @EJB
    private ProductoFacade productoFacade;

    public List<Producto> obtenerTodos() {
        return this.productoFacade.findAll();
    }
    
    public List<Producto> obtenerProductoB(Integer codBodega){
        return this.productoFacade.findByBodega(codBodega);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void crear(Producto producto) {
        this.productoFacade.create(producto);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void actualizar(Producto producto) {
        this.productoFacade.edit(producto);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void eliminar(Producto producto) {
        Producto productoTmp = this.productoFacade.find(producto.getIdProducto());
        if (productoTmp != null) {
            this.productoFacade.remove(productoTmp);
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.servicio;

import com.distribuidas.csc.dao.SucursalFacade;
import com.distribuidas.csc.persistencia.Sucursal;
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
public class SucursalServicio {
    
    @EJB
    private SucursalFacade sucursalFacade;

    public List<Sucursal> obtenerTodos() {
        return this.sucursalFacade.findAll();
    }
    
    public List<Sucursal> obtenerSurcursalesE(Integer condEmpresa) {
        return this.sucursalFacade.findByEmpresa(condEmpresa);
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void crear(Sucursal sucursal) {
        this.sucursalFacade.create(sucursal);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void actualizar(Sucursal sucursal) {
        this.sucursalFacade.edit(sucursal);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void eliminar(Sucursal sucursal) {
        Sucursal sucursalTmp = this.sucursalFacade.find(sucursal.getIdSucursal());
        if (sucursalTmp != null) {
            this.sucursalFacade.remove(sucursalTmp);
        }
    }
    
}

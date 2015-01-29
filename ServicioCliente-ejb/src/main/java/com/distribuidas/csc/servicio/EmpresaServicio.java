/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.servicio;


import com.distribuidas.csc.dao.EmpresaFacade;
import com.distribuidas.csc.persistencia.Empresa;
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
public class EmpresaServicio {

    @EJB
    private EmpresaFacade empresaFacade;

    public List<Empresa> obtenerTodos() {
        return this.empresaFacade.findAll();
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void crear(Empresa empresa) {
        this.empresaFacade.create(empresa);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void actualizar(Empresa empresa) {
        this.empresaFacade.edit(empresa);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void eliminar(Empresa empresa) {
        Empresa empresaTmp = this.empresaFacade.find(empresa.getIdEmpresa());
        if (empresaTmp != null) {
            this.empresaFacade.remove(empresaTmp);
        }
    }
}

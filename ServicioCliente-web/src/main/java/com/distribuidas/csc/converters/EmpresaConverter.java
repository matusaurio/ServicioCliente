/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.converters;

import com.distribuidas.csc.dao.EmpresaFacade;
import com.distribuidas.csc.persistencia.Empresa;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Stephen
 */
@FacesConverter(value="empresaConverter", forClass = com.distribuidas.csc.persistencia.Empresa.class)
public class EmpresaConverter implements Converter{

    @EJB
    private EmpresaFacade empresaFacade;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        int empresaId;
        try {            
            empresaId = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Error EmpresaConverter", "Please try again!"));
        }
        return empresaFacade.find(empresaId);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Empresa empresa = null;
        if(value instanceof Empresa){
            empresa = (Empresa) value;
            StringBuilder asString = new StringBuilder();
            asString.append(empresa.getIdEmpresa());
            return asString.toString();
        }
        return "";
    }
    
}

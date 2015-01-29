/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.converters;

import com.distribuidas.csc.dao.SucursalFacade;
import com.distribuidas.csc.persistencia.Sucursal;
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
@FacesConverter(value="sucursalConverter", forClass = com.distribuidas.csc.persistencia.Sucursal.class)
public class SucursalConverter implements Converter{

    @EJB
    private SucursalFacade sucursalFacade;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        int sucursalId;
        try {            
            sucursalId = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Error SucursalConverter", "Please try again!"));
        }
        return sucursalFacade.find(sucursalId);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Sucursal sucursal = null;
        if(value instanceof Sucursal){
            sucursal = (Sucursal) value;
            StringBuilder asString = new StringBuilder();
            asString.append(sucursal.getIdSucursal());
            return asString.toString();
        }
        return "";
    }
    
}

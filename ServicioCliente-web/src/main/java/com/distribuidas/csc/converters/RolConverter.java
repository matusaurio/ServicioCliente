/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.converters;

import com.distribuidas.csc.dao.RolFacade;
import com.distribuidas.csc.persistencia.Rol;
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
@FacesConverter(value="rolConverter", forClass = com.distribuidas.csc.persistencia.Rol.class)
public class RolConverter implements Converter{

    @EJB
    private RolFacade rolFacade;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String submittedValue){
        int rolId;
        try {            
            rolId = Integer.parseInt(submittedValue);
        } catch (NumberFormatException e) {
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Error CiudadConverter", "Please try again!"));
        }
        return rolFacade.find(rolId);
    }
    
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object modelValue){
        Rol rol = null;
        if(modelValue instanceof Rol){
            rol = (Rol) modelValue;
            StringBuilder asString = new StringBuilder();
            asString.append(rol.getIdRol());
            return asString.toString();
        }
        return "";
    }
    
}

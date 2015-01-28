/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.converters;

import com.distribuidas.csc.dao.CiudadFacade;
import com.distribuidas.csc.persistencia.Ciudad;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Santiago
 */
@FacesConverter(value="ciudadConverter", forClass = com.distribuidas.csc.persistencia.Ciudad.class)
public class CiudadConverter implements Converter {
    
    @EJB
    private CiudadFacade ciudadFacade;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String submittedValue){
        int ciudadId;
        try {
            //mierda entra dos veces pero no se xk 
            
            ciudadId = Integer.parseInt(submittedValue);
        } catch (NumberFormatException e) {
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Error CiudadConverter", "Please try again!"));
        }
        return ciudadFacade.find(ciudadId);
    }
    
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object modelValue){
        Ciudad ciudad = null;
        if(modelValue instanceof Ciudad){
            ciudad = (Ciudad) modelValue;
            StringBuilder asString = new StringBuilder();
            asString.append(ciudad.getIdCiudad());
            return asString.toString();
        }
        return "";
    }
}

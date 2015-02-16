/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.converters;

import com.distribuidas.csc.dao.ContactoFacade;
import com.distribuidas.csc.persistencia.Contacto;
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
@FacesConverter(value="contactoConverter", forClass = com.distribuidas.csc.persistencia.Contacto.class)
public class ContactoConverter implements Converter{
    
    @EJB
    private ContactoFacade contactoFacade;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String submittedValue){
        int contactoId;
        try {            
            contactoId = Integer.parseInt(submittedValue);
        } catch (NumberFormatException e) {
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Error CiudadConverter", "Please try again!"));
        }
        return contactoFacade.find(contactoId);
    }
    
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object modelValue){
        Contacto contacto = null;
        if(modelValue instanceof Contacto){
            contacto = (Contacto) modelValue;
            StringBuilder asString = new StringBuilder();
            asString.append(contacto.getIdContacto());
            return asString.toString();
        }
        return "";
    }
    
}

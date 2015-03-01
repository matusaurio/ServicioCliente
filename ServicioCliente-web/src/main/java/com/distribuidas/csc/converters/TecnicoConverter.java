/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.converters;

import com.distribuidas.csc.dao.TecnicoFacade;
import com.distribuidas.csc.persistencia.Tecnico;
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
@FacesConverter(value="tecnicoConverter", forClass = com.distribuidas.csc.persistencia.Tecnico.class)
public class TecnicoConverter implements Converter{
    
    @EJB
    private TecnicoFacade tecnicoFacade;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String submittedValue){
        int tecnicoId;
        try {            
            tecnicoId = Integer.parseInt(submittedValue);
        } catch (NumberFormatException e) {
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Error TecnicoConverter", "Please try again!"));
        }
        return tecnicoFacade.find(tecnicoId);
    }
    
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object modelValue){
        Tecnico tecnico = null;
        if(modelValue instanceof Tecnico){
            tecnico = (Tecnico) modelValue;
            StringBuilder asString = new StringBuilder();
            asString.append(tecnico.getIdTecnico());
            return asString.toString();
        }
        return "";
    }
    
}

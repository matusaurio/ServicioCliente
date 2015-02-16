/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.converters;

import com.distribuidas.csc.dao.EstadoFacade;
import com.distribuidas.csc.persistencia.Estado;
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
@FacesConverter(value="estadoConverter", forClass = com.distribuidas.csc.persistencia.Estado.class)
public class EstadoConverter implements Converter{
    
    @EJB
    private EstadoFacade estadoFacade;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String submittedValue){
        int estadoId;
        try {            
            estadoId = Integer.parseInt(submittedValue);
        } catch (NumberFormatException e) {
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Error CiudadConverter", "Please try again!"));
        }
        return estadoFacade.find(estadoId);
    }
    
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object modelValue){
        Estado estado = null;
        if(modelValue instanceof Estado){
            estado = (Estado) modelValue;
            StringBuilder asString = new StringBuilder();
            asString.append(estado.getIdEstadoSolicitudservicio());
            return asString.toString();
        }
        return "";
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.converters;

import com.distribuidas.csc.dao.BodegaFacade;
import com.distribuidas.csc.persistencia.Bodega;
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
@FacesConverter(value="ciudadConverter", forClass = com.distribuidas.csc.persistencia.Bodega.class)
public class BodegaConverter implements Converter{
    
    @EJB
    private BodegaFacade bodegaFacade;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String submittedValue){
        int bodegaId;
        try {            
            bodegaId = Integer.parseInt(submittedValue);
        } catch (NumberFormatException e) {
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Error CiudadConverter", "Please try again!"));
        }
        return bodegaFacade.find(bodegaId);
    }
    
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object modelValue){
        Bodega bodega = null;
        if(modelValue instanceof Bodega){
            bodega = (Bodega) modelValue;
            StringBuilder asString = new StringBuilder();
            asString.append(bodega.getIdBodega());
            return asString.toString();
        }
        return "";
    }
    
}

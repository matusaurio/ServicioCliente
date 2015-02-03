/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.converters;

import com.distribuidas.csc.dao.ModeloFacade;
import com.distribuidas.csc.persistencia.Modelo;
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
@FacesConverter(value="modeloConverter", forClass = com.distribuidas.csc.persistencia.Modelo.class)
public class ModeloConverter implements Converter{
    
    @EJB
    private ModeloFacade modeloFacade;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String submittedValue){
        int modeloId;
        try {            
            modeloId = Integer.parseInt(submittedValue);
        } catch (NumberFormatException e) {
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Error CiudadConverter", "Please try again!"));
        }
        return modeloFacade.find(modeloId);
    }
    
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object modelValue){
        Modelo modelo = null;
        if(modelValue instanceof Modelo){
            modelo = (Modelo) modelValue;
            StringBuilder asString = new StringBuilder();
            asString.append(modelo.getIdModelo());
            return asString.toString();
        }
        return "";
    }
    
}

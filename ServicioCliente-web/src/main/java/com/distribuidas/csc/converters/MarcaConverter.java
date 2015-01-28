/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.converters;

import com.distribuidas.csc.dao.MarcaFacade;
import com.distribuidas.csc.persistencia.Marca;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

/**
 *
 * @author Stephen
 */
@FacesConverter(value="marcaConverter", forClass = com.distribuidas.csc.persistencia.Marca.class)
public class MarcaConverter implements Converter{
    
    @EJB
    private MarcaFacade marcaFacade;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        int marcaId;
        try {            
            marcaId = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Error MarcaConverter", "Please try again!"));
        }
        return marcaFacade.find(marcaId);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Marca marca = null;
        if(value instanceof Marca){
            marca = (Marca) value;
            StringBuilder asString = new StringBuilder();
            asString.append(marca.getIdMarca());
            return asString.toString();
        }
        return "";
    }
    
}

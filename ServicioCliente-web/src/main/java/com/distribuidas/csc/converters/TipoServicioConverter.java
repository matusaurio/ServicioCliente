/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.converters;

import com.distribuidas.csc.dao.TipoServicioFacade;
import com.distribuidas.csc.persistencia.TipoServicio;
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
@FacesConverter(value="tipoServicioConverter", forClass = com.distribuidas.csc.persistencia.TipoServicio.class)
public class TipoServicioConverter implements Converter{
    @EJB
    private TipoServicioFacade tipoServicioFacade;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String submittedValue){
        int tipoServicioId;
        try {            
            tipoServicioId = Integer.parseInt(submittedValue);
        } catch (NumberFormatException e) {
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Error CiudadConverter", "Please try again!"));
        }
        return tipoServicioFacade.find(tipoServicioId);
    }
    
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object modelValue){
        TipoServicio tipoServicio = null;
        if(modelValue instanceof TipoServicio){
            tipoServicio = (TipoServicio) modelValue;
            StringBuilder asString = new StringBuilder();
            asString.append(tipoServicio.getIdTipoServicioSolicitudservicio());
            return asString.toString();
        }
        return "";
    }
}

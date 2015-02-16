/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.converters;

import com.distribuidas.csc.dao.UsuarioFacade;
import com.distribuidas.csc.persistencia.Usuario;
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
@FacesConverter(value="usuarioConverter", forClass = com.distribuidas.csc.persistencia.Ciudad.class)
public class UsuarioConverter implements Converter{
    
    @EJB
    private UsuarioFacade usuarioFacade;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String submittedValue){
        int usuarioId;
        try {            
            usuarioId = Integer.parseInt(submittedValue);
        } catch (NumberFormatException e) {
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Error CiudadConverter", "Please try again!"));
        }
        return usuarioFacade.find(usuarioId);
    }
    
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object modelValue){
        Usuario usuario = null;
        if(modelValue instanceof Usuario){
            usuario = (Usuario) modelValue;
            StringBuilder asString = new StringBuilder();
            asString.append(usuario.getIdUsuario());
            return asString.toString();
        }
        return "";
    }
}

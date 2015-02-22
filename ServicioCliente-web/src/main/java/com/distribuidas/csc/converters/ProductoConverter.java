/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.converters;

import com.distribuidas.csc.dao.ProductoFacade;
import com.distribuidas.csc.persistencia.Producto;
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
@FacesConverter(value="productoConverter", forClass = com.distribuidas.csc.persistencia.Producto.class)
public class ProductoConverter implements Converter {
    
    @EJB
    private ProductoFacade productoFacade;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String submittedValue){
        int productoId;
        try {            
            productoId = Integer.parseInt(submittedValue);
        } catch (NumberFormatException e) {
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Error ProductoConverter", "Please try again!"));
        }
        return productoFacade.find(productoId);
    }
    
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object modelValue){
        Producto producto = null;
        if(modelValue instanceof Producto){
            producto = (Producto) modelValue;
            StringBuilder asString = new StringBuilder();
            asString.append(producto.getIdProducto());
            return asString.toString();
        }
        return "";
    }
    
}

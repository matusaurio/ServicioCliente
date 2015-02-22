package com.distribuidas.csc.view;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stephen
 */
@ManagedBean
public class DialogView {
    
    public void enviar(){
        addMessage("Enviado","Se envio a su correo la contraseña");
    }
    
    public void addMessage(String summary, String detail){
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,summary,detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Desenvolvedor01
 */
public class FacesMessageUtil {

    public static void showMessageInDialog(FacesMessage.Severity severity, String titulo, String mensagem) {
        RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(severity, titulo, mensagem));
    }
    
    public static void addMessage(FacesMessage.Severity severity, String titulo, String mensagem) {
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, titulo, mensagem));
    }
    
    public static void addMessageById(String idComponent, FacesMessage.Severity severity, String titulo, String mensagem) {
       FacesContext.getCurrentInstance().addMessage(idComponent, new FacesMessage(severity, titulo, mensagem));
    }

    private FacesMessageUtil() {
    }
}

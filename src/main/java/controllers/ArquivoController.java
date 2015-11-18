/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import dominio.Arquivo;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Desenvolvedor01
 */
@ManagedBean
@RequestScoped
public class ArquivoController {
    private Arquivo arquivo;

    /**
     * Creates a new instance of ArquivoController
     */
    public ArquivoController() {
    }

    public Arquivo getArquivo() {
        return arquivo;
    }

    public void setArquivo(Arquivo arquivo) {
        this.arquivo = arquivo;
    }
}

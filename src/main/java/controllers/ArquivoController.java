/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dominio.Arquivo;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import util.GerenciadorCSV;

/**
 *
 * @author Desenvolvedor01
 */
@ManagedBean(name = "arquivoMB")
@ViewScoped
public class ArquivoController {

    private boolean renderColunas;
    private Arquivo arquivo;
    private UploadedFile file;
    private File fileTemp;
    private List<String> colunas;

    /**
     * Creates a new instance of ArquivoController
     */
    public ArquivoController() {
    }

    public boolean isRenderColunas() {
        return renderColunas;
    }

    public void setRenderColunas(boolean renderColunas) {
        this.renderColunas = renderColunas;
    }
    
    

    public File getFileTemp() {
        return fileTemp;
    }

    public void setFileTemp(File fileTemp) {
        this.fileTemp = fileTemp;
    }

    public List<String> getColunas() {
        return colunas;
    }

    public void setColunas(List<String> colunas) {
        this.colunas = colunas;
    }
    
    

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public Arquivo getArquivo() {
        return arquivo;
    }

    public void setArquivo(Arquivo arquivo) {
        this.arquivo = arquivo;
    }
    
    public void upload(FileUploadEvent event) {
        System.out.println("MÉTODO");
        try {
            String nomeArq = event.getFile().getFileName();
            String fileName = nomeArq;

            nomeArq = fileName.replace(".", ";");

            String[] arrayNomeArq = nomeArq.split(";");

            this.fileTemp = File.createTempFile(arrayNomeArq[0], "." + arrayNomeArq[1]);
            this.fileTemp.deleteOnExit();

            OutputStream out;

            try (InputStream inputStream = event.getFile().getInputstream()) {
                out = new FileOutputStream(new File(this.fileTemp.getAbsolutePath()));
                int byteLido;
                byte[] buffer = new byte[2048];
                while ((byteLido = inputStream.read(buffer)) != -1) {
                    out.write(buffer, 0, byteLido);
                }
            }
            out.flush();
            out.close();
            
            String[] colunas = GerenciadorCSV.getNomeDasColunas(fileTemp);
            
            for (String string : colunas) {
                this.colunas.add(string);
            }
            
            setRenderColunas(true);
        } catch (IOException ex) {
        }
    }
    
    @PostConstruct
    public void onCreate() {
        this.colunas = new ArrayList<>();

    }
}

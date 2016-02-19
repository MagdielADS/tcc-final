/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import controllers.util.FacesMessageUtil;
import dominio.Arquivo;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
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

    private boolean renderColunas, renderCaractere, renderUpload;
    private Arquivo arquivo;
    private UploadedFile file;
    private File fileTemp;
    private List<String> colunas;

    /**
     * Creates a new instance of ArquivoController
     */
    public ArquivoController() {
    }

    public boolean isRenderUpload() {
        return renderUpload;
    }

    public void setRenderUpload(boolean renderUpload) {
        this.renderUpload = renderUpload;
    }
    
    

    public boolean isRenderCaractere() {
        return renderCaractere;
    }

    public void setRenderCaractere(boolean renderCaractere) {
        this.renderCaractere = renderCaractere;
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

    public void verificaExtensaoDoArquivo() {
        if (this.arquivo.getExtensao().equalsIgnoreCase("CSV")) {
            setRenderCaractere(true);
            setRenderUpload(false);
        } else {
            setRenderCaractere(false);
            setRenderUpload(true);
        }
    }
    
    public void soutC(){
        System.out.println("Caracter: "+this.arquivo.getCaractereDetabulacao());
    }
    
    public void habilitarUpload(){
        setRenderUpload(true);
    }

    public void upload(FileUploadEvent event) {
//        System.out.println("MÉTODO");
        System.out.println("Caractere: " + arquivo.getCaractereDetabulacao());
//        System.out.println("Nome: " + arquivo.getNome());
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
                this.arquivo.setCaminho(this.fileTemp.getAbsolutePath());
                int byteLido;
                byte[] buffer = new byte[2048];
                while ((byteLido = inputStream.read(buffer)) != -1) {
                    out.write(buffer, 0, byteLido);
                }
            }
            out.flush();
            out.close();

            String[] colunas = GerenciadorCSV.getNomeDasColunas(fileTemp, arquivo.getCaractereDetabulacao());

            for (String string : colunas) {
                this.colunas.add(string);
            }
            
            setRenderColunas(true);
            System.out.println("Caminho: "+this.arquivo.getCaminho());
        } catch (IOException ex) {
        }
    }
    
    public void salvarArquivo(){
        //PERSISTIR ARQUIVOs
        
        FacesMessageUtil.showMessageInDialog(FacesMessage.SEVERITY_INFO, "Cadastro de Arquivo", "Arquivo cadastrado com sucesso!");
    }

    @PostConstruct
    public void onCreate() {
        this.colunas = new ArrayList<>();
        this.arquivo = new Arquivo();
    }
}

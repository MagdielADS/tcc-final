/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import com.opencsv.CSVReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Desenvolvedor01
 */
public class GerenciadorCSV {
    
    public List<String[]> lerArquivo(String caminho){
        List<String[]> linhas = new ArrayList();
        try {
            CSVReader reader = new CSVReader(new FileReader(caminho));
            linhas = reader.readAll();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GerenciadorCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GerenciadorCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return linhas;
    }
    
    public String[] getNomeDasColunas(String caminho){
        List<String[]> linhas = lerArquivo(caminho);
        return linhas.get(0);
    }
    
    public List<String[]> getValoresDoArquivo(String caminho){
        List<String[]> linhas = lerArquivo(caminho);
        linhas.remove(0);
        return linhas;
    }
    
    public boolean verificarSeColunaExiste(String caminho, String coluna){
        String[] colunas = getNomeDasColunas(caminho);
        boolean result = false;
        for(int i = 0; i < colunas.length; i++){
            if(colunas[i].equals(coluna)){
                result = true;
                break;
            }
        }
        return result;
    }
    
    public int qtdeLinhas(String caminho){
        int result = 0;
        try {
            CSVReader reader = new CSVReader(new FileReader(caminho));
            result = reader.readAll().size();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GerenciadorCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GerenciadorCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}

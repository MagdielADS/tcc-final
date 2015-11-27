/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import com.opencsv.CSVReader;
import java.io.File;
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
    
    public static List<String[]> lerArquivo(File file){
        List<String[]> linhas = new ArrayList();
        try {
            CSVReader reader = new CSVReader(new FileReader(file));
            linhas = reader.readAll();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GerenciadorCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GerenciadorCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return linhas;
    }
    
    public static String[] getNomeDasColunas(File file){
        List<String[]> linhas = lerArquivo(file);
        return linhas.get(0);
    }
    
    public static List<String[]> getValoresDoArquivo(File file){
        List<String[]> linhas = lerArquivo(file);
        linhas.remove(0);
        return linhas;
    }
    
    public static boolean verificarSeColunaExiste(File file, String coluna){
        String[] colunas = getNomeDasColunas(file);
        boolean result = false;
        for(int i = 0; i < colunas.length; i++){
            if(colunas[i].equals(coluna)){
                result = true;
                break;
            }
        }
        return result;
    }
    
    public static int qtdeLinhas(File file){
        int result = 0;
        try {
            CSVReader reader = new CSVReader(new FileReader(file));
            result = reader.readAll().size();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GerenciadorCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GerenciadorCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}

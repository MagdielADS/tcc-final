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
    
    /**
     * 
     * @param file arquivo do tipo CSV
     * @param caracTabulacao char de tabulação, para ser usado no processo de criação do leitor de CSV
     * @return List de Arrays de String, contendo assim para cada item da lista uma linha do arquivo, sendo os índices do Array as colunas separadas da linha. 
     * A primeira linha seria o cabeçalho do arquivo.
     */
    public static List<String[]> lerArquivo(File file, char caracTabulacao){
        List<String[]> linhas = new ArrayList();
        try {
            CSVReader reader = new CSVReader(new FileReader(file),caracTabulacao);
            linhas = reader.readAll();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GerenciadorCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GerenciadorCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return linhas;
    }
    
    public static String[] getNomeDasColunas(File file, char caracTabulacao){
        List<String[]> linhas = lerArquivo(file, caracTabulacao);
        return linhas.get(0);
    }
    
    public static List<String[]> getValoresDoArquivo(File file, char caracTabulacao){
        List<String[]> linhas = lerArquivo(file,caracTabulacao);
        linhas.remove(0);
        return linhas;
    }
    
    public static boolean verificarSeColunaExiste(File file, String coluna, char caracTabulacao){
        String[] colunas = getNomeDasColunas(file, caracTabulacao);
        boolean result = false;
        for(int i = 0; i < colunas.length; i++){
            if(colunas[i].equals(coluna)){
                result = true;
                break;
            }
        }
        return result;
    }
    
    public static int qtdeLinhas(File file, char caracTabulacao){
        int result = 0;
        try {
            CSVReader reader = new CSVReader(new FileReader(file), caracTabulacao);
            result = reader.readAll().size();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GerenciadorCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GerenciadorCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}

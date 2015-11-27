/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package teste;

import java.util.List;
import util.GerenciadorCSV;

/**
 *
 * @author Desenvolvedor01
 */
public class TesteGerenciadorCSV {
    public static void main(String[] args) {
        GerenciadorCSV gerencia = new GerenciadorCSV();
//        TODAS AS LINHAS DO ARQUIVO
//        List<String[]> linhas = gerencia.lerArquivo("C:\\Users\\Desenvolvedor01\\Documents\\Magdiel - TCC\\ubs.csv");
//        for (String[] linha : linhas) {
//            for(int i = 0; i < linha.length; i++){
//                System.out.println(linha[i]);
//            }
//        }
        
//        SÓ AS COLUNAS DO CABEÇALHO
//        String[] linha = gerencia.getNomeDasColunas("C:\\Users\\Desenvolvedor01\\Documents\\Magdiel - TCC\\ubs.csv");
//        for(int i = 0; i < linha.length; i++){
//            System.out.println(linha[i]);
//        }
        
//        SÓ OS VALORES SEM O CABEÇALHO
//        List<String[]> linhas = gerencia.getValoresDoArquivo("C:\\Users\\Desenvolvedor01\\Documents\\Magdiel - TCC\\ubs.csv");
//        for (String[] linha : linhas) {
//            for(int i = 0; i < linha.length; i++){
//                System.out.println(linha[i]);
//            }
//        }
        
//        VERIFICA SE EXISTE COLUNA
//        System.out.println(gerencia.verificarSeColunaExiste("C:\\Users\\Desenvolvedor01\\Documents\\Magdiel - TCC\\ubs.csv", "cod_munic"));
        
//        QUANTIDADE DE LINHAS DO ARQUIVO
//        System.out.println(gerencia.qtdeLinhas("C:\\Users\\Desenvolvedor01\\Documents\\Magdiel - TCC\\ubs.csv"));
    }
}

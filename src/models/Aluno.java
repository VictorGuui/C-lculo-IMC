/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author victo
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.util.Date;

public class Aluno {
    protected int id;
    protected String nome;
    protected String cpf;
    protected int dataDeNascimento;
    protected double peso;
    protected double altura;
    
    public Aluno(int id, String cpf, String nome, int dataDeNascimento, double peso, double altura){
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.peso = peso;
        this.altura = altura;
    }
    
    public Aluno( String cpf, String nome, int dataDeNascimento, double peso, double altura){
        this.cpf = cpf;
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.peso = peso;
        this.altura = altura;
    }
    
    public Aluno(){
        
    }

    public int getID(){
        return id;
    }
    public void setID(int id){
        this.id = id;
    }
    
    public String getCpf(){
        return cpf;
    }
    
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    
    public String getNome(){
        return nome;   
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    public int getDataDeNascimento(){
        return dataDeNascimento;
    }
    
    public void setDataDeNascimento(int dataDeNascimento){
        this.dataDeNascimento = dataDeNascimento;
    }
    
    public double getPeso(){
        return peso;
    }
    
    public void setPeso(double peso){
        this.peso = peso;
    }
    
    public double getAltura(){
        return altura;
    }
    
    public void setAltura(double altura){
        this.altura = altura;
    }
    
    public double getIMC() {
        double IMC = peso / java.lang.Math.pow(altura, 2);
        return IMC;
    }

    public void exportarIMC() {
    try {
        String path = System.getProperty("user.home") + File.separator + "Downloads";
        File arq = new File(path, "imc.txt");
        
        if (arq.exists()) {
            FileWriter fileWriter = new FileWriter(arq, true);
            BufferedWriter escrita = new BufferedWriter(fileWriter);
            double imc = getIMC();
            escrita.newLine();
            
            if (imc < 18.5) {
                escrita.write("CPF: " + getCpf() + " Nome: " + getNome() + " IMC: " + String.format("%.2f", imc) + " Data de gerada: " + new Date() + " Classificação: Abaixo do peso normal");
            } else if (imc >= 18.5 && imc <= 24.9) {
                escrita.write("CPF: " + getCpf() + " Nome: " + getNome() + " IMC: " + String.format("%.2f", imc) + " Data de gerada: " + new Date() + " Classificação: Peso normal");
            } else if (imc >= 25.0 && imc <= 29.9) {
                escrita.write("CPF: " + getCpf() + " Nome: " + getNome() + " IMC: " + String.format("%.2f", imc) + " Data de gerada: " + new Date() + " Classificação: Excesso de peso");
            } else if (imc >= 30.0 && imc <= 34.9) {
                escrita.write("CPF: " + getCpf() + " Nome: " + getNome() + " IMC: " + String.format("%.2f", imc) + " Data de gerada: " + new Date() + " Classificação: Obesidade classe I");
            } else if (imc >= 35.0 && imc <= 39.9) {
                escrita.write("CPF: " + getCpf() + " Nome: " + getNome() + " IMC: " + String.format("%.2f", imc) + " Data de gerada: " + new Date() + " Classificação: Obesidade classe II");
            } else {
                escrita.write("CPF: " + getCpf() + " Nome: " + getNome() + " IMC: " + String.format("%.2f", imc) + " Data de gerada: " + new Date() + " Obesidade classe III");
            }
            
            escrita.close();
        } else {
            arq.createNewFile();
            FileWriter fileWriter = new FileWriter(arq, true);
            BufferedWriter escrita = new BufferedWriter(fileWriter);
            double imc = getIMC();
            escrita.write("CPF: " + getCpf() + " Nome: " + getNome() + " IMC: " + String.valueOf(imc) + " Data de gerada: " + new Date());
            escrita.close();
        }
    } catch (IOException e) {
        System.out.println(e);
        JOptionPane.showMessageDialog(null, e);
    }
}  
}

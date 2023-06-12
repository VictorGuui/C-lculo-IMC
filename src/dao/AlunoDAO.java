/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import factory.ConnectionFactory;
import java.sql.Connection;
/**
 *
 * @author victo
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Aluno;
public class AlunoDAO extends DAO{
    
    private ArrayList<Aluno> lista = new ArrayList<>();
    
    public void adicionar(Aluno aluno) {
    String sql = "INSERT INTO aluno(id, cpf, nome, data_nascimento, peso, altura) VALUES (?, ?, ?, ?, ?, ?)";
    try {
        Connection conn = new ConnectionFactory().getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, aluno.getID());
        stmt.setString(2, aluno.getCpf());
        stmt.setString(3, aluno.getNome());
        stmt.setInt(4, aluno.getDataDeNascimento());
        stmt.setDouble(5, aluno.getPeso());
        stmt.setDouble(6, aluno.getAltura());
        stmt.executeUpdate();
        stmt.close();
        } catch (SQLException e) {
        throw new RuntimeException(e);
        }
    }

    public ArrayList<Aluno> obterTodos() {
        String sql = "SELECT * FROM aluno";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Aluno alunos = new Aluno();
                alunos.setID(rs.getInt("id"));
                alunos.setCpf (rs.getString("cpf"));
                alunos.setNome(rs.getString("nome"));
                alunos.setDataDeNascimento(rs.getInt("data_nascimento"));
                alunos.setPeso(rs.getDouble("peso"));
                alunos.setAltura(rs.getDouble("altura"));
                this.lista.add(alunos);
                
            }
            stmt.close();
            return this.lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }

    public void deletar(int id) {
        String sql = "DELETE FROM aluno WHERE id = ?";
        Connection conn = new ConnectionFactory().getConnection();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void atualizar(Aluno aluno) {
        String sql = "UPDATE aluno SET nome = ?, data_nascimento = ?, peso = ?, altura = ? WHERE cpf = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setInt(2, aluno.getDataDeNascimento());
            stmt.setDouble(3, aluno.getPeso());
            stmt.setDouble(4, aluno.getAltura());
            stmt.setString(5, aluno.getCpf());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

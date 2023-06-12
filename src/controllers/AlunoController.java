package controllers;

import java.util.ArrayList;

import dao.AlunoDAO;
import models.Aluno;

public class AlunoController {
    
    public static String [] obterTodosAlunos(){
        AlunoDAO dao = new AlunoDAO();

        ArrayList<Aluno> list = dao.obterTodos();
        String alunos[] = new String[list.size()];

        for(int i = 0;i < list.size(); i++){
            alunos[i] = list.get(i).getNome();
        }
        return alunos;
    }

}

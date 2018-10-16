/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author Aluno
 */
public class Dependente {
    private int id;
    private Pessoa pessoa;
    private String nome;
    private String sobrenome;

    public Dependente() {
    }

    public Dependente(int id, Pessoa pessoa, String nome, String sobrenome) {
        this.id = id;
        this.pessoa = pessoa;
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    
    

    
}

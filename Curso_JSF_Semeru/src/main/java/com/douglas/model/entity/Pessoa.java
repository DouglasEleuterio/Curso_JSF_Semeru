/**
 * Tabela pessoa no banco de dados.
 */
package com.douglas.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

/**
 * @author douglas
 */
@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {

    private static final long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_pessoa", nullable = false)
    private Integer id;

    @NotNull
    @Column(nullable = false, name = "nome_pessoa", length = 80)
    private String nome;

    @Size.List({
        @Size(min = 10, message = "O Telefone deve conter no minimo {min} caracteres"),
        @Size(max = 15, message = "O Telefone deve conter no maximo {min} caracteres")
    })
    @Column(nullable = true, name = "telefone_pessoa", length = 15)//(062) 9999-9999
    private String telefone;

    @Column(nullable = false, name = "email_pessoa", length = 100)
    private String email;

    @CPF
    @Column(name = "cpf_pessoa", nullable = false)
    @Size.List({
        @Size(min = 11, message = "O CPF deve conter no minimo {min} caracteres")
        ,
        @Size(max = 14, message = "O CPF deve conter no maximo {min} caracteres")
    })
    private String cpf;

    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @Temporal(TemporalType.DATE)
    private Date dataDeCadastro;
    
    //Constructor

    public Pessoa() {
    }
    
    //Getters and Seters
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(Date dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}

/**
 * Tabela pessoa no banco de dados.
 */
package com.douglas.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.ForeignKey;
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
    
    @OneToOne(mappedBy = "pessoa",fetch = FetchType.LAZY)
    //Mesmo do relacionamento setado na classe endereço, no relacionamento com a classe pessoa.
    @ForeignKey(name = "endereco_pessoa")
    private Endereco endereco;
    
    
    //Se for o Lado many, necessario informar o Join Column
    @ManyToOne(optional = false)
    @ForeignKey(name = "pessoa_sexo")                   
                                 //Qual coluna da Tabela sexo fara o relacionamento ? coluna id_sexo;   
    @JoinColumn(name = "id_sexo",referencedColumnName = "id_sexo")
    private Sexo sexo;
    
    
    //Constructor
    public Pessoa() {
    }
    
    //Getters and Seters

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
    
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
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

    @Override
    public String toString() {
        return "Pessoa\n" + "id = " + id + "\nnome = " + nome + "\ntelefone = " + telefone + "\nemail = " + email + "\ncpf = " + cpf + "\ndataNascimento = " + dataNascimento + "\ndataDeCadastro = " + dataDeCadastro + "\nendereco = " + endereco + "\nsexo = " + sexo ;
    }
}

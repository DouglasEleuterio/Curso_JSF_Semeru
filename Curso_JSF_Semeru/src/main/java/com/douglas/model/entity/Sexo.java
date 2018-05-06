
package com.douglas.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author douglas
 */
@Entity
@Table(name = "sexo")
public class Sexo implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_sexo", nullable = false)//Masculino 
    private Integer id;

    @Column(name = "descicao",length = 9, unique = true, nullable = false)    
    private String descricao;
    
    //Um sexo para muitas pessoas
    @OneToMany(mappedBy = "sexo", fetch = FetchType.LAZY)
    @ForeignKey(name = "pessoa_sexo")
    //Entidade Sexo tera uma lista de Sexo
    private List<Pessoa> pessoa;
    
    public Sexo() {
    }

    public List<Pessoa> getPessoa() {
        return pessoa;
    }

    public void setPessoa(List<Pessoa> pessoa) {
        this.pessoa = pessoa;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sexo)) {
            return false;
        }
        Sexo other = (Sexo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
}

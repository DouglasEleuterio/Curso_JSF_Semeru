
package com.douglas.model.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "endereco")        
class Endereco implements Serializable{
    private static final long SerialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_endereco", nullable = false)
    private Integer id;
    
    @Column (name = "bairro", length = 80)
    private String bairro;
    
    @Column(name = "nome_logradouro", length = 80)
    private String nomeLogradouro;
    
    @Column(name = "CEP", length = 9)
    private String cep;
    
    @Column(name = "numero")
    private Integer numero;
    
    @Column(name = "complemento")
    private Integer complemento;
    
    //Relacionamento com Pessoa      
    @OneToOne(optional = true, fetch = FetchType.LAZY)
    @ForeignKey(name = "endereco_pessoa")
    // Nome da Coluna de Junção     //nome coluna referencia.
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa")
    private Pessoa pessoa;
    
    
    //Relacionamento com TipoLogradouro
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "endereco_tipo_logradouro")
    @JoinColumn(name = "id_tipoLogradouro",referencedColumnName = "id_tipoLogradouro")
    private TipoLogradouro tipoLogradouro;
    
    
    //Relacionamento com Estado
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "endereco_estado")
    @JoinColumn(name = "id_estado", referencedColumnName = "id_cidade")
    private Estado estado;
    
    
    //Relacionamento com TipoEndereco
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "endereco_tipoEndereco")
    @JoinColumn(name = "id_tipoEndereco", referencedColumnName = "id_tipoEndereco")
    private TipoEndereco tipoEndereco;
    
    
    //Relacionamento com cidade.
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "endereco_cidade")
    @JoinColumn(name = "id_cidade", referencedColumnName = "id_cidade")
    private Cidade cidade;
    
    
    //Construtor
    //No lado Many, e necessario inicializar as outras classe do Lado One.
    public Endereco() {
        this.cidade = new Cidade();
        this.estado = new Estado();
        this.tipoLogradouro = new TipoLogradouro();
        this.tipoEndereco = new TipoEndereco();
        this.pessoa = new Pessoa();
    }

    //Getters and Setters 

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNomeLogradouro() {
        return nomeLogradouro;
    }

    public void setNomeLogradouro(String nomeLogradouro) {
        this.nomeLogradouro = nomeLogradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getComplemento() {
        return complemento;
    }

    public void setComplemento(Integer complemento) {
        this.complemento = complemento;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public TipoLogradouro getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public TipoEndereco getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(TipoEndereco tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    
    
    //Equals and HashCode.
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
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
        final Endereco other = (Endereco) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}

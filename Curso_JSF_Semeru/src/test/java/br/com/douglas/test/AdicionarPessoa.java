
package br.com.douglas.test;

import com.douglas.model.DAO.HIbernateDAO;
import com.douglas.model.entity.Pessoa;
import com.douglas.util.HibernateUtil;

public class AdicionarPessoa {
    public static void main(String[] args) {
       
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Douglas");
        
        System.out.println(pessoa.toString());
    }
}

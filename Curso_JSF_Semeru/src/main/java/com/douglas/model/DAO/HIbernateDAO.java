/**
 * Implementação da Interface Gererica que manipula dados.
 * 
 */
package com.douglas.model.DAO;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

/**
 *
 * @author douglas
 */
public class HIbernateDAO<T> implements InterfaceDAO<T>,Serializable{

    private static final long SerialVersionUID = 1L;
    
    private Class<T> classe;
    private Session session;
    
    /**
     * Construtor 
     * Ao construirmos esta classe, devemos passar a classe que queremos manipular e 
     * a Session do Hibernate.
     * @param entity 
     */
    public HIbernateDAO(Class<T> classe, Session session) {
        super();
        this.classe = classe;
        this.session = session;
    }

    @Override
    public void save(T entity) {
        session.save(entity);
    }

    @Override
    public void update(T entity) {
        session.update(entity);
    }

    @Override
    public void remove(T entity) {
        session.delete(entity);
    }

    @Override
    public void merge(T entity) {
        session.merge(entity);
    }

    @Override
    public T getEntity(Serializable id) {
        T entity = (T)session.get(classe, id);
        return entity;
    }

    @Override
    public T getEntityByDetachedCriteria(DetachedCriteria criteria) {
        T entity = (T)criteria.getExecutableCriteria(session).uniqueResult();
        return entity;
    }

    @Override
    public List<T> getEntities() {
        List<T> entities =  (List<T>) session.createCriteria(classe).list();
        return entities;
    }

    @Override
    public List<T> getListByDetachedCriteria(DetachedCriteria criteria) {
        return criteria.getExecutableCriteria(session).list();
    }
}

/**
 * Não foi explicado pelo professor qual a responsabilidade desta classe.
 */
package com.douglas.util;

import javax.faces.context.FacesContext;
import org.hibernate.Session;

/**
 *
 * @author douglas
 */
public class FacesContextUtil {

    private static final String HIBERNATE_SESSION = "hibernate_session";

    /**
     * Seta no cabeçalho da requisição, a sessão do Hibernate.
     * @param session 
     */
    public static void setRequestSession(Session session) {
        FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put(HIBERNATE_SESSION, session);
    }

    public static Session getRequestSession() {
        return (Session) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(HIBERNATE_SESSION);
    }

}

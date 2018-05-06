/**
 *  Sera utilizado para gerenciar o fechamento da secao com o banco de dados.
 * Garantindo que ao iniciar o cliclo de vida do JSF, a secao com o banco seja aberta.
 * E no momento de Renderizacao da resposta, a secao seja fechada.
 */
package com.douglas.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import org.hibernate.Session;

/**
 *
 * @author douglas
 */
public class PhaseListener implements javax.faces.event.PhaseListener {

    @Override
    public void afterPhase(PhaseEvent fase) {
        //Depois da Fase
        System.out.println("Depois da Fase:\n Estamos na fase: " + fase.getPhaseId().toString());

        //Se estiver tentando restaura a visao.
        if (fase.getPhaseId().equals(PhaseId.RESTORE_VIEW)) {
            //Abre a secao com o Hibernate, efetua a transacao e seta na Request a sessao do Hibernate.
            Session session = HibernateUtil.getSESSION_FACTORY().openSession();
            //Inicia a transacao
            session.beginTransaction();
            FacesContextUtil.setRequestSession(session);
        }
    }

    @Override
    //Antes do Phase.
    public void beforePhase(PhaseEvent fase) {
        if (fase.getPhaseId().equals(PhaseId.RENDER_RESPONSE)) {
            System.out.println("Antes da Fase:\n Estamos na fase: " + fase.getPhaseId().toString());
            Session session = FacesContextUtil.getRequestSession();
            try {
                session.getTransaction().commit();
            } catch (Exception e) {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } finally {
                session.close();
            }
        }
    }

    @Override
    //Determina em qual secao o metodo sera invocado.
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }

}

package br.com.ctis.detran.persistence.audit;

import java.util.Calendar;

import org.hibernate.envers.RevisionListener;

/**
 * Listener Envers
 * 
 * @author alysson.cordeiro@ctis.com.br
 *
 */
public class AuditListener implements RevisionListener {

	@Override
	public void newRevision(Object objRevision) {
		
		Revision revision = (Revision) objRevision;
		revision.setMatricula("00019991");
		revision.setDtRevisao(Calendar.getInstance().getTime());
	}

}

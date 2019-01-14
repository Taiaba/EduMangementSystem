/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import info.edu.sys.SchClassName;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import info.edu.sys.SchClassName_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import info.edu.sys.SchSectionName;
import java.util.Collection;

/**
 *
 * @author RT
 */
@Stateless
public class SchClassNameFacade extends AbstractFacade<SchClassName> {

    @PersistenceContext(unitName = "EduMangementSystemPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SchClassNameFacade() {
        super(SchClassName.class);
    }

    public boolean isSchSectionNameCollectionEmpty(SchClassName entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<SchClassName> schClassName = cq.from(SchClassName.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(schClassName, entity), cb.isNotEmpty(schClassName.get(SchClassName_.schSectionNameCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<SchSectionName> findSchSectionNameCollection(SchClassName entity) {
        SchClassName mergedEntity = this.getMergedEntity(entity);
        Collection<SchSectionName> schSectionNameCollection = mergedEntity.getSchSectionNameCollection();
        schSectionNameCollection.size();
        return schSectionNameCollection;
    }
    
}

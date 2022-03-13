/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enterprise;

import entity.BookDataEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 2021.7.18 エンティティマネージャーをインジェクト
 * @author daidou
 */
@Stateless
public class RegBookWorker {
    @PersistenceContext
    private EntityManager em;
    
    public void register(BookDataEntity et) {
        em.persist(et);
    }
    
}

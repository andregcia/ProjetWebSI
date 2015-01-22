/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import entity.Member;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Julie
 */
@Stateless
public class Members {
    
    @PersistenceContext
    EntityManager emMember;
    
   public Member enregistre(Member m){
        Member member = emMember.merge(m);
        return member;
    }
    
    public Member find(long insId) {
        return this.emMember.find(Member.class, insId);
    }
    
    public List<Member> findAll() {
        return this.emMember.createNamedQuery("findAllMembers",Member.class).getResultList();
    }
}

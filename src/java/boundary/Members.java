package boundary;

import entity.Member;
import entity.Member_;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import static security.Encodage.hash;

@Stateless
public class Members {
    
    @PersistenceContext
    EntityManager emMember;
    
    //enregistre l'utilisateur dans la BDD
    public Member enregistre(Member m){
        Member member = emMember.merge(m);
        return member;
    }
    
    //met à jour l'utilisateur
    public void maj(Member m){
        emMember.merge(m);

    }
    
    //supprime l'utilisateur
    public void supprimer(int idm){
        Member mTmp = find(idm);
        emMember.remove(mTmp);
    }
    
   // renvoie l'utilisateur recherché
    public Member find(int insId) {
        return this.emMember.find(Member.class, insId);
    }
    
    // Renvoie tous les membres du site
    public List<Member> findAll() {
        return this.emMember.createNamedQuery("findAllMembers",Member.class).getResultList();
    }
    
    // Recherche d'un utilisateur
    public Member trouver(Member u){
        try{
            CriteriaBuilder cb = emMember.getCriteriaBuilder();
            CriteriaQuery<Member> cq = cb.createQuery(Member.class);
            Root<Member> utilisateur = cq.from(Member.class);
            cq.select(utilisateur);
            cq.where(cb.and(
                        cb.equal(utilisateur.get(Member_.userName), u.getUserName()), 
                        cb.equal(utilisateur.get(Member_.password), hash(u.getPassword())
                        )));
            TypedQuery<Member> tq = emMember.createQuery(cq);
            Member result = tq.getSingleResult();
            return result;
        }catch  (NoResultException nre){
            return null;
        }
    }
    
    public boolean memberExiste(String u){
        try{
            CriteriaBuilder cb = emMember.getCriteriaBuilder();
            CriteriaQuery<Member> cq = cb.createQuery(Member.class);
            Root<Member> utilisateur = cq.from(Member.class);
            cq.select(utilisateur);
            cq.where(cb.equal(utilisateur.get(Member_.userName), u));
            TypedQuery<Member> tq = emMember.createQuery(cq);
            Member result = tq.getSingleResult();
        return true;
        }catch  (NoResultException nre){
            return false;
        }
 
    }
}


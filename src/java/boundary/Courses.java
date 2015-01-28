package boundary;

import entity.Cours;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class Courses {
    @PersistenceContext
    EntityManager emCours;
    
   public Cours enregistre(Cours c){
        Cours cours = emCours.merge(c);
        return cours;
    }
    
    public Cours find(int cId){
        return this.emCours.find(Cours.class, cId);
    }
    
    public List<Cours> findAll(){
        return this.emCours.createNamedQuery("findAllCourses",Cours.class).getResultList();
    }
}

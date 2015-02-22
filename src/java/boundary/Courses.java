package boundary;

import entity.Cours;
import entity.Episode;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class Courses {
    @PersistenceContext
    EntityManager emCours;
    
    public Cours enregistre(Cours c, String name){
        c.setPicture(name);
        Cours cours = emCours.merge(c);
        return cours;
    }
    
    public void maj(Cours c){
        emCours.merge(c);

    }
    
    public void supprimer(int idc){
        Cours cTmp = find(idc);
        emCours.remove(cTmp);
    }
    
    public void addEpisode(Cours c, Episode e){
        c.getListEpisode().add(e);
        this.emCours.merge(c);
    }
    
    public Cours find(int cId){
        return this.emCours.find(Cours.class, cId);
    }
    
    public int nbEpisode(int idc){
        Cours c = find(idc);
        return c.getListEpisode().size();
    }
    public List<Cours> findAll(){
        return this.emCours.createNamedQuery("findAllCourses",Cours.class).getResultList();
    }
}

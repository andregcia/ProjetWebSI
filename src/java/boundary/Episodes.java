package boundary;

import entity.Episode;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class Episodes {
    
    @PersistenceContext
    EntityManager emEpisode;
    
    public Episode enregistre(Episode e){
        Episode episode = emEpisode.merge(e);
        return episode;
    }
    
    public Episode find(long eId){
        return this.emEpisode.find(Episode.class, eId);
    }
    
    public List<Episode> findAll(){
        return this.emEpisode.createNamedQuery("findAllEpisodes",Episode.class).getResultList();
    }
    
}

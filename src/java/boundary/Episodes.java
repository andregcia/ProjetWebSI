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
    
    public void maj(Episode e){
        emEpisode.merge(e);

    }
    
    public void supprimer(int ide){
        Episode eTmp = find(ide);
        emEpisode.remove(eTmp);
    }
    
    public Episode find(int eId){
        return this.emEpisode.find(Episode.class, eId);
    }
    
    public List<Episode> findAll(int idc){
        return this.emEpisode.createNamedQuery("findAllEpisodesByIdCours",Episode.class).setParameter("idcours", idc).getResultList();
    }
    
}

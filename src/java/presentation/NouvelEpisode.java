package presentation;

import boundary.Episodes;
import entity.Episode;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class NouvelEpisode {

    @Inject
    Episodes episodes; // Créer une nouvelle instance sans faire de new
    private Episode episode; 
    
    @PostConstruct
    public void onInit(){
        this.episode = new Episode();
    }

    public Episodes getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Episodes episodes) {
        this.episodes = episodes;
    }

    public Episode getEpisode() {
        return episode;
    }

    public void setEpisode(Episode episode) {
        this.episode = episode;
    }
    
    public String doAjouter(){
        episode = episodes.enregistre(episode);
        //Si on veut ajouter un nouvel episoe 
        //return "nouveauEpisode.xhtml?faces-redirect=true";
        //Sinon on renvoie la liste 
        return "listeCourses.xhtml?faces-redirect=true";
    }
    
}

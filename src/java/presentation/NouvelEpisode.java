package presentation;

import boundary.Courses;
import boundary.Episodes;
import entity.Cours;
import entity.Episode;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class NouvelEpisode {

    @Inject
    Episodes episodes; // Créer une nouvelle instance sans faire de new
    private Episode episode; 
    private int infoCours;
    private Courses c;
    
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

    public int getInfoCours() {
        return infoCours;
    }

    public void setInfoCours(int infoCours) {
        this.infoCours = infoCours;
    }
    
    public String doAjouter(){
        episode = episodes.enregistre(episode);
        
        return "listeCourses.xhtml?faces-redirect=true";
    }
    
}

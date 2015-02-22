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
    @Inject
    Courses courses;
    private Episode episode; 
    private Cours cours;
    
    @PostConstruct
    public void onInit(){
        this.episode = new Episode();
        this.cours = new Cours();
    }

    public Episodes getEpisodes() {
        return episodes;
    }

    public Courses getCourses() {
        return courses;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
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

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }
    
    public String gotoAjoutEpisode() {
        int idCours = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("cC"));
        this.cours = courses.find(idCours);
        return "nouvelEpisode?faces-redirect=true&amp;includeViewParams=true";
    }
    
    public void loadCours(){
        this.cours = courses.find(this.cours.getIdcours());
    }

    public String doAjouter(){
        loadCours();
        episodes.enregistre(episode,cours);
        return "listeCourses.xhtml?faces-redirect=true";
    }
    
}

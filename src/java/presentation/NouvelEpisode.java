package presentation;

import boundary.Courses;
import boundary.Episodes;
import entity.Cours;
import entity.Episode;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class NouvelEpisode {

    @Inject
    Episodes episodes; // Créer une nouvelle instance sans faire de new
    private Episode episode; 
    private Cours cours;
    
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

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }


    public void getParam() {
        Flash flash =  FacesContext.getCurrentInstance().getExternalContext().getFlash();
        //System.out.println("parametre :"+ flash.get("param"));
        setCours((Cours) flash.get("idcours"));

    }

    public String doAjouter(){
        episode.setCours(cours);
        episode = episodes.enregistre(episode);
        //List<Episode> listE = cours.getListEpisode();
        //listE.add(episode);
        //cours.setListEpisode(listE);
        return "listeCourses.xhtml?faces-redirect=true";
    }
    
}

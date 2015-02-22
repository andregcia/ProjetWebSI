package presentation;

import boundary.Courses;
import boundary.Episodes;
import entity.Cours;
import entity.Episode;
import entity.Member;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class ListeEpisode {
    @Inject
    Episodes episodes;
    @Inject
    Courses courses;
    private List<Episode> liste = new ArrayList<>();
    private Cours cours;
    
    @PostConstruct
    public void onInit(){
        this.cours = new Cours();
    }
    public Episodes getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Episodes episodes) {
        this.episodes = episodes;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

    public Courses getCourses() {
        return courses;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
    }
        
    public String gotoListEpisode() {
        int idCours = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("cCe"));
        this.cours = courses.find(idCours);
        return "listeEpisodes?faces-redirect=true&amp;includeViewParams=true";
    }
    
    public void loadCours(){
        this.cours = courses.find(this.cours.getIdcours());
    }
    
    public List<Episode> getListe() {
        liste = episodes.findAll(cours.getIdcours());
        return liste;
    }

    public void setListe(List<Episode> liste) {
        this.liste = liste;
    }
    
    public boolean accesOk(int idc, int idm){
        cours = courses.find(idc);
        for(Member m:cours.getListuser()){
            if(m.getId() == idm){
                return true;
            }
        }
        return false;
    }
    
    public String doSupEpisode(int ide){
        episodes.supprimer(ide);
        return "listeCourses?faces-redirect=true&amp;includeViewParams=true";
    }
}

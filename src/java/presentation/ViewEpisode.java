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
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class ViewEpisode {
    
    @Inject
    Episodes episodes;
    @Inject
    Courses courses;
    private Episode episode;
    private Cours cours;
    private List<Episode> liste = new ArrayList<>();
    
    @PostConstruct
    public void onInit() {
        this.episode = new Episode();
        this.cours = new Cours();
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

    public Courses getCourses() {
        return courses;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
    }
    
    public List<Episode> getListe() {
        liste = episodes.findAll(cours.getIdcours());
        return liste;
    }

    public void setListe(List<Episode> liste) {
        this.liste = liste;
    }
    
    public String gotoView(){
        int idCours = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("cC"));
        this.cours = courses.find(idCours);
        if(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("cvE") == null){
            this.episode = cours.getListEpisode().get(0);
        }else{
            int idEpisode = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("cvE"));
            this.episode = episodes.find(idEpisode); 
        }
        return "voirEpisode?faces-redirect=true&amp;includeViewParams=true";
    }
    
    public void loadEpisode(){
        this.episode = episodes.find(this.episode.getIdepisode());
    }
    public void loadCours(){
        this.cours = courses.find(this.cours.getIdcours());
    }
    
    public List<SelectItem> getValeursPossibles() {
        loadCours();
        List<SelectItem> options = new ArrayList<SelectItem>();
        for(Episode e:cours.getListEpisode()){
            options.add(new SelectItem(e.getIdepisode(),e.getTitle()));
        }
        return options;
    }
    
    public boolean accesOk(int idc, int idm){
        this.cours = this.courses.find(idc);
        for(Member m:this.cours.getListuser()){
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

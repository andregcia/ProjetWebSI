package presentation;

import boundary.Episodes;
import entity.Cours;
import entity.Episode;
import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class modifierEpisode {
    
    @Inject
    Episodes episodes;
    private Episode episode;
    
    @PostConstruct
    public void onInit() {
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
    
    public String gotoModif(){
        int idEpisode = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("cE"));
        this.episode = episodes.find(idEpisode);
        return "modifierEpisode.xhtml?faces-redirect=true&amp;includeViewParams=true";
    }
    
    public void loadEpisode(){
        this.episode = episodes.find(this.episode.getIdepisode());
    }
    
    public void doMajEpisode() throws IOException{
        if(episode.getTitle().isEmpty() || episode.getUrl().isEmpty()){
            FacesMessage m = new FacesMessage("Un des champs est vide !");
            FacesContext.getCurrentInstance().addMessage("newForm:msgError", m);
        }else{
            if(episode.getUrl().contains("https://www.youtube.com/embed/")){
                Episode e = episodes.find(this.episode.getIdepisode());
                e.setTitle(this.episode.getTitle());
                e.setUrl(this.episode.getUrl());
                episodes.maj(e);
                FacesContext.getCurrentInstance().getExternalContext().redirect("listeCourses.xhtml");
            }else{
                FacesMessage m = new FacesMessage("Ceci n'est pas un lien youtube");
                FacesContext.getCurrentInstance().addMessage("newForm:msgError", m);
            }
            
        }
    }      
}

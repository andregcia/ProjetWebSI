package presentation;

import boundary.Episodes;
import entity.Cours;
import entity.Episode;
import entity.Member;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class ListeEpisode {
    @Inject
    private Episodes episodes;
    private List<Episode> liste = new ArrayList<>();
    private Cours cours;

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
    
    public void getParam() {
        Flash flash =  FacesContext.getCurrentInstance().getExternalContext().getFlash();
        setCours((Cours) flash.get("cours"));

    }
    public List<Episode> getListe() {
        liste = episodes.findAll(cours.getIdcours());
        return liste;
    }

    public void setListe(List<Episode> liste) {
        this.liste = liste;
    }
    
    public boolean accesOk(int idc, Member m, int scan){
        if(scan==1){
            return true;
        }else{
            if(cours.getIdcours() == idc && cours.getListuser().contains(m)){
                return true;
            }
        }
        return false;
    }
}

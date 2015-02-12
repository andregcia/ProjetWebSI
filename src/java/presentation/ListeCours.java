package presentation;

import boundary.Courses;
import boundary.Members;
import entity.Cours;
import entity.Member;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class ListeCours {
   
    @Inject
    private Courses courses;
    private List<Cours> liste = new ArrayList<>();
    private Members members;

    public Courses getCourses() {
        return courses;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
    }

    public List<Cours> getListe() {
        liste = courses.findAll();
        return liste;
    }

    public void setListe(List<Cours> liste) {
        this.liste = liste;
    }
    
    public String gotoListEpisode(Cours c) {
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("cours", c);
        return "listeEpisodes?faces-redirect=true&amp;includeViewParams=true";
    }
    
    public String gotoAjoutEpisode(Cours idc) {
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("idcours", idc);
        return "nouvelEpisode?faces-redirect=true&amp;includeViewParams=true";
    }
    
    public List<Cours> accesOk(List<Cours> l,Member m){
        List<Cours> listTemp = new ArrayList<>();
        for(Cours c:l){
            for(Member mTmp:c.getListuser()){
                if(mTmp.getId() == m.getId()){
                    listTemp.add(c);
                }
            }
        }
        return listTemp;
    }
}

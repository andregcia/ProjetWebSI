package presentation;

import boundary.Courses;
import entity.Cours;
import entity.Member;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class ListeCours {
   
    @Inject
    private Courses courses;
    private Cours cours;
    private List<Cours> liste = new ArrayList<>();

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
    public boolean accesOkB(int idc, int idm){
        cours = courses.find(idc);
        for(Member m:cours.getListuser()){
            if(m.getId() == idm){
                return true;
            }
        }
        return false;
    }
    
    public String doSupCours(int idc){
        courses.supprimer(idc);
        return "listeCourses?faces-redirect=true&amp;includeViewParams=true";
    }
}

package presentation;

import boundary.LesCours;
import entity.Cours;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class ListeCours {
   
    @Inject
    private LesCours courses;
    private List<Cours> liste = new ArrayList<>();

    public LesCours getCourss() {
        return courses;
    }

    public void setCourss(LesCours courses) {
        this.courses = courses;
    }

    public List<Cours> getListe() {
        liste = courses.findAll();
        return liste;
    }

    public void setListe(List<Cours> liste) {
        this.liste = liste;
    }    
}

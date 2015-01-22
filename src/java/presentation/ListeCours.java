package presentation;

import boundary.Courses;
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
    private Courses courses;
    private List<Cours> liste = new ArrayList<>();

    public Courses getCourss() {
        return courses;
    }

    public void setCourss(Courses courses) {
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

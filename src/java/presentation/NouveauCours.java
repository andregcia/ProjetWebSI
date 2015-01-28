package presentation;

import boundary.Courses;
import entity.Cours;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class NouveauCours {
    
    @Inject
    Courses courses; // Créer une nouvelle instance sans faire de new
    private Cours cours; 
    
    @PostConstruct
    public void onInit(){
        this.cours = new Cours();
    }

    public Courses getCourses() {
        return courses;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }
    
    public String doAjouter(){
        cours = courses.enregistre(cours);
        return "nouvelEpisode.xhtml?faces-redirect=true";
    }
}


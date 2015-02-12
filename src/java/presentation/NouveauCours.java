package presentation;

import boundary.Courses;
import entity.Cours;
import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
    
    public void doAjouter() throws IOException{
        if(cours.getTitle().isEmpty() || cours.getDescription().isEmpty() 
                || cours.getPicture().isEmpty()){
            FacesMessage m = new FacesMessage("Un des champs est vide !");
            FacesContext.getCurrentInstance().addMessage("newForm:msgError", m);
        }else{
            if(cours.getPrice()<0){
                FacesMessage m = new FacesMessage("Le prix doit être supérieur ou égal à 0€");
                FacesContext.getCurrentInstance().addMessage("newForm:msgPrix", m);
            }else{
                cours = courses.enregistre(cours);
                FacesContext.getCurrentInstance().getExternalContext().redirect("listeCourses.xhtml?faces-redirect=true");
            }
        }
    }
}


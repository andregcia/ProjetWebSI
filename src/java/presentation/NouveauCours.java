package presentation;

import boundary.Courses;
import entity.Cours;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;

@Named
@RequestScoped
public class NouveauCours {
    
    @Inject
    Courses courses; // Créer une nouvelle instance sans faire de new
    private Cours cours; 
    private Part picture;
    
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

    public Part getPicture() {
        return picture;
    }

    public void setPicture(Part picture) {
        this.picture = picture;
    }
    
    public String doAjouter(){
        
        //saveImage(file);
        cours = courses.enregistre(cours);
        return "listeCourses.xhtml?faces-redirect=true";
    }
    
    /*public void saveImage(File file) throws IOException {
        String filename = file.getName();
        String suffix = filename.substring(filename.lastIndexOf('.') + 1);
        suffix = suffix.toLowerCase();
        
        if (suffix.equals("jpg") || suffix.equals("png")) {
            BufferedImage image = ImageIO.read(file);
            ImageIO.write(image, suffix, file);
        }
        else {
            FacesMessage m = new FacesMessage("L'image doit être de type .jpg ou .png");
            FacesContext.getCurrentInstance().addMessage("newForm:msgError", m);
        }
    }*/
}


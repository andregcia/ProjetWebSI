package presentation;

import boundary.Courses;
import entity.Cours;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.UploadedFile;

@Named
@RequestScoped
public class modifierCours {
    
    @Inject
    Courses courses;
    private Cours cours;
    UploadedFile file;
    
    @PostConstruct
    public void onInit() {
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

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }
    
    
    
    public String gotoModif(){
        int idCours = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("cC"));
        this.cours = courses.find(idCours);
        return "modifierCours?faces-redirect=true&amp;includeViewParams=true";
    }
    
    public void loadCours(){
        this.cours = courses.find(this.cours.getIdcours());
    }
    
    public void doMajCours() throws IOException{
        if(cours.getTitle().isEmpty() || cours.getDescription().isEmpty() || (file == null)){
            FacesMessage m = new FacesMessage("Un des champs est vide !");
            FacesContext.getCurrentInstance().addMessage("newForm:msgError", m);
        }else{
            if(chargerImage() == 2){
                FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Erreur!", "Format de l'image incorrect (png ou jpeg)");
                FacesContext.getCurrentInstance().addMessage("newForm:msgImg", m);
            }
            if(cours.getDescription().length() > 250){
                FacesMessage m = new FacesMessage("La longueur maximale de la description est de 255 caractères.");
                FacesContext.getCurrentInstance().addMessage("newForm:msgDesc", m);
            }else{
                if(cours.getPrice()<0){
                    FacesMessage m = new FacesMessage("Le prix doit être supérieur ou égal à 0€");
                    FacesContext.getCurrentInstance().addMessage("newForm:msgPrix", m);
                }else{
                    Cours c = courses.find(this.cours.getIdcours());
                    c.setTitle(this.cours.getTitle());
                    c.setDescription(this.cours.getDescription());
                    c.setPicture(file.getFileName());
                    c.setPrice(this.cours.getPrice());
                    courses.maj(c);
                    FacesContext.getCurrentInstance().getExternalContext().redirect("listeCourses.xhtml");
                }
            }
        }     
    }
    public int chargerImage() throws IOException{
        String nomFichier = file.getFileName();      
        String prefix     = nomFichier.substring(0, nomFichier.lastIndexOf("."));  
        String suffix     = nomFichier.substring(nomFichier.lastIndexOf("."));
        if(suffix.contains("png") || suffix.contains("jpeg")){
            File f = File.createTempFile(prefix, suffix, new File("C:\\Users\\André\\Documents\\NetBeansProjects\\ProjetWebSI\\web\\fileupload"));
            InputStream input   = null ;
            OutputStream output = null ;
            input = new BufferedInputStream( file.getInputstream(), 10240 );
            output = new BufferedOutputStream( new FileOutputStream(f), 10240 );
            byte[] buffer = new byte[10240];
            int length = 0 ;
            while( (length = input.read(buffer))  > 0  ){
                    output.write(buffer, 0, length);
            }
            return 0;
        }else{
            return 2;
        }
    }
}

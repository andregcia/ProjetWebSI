package presentation;

import java.io.IOException;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@SessionScoped
public class ConnectBean implements Serializable {
    
    private String username="";
    private String password="";

    public ConnectBean() {
        this.username = "";
        this.password = "";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void checkLogin() throws IOException{
        if(username.isEmpty() || password.isEmpty()){
            FacesMessage m = new FacesMessage("Au moins un des champs est vide !");
            FacesContext.getCurrentInstance().addMessage("connexionForm:msgLogin", m);  
        }else{
        if(username.equals("patate") && password.equals("truc")){
            FacesContext.getCurrentInstance().getExternalContext().redirect("monProfil.xhtml");
        }else{
            FacesMessage m = new FacesMessage("La combinaison username et password n'est pas correcte");
            FacesContext.getCurrentInstance().addMessage("connexionForm:msgLogin", m);
        }
        }
    }
    
    /*public boolean verificationLogin() {
        FacesContext.getCurrentInstance().getExternalContext().getContextName().
    }
    public void verificationAdmin()) {
        
    }*/
    public void deconnexion() throws IOException{
        FacesMessage m = new FacesMessage("Vous êtes déconnecté :)");
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().addMessage("connexionForm:msgLogin", m);
        FacesContext.getCurrentInstance().getExternalContext().redirect("connect.xhtml");
    }    
}

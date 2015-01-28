package presentation;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import static security.Encodage.hash;

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
    
    public void checkLogin() throws IOException, SQLException{ 
        if(username.isEmpty() || password.isEmpty()){
            FacesMessage m = new FacesMessage("Au moins un des champs est vide !");
            FacesContext.getCurrentInstance().addMessage("connexionForm:msgLogin", m);  
        }
        if(username.length() < 3 && username.length() > 30|| password.length() < 5){
            FacesMessage m = new FacesMessage("Votre nom d'utilisateur ou votre mot de passe est trop court ou trop long.");
            FacesContext.getCurrentInstance().addMessage("connexionForm:msgLogin", m);  
        }
        if(loginExiste(username)){
            String passSecret = hash(password);
            if(passSecret.equals(recupMDP(username))){
                FacesContext.getCurrentInstance().getExternalContext().redirect("monProfil.xhtml");
            }else{
                FacesMessage m = new FacesMessage("La combinaison username et password n'est pas correcte");
                FacesContext.getCurrentInstance().addMessage("connexionForm:msgLogin", m);
            }
        }
    }
    
    public String recupMDP(String u) throws SQLException{
        try{
            Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/ProjetWebSI", "app", "app");
            String sql = "SELECT password FROM Member WHERE username= ?";
            PreparedStatement pS = connection.prepareStatement(sql);
            pS.setString(1, u);
            ResultSet rs = pS.executeQuery();
            rs.next();
            String p = rs.getString(1);
            rs.close();
            pS.close();
            connection.close();
            return p;
        }catch (SQLException e){
            FacesMessage m = new FacesMessage("Problème d'identification !");
            FacesContext.getCurrentInstance().addMessage("connexionForm:msgLogin", m);
            return null;
        }
    }
    
    public boolean loginExiste(String u){
        try{
            Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/ProjetWebSI", "app", "app");
            String sql = "SELECT username FROM Member WHERE username= ?";
            PreparedStatement pS = connection.prepareStatement(sql);
            pS.setString(1, u);
            pS.close();
            connection.close();
            return pS.execute();
        }catch (SQLException e){
            FacesMessage m = new FacesMessage("Problème d'identification !");
            FacesContext.getCurrentInstance().addMessage("connexionForm:msgLogin", m);
            return false;
        }
    }

    
    public boolean verificationLogin() {
        if(username.isEmpty()){
            return false;
        }else{
            return true;
        }
    }
    public boolean verificationAdmin() {
        return true;
    }
    public void deconnexion() throws IOException{
        FacesMessage m = new FacesMessage("Vous êtes déconnecté :)");
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().addMessage("connexionForm:msgLogin", m);
        FacesContext.getCurrentInstance().getExternalContext().redirect("connect.xhtml");
    }    
}

package presentation;

import java.io.IOException;
import java.io.Serializable;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
    public void checkLogin() throws IOException, SQLException{ 
        if(username.isEmpty() || password.isEmpty()){
            FacesMessage m = new FacesMessage("Au moins un des champs est vide !");
            FacesContext.getCurrentInstance().addMessage("connexionForm:msgLogin", m);  
        }
        if(username.length() < 3 && username.length() > 30|| password.length() < 3){
            FacesMessage m = new FacesMessage("Votre nom d'utilisateur ou votre mot de passe est trop court ou trop long.");
            FacesContext.getCurrentInstance().addMessage("connexionForm:msgLogin", m);  
        }
        Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/ProjetWebSIAndreJulie", "app", " ");
        String sql = "SELECT PASSWORD FROM APP.\"USER\" WHERE USERNAME= ?";
        PreparedStatement pS = connection.prepareStatement(sql);
        pS.setString(1, username);
        if(pS.execute()){
            String passSecret = hash(password);
            ResultSet rs = pS.executeQuery();
            rs.next();
            if(passSecret.equals(rs.getString("PASSWORD"))){
                pS.close();
                connection.close();
                FacesContext.getCurrentInstance().getExternalContext().redirect("monProfil.xhtml");
            }else{
                FacesMessage m = new FacesMessage("La combinaison username et password n'est pas correcte");
                pS.close();
                connection.close();
                FacesContext.getCurrentInstance().addMessage("connexionForm:msgLogin", m);
            }
        }
    }
    
    public static String hash(String base){
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

        return hexString.toString();
        } catch(Exception ex){
           throw new RuntimeException(ex);
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

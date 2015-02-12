package presentation;

import boundary.Members;
import entity.Member;
import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Inject;
import javax.inject.Named;
import static security.Encodage.hash;

@Named
@RequestScoped
public class GestionMembre {
    
    @Inject
    Members members;
    private Member member;

    @PostConstruct
    public void onInit() {
        this.member = new Member();
    }
    
    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Members getMembers() {
        return members;
    }

    public void setMembers(Members members) {
        this.members = members;
    }

    public void doAjouter() throws IOException {
        
        if(member.getFirstName().isEmpty() || member.getLastName().isEmpty() 
                || member.getEmail().isEmpty() || member.getUserName().isEmpty() 
                || member.getPassword().isEmpty()){
            FacesMessage m = new FacesMessage("Un des champs est vide !");
            FacesContext.getCurrentInstance().addMessage("newForm:msgError", m);
        }else{
            if(!verifieMDP(member.getPassword())){
                FacesMessage m = new FacesMessage("Le mot de passe doit être contenir au moins 6 caractères.");
                FacesContext.getCurrentInstance().addMessage("newForm:msgMDP", m);
            }else{
                member.setPassword(hash(member.getPassword()));
            }
            if(!validationEmail(member.getEmail())){
                FacesMessage m = new FacesMessage("Merci de saisir une adresse mail valide.");
                FacesContext.getCurrentInstance().addMessage("newForm:msgEmail", m);
            }
            if(verifieLongUsername(member.getUserName())){
                FacesMessage m = new FacesMessage("Le nom d'utilisateur doit être compris entre 3 et 30 caractères.");
                FacesContext.getCurrentInstance().addMessage("newForm:msgLogin", m); 
            }
            
            if(!members.memberExiste(member.getUserName())){
                member = members.enregistre(member);
                FacesContext.getCurrentInstance().getExternalContext().redirect("connect.xhtml");
            } else {
                FacesMessage m = new FacesMessage("Le nom d'utilisateur n'est pas disponible.");
                FacesContext.getCurrentInstance().addMessage("newForm:msgLogin", m); 
            }
        }  
    }
    
    public boolean validationEmail(String email) {
        return !(email.isEmpty() || !email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)"));
    }
    
    public boolean verifieMDP(String mdp){
        return mdp.length() >= 6;
    }
    
    public boolean verifieLongUsername(String name){
        FacesMessage m = new FacesMessage("Le nom d'utilisateur doit être compris entre 3 et 30 caractères."+name);
        return !(name.length() > 2 && name.length() <= 30);
    }
   
    
    public String doSupMembre(int idm){
        members.supprimer(idm);
        return "listeMembre?faces-redirect=true&amp;includeViewParams=true";
    }
    
    public String gotoModif(){
        //FacesContext.getCurrentInstance().getExternalContext().getFlash()
        return "modifierProfil?faces-redirect=true&amp;includeViewParams=true";
    }
    
    public void getParam() {
        Flash flash =  FacesContext.getCurrentInstance().getExternalContext().getFlash();
        //System.out.println("parametre :"+ flash.get("idmember"));
        setMember(members.find((int) flash.get("idm")));
    }
    
    public void doMajProfil(int id, String nom, String prenom, String email) throws IOException{
        System.out.println("membre :"+ id);
        FacesContext.getCurrentInstance().getExternalContext().redirect("monProfil.xhtml");
        
    }
}

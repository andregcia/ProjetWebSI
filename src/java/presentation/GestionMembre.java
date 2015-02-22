package presentation;

import boundary.Members;
import entity.Member;
import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import static security.Encodage.hash;

@Named
@RequestScoped
public class GestionMembre {
    
    @Inject
    Members members;
    @Inject
    Connect co;
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
        int idMembre = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("cM"));
        this.member = members.find(idMembre);
        return "modifierProfil?faces-redirect=true&amp;includeViewParams=true";
    }
    
    public void loadMember(){
        this.member = members.find(this.member.getId());
    }
    
    public void doMajProfil() throws IOException{
        if(member.getFirstName().isEmpty() || member.getLastName().isEmpty() 
                || member.getEmail().isEmpty()){
            FacesMessage m = new FacesMessage("Un des champs est vide !");
            FacesContext.getCurrentInstance().addMessage("newForm:msgError", m);
        }else{
            if(!validationEmail(member.getEmail())){
                FacesMessage m = new FacesMessage("Merci de saisir une adresse mail valide.");
                FacesContext.getCurrentInstance().addMessage("newForm:msgError", m);
            }else{
                Member m = members.find(this.member.getId());
                m.setFirstName(this.member.getFirstName());
                m.setLastName(this.member.getLastName());
                m.setEmail(this.member.getEmail());
                members.maj(m);
                co.majProfil(m.getId());
                FacesContext.getCurrentInstance().getExternalContext().redirect("monProfil.xhtml");
            }
        }        
    }
    
    public void doMajPwd() throws IOException{
        if(member.getPassword().isEmpty()){
            FacesMessage m = new FacesMessage("Un des champs est vide !");
            FacesContext.getCurrentInstance().addMessage("newForm:msgError", m);
        }else{
            if(!verifieMDP(member.getPassword())){
                FacesMessage m = new FacesMessage("Le mot de passe doit être contenir au moins 6 caractères.");
                FacesContext.getCurrentInstance().addMessage("newForm:msgError", m);
            }else{
                Member m = members.find(this.member.getId());
                m.setPassword(hash(this.member.getPassword()));
                members.maj(m);
                FacesContext.getCurrentInstance().getExternalContext().redirect("monProfil.xhtml");
            }
        }        
    }
    
    public void doMajScan() throws IOException{
        Member m = members.find(this.member.getId());
        m.setScan(this.member.getScan());
        members.maj(m);
        FacesContext.getCurrentInstance().getExternalContext().redirect("listeMembre.xhtml");
      
    }
}

package presentation;

import boundary.Members;
import entity.Member;
import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@SessionScoped
public class Connect implements Serializable {
    
    @Inject
    Members members;
    private Member member;
    
    @PostConstruct
    public void onInit() {
        this.member = new Member();
    }

    public Members getMembers() {
        return members;
    }

    public void setMembers(Members members) {
        this.members = members;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
    
    public void checkLogin() throws IOException{ 
        //récupérer login
        if(!member.getUserName().isEmpty() && !member.getPassword().isEmpty()){
            Member membertemp = members.trouver(this.member);
            if(membertemp != null){
                member = membertemp;
                FacesContext.getCurrentInstance().getExternalContext().redirect("monProfil.xhtml"); 
             }else{
                this.member.setUserName(null);
                FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Erreur!", "La combinaison username et password n'est pas correcte");
                FacesContext.getCurrentInstance().addMessage("connexionForm:msgLogin", m);
             }
        }else{
            this.member.setUserName(null);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Erreur!", "Un des champs est vide !");
            FacesContext.getCurrentInstance().addMessage("connexionForm:msgLogin", m);
        }
    }
    
    public void majProfil(int idm){
        if(idm == member.getId()){
           this.member = members.find(idm);  
        }
    }
    public void deconnexion() throws IOException{
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().getExternalContext().redirect("connect.xhtml");
    }    
}

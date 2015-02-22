package presentation;

import boundary.Courses;
import boundary.Members;
import entity.Cours;
import entity.Member;
import java.io.IOException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class paiement {
    
    @Inject
    Courses courses;
    @Inject
    Members members;
    private Cours cours;
    private Member member;
    private int mois;
    private int annee;
    private String numCard;
    private int secure;
    
    @PostConstruct
    public void onInit() {
        this.cours = new Cours();
        this.member = new Member();
    }

    public Courses getCourses() {
        return courses;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
    }

    public Members getMembers() {
        return members;
    }

    public void setMembers(Members members) {
        this.members = members;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public int getMois() {
        return mois;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public String getNumCard() {
        return numCard;
    }

    public void setNumCard(String numCard) {
        this.numCard = numCard;
    }

    public int getSecure() {
        return secure;
    }

    public void setSecure(int secure) {
        this.secure = secure;
    }
    
    public String gotoPaiement() throws IOException{
        int idCours = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("cC"));
        this.cours = courses.find(idCours);
        int idMember = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("cM"));
        this.member = members.find(idMember);
        if(cours.getPrice() > 0){
            return "paiement?faces-redirect=true&amp;includeViewParams=true";
        }else{
            this.doAjout();
            return "monProfil?faces-redirect=true&amp;includeViewParams=true";
        }
    }
    
    public void loadCours(){
        this.cours = courses.find(this.cours.getIdcours());
    }
    public void loadMember(){
        this.member = members.find(this.member.getId());
    }
    
    public void doTransaction() throws IOException{
        int calculP = 0;
        int calculD;
        int calcul;
        if(!this.numCard.isEmpty() && this.annee > 0 && this.mois > 0 && this.secure >0){
            if(isInt(this.numCard)){
                for(char chiffre : this.numCard.toCharArray()){
                    calculP = calculP+Character.getNumericValue(chiffre);
                }
                calculP = (calculP*20)/50;
                calculD = (this.mois + this.annee) / 50;

                calcul = (calculP + calculD)*10;
                System.out.println("Calcul = "+calcul);

                if(calcul == this.secure){
                    this.doAjout();
                }else{
                    FacesMessage m = new FacesMessage("Paiement refusé !");
                    FacesContext.getCurrentInstance().addMessage("newForm:msgError", m);
                }
            }else{
                FacesMessage m = new FacesMessage("Vérifier votre numéro de carte");
                FacesContext.getCurrentInstance().addMessage("newForm:msgError", m);
            }
        }else{
            FacesMessage m = new FacesMessage("Les données sont incorrectes");
            FacesContext.getCurrentInstance().addMessage("newForm:msgError", m);
        }
    }
    
    public void doAjout() throws IOException{
        loadCours();
        loadMember();

        List<Cours> TmpC = member.getListCours();
        TmpC.add(cours);
        member.setListCours(TmpC);
        List<Member> TmpM = cours.getListuser();
        TmpM.add(member);
        courses.maj(cours);
        members.maj(member);
        FacesContext.getCurrentInstance().getExternalContext().redirect("monProfil.xhtml");
    }
    
    public static boolean isInt(String chaine){ 
        boolean valeur = true; 
        char[] tab = chaine.toCharArray(); 

        for(char carac : tab){ 
            if(!Character.isDigit(carac) && valeur){ valeur = false; } 
        } 

        return valeur; 
    }  
}

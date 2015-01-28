/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import boundary.Members;
import entity.Member;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Julie
 */
@Named
@RequestScoped
public class NouvelleInscription {
    
    @Inject
    Members members;
    private Member member;

    @PostConstruct
    public void onInit() {
        this.member = new Member();
    }
    
    public Member getUser() {
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

    public String doAjouter() {
        member = members.enregistre(member);
        return "index.xhtml?faces-redirect=true";
    }
   
}

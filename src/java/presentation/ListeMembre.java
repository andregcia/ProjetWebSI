package presentation;

import boundary.Members;
import entity.Member;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class ListeMembre {
    
    @Inject
    private Members members;
    private List<Member> liste = new ArrayList<>();

    public Members getMembers() {
        return members;
    }

    public void setMembers(Members members) {
        this.members = members;
    }

    public List<Member> getListe() {
        liste = members.findAll();
        return liste;
    }

    public void setListe(List<Member> liste) {
        this.liste = liste;
    }    
}

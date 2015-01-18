package presentation;

import boundary.Courss;
import entity.Cours;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class ListeCours {
   
    @Inject
    private Courss courss;
    private List<Cours> liste = new ArrayList<>();

    public Courss getCourss() {
        return courss;
    }

    public void setCourss(Courss courss) {
        this.courss = courss;
    }

    public List<Cours> getListe() {
        //liste = courss.findAll();
        return liste;
    }

    public void setListe(List<Cours> liste) {
        this.liste = liste;
    }    
}

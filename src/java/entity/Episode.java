package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="findAllEpisodesByIdCours", query="SELECT i FROM Episode i WHERE i.cours.idcours = :idcours")
public class Episode implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int idepisode;
    private String title;
    private String url;
    @ManyToOne(optional = false)
    private Cours cours;

    public Episode() {
    }

    public Episode(String title, String url, Cours cours) {
        this.title = title;
        this.url = url;
        this.cours = cours;
    }

    public Episode(Cours cours) {
        this.cours = cours;
    }
    

    public int getIdepisode() {
        return idepisode;
    }

    public void setIdepisode(int idepisode) {
        this.idepisode = idepisode;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }
   
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    
    
    
}

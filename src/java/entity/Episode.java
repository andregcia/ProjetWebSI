package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;

@Entity
@NamedQuery(name="findAllEpisodes", query="SELECT i FROM Episode i")
public class Episode implements Serializable {
    
    @Id
    @GeneratedValue
    private int idepisode;
    private String title;
    private String url;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateVu;
    @ManyToOne(optional = false)
    private Cours cours;

    public Episode() {
    }

    public Episode(String title, String url) {
        this.title = title;
        this.url = url;
        this.dateVu = null;
    }

    public int getIdepisode() {
        return idepisode;
    }

    public void setIdepisode(int idepisode) {
        this.idepisode = idepisode;
    }

    public Date getDateVu() {
        return dateVu;
    }

    public void setDateVu(Date dateVu) {
        this.dateVu = dateVu;
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

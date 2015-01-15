package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="findAllEpisodes", query="SELECT i FROM Episode i")
public class Episode {
    
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String url;
    @ManyToOne(optional = false)
    private Cours cours;

    public Episode() {
    }

    public Episode(String title, String url) {
        this.title = title;
        this.url = url;
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

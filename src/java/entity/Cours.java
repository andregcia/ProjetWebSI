package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@Entity
@NamedQuery(name="findAllCours", query="SELECT i FROM Cours i")
public class Cours implements Serializable {
    
    @Id
    @GeneratedValue
    private int idcours;
    private String title;
    private String description;
    private String picture;
    private int price;
    @OneToMany(cascade=CascadeType.ALL,mappedBy="cours")
    private List<Episode> listEpisode;
    @ManyToOne(optional = false)
    private Member user;

    public Cours() {
    }

    public Cours(String title, String description, String picture, int price) {
        this.title = title;
        this.description = description;
        this.picture = picture;
        this.price = price;
    }
    
    public int getIdCours() {
        return idcours;
    }

    public void setIdCours(int id) {
        this.idcours = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Member getUser() {
        return user;
    }

    public void setUser(Member user) {
        this.user = user;
    }
       
    public List<Episode> getListEpisode() {
        return listEpisode;
    }

    public void setListEpisode(List<Episode> listEpisode) {
        this.listEpisode = listEpisode;
    }
    
}

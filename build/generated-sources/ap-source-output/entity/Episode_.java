package entity;

import entity.Cours;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-02-21T10:35:12")
@StaticMetamodel(Episode.class)
public class Episode_ { 

    public static volatile SingularAttribute<Episode, Integer> idepisode;
    public static volatile SingularAttribute<Episode, String> title;
    public static volatile SingularAttribute<Episode, Cours> cours;
    public static volatile SingularAttribute<Episode, String> url;

}
package entity;

import entity.Episode;
import entity.Member;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-02-21T10:35:12")
@StaticMetamodel(Cours.class)
public class Cours_ { 

    public static volatile SingularAttribute<Cours, Integer> idcours;
    public static volatile SingularAttribute<Cours, Integer> price;
    public static volatile ListAttribute<Cours, Episode> listEpisode;
    public static volatile SingularAttribute<Cours, String> description;
    public static volatile SingularAttribute<Cours, String> title;
    public static volatile ListAttribute<Cours, Member> listuser;
    public static volatile SingularAttribute<Cours, String> picture;

}
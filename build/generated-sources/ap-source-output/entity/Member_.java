package entity;

import entity.Cours;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-02-21T10:35:12")
@StaticMetamodel(Member.class)
public class Member_ { 

    public static volatile SingularAttribute<Member, String> firstName;
    public static volatile SingularAttribute<Member, String> lastName;
    public static volatile ListAttribute<Member, Cours> listCours;
    public static volatile SingularAttribute<Member, String> password;
    public static volatile SingularAttribute<Member, Integer> scan;
    public static volatile SingularAttribute<Member, Integer> id;
    public static volatile SingularAttribute<Member, String> userName;
    public static volatile SingularAttribute<Member, String> email;

}
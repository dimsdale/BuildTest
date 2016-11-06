package ua.sdo.model;


import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity @Table(name = "invite_build")
public class InviteBuild implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "build_id")
    private Build build;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "date_invite")
    @Type(type = "timestamp")
    private Date dateInvite;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Build getBuild() {
        return build;
    }

    public void setBuild(Build build) {
        this.build = build;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDateInvite() {
        return dateInvite;
    }

    public void setDateInvite(Date dateInvite) {
        this.dateInvite = dateInvite;
    }
}

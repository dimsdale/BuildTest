package ua.sdo.model;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

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
    private LocalDate dateInvite;

    @Column(name = "time_invite")
    private LocalTime timeInvite;

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

    public LocalDate getDateInvite() {
        return dateInvite;
    }

    public void setDateInvite(LocalDate dateInvite) {
        this.dateInvite = dateInvite;
    }

    public LocalTime getTimeInvite() {
        return timeInvite;
    }

    public void setTimeInvite(LocalTime timeInvite) {
        this.timeInvite = timeInvite;
    }
}

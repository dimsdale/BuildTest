package ua.sdo.model;

import javax.persistence.*;
import java.util.List;

@Entity @Table(name = "builds")
public class Build {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @OneToMany(mappedBy = "build")
    private List<InviteBuild> inviteBuild;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getOwner() {
        return owner;
    }

    public List<InviteBuild> getInviteBuild() {
        return inviteBuild;
    }

    public void setInviteBuild(List<InviteBuild> inviteBuild) {
        this.inviteBuild = inviteBuild;
    }
}

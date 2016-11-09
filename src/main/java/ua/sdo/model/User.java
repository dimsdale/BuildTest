package ua.sdo.model;


import ua.sdo.annotations.Phone;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "login", unique = true)
    @Size(min = 3, max = 50)
    private String login;

    @Column(name = "fio")
    @Size(min = 5, max = 100)
    @NotNull
    private String fio;

    @Column(name = "telephone")
    @Phone
    private String telephone;

    @Column(name = "password")
    @Size(min = 4, max = 100)
    @NotNull
    private String password;

    @OneToMany(mappedBy = "owner")
    List<Build> builds = new ArrayList<Build>();

    @OneToMany(mappedBy = "user")
    private List<InviteBuild> inviteBuilds;

    public User() {
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Build> getBuilds() {
        return builds;
    }

    public void setBuilds(List<Build> builds) {
        this.builds = builds;
    }

    public List<InviteBuild> getInviteBuilds() {
        return inviteBuilds;
    }

    public void setInviteBuilds(List<InviteBuild> inviteBuilds) {
        this.inviteBuilds = inviteBuilds;
    }

    public String getLogin() {
        return login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    }

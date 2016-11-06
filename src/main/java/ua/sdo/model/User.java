package ua.sdo.model;


import ua.sdo.annotations.FieldEquals;
import ua.sdo.annotations.Phone;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@FieldEquals(field = "password", equalsTo = "confirmPassword")
public class User implements Serializable {

    @Id
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

    @NotNull
    @Transient
    private String confirmPassword;

    @OneToMany(mappedBy = "owner")
    List<Build> builds = new ArrayList<Build>();

    @OneToMany(mappedBy = "user")
    private List<InviteBuild> inviteBuilds;

    public User() {
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public List<Build> getBuilds() {
        return builds;
    }

    public void setBuilds(List<Build> builds) {
        this.builds = builds;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User[login: " + login + ", password: " + password + ", fio: " + fio + "]";
    }
}

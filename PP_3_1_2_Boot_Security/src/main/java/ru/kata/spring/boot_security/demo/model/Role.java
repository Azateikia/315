package ru.kata.spring.boot_security.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    public Role() {
    }
    public Role(String role) {
        this.name = role;
    }

    // Оставлю на память все версии конструкторов... Я слишком многое с ними пережил
    public Role(Long id) {
        this.id = id;
    }

    public Role(Long id, String role, List<User> users) {
        this.id = id;
        this.name = role;
        this.users = users;
    }

    public Role(String role, List<User> users) {
        this.name = role;
        this.users = users;
    }

    public Role(List<User> users) {
        this.users = users;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "role")
    private String name;


    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    /// дальше всякое

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return name;
    }

    public void setRole(String role) {
        this.name = role;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String getAuthority() {
        return getRole();
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role1 = (Role) o;
        return Objects.equals(id, role1.id) && Objects.equals(name, role1.name) && Objects.equals(users, role1.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, users);
    }

    public String getRoleName() {
        return name.substring("ROLE_".length());
    }
}

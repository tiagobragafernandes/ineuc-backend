package edu.ineuc.backend.model;

import edu.ineuc.backend.controller.dto.CreateUserData;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private Boolean isActive;

    @OneToMany(mappedBy = "user")
    private List<Activity> activity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userPersonalData", referencedColumnName = "id")
    private UserPersonalData userPersonalData;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userRole", referencedColumnName = "id")
    private UserRole userRole;

    public User(CreateUserData data) {
        this.email = data.email();
        this.password = data.password();
        this.isActive = data.isActive();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}

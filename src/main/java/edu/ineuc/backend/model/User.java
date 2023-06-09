package edu.ineuc.backend.model;

import edu.ineuc.backend.controller.dto.CreateUserData;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
    @JoinColumn(name = "user_personal_data_id", referencedColumnName = "id")
    private UserPersonalData userPersonalData;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_role_id", referencedColumnName = "id")
    private UserRole userRole;

    public User(CreateUserData data, String encryptedPassword) {
        this.email = data.email();
        this.password = encryptedPassword;
        this.isActive = data.isActive();
        this.userPersonalData = new UserPersonalData(data.createUserPersonalData());
        this.userRole = new UserRole(data.userType());
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

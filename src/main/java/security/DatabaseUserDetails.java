package security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.lessons.java.bean.Ruolo;
import org.lessons.java.bean.Utente;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class DatabaseUserDetails implements UserDetails {

    //ATTRIBUTES TO FILL USERDETAILS'S METHODS WITH
    private String username;
    private String password;
    private Set<GrantedAuthority> authorities;

    //CONSTRUCTOR in which to insert the attributes
    public DatabaseUserDetails(Utente user) {
        this.username = user.getEmail();
        this.password = user.getPassword();
        this.authorities = new HashSet<>();
        //for (Ruolo r : user.getRuolo()) {
           // authorities.add(new SimpleGrantedAuthority(r.getNome()));
     //   }
    }

    //USERDETAILS'S METHODS

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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

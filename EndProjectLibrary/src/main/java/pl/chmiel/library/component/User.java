package pl.chmiel.library.component;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "users")
public class User implements Serializable, UserDetails {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long userId;
  private String userName;
  private String password;
  private String email;
  private boolean enabled;
  private String role;

  @ManyToMany(cascade = { CascadeType.ALL })
  @JoinTable(
          name = "book_list",
          joinColumns = @JoinColumn(name = "userId"),
          inverseJoinColumns = @JoinColumn(name = "id"))
  private Set<Book> bookSet = new HashSet<>();

  public User() {
  }

  public User(String userName, String password, String email, boolean enabled, String role, Set<Book> bookSet) {
    this.userName = userName;
    this.password = password;
    this.email = email;
    this.enabled = enabled;
    this.role = role;
    this.bookSet = bookSet;
  }

  public User(User user) {
    this.userId = user.userId;
    this.userName = user.userName;
    this.email = user.email;
    this.password = user.password;
    this.enabled = user.enabled;
    this.role = user.role;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public boolean getEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  public Long getUserid() {
    return userId;
  }

  public void setUserid(Long userid) {
    this.userId = userid;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public Set<Book> getBookSet() {
    return bookSet;
  }

  public void setBookSet(Set<Book> bookSet) {
    this.bookSet = bookSet;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return Collections.singleton(new SimpleGrantedAuthority(role));
  }

  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return userName;
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

  @Override
  public String toString() {
    return "User{" +
            "userId=" + userId +
            ", userName='" + userName + '\'' +
            ", password='" + password + '\'' +
            ", email='" + email + '\'' +
            ", enabled=" + enabled +
            ", role='" + role + '\'' +
            '}';
  }
}
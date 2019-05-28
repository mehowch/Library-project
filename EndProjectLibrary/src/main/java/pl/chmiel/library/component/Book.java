package pl.chmiel.library.component;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private String author;
  private int year;

  @ManyToMany(fetch = FetchType.LAZY,
          mappedBy = "bookSet")
  private Set<User> userSet = new HashSet<>();

  public Book() {
  }

  public Book(String title, String author, int year) {
    this.title = title;
    this.author = author;
    this.year = year;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public Set<User> getUserSet() {
    return userSet;
  }

  public void setUserSet(Set<User> userSet) {
    this.userSet = userSet;
  }

  @Override
  public String toString() {
    return "repository{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", author='" + author + '\'' +
            ", year=" + year +
            '}';
  }
}


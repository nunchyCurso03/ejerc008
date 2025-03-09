package es.santander.ascender.ejer008.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Usuario {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

@Column(nullable = false,  unique = true)
private String username;

@Column(nullable = false)
private String password;

@OneToOne(cascade = CascadeType.ALL)
  private Persona persona;

public Usuario() {
}

public Usuario(Long id, String username, String password, Persona persona) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.persona = persona;
}

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getUsername() {
    return username;
}

public void setUsername(String username) {
    this.username = username;
}

public String getPassword() {
    return password;
}

public void setPassword(String password) {
    this.password = password;
}

public Persona getPersona() {
    return persona;
}

public void setPersona(Persona persona) {
    this.persona = persona;
}

@Override
public String toString() {
    return "Usuario [id=" + id + ", usuario=" + username + ", password=" + password + ", persona=" + persona + "]";
}

@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
}

@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    Usuario other = (Usuario) obj;
    if (id == null) {
        if (other.id != null)
            return false;
    } else if (!id.equals(other.id))
        return false;
    return true;
}


  

}

 

package src.library;

import java.util.Objects;

public class Author {
    private String name;
    private String email;
    private Character gender;

    public Author(String name, String email, Character gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Character getGender() {
        return gender;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        Author that = (Author) obj;

        return Objects.equals(this.name, that.name) &&
                Objects.equals(this.email, that.email) &&
                Objects.equals(this.gender, that.gender);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash *= prime + ((name == null) ? 0 : name.hashCode());
        hash *= prime + ((email == null) ? 0 : email.hashCode());
        hash *= prime + ((gender == null) ? 0 : gender.hashCode());

        if (hash < 0) hash = -hash;

        return hash;
    }

    @Override
    public String toString() {
        return "Author[name = " + name + ", email = " + email + "gender = " + gender + "]";
    }
}

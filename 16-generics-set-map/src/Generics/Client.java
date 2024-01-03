package src.Generics;

import lombok.Getter;

@Getter
public class Client {

    @Getter
    private final String name;
    private final String email;

    public Client(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash *= prime + ((email == null) ? 0 : email.hashCode());

        if (hash < 0)
            hash *= -1;
        
        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        Client other = (Client) obj;

        if (this.email == null) {
            return other.email == null;
        } else return this.email.equals(other.email);
    }
}
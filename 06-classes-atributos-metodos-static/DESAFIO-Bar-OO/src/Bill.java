import java.util.Objects;

public class Bill {

    private final char gender;
    private final int beer;
    private final int barbecue;
    private final int softDrink;

    public Bill(char gender,
                int beer,
                int barbecue,
                int softDrink) {
        this.gender = gender;
        this.beer = beer;
        this.barbecue = barbecue;
        this.softDrink = softDrink;
    }

    double cover() {
        return this.feeding() > 30 ? 0 : 4;
    }

    double feeding() {
        double beerCost = 5 * beer;
        double barbecueCost = 7 * barbecue;
        double softDrinkCost = 3 * softDrink;

        return beerCost + barbecueCost + softDrinkCost;
    }

    double ticket() {
        return gender == 'M' ? 10 : 8;
    }

    double total() {
        double cover = this.cover();
        return cover + this.feeding() + this.ticket();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;

        Bill that = (Bill) o;

        return Objects.equals(this.gender, that.gender) &&
                Objects.equals(this.beer, that.beer) &&
                Objects.equals(this.barbecue, that.barbecue) &&
                Objects.equals(this.softDrink, that.softDrink);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash *= prime + Character.hashCode(this.gender);
        hash *= prime + Integer.hashCode(this.beer);
        hash *= prime + Integer.hashCode(this.barbecue);
        hash *= prime + Integer.hashCode(this.softDrink);

        if (hash < 0)
            hash *= -1;

        return hash;
    }

    @Override
    public String toString() {
        return "{" +
                "\n  \"gender\": \"" + this.gender + "\"," +
                "\n  \"beer\": " + this.beer + "," +
                "\n  \"barbecue\": " + this.barbecue + "," +
                "\n  \"softDrink\": " + this.softDrink +
                "\n}";
    }
}
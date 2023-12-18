public class Sale {

    private Integer month;
    private Integer day;
    private String seller;
    private Integer items;
    private Double total;

    public Sale(Integer month,
                Integer day,
                String seller,
                Integer items,
                Double total) {
        this.month = month;
        this.day = day;
        this.seller = seller;
        this.items = items;
        this.total = total;
    }

    public double averagePrice() {
        if (items != 0)
            return total / items;
        else
            return 0.0;
    }

    public String saleDetails() {
        return String.format("Venda em %d/%d por %s - Itens: %d, Total: R$ %.2f",
                month, day, seller, items, total);
    }

    public Integer getMonth() {
        return month;
    }

    public Integer getDay() {
        return day;
    }

    public String getSeller() {
        return seller;
    }

    public Integer getItems() {
        return items;
    }

    public Double getTotal() {
        return total;
    }
}

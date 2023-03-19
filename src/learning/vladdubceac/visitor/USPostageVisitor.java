package learning.vladdubceac.visitor;

public class USPostageVisitor implements Visitor {
    private static final double MINIMUM_PRICE_FOR_FREE_SHIPPING = 20.0;
    private double totalPostageForCart = 0;

    // collect data about the book
    @Override
    public void visit(Book book) {
        // assume we have a calculation here related to weight and price, free postage for a book over 20
        double price = book.getPrice();
        if (price < MINIMUM_PRICE_FOR_FREE_SHIPPING) {
            totalPostageForCart += book.getWeight() * 2;
        }
    }

    @Override
    public void visit(CD cd) {
        double price = cd.getPrice();
        if (price < MINIMUM_PRICE_FOR_FREE_SHIPPING) {
            totalPostageForCart += cd.getWeight() * 2.5;
        }
    }

    @Override
    public void visit(DVD dvd) {
        double price = dvd.getPrice();
        if (price < MINIMUM_PRICE_FOR_FREE_SHIPPING) {
            totalPostageForCart += dvd.getWeight() * 3;
        }
    }

    // return the internal state
    @Override
    public double getTotalPostage() {
        return totalPostageForCart;
    }
}

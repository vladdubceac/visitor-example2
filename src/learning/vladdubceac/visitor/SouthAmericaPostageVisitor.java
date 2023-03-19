package learning.vladdubceac.visitor;

public class SouthAmericaPostageVisitor implements Visitor {
    private static final double MINIMUM_PRICE_FOR_FREE_SHIPPING = 30.0;
    private double totalPostageForCart = 0;

    // collect data about the book
    @Override
    public void visit(Book book) {
        double price = book.getPrice();
        //assume we have a calculation here related to weight and price free postage for a book over 10
        if (price < MINIMUM_PRICE_FOR_FREE_SHIPPING) {
            totalPostageForCart += book.getWeight() * 4;
        }
    }

    @Override
    public void visit(CD cd) {
        double price = cd.getPrice();
        if (price < MINIMUM_PRICE_FOR_FREE_SHIPPING) {
            totalPostageForCart += cd.getWeight() * 5;
        }
    }

    @Override
    public void visit(DVD dvd) {
        double price = dvd.getPrice();
        if (price < MINIMUM_PRICE_FOR_FREE_SHIPPING) {
            totalPostageForCart += dvd.getWeight() * 6;
        }
    }

    @Override
    public double getTotalPostage() {
        return totalPostageForCart;
    }
}

package learning.vladdubceac.visitor;

import java.util.ArrayList;
import java.util.List;

public class Client {

    public static void main(String[] args) {
        Visitable book1 = new Book(8.52,1.05);

        Visitable cd1 = new CD(18.52,3.05);

        Visitable dvd1 = new DVD(6.53,4.02);

        List<Visitable> visitableList = new ArrayList();
        visitableList.add(book1);
        visitableList.add(cd1);
        visitableList.add(dvd1);

        double totalCost = 0d;
        totalCost = calculateTotalCost(visitableList, new USPostageVisitor());
        System.out.println("The total postage for shipping my items to US is: "+totalCost);
        System.out.println("-----------------------");
        totalCost = calculateTotalCost(visitableList, new SouthAmericaPostageVisitor());
        System.out.println("The total postage for shipping my items to South America is: "+totalCost);


    }

    private static double calculateTotalCost(List<Visitable> visitableList, Visitor visitor) {
        for (Visitable visitable : visitableList){
            visitable.accept(visitor);
        }
        return visitor.getTotalPostage();
    }
}

package pv260.solid.srp.original.page;

import pv260.solid.srp.original.Product;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class OrderPageConstructor {
    public String constructOrderPage(List<Product> products) throws Exception {
        try (InputStream in = getClass().getResourceAsStream("order.html");
             Scanner scan = new Scanner(in).useDelimiter("\\A")) {
            String template = scan.next();
            StringBuilder productsFormatted = new StringBuilder();
            for (Product p : products) {
                productsFormatted.append(Product.formatProduct(p));
            }
            return template.replace("{PRODUCTS}",
                    productsFormatted.toString());
        }
    }
}

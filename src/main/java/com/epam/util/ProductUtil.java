package main.java.com.epam.util;

import main.java.com.epam.constant.ProductNameEntityConstantEnum;
import main.java.com.epam.constant.ProductNamePrefixConstantEnum;
import main.java.com.epam.entity.Product;

import java.text.DecimalFormat;
import java.util.concurrent.ThreadLocalRandom;

public final class ProductUtil {

    private ProductUtil() {

    }

    public static Product getRandomlyGeneratedProduct(int id) {
        Product product;

        product = new Product(id, getRandomlyGeneratedProductName(), getRandomlyGeneratedPrice());

        return product;
    }

    public static double getRandomlyGeneratedPrice() {
        double price;
        double minValue = 5.00;
        double maxValue = 100_000.00;

        price = ThreadLocalRandom.current().nextDouble(minValue, maxValue);
        DecimalFormat df = new DecimalFormat("#.##");
        price = Double.valueOf(df.format(price));

        return price;
    }

    public static String getRandomlyGeneratedProductName() {
        String productName;

        productName = ProductNamePrefixConstantEnum.getRandomNameEntity().getNamePrefix() + " " +
                ProductNameEntityConstantEnum.getRandomNameEntity().getNameEntity();

        return productName;
    }
}

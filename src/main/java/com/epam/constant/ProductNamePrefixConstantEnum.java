package main.java.com.epam.constant;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum ProductNamePrefixConstantEnum {
    OLD("Old"),
    YELLOW("Yellow"),
    RED("Red"),
    BLUE("Blue"),
    WHITE("White"),
    GOLDEN("Golden"),
    BRAND_NEW("Brand New"),
    BLACK("BLACK"),
    NICE("Nice"),
    UNIQUE("Unique"),
    PRICELESS("Priceless"),
    CHEAP("Cheap"),
    FAKE("Fake");

    private String namePrefix;
    private static final List<ProductNamePrefixConstantEnum> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    ProductNamePrefixConstantEnum(String name) {
        namePrefix = name;
    }

    public static ProductNamePrefixConstantEnum getRandomNameEntity()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

    public String getNamePrefix() {
        return namePrefix;
    }
}

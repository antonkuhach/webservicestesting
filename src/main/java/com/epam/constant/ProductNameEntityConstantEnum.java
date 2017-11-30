package main.java.com.epam.constant;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum ProductNameEntityConstantEnum {
    SHOES("Shoes"),
    TABLE("Table"),
    NOTEBOOK("Notebook"),
    CAR("Car"),
    BICYCLE("Bicycle"),
    WALLET("Wallet"),
    DRESS("Dress"),
    JACKET("Jacket"),
    PARROT("Parrot"),
    CAT("Cat"),
    HOUSE("House"),
    MOOSE("Moose"),
    FRIDGE("Fridge");

    private String nameEntity;
    private static final List<ProductNameEntityConstantEnum> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    ProductNameEntityConstantEnum(String name) {
        nameEntity = name;
    }

    public static ProductNameEntityConstantEnum getRandomNameEntity()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

    public String getNameEntity() {
        return nameEntity;
    }
}

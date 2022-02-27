package com.tms.web.entities;

public enum BRAND {

    AUDI,
    MERCEDES,
    BMW;

    public static void forSetBrand(Car car) {

        if (String.valueOf(car.getNumber()).contains("1")) {
            car.setBrand(BRAND.AUDI);
        } else if (String.valueOf(car.getNumber()).contains("2")) {
            car.setBrand(BRAND.MERCEDES);
        } else {
            car.setBrand(BRAND.BMW);
        }
    }
}
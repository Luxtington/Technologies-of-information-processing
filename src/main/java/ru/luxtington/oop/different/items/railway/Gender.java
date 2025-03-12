package ru.luxtington.oop.different.items.railway;

public enum Gender {
    MALE_GENDER("male"),
    FEMALE_GENDER("female");

    private String desc;

    Gender(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return desc + "";
    }
}

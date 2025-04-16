package ru.luxtington.spring.bpp;

import org.springframework.stereotype.Component;
import ru.luxtington.annotations.ToString;
import ru.luxtington.annotations.ToStringOption;
import ru.luxtington.annotations.ValidateNew;

@Component
@ToString(ToStringOption.NO)
@ValidateNew("girlTest")
public class Girl {
    @ToString(ToStringOption.YES)
    private int age;
    private String entity;

    public Girl() {
        this(7, "Girl");
    }

    public Girl(int aNumber, String entity) {
        this.age = aNumber;
        this.entity = entity;
    }

    public int getAge() {
        return age;
    }

    public String getEntity() {
        return entity;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "age=" + age +
                ", entity='" + entity + '\'' +
                '}';
    }
}

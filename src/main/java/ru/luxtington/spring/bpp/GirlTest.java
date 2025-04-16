package ru.luxtington.spring.bpp;

import org.springframework.stereotype.Component;
import ru.luxtington.reflection.base.testSystem.TestValidationException;

@Component
public class GirlTest {
    private final Girl girl;
//    public GirlTest() {
//    }

    public GirlTest(Girl girl) {
        this.girl = girl;
    }

    public void testAge() throws TestValidationException {
        if (!(girl.getAge() > 0 && girl.getAge() < 19))
            throw new TestValidationException("Age should be from 1 to 18");
    }
}

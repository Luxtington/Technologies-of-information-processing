package ru.luxtington.reflection.base.other;

import ru.luxtington.oop.people.family.Boy;
import ru.luxtington.reflection.base.testSystem.TestValidationException;

public class TestBoyClass2 {
    private Boy boy;

    public TestBoyClass2(Boy boy) {
        this.boy = boy;
    }

    public void testParentsQuantity() throws TestValidationException {
        if (!(boy.getParentsQuantity() > 0 && boy.getParentsQuantity() < 3))
            throw new TestValidationException("Parents quantity can't be greater than 2");
    }
}

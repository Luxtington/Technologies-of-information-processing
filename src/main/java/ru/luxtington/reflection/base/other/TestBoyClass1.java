package ru.luxtington.reflection.base.other;

import ru.luxtington.oop.people.family.Boy;
import ru.luxtington.reflection.base.testSystem.TestValidationException;

public class TestBoyClass1 {
    private Boy boy;

    public TestBoyClass1(Boy boy) {
        this.boy = boy;
    }

    public void testAge() throws TestValidationException {
        if (!(boy.getAge() > 0 && boy.getAge() < 19))
            throw new TestValidationException("Age should be from 1 to 18");
    }

    private void testName() throws TestValidationException{
        if (boy.getName().length() < 2)
            throw new TestValidationException("Length of name should be greater than 2 letters");
    }
}

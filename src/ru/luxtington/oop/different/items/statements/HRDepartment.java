package ru.luxtington.oop.different.items.statements;

public class HRDepartment extends Department{

    private int availableVacancies;

    public HRDepartment(Department nextDepartment, int availableVacancies) {
        super(nextDepartment);
        if (availableVacancies < 0)
            throw new IllegalArgumentException("Quantity of vacancies should be > 0");
        this.availableVacancies = availableVacancies;
    }

    @Override
    Statement checkStatement(Statement statement) {
        if (availableVacancies < 1){
            statement.status = false;
            System.out.println("Statement was rejected by HR");
            return statement;
        }
        statement.captions.add("HR");
        return super.acceptStatement(this, statement);
    }
}

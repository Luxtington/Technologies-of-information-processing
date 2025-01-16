package ru.luxtington.oop.different.items.statements;

public class AccountingDepartment extends Department{

    public AccountingDepartment(Department nextDepartment) {
        super(nextDepartment);
    }

    @Override
    public Statement checkStatement(Statement statement) {
        char firstLetter = statement.text.toCharArray()[0];
        if (!((firstLetter >= 'A' && firstLetter <= 'Z') && statement.captions.contains("HR"))){
            statement.status = false;
            System.out.println("Statement was rejected by Accounting");
            return statement;
        }
        statement.captions.add("Accounting");
        return super.acceptStatement(this, statement);
    }
}

package ru.luxtington.oop.different.items.statements;

public abstract class Department {
    Department nextDepartment;

    public Department(Department nextDepartment) {
        this.nextDepartment = nextDepartment;
    }

    public final Statement acceptStatement(Department currDepartment, Statement statement){
        if (currDepartment.nextDepartment == null){
            statement.status = true;
            return statement;
        }
        return currDepartment.nextDepartment.checkStatement(statement);
    }

    abstract Statement checkStatement(Statement statement);
}

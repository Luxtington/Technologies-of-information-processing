package ru.luxtington.oop.different.items.statements;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SecurityDepartment extends Department{
    List<String> forbiddedNames = new ArrayList<>(Arrays.asList("Alex", "Ricco", "Bandit"));
    Department nextDepartment;

    public SecurityDepartment(Department nextDepartment) {
        super(nextDepartment);
    }

    public void addForbiddenName(@NotNull String name){
        forbiddedNames.add(name);
    }
    @Override
    public Statement checkStatement(Statement statement) {
        if (forbiddedNames.contains(statement.authorName)){
            statement.status = false;
            System.out.println("Statement was rejected by Security");
            return statement;
        }
        return super.acceptStatement(this, statement);
    }
}

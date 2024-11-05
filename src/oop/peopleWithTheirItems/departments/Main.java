package oop.peopleWithTheirItems.departments;

public class Main {
    public static void main(String[] args) {
        Worker w1 = new Worker("Petrov");
        Worker w2 = new Worker("Kozlov");
        Worker w3 = new Worker("Sidorov");
        Worker w4 = new Worker("Volkov");

        Department dep1 = new Department("IT", w2);

        w1.setDepartment(dep1);
        w2.setDepartment(dep1);
        w3.setDepartment(dep1);

        //Department dep2 = new Department("CyberSecurity", w1); // Petrov in IT => exc

        Department dep2 = new Department("CyberSecurity", w4);
        w4.setDepartment(dep2);
        w2.setDepartment(dep2);

        dep2.removeWorker(w4);
        dep1.removeWorker(w1);

        dep1.setChief(w4);
        dep2.setChief(w4);
        dep2.setChief(w1);

        System.out.println(w1 + " | " + w2 + " | " + w3+ " | " + w4);

        // тесты:
        //1) создание отделов с присвоением начальника - oк
        //2) сотруднику с имеющимся отделом сеттаем новый отдел - ок
        //3) начальнику с имеющимся отделом сеттаем новый отдел - ок
        //4) удаляем сотрудника (шефа), теперь нет шефа и сотрудника - ок
        //5) удаляем сотрудника - ок
        //6) установка шефа без исходного отдела - ок
        //7) установка шефа с исходным отделом (он пропадает из исходного) - ок
        //8) при установке нового шефа старый не пропадает из сотрудников своего отдела - ok
    }
}

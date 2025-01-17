package ru.luxtington.oop.people.studying;

import ru.luxtington.oop.generics.MyComparable;
import ru.luxtington.oop.generics.Stack;

import java.util.*;

public class Student implements MyComparable<Student> {

    private String name;
    private List<Integer> marks;
    private Rule rule;
    private Deque<Update> updateHistory = new ArrayDeque<>();

    public Student(String name, Rule rule, List<Integer> marks) {
        this.name = name;
        setRule(rule);
        this.setMarks(marks);
    }

    public Student(String name, Rule rule, Integer... marks) {
        this(name, rule, Arrays.asList(marks));
    }

    public Save save(){
        return new StudentSave();
    }

    public void rollBack(){
        if (updateHistory.isEmpty()){
            System.out.println("There're no updates to roll back");
            return;
        }
        updateHistory.pop().rollBack();
    }

    class AddMarkUpdate implements Update{
        private Integer mark;

        public AddMarkUpdate(Integer mark) {
            this.mark = mark;
        }

        @Override
        public void rollBack() {
            Student.this.marks.remove(mark);
        }
    }

    class RemoveMarkUpdate implements Update{
        private Integer mark;

        private RemoveMarkUpdate(Integer mark) {
            this.mark = mark;
        }

        @Override
        public void rollBack() {
            Student.this.marks.add(mark);
        }
    }

    class SetNameUpdate implements Update{

        private String oldName;
        private String newName;

        private SetNameUpdate(String newName) {
            this.oldName = Student.this.name;
            this.newName = newName;
        }

        @Override
        public void rollBack() {
            Student.this.name = oldName;
        }
    }
    class AddMarksUpdate implements Update{

        private List<Integer> marks;

        private AddMarksUpdate(List<Integer> marks) {
            this.marks = marks;
        }

        @Override
        public void rollBack() {
            for (int i=marks.size() - 1; i >= 0; i--)
                Student.this.marks.remove(i);
        }
    }

    class StudentSave implements Save{

        private final String name;
        private final List<Integer> marks;


        private StudentSave() {
            this.name = Student.this.name;
            this.marks = Student.this.getMarks();
        }

        @Override
        public void load(){
            Student.this.name = name;
            Student.this.marks = new ArrayList<>(marks);
        }
    }

    public void setName(String name){
        updateHistory.push(new SetNameUpdate(name));
        this.name = name;
    }

    public void setMarks(List<Integer> marks) {
        this.marks = new ArrayList<>();
        this.addMarks(marks);
    }

    public void setRule(Rule rule) {
        if (rule == null)
            throw new IllegalArgumentException("Rule can't be null");
        this.rule = rule;
    }

    public double getAverageMark() {
        if (marks == null)
            return 0;

        int i, sum = 0;
        for (i = 0; i < marks.size(); i++)
            sum += marks.get(i);

        return (double)sum / (i);
    }

    public boolean isHeEpcellentStudent() {
        return this.getAverageMark() == rule.getUpMark();
    }

    public String getName() {
        return name;
    }

    public List<Integer> getMarks() {
        return new ArrayList<Integer>(marks);
    }

    public void addMarks(List<Integer> marks) {
        for (int i = 0; i < marks.size(); i++){
            this.addMark(marks.get(i));
            updateHistory.push(new AddMarksUpdate(marks));
        }
    }

    public void addMark(int mark) throws IncorrectMarkException {
        if (rule.isCorrectMark(mark)){
            marks.add(mark);
            updateHistory.push(new AddMarkUpdate(mark));
        }

        else
            throw new IncorrectMarkException("Incorrect value of student's mark");
    }

    public void removeMark(int mark){
        if (!(marks.contains(mark)))
            throw new IllegalArgumentException("There's no such mark in student's marks");

        for (int i=marks.size() - 1; i >= 0 ; i--)
            if (marks.get(i) == mark){
                marks.remove(i);
                updateHistory.push(new RemoveMarkUpdate(mark));
                break;
            }

    }

    @Override
    public int compareTo(Student otherStudent) {
        if ((this.getAverageMark() - otherStudent.getAverageMark()) == 0)
            return 0;
        return (this.getAverageMark() > otherStudent.getAverageMark()) ? 1 : -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && getAverageMark() == student.getAverageMark();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, getAverageMark());
    }

    public String toString() {
        String res = (marks == null) ? (name + " without marks") : (name + ": " + marks.toString());
        return res;
    }
}

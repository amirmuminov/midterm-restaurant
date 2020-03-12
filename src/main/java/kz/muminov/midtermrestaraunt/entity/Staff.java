package kz.muminov.midtermrestaraunt.entity;

import java.util.Date;

public class Staff {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private Position position;
    private Date hireDate;
    private float baseSalary;

    public Staff(Long id, String firstName, String lastName, int age, Position position, Date hireDate, float baseSalary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.position = position;
        this.hireDate = hireDate;
        this.baseSalary = baseSalary;
    }

    public Staff(String firstName, String lastName, int age, Position position, Date hireDate, float baseSalary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.position = position;
        this.hireDate = hireDate;
        this.baseSalary = baseSalary;
    }

    public Staff() {
    }

    public float getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(float baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
}

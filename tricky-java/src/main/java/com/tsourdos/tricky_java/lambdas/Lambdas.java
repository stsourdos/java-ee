package com.tsourdos.tricky_java.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import static java.util.stream.Collectors.*;

/**
 *
 * @author s.tsourdos
 */
public class Lambdas {

    public static void main(String[] args) {

        Person[] personArray = new Person[2];
        personArray[0] = new Person("Palmer", "Dene", "Java programmer", "male", 33, 2000);
        personArray[1] = new Person("Addison", "Pam", "Java programmer", "female", 34, 1360);

        // sort elementa in an array
        Arrays.sort(personArray, (p1, p2) -> (p1.getFirstName().compareTo(p2.getFirstName())));

        List<Person> personList = new ArrayList();
        personList.add(new Person("Palmer", "Dene", "Java programmer", "male", 33, 2000));
        personList.add(new Person("Addison", "Pam", "Java programmer", "female", 34, 1360));
        personList.add(new Person("Addison", "Pam", "Java programmer", "female", 35, 1350));

        // perform operation on each list element
        Consumer<Person> giveRaise = e -> e.setSalary(e.getSalary() / 100 * 5 + e.getSalary());
        personList.forEach(giveRaise);

        // sort elements in a list
        List<Person> sortedJavaProgrammers = personList
                .stream()
                .sorted((p, p2) -> {
                    return !(p.getFirstName().equals(p2.getFirstName())) ? p.getFirstName().compareTo(p2.getFirstName()) : p2.getSalary().compareTo(p.getSalary());
                })
                .collect(toList());

        System.out.println(sortedJavaProgrammers);

        // get min/max element
        Person person = personList
                .stream()
                //.min((p, p2) -> (p.getSalary() - p2.getSalary()))
                .max((p, p2) -> (p.getSalary() - p2.getSalary()))
                .get();
        System.out.println(person);

        // get first names in a list/csv/treeset ...
        Set<String> personNames = personList
                .stream()
                .map(Person::getFirstName)
                .collect(toSet());

        // parallel streams to get total salary
        int totalSalary = personList
                .parallelStream()
                .mapToInt(p -> p.getSalary())
                .sum();
    }

    public static class Person {

        private String firstName, lastName, job, gender;
        private int salary, age;

        public Person(String firstName, String lastName, String job, String gender, int age, int salary) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.gender = gender;
            this.age = age;
            this.job = job;
            this.salary = salary;
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

        public String getJob() {
            return job;
        }

        public void setJob(String job) {
            this.job = job;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public Integer getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" + "firstName=" + firstName + ", salary=" + salary + '}';
        }
    }
}

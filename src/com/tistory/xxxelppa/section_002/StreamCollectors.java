package com.tistory.xxxelppa.section_002;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
    collect    : method
    Collector  : interface
    Collectors : class

     // Accumulate names into a List
         List<String> list
            = people.stream().map(Person::getName)
                .collect(Collectors.toList());

     // Accumulate names into a TreeSet
         Set<String> set
            = people.stream().map(Person::getName)
                .collect(Collectors.toCollection(TreeSet::new));

     // Convert elements to strings and concatenate them, separated by commas
         String joined
            = things.stream().map(Object::toString)
                .collect(Collectors.joining(", "));

     // Compute sum of salaries of employee
         int total
            = employees.stream()
                .collect(Collectors.summingInt(Employee::getSalary)));

     // Group employees by department
         Map<Department, List<Employee>> byDept
            = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

     // Compute sum of salaries by department
         Map<Department, Integer> totalByDept
            = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingInt(Employee::getSalary)));

     // Partition students into passing and failing
         Map<Boolean, List<Student>> passingFailing
            = students.stream()
                .collect(Collectors.partitioningBy(s -> s.getGrade() >= PASS_THRESHOLD));

 */
public class StreamCollectors {
    /*
     * collect(Collector<T, A, R> collector)
     * collect 메소드는 Collector<T, A, R> 인터페이스 타입을 매개변수로 받음.
     * Collector<T, A, R> 타입을 반환하는 메소드를 Collectors 클래스에 static method 로 미리 정의.
     * 특별한 경우가 아니라면 collect 메소드 사용시 Collectors 클래스의 method 를 사용.
     */

    public static void main(String[] args) {
        List<Student> totalList = Arrays.asList(
                new Student("고구마", 10, Student.Gender.MALE),
                new Student("감자", 6, Student.Gender.FEMALE),
                new Student("김치찌개", 10, Student.Gender.MALE),
                new Student("된장찌개", 6, Student.Gender.FEMALE)
        );

        List<Student> maleList = totalList.stream()
                .filter(s -> s.getGender() == Student.Gender.MALE)
                .collect(Collectors.toList());
        maleList.stream()
                .forEach(s -> System.out.println(s.getName()));

        System.out.println();

        Set<Student> femaleList = totalList.stream()
                .filter(s -> s.getGender() == Student.Gender.FEMALE)
                .collect(Collectors.toCollection(HashSet::new));
        femaleList.stream()
                .forEach(s -> System.out.println(s.getName()));

    }
}

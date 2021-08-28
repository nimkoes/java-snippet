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
     *
     * T : collect 대상
     * A : accumulator -> 누산기, T 를 collection 에 수집
     * R : T 가 수집 된 새로운 collection
     *
     * Collectors API 의 static method 중 accumulator 가 ? 로 되어있는 부분이 있는데
     * 잘 알려진 각 collection (List, Map, Set) 에 대해 누산 할 방법을 이미 알고 있기 때문에
     * accumulator 를 굳이 알려주지 않아도 되기 때문이다.
     */

    public static void main(String[] args) {

    }
}

package me.nimkoes.section_002;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
        List<Student> totalList = Arrays.asList(
            new Student("고구마", 17, Student.Gender.MALE, Student.City.ANYANG),
            new Student("복숭아", 21, Student.Gender.FEMALE, Student.City.SEOUL),
            new Student("스트림", 17, Student.Gender.MALE, Student.City.SEOUL),
            new Student("컬렉션", 21, Student.Gender.FEMALE, Student.City.ANYANG)
        );

        // 남학생 리스트 생성
        List<Student> maleList = totalList.stream().filter(s -> s.getGender() == Student.Gender.MALE).collect(Collectors.toList());
        maleList.forEach(s-> System.out.println(s.getName()));

        System.out.println();

        // 여학생 HashSet 생성
        HashSet<Student> femaleSet = totalList.stream().filter(s -> s.getGender() == Student.Gender.FEMALE).collect(Collectors.toCollection(HashSet::new));
        femaleSet.forEach(s-> System.out.println(s.getName()));

        System.out.println();

        // 사용자 정의 컨테이너 collect 실습 (싱글 스레드)
        MaleStudent maleStudent = totalList.stream().filter(s -> s.getGender() == Student.Gender.MALE)
            .collect(
                () -> new MaleStudent(),            // 사용자 정의 컨테이너를 만드는 supplier
                (r, t) -> r.accumulate(t),          // r : 컨테이너로 첫번째 매개변수를 가리킨다. / t : filter 된 요소를 가리킨다.
                (r1, r2) -> r1.combine(r2)          // 병렬 처리를 위해 추가 된 것 / r1 과 r2 는 MaleStudent 의 서로 다른 객체
            );

        maleStudent.getList().stream().forEach(s-> System.out.println(s.getName()));

        System.out.println();

        // grouping 실습
        Map<Student.Gender, List<Student>> mapByGenderListMap = totalList.stream().collect(Collectors.groupingBy(Student::getGender));
        mapByGenderListMap.forEach((k, v) -> {
            System.out.println(k);
            System.out.println("==========");
            v.forEach(elem -> System.out.println(elem.getName() + " : " + elem.getCity() + " : " + elem.getScore()));
            System.out.println();
        });

        Map<Student.City, List<String>> mapByCityListMap = totalList.stream()
            .collect(
                Collectors.groupingBy(
                    Student::getCity,
                    Collectors.mapping(Student::getName, Collectors.toList())
                )
            );

        Map<Student.City, Set<String>> mapByCitySetMap_1 = totalList.stream()
            .collect(
                Collectors.groupingBy(
                    Student::getCity,
                    Collectors.mapping(Student::getName, Collectors.toCollection(HashSet::new))
                )
            );

        Map<Student.City, Set<String>> mapByCitySetMap_2 = totalList.stream()
            .collect(
                Collectors.groupingBy(
                    Student::getCity,
                    Collectors.mapping(Student::getName, Collectors.toSet())
                )
            );

        // grouping 실습 2
        Map<Student.Gender, Double> mapByGenderAvg = totalList.stream()
            .collect(
                Collectors.groupingBy(
                    Student::getGender,
                    Collectors.averagingDouble(Student::getScore)
                )
            );

        mapByGenderAvg.forEach((k, v) -> {
            System.out.println(k + " :: " + v);
        });

        System.out.println();

        Map<Student.Gender, String> mapByName = totalList.stream()
            .collect(
                Collectors.groupingBy(
                    Student::getGender,
                    Collectors.mapping(Student::getName, Collectors.joining(","))
                )
            );

        mapByName.forEach((k, v) -> {
            System.out.println(k + " : " + v);
        });
    }
}

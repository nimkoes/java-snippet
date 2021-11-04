package me.nimkoes.section_002;

public class Student {
    public enum Gender {MALE, FEMALE}

    public enum City {ANYANG, SEOUL}

    private String name;
    private int score;
    private Gender gender;
    private City city;

    public Student(String name, int score, Gender gender) {
        this.name = name;
        this.score = score;
        this.gender = gender;
    }

    public Student(String name, int score, Gender gender, City city) {
        this.name = name;
        this.score = score;
        this.gender = gender;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public Gender getGender() {
        return gender;
    }

    public City getCity() {
        return city;
    }
}

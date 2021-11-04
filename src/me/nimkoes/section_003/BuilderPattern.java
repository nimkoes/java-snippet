package me.nimkoes.section_003;

public class BuilderPattern {
    public static void main(String[] args) {
        System.out.println(new DataSample.Builder("nimkoes", 11).build().toString());
        System.out.println(new DataSample.Builder("nimkoes", 21).address("korea").build().toString());
        System.out.println(new DataSample.Builder("nimkoes", 31).address("asia").gender("male").build().toString());
    }
}

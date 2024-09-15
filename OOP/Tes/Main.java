public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Ali");

        Person p2 = p1;

        p1.setName("Budi");
        System.out.println(p1.getName());
        System.out.println(p2.getName());
    }
}

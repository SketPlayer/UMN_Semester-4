public class Main {
    public static void main(String[] args) {
        // Membuat objek Person
        Person person1 = new Person("John Thor", 'M', null, null);
        Person person2 = new Person("Jane Doe", 'F', person1, null);
        Person person3 = new Person("Megawati", 'F', person1, null);
        Person person4 = new Person("Arya Wiguna", 'M', person2, null);
        Person person5 = new Person("Emma Batu", 'F', person3, null);

        // Menambahkan hubungan antar Person
        person1.addChild(person2);
        person1.addChild(person3);
        person3.addChild(person5);
        person2.addChild(person4);

        // Menampilkan informasi
        System.out.println("Anak dari setiap person:");
        System.out.print("Person 1 "); displayChildren(person1);
        System.out.print("Person 2 "); displayChildren(person2);
        System.out.print("Person 3 "); displayChildren(person3);
        System.out.print("Person 4 "); displayChildren(person4);
        System.out.print("Person 5 "); displayChildren(person5);

        // Successors
        System.out.println("\nKeturunan dari setiap person:");
        System.out.print("Person 1 "); displaySuccessors(person1);
        System.out.print("Person 2 "); displaySuccessors(person2);
        System.out.print("Person 3 "); displaySuccessors(person3);
        System.out.print("Person 4 "); displaySuccessors(person4);
        System.out.print("Person 5 "); displaySuccessors(person5);

        // Ancestors
        System.out.println("\nLeluhur dari setiap person:");
        System.out.print("Person 1 "); displayAncestors(person1);
        System.out.print("Person 2 "); displayAncestors(person2);
        System.out.print("Person 3 "); displayAncestors(person3);
        System.out.print("Person 4 "); displayAncestors(person4);
        System.out.print("Person 5 "); displayAncestors(person5);
    }

    // Metode untuk menampilkan informasi anak
    public static void displayChildren(Person person) {
        System.out.print(person.getNama() + " -> ");
        Person[] children = person.getChild(' ');
        if (children != null) {
            for (Person child : children) {
                System.out.print(child + ", ");
            }
        } else {
            System.out.print("");
        }
        System.out.println();
    }

    // Metode untuk menampilkan informasi keturunan
    public static void displaySuccessors(Person person) {
        System.out.print(person.getNama() + " -> ");
        for (Person successor : person.getAllSuccessors()) {
            System.out.print(successor + ", ");
        }
        System.out.println();
    }

    // Metode untuk menampilkan informasi leluhur
    public static void displayAncestors(Person person) {
        System.out.print(person.getNama() + " -> ");
        for (Person ancestor : person.getAllAncestors()) {
            System.out.print(ancestor + ", ");
        }
        System.out.println();
    }
}

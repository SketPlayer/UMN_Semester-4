import java.util.ArrayList;
import java.util.List;

public class Person {
    private String nama;
    private char jenisKelamin;
    private Person parent;
    private Person[] children;

    // Constructor
    public Person(String nama, char jenisKelamin, Person parent, Person[] children) {
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.parent = parent;
        this.children = children;
    }

    // Mengembalikan nilai atribut nama
    public String getNama() {
        return nama;
    }

    // Mengembalikan nilai jenis_kelamin
    public String getJenisKelamin() {
        if (jenisKelamin == 'F') {
            return "Perempuan";
        } else if (jenisKelamin == 'M') {
            return "Pria";
        } else {
            return "Unknown";
        }
    }

    // Mengembalikan nilai atribut parent
    public Person getParent() {
        return parent;
    }

    // Mengembalikan subset dari children berdasarkan jenis kelamin
    public Person[] getChild(char jenisKelamin) {
        if (jenisKelamin == ' ') {
            return children; // Kembalikan seluruh children
        } else {
            List<Person> selectedChildren = new ArrayList<>();
            for (Person child : children) {
                if (child.getJenisKelamin().charAt(0) == jenisKelamin) {
                    selectedChildren.add(child);
                }
            }
            return selectedChildren.toArray(new Person[0]);
        }
    }

    // Method untuk menambahkan seorang anak ke dalam children
    public void addChild(Person p) {
        if (children == null) {
            children = new Person[1];
            children[0] = p;
        } else {
            Person[] newChildren = new Person[children.length + 1];
            System.arraycopy(children, 0, newChildren, 0, children.length);
            newChildren[children.length] = p;
            children = newChildren;
        }
    }

    // Mengembalikan seluruh keturunan dari sebuah objek Person
    public Person[] getAllSuccessors() {
        List<Person> successors = new ArrayList<>();
        if (children != null) {
            for (Person child : children) {
                successors.add(child);
                successors.addAll(List.of(child.getAllSuccessors()));
            }
        }
        return successors.toArray(new Person[0]);
    }

    // Mengembalikan seluruh leluhur dari sebuah objek Person
    public Person[] getAllAncestors() {
        List<Person> ancestors = new ArrayList<>();
        if (parent != null) {
            ancestors.add(parent);
            ancestors.addAll(List.of(parent.getAllAncestors()));
        }
        return ancestors.toArray(new Person[0]);
    }

    @Override
    public String toString() {
        return nama;
    }
}
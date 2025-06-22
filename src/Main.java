import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Owner.Pet> pets = new ArrayList<>();
        pets.add(new Owner("Anna").new Pet("Barsik", 3));
        pets.add(new Owner("Ivan").new Pet("Kuzia", 5));
        pets.add(new Owner("Oleh").new Pet("Barsik", 3));
        pets.add(new Owner("Nina").new Pet("Luna", 2));


        System.out.println("\n--- ArrayList (всі елементи):");
        for (Owner.Pet pet : pets) {
            System.out.println(pet);
        }


        Set<Owner.Pet> petSet = new HashSet<>(pets);
        System.out.println("\n--- HashSet (унікальні елементи):");
        for (Owner.Pet pet : petSet) {
            System.out.println(pet);
        }


        pets.sort(Comparator.naturalOrder());
        System.out.println("\n--- Sorted ArrayList (за ім’ям):");
        for (Owner.Pet pet : pets) {
            System.out.println(pet);
        }


        Set<Owner.Pet> treeSet = new TreeSet<>(pets);
        System.out.println("\n--- TreeSet (впорядковані унікальні):");
        for (Owner.Pet pet : treeSet) {
            System.out.println(pet);
        }


        Map<String, Owner.Pet> petMap = new TreeMap<>();
        for (Owner.Pet pet : pets) {
            petMap.put(pet.getName(), pet);
        }
        System.out.println("\n--- TreeMap (ключ - ім’я):");
        for (String name : petMap.keySet()) {
            System.out.println(name + " => " + petMap.get(name));
        }


        LinkedList<Owner.Pet> linkedList = new LinkedList<>(pets);
        System.out.println("\n--- LinkedList:");
        linkedList.forEach(System.out::println);


        Queue<Owner.Pet> queue = new LinkedList<>(pets);
        System.out.println("\n--- Queue (FIFO):");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

        PriorityQueue<Owner.Pet> priorityQueue = new PriorityQueue<>(pets);
        System.out.println("\n--- PriorityQueue (sorted by name):");
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
    }
}


class Owner {
    private String name;

    public Owner(String name) {
        this.name = name;
    }

    public class Pet implements Comparable<Pet> {
        private String name;
        private int age;

        public Pet(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public void displayPetInfo() {
            System.out.println("Pet: " + name + ", Age: " + age);
        }

        @Override
        public String toString() {
            return "Pet{name='" + name + "', age=" + age + '}';
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pet pet = (Pet) obj;
            return age == pet.age && Objects.equals(name, pet.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

        @Override
        public int compareTo(Pet o) {
            return this.name.compareTo(o.name);
        }
    }
}

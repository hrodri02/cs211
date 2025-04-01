import java.util.Comparator;

public abstract class Animal implements Comparable<Animal>
{
   private AnimalStatus status;
   private String name;
   private int age;
   private static final AnimalStatus DEFAULT_STATUS = AnimalStatus.NEW;

   public Animal(String name, int age) {
      this(name, age, Animal.DEFAULT_STATUS);
   }

   public Animal(String name, int age, AnimalStatus status) {
      this.name = name;
      this.age = age;
      this.status = status;
   }

   public String getName() {
      return name;
   }
   public int getAge() {
      return age;
   }
   public void setName(String name) {
      this.name = name;
   }
   public void setAge(int age) {
      if (age >= 0) {
         this.age = age;
      }
   }

   public AnimalStatus getStatus() {
    return status;
   }

   @Override
   public String toString() {
      return name + " (Age: " + age + ")";
   }

   public void feed() {
      System.out.println("Feeding " + name);
   }

   public void adopt() {
      System.out.println(name + " is being adopted.");
   }

   @Override
   public boolean equals(Object otherAnimal) {
      if (this == otherAnimal) return true;
      if (otherAnimal == null) return false;
      return (otherAnimal instanceof Animal a) && 
                a.name.equalsIgnoreCase(name) &&
                a.age == age;
   }

   @Override
   public int compareTo(Animal animal) {
      if (name.equalsIgnoreCase(animal.name)) {
        return Integer.compare(age, animal.age);
      }
      return name.compareTo(animal.name);
   }

   public static class AnimalAgeComparator implements Comparator<Animal> {
      @Override
      public int compare(Animal a1, Animal a2) {
        return Integer.compare(a1.age, a2.age);
      }
   }
}
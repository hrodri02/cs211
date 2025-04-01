import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnimalDriver {
    public static void main(String[] args) {
        List<Animal> animalList = new ArrayList<>();
        Animal a1 = new Dog("Droolius Caesar", 8, AnimalStatus.TEMPORARY, "Mutt");
        Animal a2 = new Dog("Salvador Dogi",   2, AnimalStatus.TEMPORARY, "Lab");
        animalList.add(a1);
        animalList.add(a2);
        animalList.add(new Cat("Hairy Pawter",    8, false));
        animalList.add(new Bird("Meryl Cheep",    1));

        for(Animal animal : animalList) {
            animal.feed();
        }

        System.out.println(animalList);
        System.out.println("Animals sorted by name then age");
        Collections.sort(animalList);
        System.out.println(animalList);

        Volunteer heri = new Volunteer("heri", "(415) 111-1111");
        System.out.println(heri);

        // printOlderAnimalsToFile(animalList, 3, "cats_older_than_3.txt");

        // System.out.println(animalList);
        // Collections.sort(animalList, new Animal.AnimalAgeComparator());
        // System.out.println("Animals sorted by age");
        // System.out.println(animalList);

        System.out.println(countAdoptableAnimals(animalList));

        Map<String, Animal> nameToAnimal = createNameToAnimalMap(animalList);
        adoptionUpdates(nameToAnimal, List.of("Droolius Caesar", "Salvador Dogi"));
    }

    public static void printOlderAnimalsToFile(List<Animal> animals, int minAge, String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(fileName))) {
            for (Animal animal : animals) {
                if (animal.getAge() > minAge) {
                    writer.println(animal.getName());
                }
            }
        }
        catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
   }

   public static int countAdoptableAnimals(List<Animal> animals) {
      int total = 0;
      for (Animal animal : animals) {
        if (animal.getStatus().getIsEligibleForAdoption()) {
            total += 1;
        }
      }
      return total;
   }

   // animalMap: key = String name, value = Animal animal
   public static void adoptionUpdates(Map<String, Animal> animalMap, List<String> adoptedAnimalNameList) {
      for (String name : adoptedAnimalNameList) {
        if (animalMap.containsKey(name)) {
            Animal animal = animalMap.get(name);
            animal.adopt();
        }
      }
   }

   public static Map<String, Animal> createNameToAnimalMap(List<Animal> animalList) {
      Map<String, Animal> nameToAnimal = new HashMap<>();
      for (Animal animal : animalList) {
        nameToAnimal.put(animal.getName(), animal);
      }
      return nameToAnimal;
   }
}

package rocks.zipcodewilmington;

import org.junit.Assert;
import org.junit.Test;
import rocks.zipcodewilmington.animals.Animal;
import rocks.zipcodewilmington.animals.Cat;
import rocks.zipcodewilmington.animals.Dog;
import rocks.zipcodewilmington.animals.animal_creation.AnimalFactory;
import rocks.zipcodewilmington.animals.animal_storage.CatHouse;
import rocks.zipcodewilmington.animals.animal_storage.DogHouse;

import java.util.Date;

/**
 * @author leon on 4/19/18.
 */
public class AnimalFactoryTest {


    //TODO - Create Test for `Animal createDog(String name, Date birthDate)`
    @Test
    public void dogTest() {
        DogHouse testHouse = new DogHouse();
        testHouse.add(new Dog("", new Date(), 1));
        testHouse.add(new Dog("", new Date(), 2));
        testHouse.add(new Dog("", new Date(), 4));
        // Given (dog data)
        String givenName = "Zula";
        Date givenBirthDate = new Date();

        // When (a dog is constructed)
        Dog dog = AnimalFactory.createDog(givenName, givenBirthDate);

        // When (we retrieve data from the dog)
        String retrievedName = dog.getName();
        Date retrievedBirthDate = dog.getBirthDate();
        Integer retrievedId = dog.getId();

        // Then (we expect the given data, to match the retrieved data)
        Assert.assertEquals(givenName, retrievedName);
        Assert.assertEquals(givenBirthDate, retrievedBirthDate);
        Assert.assertTrue(3 == retrievedId);
        testHouse.clear();
    }
    //TODO - Create Test for `Animal createCat(String name, Date birthDate)`
    @Test
    public void catTest() {
        CatHouse testHouse = new CatHouse();
        testHouse.add(new Cat("", new Date(), 1));
        testHouse.add(new Cat("", new Date(), 2));
        testHouse.add(new Cat("", new Date(), 4));
        // Given (cat data)
        String givenName = "Zula";
        Date givenBirthDate = new Date();

        // When (a cat is constructed)
        Cat cat = AnimalFactory.createCat(givenName, givenBirthDate);

        // When (we retrieve data from the cat)
        String retrievedName = cat.getName();
        Date retrievedBirthDate = cat.getBirthDate();
        Integer retrievedId = cat.getId();

        // Then (we expect the given data, to match the retrieved data)
        Assert.assertEquals(givenName, retrievedName);
        Assert.assertEquals(givenBirthDate, retrievedBirthDate);
        Assert.assertTrue(3 == retrievedId);
        testHouse.clear();
    }
}

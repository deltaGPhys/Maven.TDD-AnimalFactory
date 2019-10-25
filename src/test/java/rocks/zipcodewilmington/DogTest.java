package rocks.zipcodewilmington;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import rocks.zipcodewilmington.animals.Animal;
import rocks.zipcodewilmington.animals.Dog;
import rocks.zipcodewilmington.animals.Mammal;

import java.util.Date;

/**
 * @author leon on 4/19/18.
 */
@RunWith(JUnitParamsRunner.class)
public class DogTest {

    private static Dog testDog;

    @Before
    public void setUp() throws Exception {
        // Given (dog data)
        String givenName = "Bilbo";
        Date givenBirthDate = new Date();
        Integer givenId = 0;

        // When (a dog is constructed)
        testDog = new Dog(givenName, givenBirthDate, givenId);
    }

    @Test
    public void constructorTest() {
        // Given (dog data)
        String givenName = "Zula";
        Date givenBirthDate = new Date();
        Integer givenId = 0;

        // When (a dog is constructed)
        Dog dog = new Dog(givenName, givenBirthDate, givenId);

        // When (we retrieve data from the dog)
        String retrievedName = dog.getName();
        Date retrievedBirthDate = dog.getBirthDate();
        Integer retrievedId = dog.getId();

        // Then (we expect the given data, to match the retrieved data)
        Assert.assertEquals(givenName, retrievedName);
        Assert.assertEquals(givenBirthDate, retrievedBirthDate);
        Assert.assertEquals(givenId, retrievedId);
    }


    @Test
    @Parameters({"Bea","Arthur",""})
    public void setNameTest (String expected) {

        testDog.setName(expected);
        String actual = testDog.getName();

        Assert.assertEquals(actual, expected);
    }


    // TODO - Create tests for `speak`

    @Test
    public void speakTest1() {

        Assert.assertEquals("bark!", testDog.speak());
    }

    // TODO - Create tests for `setBirthDate(Date birthDate)`

    @Test
    public void setBirthDateTests() {

        Date date1 = new Date();
        Date date2 = new Date();
        testDog.setBirthDate(date1);
        Assert.assertEquals(testDog.getBirthDate(), date1);
        testDog.setBirthDate(date2);
        Assert.assertEquals(testDog.getBirthDate(), date2);
    }


    // TODO - Create tests for `void eat(Food food)`
    @Test
    public void eatTest () {
        Food food1 = new Food();
        Food food2 = new Food();
        Assert.assertTrue(0 == testDog.getNumberOfMealsEaten());
        testDog.eat(food1);
        Assert.assertTrue(1 == testDog.getNumberOfMealsEaten());
        testDog.eat(food2);
        Assert.assertTrue(2 == testDog.getNumberOfMealsEaten());
    }

    // TODO - Create tests for `Integer getId()`
    @Test
    public void idTest () {

        Assert.assertTrue(0 == testDog.getId());

        // Given (dog data)
        String givenName = "Bilbo";
        Date givenBirthDate = new Date();
        Integer givenId = 1;

        // When (a dog is constructed)
        Dog testDog2 = new Dog(givenName, givenBirthDate, givenId);
        Assert.assertTrue(1 == testDog2.getId());
    }

    // TODO - Create test to check Animal inheritance; google search `java instanceof keyword`

    @Test
    public void animalInheritanceTest() {
        Assert.assertTrue(testDog instanceof Animal);
    }


    // TODO - Create test to check Mammal inheritance; google search `java instanceof keyword`
    @Test
    public void mammalInheritanceTest() {
        Assert.assertTrue(testDog instanceof Mammal);
    }

}

package rocks.zipcodewilmington;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import rocks.zipcodewilmington.animals.Animal;
import rocks.zipcodewilmington.animals.Cat;
import rocks.zipcodewilmington.animals.Mammal;

import java.util.Date;

/**
 * @author leon on 4/19/18.
 */
@RunWith(JUnitParamsRunner.class)
public class CatTest {

    private static Cat testCat;

    @Before
    public void setUp() throws Exception {
        // Given (cat data)
        String givenName = "Bilbo";
        Date givenBirthDate = new Date();
        Integer givenId = 0;

        // When (a cat is constructed)
        testCat = new Cat(givenName, givenBirthDate, givenId);
    }

    @Test
    public void constructorTest() {
        // Given (cat data)
        String givenName = "Zula";
        Date givenBirthDate = new Date();
        Integer givenId = 0;

        // When (a cat is constructed)
        Cat cat = new Cat(givenName, givenBirthDate, givenId);

        // When (we retrieve data from the cat)
        String retrievedName = cat.getName();
        Date retrievedBirthDate = cat.getBirthDate();
        Integer retrievedId = cat.getId();

        // Then (we expect the given data, to match the retrieved data)
        Assert.assertEquals(givenName, retrievedName);
        Assert.assertEquals(givenBirthDate, retrievedBirthDate);
        Assert.assertEquals(givenId, retrievedId);
    }


    @Test
    @Parameters({"Bea","Arthur",""})
    public void setNameTest (String expected) {

        testCat.setName(expected);
        String actual = testCat.getName();

        Assert.assertEquals(actual, expected);
    }


    // TODO - Create tests for `speak`

    @Test
    public void speakTest1() {

        Assert.assertEquals("meow!", testCat.speak());
    }

    // TODO - Create tests for `setBirthDate(Date birthDate)`

    @Test
    public void setBirthDateTests() {

        Date date1 = new Date();
        Date date2 = new Date();
        testCat.setBirthDate(date1);
        Assert.assertEquals(testCat.getBirthDate(), date1);
        testCat.setBirthDate(date2);
        Assert.assertEquals(testCat.getBirthDate(), date2);
    }


        // TODO - Create tests for `void eat(Food food)`
    @Test
    public void eatTest () {
        Food food1 = new Food();
        Food food2 = new Food();
        Assert.assertTrue(0 == testCat.getNumberOfMealsEaten());
        testCat.eat(food1);
        Assert.assertTrue(1 == testCat.getNumberOfMealsEaten());
        testCat.eat(food2);
        Assert.assertTrue(2 == testCat.getNumberOfMealsEaten());
    }

        // TODO - Create tests for `Integer getId()`
    @Test
    public void idTest () {

        Assert.assertTrue(0 == testCat.getId());

        // Given (cat data)
        String givenName = "Bilbo";
        Date givenBirthDate = new Date();
        Integer givenId = 1;

        // When (a cat is constructed)
        Cat testCat2 = new Cat(givenName, givenBirthDate, givenId);
        Assert.assertTrue(1 == testCat2.getId());
    }

        // TODO - Create test to check Animal inheritance; google search `java instanceof keyword`

    @Test
    public void animalInheritanceTest() {
        Assert.assertTrue(testCat instanceof Animal);
    }


    // TODO - Create test to check Mammal inheritance; google search `java instanceof keyword`
    @Test
    public void mammalInheritanceTest() {
        Assert.assertTrue(testCat instanceof Mammal);
    }

}

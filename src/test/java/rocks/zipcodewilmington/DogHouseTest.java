package rocks.zipcodewilmington;

import junitparams.JUnitParamsRunner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import rocks.zipcodewilmington.animals.Dog;
import rocks.zipcodewilmington.animals.animal_storage.DogHouse;

import java.util.Date;

/**
 * @author leon on 4/19/18.
 */
@RunWith(JUnitParamsRunner.class)
public class DogHouseTest {

    private static DogHouse testHouse;

    @Before
    public void setUp() throws Exception {
        testHouse = new DogHouse();
    }

    @After
    public void tearDown() throws Exception {
        testHouse.clear();
    }

    // TODO - Create tests for `void add(Dog dog)`

    @Test
    public void addDogTest() {
        testHouse.add(new Dog("", new Date(), 1));

        Assert.assertTrue(1 == testHouse.getNumberOfDogs());
        testHouse.add(new Dog("", new Date(), 2));
        testHouse.add(new Dog("", new Date(), 3));

        Assert.assertTrue(3 == testHouse.getNumberOfDogs());
    }


    // TODO - Create tests for `void remove(Integer id)`

    @Test
    public void removeDogsTests() {
        testHouse.add(new Dog ("", new Date(), 2));


        testHouse.add(new Dog("", new Date(), 4));
        testHouse.add(new Dog("", new Date(), 5));

        Assert.assertTrue(3 == testHouse.getNumberOfDogs());
        testHouse.remove(4);
        testHouse.remove(5);

        Assert.assertTrue(1 == testHouse.getNumberOfDogs());
    }

    // TODO - Create tests for `void remove(Dog dog)`
    @Test
    public void removeDogsTests2() {
        Dog dog1 = new Dog ("", new Date(), 2);
        Dog dog2 = new Dog ("", new Date(), 5);
        testHouse.add(dog1);
        testHouse.add(dog2);

        testHouse.add(new Dog("", new Date(), 4));

        Assert.assertTrue(3 == testHouse.getNumberOfDogs());
        testHouse.remove(dog1);
        testHouse.remove(dog2);

        Assert.assertTrue(1 == testHouse.getNumberOfDogs());
    }

    // TODO - Create tests for `Dog getDogById(Integer id)`
    @Test
    public void getDogbyIdTest() {
        Dog dog1 = new Dog ("", new Date(), 2);
        Dog dog2 = new Dog ("", new Date(), 5);
        testHouse.add(dog1);
        testHouse.add(dog2);

        Assert.assertEquals(dog1, testHouse.getDogById(2));
        Assert.assertEquals(dog2, testHouse.getDogById(5));
        Assert.assertNull(testHouse.getDogById(8));
    }


}

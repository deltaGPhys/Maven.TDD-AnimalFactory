package rocks.zipcodewilmington;

import junitparams.JUnitParamsRunner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import rocks.zipcodewilmington.animals.Cat;
import rocks.zipcodewilmington.animals.animal_storage.CatHouse;

import java.util.Date;

/**
 * @author leon on 4/19/18.
 */
@RunWith(JUnitParamsRunner.class)
public class CatHouseTest {

    private static CatHouse testHouse;

    @Before
    public void setUp() throws Exception {
        testHouse = new CatHouse();
    }

    @After
    public void tearDown() throws Exception {
        testHouse.clear();
    }

    // TODO - Create tests for `void add(Cat cat)`

    @Test
    public void addCatTest() {
        testHouse.add(new Cat("", new Date(), 1));

        Assert.assertTrue(1 == testHouse.getNumberOfCats());
        testHouse.add(new Cat("", new Date(), 2));
        testHouse.add(new Cat("", new Date(), 3));

        Assert.assertTrue(3 == testHouse.getNumberOfCats());
    }


    // TODO - Create tests for `void remove(Integer id)`

    @Test
    public void removeCatsTests() {
        testHouse.add(new Cat ("", new Date(), 2));


        testHouse.add(new Cat("", new Date(), 4));
        testHouse.add(new Cat("", new Date(), 5));

        Assert.assertTrue(3 == testHouse.getNumberOfCats());
        testHouse.remove(4);
        testHouse.remove(5);

        Assert.assertTrue(1 == testHouse.getNumberOfCats());
    }

    // TODO - Create tests for `void remove(Cat cat)`
    @Test
    public void removeCatsTests2() {
        Cat cat1 = new Cat ("", new Date(), 2);
        Cat cat2 = new Cat ("", new Date(), 5);
        testHouse.add(cat1);
        testHouse.add(cat2);

        testHouse.add(new Cat("", new Date(), 4));

        Assert.assertTrue(3 == testHouse.getNumberOfCats());
        testHouse.remove(cat1);
        testHouse.remove(cat2);

        Assert.assertTrue(1 == testHouse.getNumberOfCats());
    }

    // TODO - Create tests for `Cat getCatById(Integer id)`
    @Test
    public void getCatbyIdTest() {
        Cat cat1 = new Cat ("", new Date(), 2);
        Cat cat2 = new Cat ("", new Date(), 5);
        testHouse.add(cat1);
        testHouse.add(cat2);

        Assert.assertEquals(cat1, testHouse.getCatById(2));
        Assert.assertEquals(cat2, testHouse.getCatById(5));
        Assert.assertNull(testHouse.getCatById(8));
    }


}

package test;

import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FelineTest {

    private final int DEFAULT_AMOUNT_OF_KITTENS =1;
    private final int NOT_DEFAULT_AMOUNT_OF_KITTENS =2;

    @Test
    public void checkFelineKittensDefaultValue(){
        Feline feline = new Feline();
        Assert.assertEquals(DEFAULT_AMOUNT_OF_KITTENS, feline.getKittens());
    }

    @Test
    public void checkFelineKittensNonDefaultValue(){
        Feline feline = new Feline();
        Assert.assertEquals(NOT_DEFAULT_AMOUNT_OF_KITTENS, feline.getKittens(NOT_DEFAULT_AMOUNT_OF_KITTENS));
    }

    @Test
    public void checkFelineFamily(){
        Feline feline = new Feline();
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void checkFelineFoodMeatVariant() throws Exception {
        Feline feline = new Feline();
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

    @Test
    public void checkFelineFoodVeganVariant() throws Exception {
        Feline feline = new Feline();
        Assert.assertEquals(List.of("Трава", "Различные растения"), feline.getFood("Травоядное"));
    }
}

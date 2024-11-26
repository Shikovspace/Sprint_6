package test;

import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

public class LionTest {

    private final int DEFAULT_AMOUNT_OF_KITTENS =1;

    @Test
    public void checkLionFood() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Mockito.when(feline.getFood("Хищник")).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
        Lion lion = new Lion("Самец", feline);
        Assert.assertEquals(Arrays.asList("Животные", "Птицы", "Рыба"), lion.getFood());
    }

    @Test
    public void checkLionMane() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion("Самец", feline);
        Assert.assertTrue(lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void checkLionManeUnIdentifiedGender() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion("Самурай", feline);
    }

    @Test
    public void checkLionWithoutMane() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion("Самка", feline);
        Assert.assertFalse(lion.doesHaveMane());
    }

    @Test
    public void checkLionKittens() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Mockito.when(feline.getKittens()).thenReturn(DEFAULT_AMOUNT_OF_KITTENS);
        Lion lion = new Lion("Самец", feline);
        Assert.assertEquals(DEFAULT_AMOUNT_OF_KITTENS, lion.getKittens());
    }
}

package test;

import com.example.Animal;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class AnimalParameterizedTest {
    private final List<String> food;
    private final String animalKind;

    public AnimalParameterizedTest(List<String> food, String animalKind) {
        this.food = food;
        this.animalKind = animalKind;
    }

    @Parameterized.Parameters (name = "Список еды для животных {1}: {0}")
    public static Object[][] getFoodData() {
        return new Object[][]{
                {List.of("Трава", "Различные растения"), "Травоядное"},
                {List.of("Животные", "Птицы", "Рыба"), "Хищник"},
        };
    }

    @Test
    public void checkFoodForAnimalKindTest() throws Exception {
        Animal animal = new Animal();
        Assert.assertEquals(food, animal.getFood(animalKind));
    }

    @Test(expected = Exception.class) //Проверка выброса исключения
    public void testAnimalWithInvalidType() throws Exception {
        Animal animal = new Animal();
        animal.getFood("Непонятный тип");
    }

    @Test
    public void getFamilyTest(){
        Animal mockedAnimal = Mockito.mock(Animal.class);
        Animal animal = new Animal();
        when(mockedAnimal.getFamily()).thenReturn("Существует несколько семейств: заячьи," +
                " беличьи, мышиные, кошачьи, псовые, медвежьи, куньи");
        Assert.assertEquals(animal.getFamily(), mockedAnimal.getFamily());
    }
}


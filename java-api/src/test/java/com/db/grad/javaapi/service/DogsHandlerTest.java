package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;
import com.db.grad.javaapi.repository.DogsRepositoryStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DogsHandlerTest {

    private DogsRepository itsDogRepo = new DogsRepositoryStub();

    @BeforeEach
    public void makeSureRepoIsEmpty() {
        itsDogRepo.deleteAll();
    }


    @Test
    public void add_a_dog_return_number_of_dogs_in_repo_is_one() {
        //arrange
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog( theDog );
        int expectedResult = 1;


        //acting
        long actualResult = cut.getNoOfDogs();


        //assert
        assertEquals(expectedResult, actualResult);



    }

    @Test
    public void add_several_dogs_return_number_of_dogs_match_number_added(){
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog theDog = new Dog();
        Dog theSecDog = new Dog();
        Dog theLastDog = new Dog();
        theDog.setName("Oscar");
        theSecDog.setName("Bingo");
        theLastDog.setName("Frosty");
        cut.addDog(theDog);
        cut.addDog(theSecDog);
        cut.addDog(theLastDog);

        int expectedResult = 3;


        //acting
        long actualResult = cut.getNoOfDogs();


        //assert
        assertEquals(expectedResult, actualResult);



    }

    @Test
    public void test_for_getDogByName_1(){
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog theDog = new Dog();
        Dog theSecDog = new Dog();
        Dog theLastDog = new Dog();
        theDog.setName("Oscar");
        theSecDog.setName("Oscar");
        theLastDog.setName("Frosty");
        cut.addDog(theDog);
        cut.addDog(theSecDog);
        cut.addDog(theLastDog);

       //


        //acting
        Dog actualResult = cut.getDogByName("Robert");


        //assert
        assertEquals(expectedResult, actualResult);

    }

}

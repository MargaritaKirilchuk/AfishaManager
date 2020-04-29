package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Afisha;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AfishaRepositoryTest {
    private AfishaRepository repository;
    private Afisha first = new Afisha(1,1,"Bloodshot",1);
    private Afisha second = new Afisha(2,2,"Vpered",2);
    private Afisha third = new Afisha(3,3,"HotelBelgrad",3);
    private Afisha fourth = new Afisha(4,4,"Gentlmen",4);
    private Afisha fifth =  new Afisha(5,5,"Trolls",5);
    private Afisha sixth = new Afisha(6,6,"InvisibleMan",6);
    private Afisha seventh = new Afisha(7,7,"NumberOne",7);
    private Afisha eighth = new Afisha(8,8,"PredatorBirds",8);
    private Afisha ninth = new Afisha(9,9,"Sonic",9);
    private Afisha tenth = new Afisha(10,10,"Bond25",10);
    private Afisha eleventh;

    @BeforeEach
    void prepareManager () {
        repository = new AfishaRepository();

        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);
        repository.save(seventh);
        repository.save(eighth);
        repository.save(ninth);
        repository.save(tenth);
    }

    @Test
    void findAll() {

        Afisha[] actual = repository.findAll();
        Afisha[] expected = new Afisha[] {first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};

        assertArrayEquals (expected, actual);

    }

    @Test
    void saveMovie () {
        eleventh = new Afisha(11,11,"Ice2",11);
        repository.save(eleventh);

        Afisha[] actual = repository.findAll();
        Afisha[] expected = new Afisha[] {first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh};

        assertArrayEquals (expected, actual);
    }

    @Test
    void shouldFindIfExist (){
        repository.findById(2);

        Afisha expected = second;
        Afisha actual = repository.findById(2);

        assertEquals(expected, actual);
    }

    @Test
    void shouldRemoveIfExist() {
        repository.removeById (10);

        Afisha[] actual = repository.findAll();
        Afisha[] expected = new Afisha[] {first, second, third, fourth, fifth, sixth, seventh, eighth, ninth};

        assertArrayEquals (expected, actual);
    }

    @Test
    void removeAll(){
        repository.removeAll();

        Afisha[] actual = repository.findAll();
        Afisha[] expected = new Afisha[] {};

        assertArrayEquals (expected, actual);

    }

}
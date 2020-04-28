package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Afisha;
import ru.netology.manager.AfishaManager;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AfishaManagerTestNotEmpty {
    @Mock
    private AfishaRepository repository;
    @InjectMocks
    private AfishaManager manager;
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
        manager = new AfishaManager (repository, 11);

        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        manager.addMovie(sixth);
        manager.addMovie(seventh);
        manager.addMovie(eighth);
        manager.addMovie(ninth);
        manager.addMovie(tenth);
    }

    @Test
    void addMovie () {
        eleventh = new Afisha(11,11,"Ice2",11);

        Afisha[] returned = new Afisha[] {first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).save(eleventh);

        manager.addMovie(eleventh);
        Afisha[] actual = manager.showAfisha();
        Afisha[] expected = new Afisha[] {eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};

        assertArrayEquals (expected, actual);

        verify(repository).save(eleventh);

    }

    @Test
    void MovieList(){

        Afisha[] actual = manager.showAfisha();
        Afisha[] expected = new Afisha[] {ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};

        assertArrayEquals (expected, actual);
    }


}
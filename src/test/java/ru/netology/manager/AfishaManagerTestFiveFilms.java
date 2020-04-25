package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Afisha;

import static org.junit.jupiter.api.Assertions.*;

class AfishaManagerTestLessThanFive {
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

    @BeforeEach
    void prepareManager () {
        manager = new AfishaManager(5);

        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);

    }

    @Test
    void shouldShowFilmsLessThanFive (){
        Afisha[] actual = manager.showAfisha();
        Afisha[] expected = new Afisha[] {fourth, third, second, first};

        assertArrayEquals (expected, actual);
    }

    @Test
    void shouldShowFiveFilms (){


    }


}
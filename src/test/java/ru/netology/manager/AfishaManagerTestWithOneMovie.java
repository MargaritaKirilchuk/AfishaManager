package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Afisha;
import ru.netology.manager.AfishaManager;

import static org.junit.jupiter.api.Assertions.*;

class AfishaManagerTestWithOneMovie {
    private AfishaManager manager;
    private Afisha first;
    private Afisha second;
    private Afisha third;
    private Afisha fourth;
    private Afisha fifth;
    private Afisha sixth;
    private Afisha seventh;
    private Afisha eighth;
    private Afisha ninth;
    private Afisha tenth;


    @BeforeEach
    void prepareManager () {
        manager = new AfishaManager(10);
        first = new Afisha(1,1,"Bloodshot",1);

        manager.addMovie(first);
    }

    @Test
    void addMovie() {
        second = new Afisha(2,2,"Vpered",2);

        manager.addMovie(second);

        Afisha[] actual = manager.showAfisha();
        Afisha[] expected = new Afisha[] {second, first};

        assertArrayEquals (expected, actual);
    }

    @Test
    void MovieList() {

        Afisha[] actual = manager.showAfisha();
        Afisha[] expected = new Afisha[]{first};

        assertArrayEquals(expected, actual);
    }
}
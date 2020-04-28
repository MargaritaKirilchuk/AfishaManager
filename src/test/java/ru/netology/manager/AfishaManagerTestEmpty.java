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

@ExtendWith(MockitoExtension.class)
class AfishaManagerTestEmpty {
    @Mock
    private AfishaRepository repository;
    @InjectMocks
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
        manager = new AfishaManager(repository,10);
    }


    @Test
    void addMovie() {
        first = new Afisha(1,1,"Bloodshot",1);

        manager.addMovie(first);

        Afisha[] actual = manager.showAfisha();
        Afisha[] expected = new Afisha[] {first};

        assertArrayEquals (expected, actual);
    }

    @Test
    void MovieList() {

        Afisha[] actual = manager.showAfisha();
        Afisha[] expected = new Afisha[]{};

        assertArrayEquals(expected, actual);
    }

    }

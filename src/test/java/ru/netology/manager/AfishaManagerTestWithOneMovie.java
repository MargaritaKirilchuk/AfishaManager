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
class AfishaManagerTestWithOneMovie {
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
        first = new Afisha(1,1,"Bloodshot",1);

        manager.add(first);
    }

    @Test
    void addMovie() {
        second = new Afisha(2,2,"Vpered",2);

        Afisha[] returned = new Afisha[] {second, first};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).save(second);

        manager.add(second);

        Afisha[] actual = repository.findAll();
        Afisha[] expected = new Afisha[] {second, first};

        assertArrayEquals (expected, actual);

        verify(repository).save(second);
    }

    @Test
    void MovieList() {

        Afisha[] returned = new Afisha[] {first};
        doReturn(returned).when(repository).findAll();

        Afisha[] actual = repository.findAll();
        Afisha[] expected = new Afisha[]{first};

        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }
}
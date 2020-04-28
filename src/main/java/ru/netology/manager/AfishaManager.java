package ru.netology.manager;

import lombok.*;
import ru.netology.domain.Afisha;
import ru.netology.repository.AfishaRepository;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AfishaManager {
    private Afisha[] movies = new Afisha [0];
    private AfishaRepository repository;
    private int lengthOfAfisha = 10;

    public AfishaManager(AfishaRepository repository) {
        this.repository = repository;
    }

    public AfishaManager (AfishaRepository repository, int lengthOfAfisha) {
        this.repository = repository;
        this.lengthOfAfisha = lengthOfAfisha;
    }

    public void addMovie (Afisha movie){
        int length = movies.length + 1;
        Afisha[] tmp = new Afisha [length];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        int lastIndex = tmp.length -1;
        tmp [lastIndex] = movie;
        movies = tmp;
    }

    public Afisha [] showAfisha (){
        if (movies.length < lengthOfAfisha){
            lengthOfAfisha = movies.length;
        }
        Afisha [] result = new Afisha[lengthOfAfisha];
        for (int i = 0; i < lengthOfAfisha; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }

    public void add (Afisha movie){
        repository.save(movie);
    }

    public void removeById (int id){
        repository.removeById (id);
    }

    public void findById (int id){
        repository.findById(id);
    }

    public void removeAll (){
        repository.removeAll();
    }

    public void findAll (){
        repository.findAll();
    }

}

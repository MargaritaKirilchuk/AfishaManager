package ru.netology.manager;

import lombok.*;
import ru.netology.domain.Afisha;
import ru.netology.repository.AfishaRepository;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AfishaManager {
    private AfishaRepository repository;
    private int lengthOfAfisha = 10;

    public AfishaManager(AfishaRepository repository) {
        this.repository = repository;
    }

    public Afisha[] findAll (){
        Afisha[] movies = repository.findAll();
        Afisha[] result = new Afisha[movies.length];
        for (int i = 0; i < movies.length; i++) {
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


}

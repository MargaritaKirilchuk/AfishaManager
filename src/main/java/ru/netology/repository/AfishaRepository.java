package ru.netology.repository;

import ru.netology.domain.Afisha;

public class AfishaRepository {
    private Afisha[] movies = new Afisha [0];

    public Afisha[] findAll (){
        return movies;
    }

    public void save(Afisha movie) {
        int length = movies.length + 1;
        Afisha[] tmp = new Afisha[length];
        System.arraycopy(movies, 0, tmp,0,movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public void findById (int id){
        Afisha[] tmp = new Afisha[1];
        int index = 0;
        for(Afisha movie : movies){
            if (movie.getId() == id){
                tmp[index] = movie;
            }
        }
        movies = tmp;
    }

    public void removeById (int id){
        int length = movies.length - 1;
        Afisha[] tmp = new Afisha[length];
        int index = 0;
        for (Afisha movie : movies) {
            if (movie.getId() !=10) {
                tmp[index] = movie;
                index++;
            }
        }
        movies = tmp;
    }

    public void removeAll(){
        movies = new Afisha[0];
    }
}

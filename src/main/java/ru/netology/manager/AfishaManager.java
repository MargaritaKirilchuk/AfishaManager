package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Afisha;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AfishaManager {
    private Afisha[] movies = new Afisha [0];
    private int lengthOfAfisha = 10;

    public AfishaManager(int lengthOfAfisha) {
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
}

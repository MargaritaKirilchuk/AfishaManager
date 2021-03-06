package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Afisha {
        private int id;
        private int imageURL;
        private String name;
        private String genre;
        private int count;


        public Afisha(int id, int imageURL, String name, int count) {
            this.id = id;
            this.imageURL = imageURL;
            this.name = name;
            this.count = count;
        }
}

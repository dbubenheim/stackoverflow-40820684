package com.stackoverflow.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author daniel.bubenheim@gmail.com
 */
@Entity
public class Dog {

    @Id
    @GeneratedValue
    private Long id;
    private String breedType;
    private String imgUrl;
    private long likes;

    public Dog() {
    }

    private Dog(final DogBuilder builder) {
        this.breedType = builder.breedType;
        this.imgUrl = builder.imgUrl;
        this.likes = builder.likes;
    }

    public Long getId() {
        return id;
    }

    public String getBreedType() {
        return breedType;
    }

    public void setBreedType(final String breedType) {
        this.breedType = breedType;
    }

    public long getLikes() {
        return likes;
    }

    public void setLikes(final long likes) {
        this.likes = likes;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(final String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public long like() {
        return this.likes++;
    }

    public static class DogBuilder {
        private String breedType;
        private String imgUrl;
        private long likes;

        public DogBuilder() {
        }

        public DogBuilder likes(final long likes) {
            this.likes = likes;
            return this;
        }

        public DogBuilder breedType(final String breedType) {
            this.breedType = breedType;
            return this;
        }

        public DogBuilder imgUrl(final String imgUrl) {
            this.imgUrl = imgUrl;
            return this;
        }

        public Dog build() {
            return new Dog(this);
        }
    }
}
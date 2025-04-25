package info.hccis.photography.session.entity;

import info.hccis.photography.session.jpa.entity.PhotographySession;

import java.util.ArrayList;

/**
 * Entity class to hold the attributes of the movie
 *
 * @author Vy Phan
 * @since 20241110
 */
public class Movie {

    private String keyword;
    private String movieString;
    private ArrayList<String> titleLists;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getMovieString() {
        return movieString;
    }

    public void setMovieString(String movieString) {
        this.movieString = movieString;
    }

    public ArrayList<String> getTitleLists() {
        return titleLists;
    }

    public void setTitleLists(ArrayList<String> titleLists) {
        this.titleLists = titleLists;
    }
}

package co4353distributedsystems.reviews.resources;

public class MovieReviews {
    private int userid;
    private int ratings;
    private String moviename;
    private String comments;

    public MovieReviews() {
    }

    public MovieReviews(int userid, int ratings, String moviename, String comments) {
        this.userid = userid;
        this.ratings = ratings;
        this.moviename = moviename;
        this.comments = comments;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}

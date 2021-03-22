import java.util.ArrayList;

/**
 *  <h1>Video</h1>
 *  A model of a video that's kept in a video rental store
 *
 *  @author Jack McPake
 *  @since 22-03-2021
 */

public class Video {

    private String videoTitle;
    private boolean videoCheckedOut;
    private ArrayList<Integer> videoRatings;

    /**
     * A Constructor for the Video class
     * @param title This is the title of a video
     */
    public Video(String title){
        videoTitle = title;
    }

    /**
     * Getter for the title
     * @return String This return's the video's title
     */
    public String getTitle(){
        return videoTitle;
    }
    //Return the video’s title.

    /**
     * Adds a new rating to the video's ratings
     * @param rating This is the new rating to be added
     * @return boolean This returns true if the rating is between 1-5 inclusive, false if it isn't in this criteria
     */
    public boolean addRating(int rating){

        if (rating >= 1 && rating <= 5){

            this.videoRatings.add(rating);
            return true;

        } else {

            System.out.println("Please input a rating between 1 and 5");
            return false;
        }


    }

    /**
     * Calculates and returns the average rating for a video.
     * @return double This returns the average rating for a video, returns 0 if the video has no ratings.
     */
    public double getAverageRating() {

        if (this.videoRatings.isEmpty()){
            return 0;
        }

        int totalRatings = 0;
        double avgRatings;

        for (int rating: this.videoRatings) totalRatings += rating;

        avgRatings = totalRatings/(double)this.videoRatings.size();

        return avgRatings;

    }

    /**
     * Checks the video out
     * @return boolean This returns true or false based on whether or not the video has been checked out
     */
    public boolean checkOut() {
        if (this.videoCheckedOut){
            System.out.println("Unsuccessful, The video has been already checked out");
            return false;
        } else {
            System.out.println("Successfully checked out");
            this.videoCheckedOut = true;
            return true;
        }
    }

    /**
     *
     * @return boolean This returns true or false based on whether or not the video has been returned to the store
     */
    public boolean returnToStore(){
        if (this.videoCheckedOut){
            System.out.println("Successfully returned to store.");
            return true;
        } else {
            System.out.println("Unsuccessful, This video has not been checked into the store");
            return false;
        }
    }

    /**
     * Returns the checked out status of the video
     * @return boolean The checked out status of the video
     */
    public boolean isCheckedOut() {
        return this.videoCheckedOut;
    }

    /**
     * Returns a String of the form Video[title="<title>", checkedOut=<status>].
     * @return String returns the state of the video
     */
    public String toString() {
     return "title = '" + this.videoTitle + "', checkedOut = " + this.videoCheckedOut;
     }
}

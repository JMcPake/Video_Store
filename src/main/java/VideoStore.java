import java.util.ArrayList;

public class VideoStore {

    private ArrayList<Video> storeInventory = new ArrayList<Video>();

    /**
     * This adds a new video to the store's inventory
     * @param title This is the title of the new video that will be added
     * @return This returns whether if the video has been added
     */
    public boolean addVideo(String title){

        if (this.storeInventory == null){
            System.out.println("Successful, " + title + " added.");
            this.storeInventory.add(new Video(title));
            return true;
        }

        for (Video videos:this.storeInventory) {
                if (videos.getTitle().equals(title)) {
                    System.out.println("Unsuccessful, a video with that title already exists.");
                    return false;
                }
        }

        System.out.println("Successful, " + title + " added.");
        this.storeInventory.add(new Video(title));
        return true;
    }

    /**
     * Will find a video given a title
     * @param title This is the title of the video the user is looking for
     * @return video The video with the title
     */
    public Video getVideo(String title){
        for (Video videos:this.storeInventory){
            if(videos.getTitle().equals(title)){
                return videos;
            }
        }

        System.out.println("No videos called " + title + " were found.");
        return null;
    }

    /**
     * Checks out a video based on title
     * @param title This is the title of the book the user wants to check out
     * @return boolean This is whether or not the book has been checked out
     */
    public boolean checkOutVideo(String title){
        for (Video videos:this.storeInventory){
            if(videos.getTitle().equals(title)){
                if(!videos.isCheckedOut()){
                    videos.checkOut();
                    return true;
                }
            }
        }

        System.out.println("Unsuccessful, video is already checked out");
        return false;
    }

    /**
     * Returns a video to the store
     * @param video This is the video the user wants to return to the store
     * @return boolean This is whether or not the video has been returned to the store already
     */
    public boolean returnVideo(Video video){
        return video.returnToStore();
    }

    /**
     * Adds a rating to a video
     * @param video This is the video the user want to add a rating to
     * @param rating This is the rating the user wants to add to the video
     */
    public void rateVideo(Video video, int rating){
        video.addRating(rating);
    }

    /**
     * Gets the average rating for a video
     * @param video This is the video the user wants to get the average rating of
     * @return double This is the average rating
     */
    public double getAverageRatingForVideo(Video video){
        return video.getAverageRating();
    }

    /**
     * Gets an array of all the videos that are checked out
     * @return Video[] An array of videos that are checked out, with a range of all the videos in the store
     */
    public Video[] getCheckedOut(){
        Video[] checkedVideos = new Video[this.storeInventory.size()];
        int i = 0;
        for (Video video : this.storeInventory) {
            if (!video.isCheckedOut()) {
                checkedVideos[i] = video;
                i++;
            }
        }

        return  checkedVideos;
    }

    /**
     * This returns the video with the highest average rating
     * @return Video This is the most popular video
     */
    public Video mostPopular() {

        if(this.storeInventory.isEmpty()){
            return null;
        }

        Video popularVideo = this.storeInventory.get(0);

        for (Video videos:this.storeInventory){
            if(popularVideo.getAverageRating() < videos.getAverageRating()){
                popularVideo = videos;
            }
        }

        return popularVideo;
    }

}

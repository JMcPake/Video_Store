public class VideoStoreTest {

    public static void main(String[] args) {

        VideoStore blockBuster = new VideoStore();

        blockBuster.addVideo("Electric Dreams");

        blockBuster.checkOutVideo("Electric Dreams");
        blockBuster.returnVideo(blockBuster.getVideo("Electric Dreams"));

        blockBuster.rateVideo(blockBuster.getVideo("Electric Dreams"),5);
        blockBuster.rateVideo(blockBuster.getVideo("Electric Dreams"),3);
        blockBuster.rateVideo(blockBuster.getVideo("Electric Dreams"),2);
        blockBuster.rateVideo(blockBuster.getVideo("Electric Dreams"),4);
        blockBuster.rateVideo(blockBuster.getVideo("Electric Dreams"),2);
        blockBuster.rateVideo(blockBuster.getVideo("Electric Dreams"),1);
        blockBuster.rateVideo(blockBuster.getVideo("Electric Dreams"),5);

        blockBuster.getAverageRatingForVideo(blockBuster.getVideo("Electric Dreams"));

    }

}

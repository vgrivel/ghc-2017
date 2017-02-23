package ch.daplab.google.input;

/**
 * Created by vincent on 2/23/17.
 */
public class Video {

    public Video(int id, int sizeMB){
        this.id = id;
        this.sizeMB = sizeMB;
    }
    public int getId() {
        return id;
    }

    final int id;

    public int getSizeMB() {
        return sizeMB;
    }

    final int sizeMB;

}

package ch.daplab.google.input;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vincent on 2/23/17.
 */
public class Cache {
    int cacheId;
    int sizeReminder;

    public int getCacheId() {
        return cacheId;
    }

    public void setCacheId(int cacheId) {
        this.cacheId = cacheId;
    }

    public int getMaxSizeMB() {
        return maxSizeMB;
    }

    public void setMaxSizeMB(int maxSizeMB) {
        this.maxSizeMB = maxSizeMB;
    }

    public List<Integer> getListVideo() {
        return listVideo;
    }

    public void setListVideo(List<Integer> listVideo) {
        this.listVideo = listVideo;
    }

    public boolean addVideoToList(int videoId, int sizevideo){
        if(sizevideo < sizeReminder){
            if(!listVideo.contains(videoId)) {
                listVideo.add(videoId);
                sizeReminder -= sizevideo;
                return true;
            }
        }
        return false;
    }

    int maxSizeMB;
    List<Integer> listVideo = new ArrayList<>();

    public Cache(int cacheId, int maxSizeMB) {
        this.cacheId = cacheId;
        this.maxSizeMB = maxSizeMB;
        this.listVideo = new ArrayList<>();
        this.sizeReminder = maxSizeMB;
    }

    public String toString(){
        String videoString ="";
      for(int i =0; i<listVideo.size(); i++){
          videoString = videoString+ " " + listVideo.get(i);
      }
        return cacheId + " " + videoString;
    }
}

package ch.daplab.google.input;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

/**
 * Created by vincent on 2/23/17.
 */
public class Request implements Comparable<Request>{


    public Request(int number, Video video, Endpoints endpoints){
        this.number = number;
        this.video = video;
        this.endpoints = endpoints;
    }

    int number;
    Video video;

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Endpoints getEndpoints() {
        return endpoints;
    }

    Endpoints endpoints;



    public int getNumber() {
        return number;
    }




    @Override
    public int compareTo(@NotNull Request o) {
        Request r1 = (Request)o;
        if(getNumber()>= r1.getNumber()){
            return 1;
        }
        else{
            return 0;
        }
    }
}

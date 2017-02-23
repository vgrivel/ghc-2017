package ch.daplab.google.input;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vincent on 2/11/16.
 */
public class Container {
    private List<Request> requestList;
    private List<Endpoints> endpointsList;

    public int getCachSize() {
        return cachSize;
    }

    public void setCachSize(int cachSize) {
        this.cachSize = cachSize;
    }

    private int cachSize;
    public int getMaxLentencyforEndpoints() {
        return maxLentencyforEndpoints;
    }

    public void setMaxLentencyforEndpoints(int maxLentencyforEndpoints) {
        this.maxLentencyforEndpoints = maxLentencyforEndpoints;
    }

    private int maxLentencyforEndpoints;
    public List<Cache> getCacheList() {
        return cacheList;
    }

    public void setCacheList(List<Cache> cacheList) {
        this.cacheList = cacheList;
    }

    private List<Cache> cacheList;

    public List<Request> getRequestList() {
        return requestList;
    }

    public void setRequestList(List<Request> requestList) {
        this.requestList = requestList;
    }

    public List<Endpoints> getEndpointsList() {
        return endpointsList;
    }

    public void setEndpointsList(List<Endpoints> endpointsList) {
        this.endpointsList = endpointsList;
    }

    public List<Video> getVideoList() {
        return videoList;
    }

    public void setVideoList(List<Video> videoList) {
        this.videoList = videoList;
    }

    private List<Video> videoList;


}

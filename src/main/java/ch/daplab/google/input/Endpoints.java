package ch.daplab.google.input;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vincent on 2/23/17.
 */
public class Endpoints {
 int endpointId;

    public int getEndpointId() {
        return endpointId;
    }

    public void setEndpointId(int endpointId) {
        this.endpointId = endpointId;
    }

    public Map<Integer, Integer> getCacheLatency() {
        return cacheLatency;
    }

    public void setCacheLatency(Map<Integer, Integer> cacheLatency) {
        this.cacheLatency = cacheLatency;
    }

    Map<Integer, Integer> cacheLatency = new HashMap<>();


    public Endpoints(int endpointId, Map<Integer, Integer> cacheLatency) {
        this.endpointId = endpointId;
        this.cacheLatency = cacheLatency;
    }
}

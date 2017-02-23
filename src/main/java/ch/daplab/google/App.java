package ch.daplab.google;

import ch.daplab.google.Algo.AlgoNaive;
import ch.daplab.google.input.*;
import ch.daplab.google.output.Output;
import ch.daplab.google.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by vincent on 6/25/15.
 */
public class App {
    private static final Logger LOG = LoggerFactory.getLogger(App.class);

    public static void main(String args[]) throws Exception {
        Input input = new Input();
        //String fileName = "kittens";
        //String fileName = "me_at_the_zoo";
        String fileName = "trending_today";
       // String fileName = "videos_worth_spreading";
        Container container = input.loadData(fileName + ".in");
        int cacheSize = container.getCachSize();
        int maxVideoSizeAllowed = cacheSize/50;
        List<Cache> cacheList = container.getCacheList();
        List<Request> requestList = container.getRequestList();
        Collections.sort(requestList);
        int maxLatency = container.getMaxLentencyforEndpoints();
        int cachListSize = cacheList.size();
        Random rnd = new Random();

        for (int i = 0; i<requestList.size(); i++){

            Set<Integer> set = requestList.get(i).getEndpoints().getCacheLatency().keySet();
            Iterator it = set.iterator();
            while(it.hasNext()) {
                Integer id = (Integer)it.next();
                if(id>maxLatency){
                    break;
                }
                int cacheId = requestList.get(i).getEndpoints().getCacheLatency().get(id);
                Video video = requestList.get(i).getVideo();
                int videoId = video.getId();

                if(video.getSizeMB()<maxVideoSizeAllowed) {
                    boolean isAdded = cacheList.get(cacheId).addVideoToList(videoId, video.getSizeMB());
                    if (isAdded)
                        break;
                }
                else{
                    boolean isAdded = cacheList.get(rnd.nextInt(cachListSize)).addVideoToList(videoId, video.getSizeMB());
                        break;
                }
            }

        }



        Output output = new Output(fileName + ".out", cacheList);
        output.write();
    }
}

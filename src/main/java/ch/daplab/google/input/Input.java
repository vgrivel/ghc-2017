package ch.daplab.google.input;

import java.io.*;
import java.util.*;

/**
 * Created by vincent on 2/11/16.
 */
public class Input {
    private int videoNumber;
    private int enpointsNumber;
    private int reqNum;
    private int cacheNum;
    private int cachSize;
    private int maxLentencyforEndpoints;
    private int row;
    private int col;

    public Container loadData(String filename) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(filename).getFile());
        Container cont = new Container();
        short matrix[][] = {};
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            line = br.readLine();
            parseFirstLine(line); //parse first line

            List<Video> videoList = parseVideos(br.readLine());
            List<Cache> cacheList = new ArrayList<>();
            for (int i = 0; i<cacheNum; i++){
                Cache cache = new Cache(i, cachSize);
                cacheList.add(cache);
            }
            cont.setCacheList(cacheList);
            matrix = new short[row][col];

            //load warehouse

            List<Endpoints> endpointsList = parseEnpoints(br);

            List<Request> requestList = parseRequest(br, videoList, endpointsList);

            cont.setEndpointsList(endpointsList);
            cont.setRequestList(requestList);
            cont.setVideoList(videoList);
            cont.setMaxLentencyforEndpoints(maxLentencyforEndpoints);
            cont.setCachSize(cachSize);
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return cont;
    }

    public void parseFirstLine(String line1) {
        String[] dim = line1.split(" ");
        videoNumber = Integer.valueOf(dim[0]);
        enpointsNumber = Integer.valueOf(dim[1]);
        reqNum = Integer.valueOf(dim[2]);
        cacheNum = Integer.valueOf(dim[3]);
        cachSize = Integer.valueOf(dim[4]);

    }

    public List<Video> parseVideos(String l2) {
        String[] vid = l2.split(" ");
        List<Video> listVideo = new ArrayList<>();
        for (int i = 0; i < videoNumber; i++) {
            Video v = new Video(i, Integer.valueOf(vid[i]));
            listVideo.add(v);
        }

        return listVideo;
    }

    public List<Endpoints> parseEnpoints(BufferedReader br) throws IOException {
        List<Endpoints> endpointsList = new ArrayList<>();
        // String line4 = br.readLine();
        //int nbrWarehouse = Integer.valueOf(line4);

        //for each warehouse
        for (int i = 0; i < enpointsNumber; i++) {
            String end = br.readLine();
            String[] dim = end.split(" ");

            maxLentencyforEndpoints = Integer.valueOf(dim[0]);


            int connectedcache = Integer.valueOf(dim[1]);
            Endpoints endp;
            Map<Integer, Integer> tmpEndpoints = new TreeMap<>();
            for (int j = 0; j < connectedcache; j++) {
                String connected = br.readLine();
                String[] conntmp = connected.split(" ");
                tmpEndpoints.put(Integer.valueOf(conntmp[1]),Integer.valueOf(conntmp[0]));

            }
            endp = new Endpoints(i, tmpEndpoints);
            endpointsList.add(endp);

        }

            /*


            Warehouse warehouse = new Warehouse();
            warehouse.setId(i);
            String coord = br.readLine();
            String[] dim = coord.split(" ");
            warehouse.setCoordRow(Integer.valueOf(dim[0]));
            warehouse.setCoordCol(Integer.valueOf(dim[1]));
            String prod = br.readLine();
            String[] prodArray = prod.split(" ");
            Map<Product, Integer> mapQty = new HashMap<>();
            for (int j = 0; j < prodArray.length; j++) {
                mapQty.put(prodList.get(j), Integer.valueOf(prodArray[j]));
            }
            warehouse.setMapQty(mapQty);
            endpointsList.add(warehouse);
        }
        */


        return endpointsList;
    }

    public List<Request> parseRequest(BufferedReader br, List<Video> videoList, List<Endpoints> endpointsList) throws IOException {

        List<Request> requestList = new ArrayList<>();

        for(int i = 0; i<reqNum; i++){
            String re = br.readLine();
            String[] reqend = re.split(" ");
            int videoid = Integer.valueOf(reqend[0]);
            int endpointsId = Integer.valueOf(reqend[1]);

            Request req = new Request(Integer.valueOf(reqend[2]), videoList.get(videoid), endpointsList.get(endpointsId));
            requestList.add(req);
        }
        return requestList;
    }


}

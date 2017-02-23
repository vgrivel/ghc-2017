package ch.daplab.google.output;

import ch.daplab.google.input.Cache;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by dori on 11.02.16.
 */
public class Output {
    String fileName;
    List<Cache> cacheList;

    public Output(String fileName, List<Cache> cacheList) {
        this.fileName = fileName;
        this.cacheList = cacheList;
    }

    public void write() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter(fileName, "UTF-8");
        writer.println(cacheList.size());
        for (Cache cache: cacheList){
            writer.println(cache.toString());
        }
        writer.close();
    }
}

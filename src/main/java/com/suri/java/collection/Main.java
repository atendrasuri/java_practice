package com.suri.java.collection;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.*;


/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 04/04/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class Main {

    final static String DATA_SEPARATOR = "|";

    //
    final static Path outputPath=  Paths.get("output.txt");

    public static void main(String[] args) throws IOException {

        final Map<String, List<String>> map = new HashMap<>();


        readTextFileByLines("input.txt").parallelStream().map(x->updateApiVersion.apply(x,map)).forEach(x->writeFile.accept(x));


    }
    static BiFunction<String,Map<String,List<String>>,Map<String,List<String>>> updateApiVersion = (line,map)->{
        String[] APIInfos = line.split("\\s*,\\s*");

        // extract the API name
        String APIName = APIInfos[1];

        // If API already exist in the Map then update the App name and version
        if (map.containsKey(APIName)) {

            List<String> APIInfo = map.get(APIName);
            int existVersion = Integer.parseInt(APIInfo.get(1).substring(1));
            int latestVersion = Integer.parseInt(APIInfos[2].substring(1));

            if (latestVersion > existVersion) {
                APIInfo.clear();
                APIInfo.add(APIInfos[0]);
                APIInfo.add(APIInfos[2]);
            }
            map.put(APIName, APIInfo);
        } else {
            // insert the API name as key and App name and version as value. Since, this API not exist
            List<String> LatestAPIInfo = new ArrayList<>();
            LatestAPIInfo.add(APIInfos[0]);
            LatestAPIInfo.add(APIInfos[2]);
            map.put(APIName, LatestAPIInfo);
        }
     return map;
    };


    /**
     * consumer which write the contents into a file
     */
    static Consumer<Map<String,List<String>>> writeFile = (m)-> {
        try {
            Files.write(outputPath, () -> m.entrySet().stream()
                    .<CharSequence>map(e -> e.getKey() + DATA_SEPARATOR + e.getValue().get(0))
                    .iterator());
        } catch (IOException e) {
            e.printStackTrace();
        }

    };

    /**
     *  readTextFileByLines, which reads the whole file and return contents of the file as List
     * @param
     * @return
     * @throws IOException
     */

    public static List<String> readTextFileByLines(String fileName) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(fileName));
        return lines;
    }

}
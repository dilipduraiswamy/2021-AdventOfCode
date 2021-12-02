package com.dilip;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class PartA {

    public static void main(String[] args) {

        //read the file by filepath
        String fileName = "/Users/dilip.d/Downloads/AoC-2021-Solutions-main/day_01/parta.in";
        List<String> inputData = getFileData(fileName);
        int position=0;
        int depth=0;
        for(String str:inputData){
            String[] splitData=str.split(" ");
            System.out.println(splitData[0]+" : "+splitData[1]);
            String compareStr=splitData[0];
            Integer compareVal=Integer.parseInt(splitData[1]);
            if(compareStr.equals("forward"))
            {
                position=position+compareVal;
            }else if(compareStr.equals("down"))
            {
                depth=depth+compareVal;
            }else if(compareStr.equals("up"))
            {
                depth=depth-compareVal;
            }
        }
        Integer total=depth*position;
        System.out.println(total);
    }

    private static List<String> getFileData(String fileName) {
        List<String> inputData=new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            stream.forEach(data->{
                inputData.add(data);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputData;
    }
}

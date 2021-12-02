package com.dilip;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class PartB {

    public static void main(String[] args) {

        //read the file by filepath
        String fileName = "/Users/dilip.d/Downloads/AoC-2021-Solutions-main/day_01/partb.in";
        List<String> inputData = getFileData(fileName);
        int position=0;
        int depth=0;
        int aim=0;
        for(String str:inputData){
            String[] splitData=str.split(" ");
            String compareStr=splitData[0];
            Integer compareVal=Integer.parseInt(splitData[1]);
            if(compareStr.equals("forward"))
            {
                if(aim!=0)
                {
                    position=position+compareVal;
                    depth=depth+(aim*compareVal);
                }else {
                    position=position+compareVal;
                }
            }else if(compareStr.equals("down"))
            {
                aim=aim+compareVal;
            }else if(compareStr.equals("up"))
            {
                aim=aim-compareVal;
            }
        }
        Integer total=depth*position;
        System.out.println("depth "+depth+" : position "+position+" : aim "+aim);
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

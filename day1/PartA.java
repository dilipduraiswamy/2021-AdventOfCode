package com.dilip.day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class PartA {

    public static void main(String[] args) {
        String fileName = "/Users/dilip.d/Downloads/AoC-2021-Solutions-main/day_01/day_01.in";
        List<Integer> sampleData=getFileData(fileName);
        List<String> incrementData=new ArrayList<>();
        for(int i = 0; i< sampleData.size(); i++)
        {
            if(i!=0){
                if(sampleData.get(i)> sampleData.get(i-1))
                {
                    incrementData.add(sampleData.get(i)+"(Increment)");
                }
            }
        }
        System.out.println("Total Increments are "+incrementData.size());
    }

    private static List<Integer> getFileData(String fileName) {
        List<Integer> inputDataL=new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(data->{
                inputDataL.add(Integer.parseInt(data));
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputDataL;
    }
}

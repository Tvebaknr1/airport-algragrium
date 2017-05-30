/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BigData;

import java.io.File;
import java.io.FileWriter;
import java.util.Random;



public class MakeData {
  
  public static void main(String[] args) throws Exception {
    Random randomizer = new Random(4711);
    final long size = 500;
    final long chunk = 1_000_000;
    File file = new File("/Users/AKA/Temp/bigdata.txt");
    for (long index = 0; index < size; index += chunk) {
      try (FileWriter out = new FileWriter(file, true)) {
        for (long l = 0; l < chunk; l++) {
          out.write(""+randomizer.nextDouble()+"\n");
          }
        System.out.println("Index "+index+" reached");
        }
      }
    }
  }

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.algorithm.examples.text;

/**
 *
 * @author LouiseB
 */
public class WordCounter {
    
    String word;
    int count = 1;

    public WordCounter(String word) {
        this.word = word;
    }
    
    public void increment(){
        count++;
    }
    
}

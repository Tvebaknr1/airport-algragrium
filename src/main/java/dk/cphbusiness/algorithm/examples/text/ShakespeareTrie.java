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
import java.io.PrintStream;

public class ShakespeareTrie {

    public static int SIZE = indexOf('Z') + 2;

    private WordCounter data = null;
    private ShakespeareTrie[] tries = null;

    public static int indexOf(char letter) {
        switch (letter) {
            case '\'':
                return 26;
            default:
                return (int) (letter - 'A');
        }
    }

    public void put(String word, String data) {
        if (word.isEmpty()) {
            if (this.data == null) {
                this.data = new WordCounter(data);
            } else {
                this.data.increment();
            }
        } else {
            char letter = word.charAt(0);
            int index = indexOf(letter);
            if (tries == null) {
                tries = new ShakespeareTrie[SIZE];
            }
            if (tries[index] == null) {
                tries[index] = new ShakespeareTrie();
            }
            ShakespeareTrie trie = tries[index];
            trie.put(word.substring(1), data);
        }
    }

    public String get(String word) {
        if (word.isEmpty()) {
            return data.word + ' ' + data.count;
        }
        if (tries == null) {
            return null;
        }
        char letter = word.charAt(0);
        int index = indexOf(letter);
        ShakespeareTrie trie = tries[index];
        if (trie == null) {
            return null;
        }
        return trie.get(word.substring(1));
    }

    public void print(PrintStream out) {
        if (data != null) {
            out.println(data.word + ' ' + data.count);
        }
        if (tries != null) {
            for (ShakespeareTrie trie : tries) {
                if (trie == null) {
                    continue;
                }
                trie.print(out);
            }
        }
    }

    public void sort(){
        
    }
    
    public static void main(String[] args) {
        ShakespeareTrie trie = new ShakespeareTrie();
        trie.put("ANNA", "Anna");
        trie.put("AND", "And");
        trie.put("ANDERS", "Anders");

        System.out.println(trie.get("ANNA"));
        System.out.println(trie.get("ANDERS"));
        System.out.println(trie.get("ANDERSINE"));

        trie.print(System.out);
    }

}

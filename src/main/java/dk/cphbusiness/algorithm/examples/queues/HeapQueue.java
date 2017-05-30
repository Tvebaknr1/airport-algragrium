/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.algorithm.examples.queues;

import dk.cphbusiness.airport.template.Passenger;
import java.io.PrintStream;
import java.util.NoSuchElementException;

/**
 *
 * @author LouiseB
 */
public class HeapQueue implements PriorityQueue<Passenger> {

    Passenger[] passengers;

    int size = 0;

    public HeapQueue(int capacity) {
        capacity = 1000;
        passengers = new Passenger[capacity];
    }

    private void swap(int pointer, int parentPointer) {
        passengers[0] = passengers[pointer];
        passengers[pointer] = passengers[parentPointer];
        passengers[parentPointer] = passengers[0];
    }

    @Override
    public void enqueue(Passenger person) {

        int pointer = ++size;
        passengers[pointer] = person;
        int parentPointer = parentOf(pointer);

        while (true) {
            if (parentPointer == 0 || passengers[pointer].compareTo(passengers[parentPointer]) > 0) {
                return;
            }
            swap(pointer, parentPointer);
            pointer = parentPointer;
            parentPointer = parentOf(pointer);
        }
    }

    private int parentOf(int pointer) {
        return pointer / 2;
    }

    private int leftOf(int pointer) {
        return 2 * pointer;
    }

    private int rightOf(int pointer) {
        return 2 * pointer + 1;
    }

    @Override
    public Passenger dequeue() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Passenger result = passengers[1];
        swap(1, size--);
        int child = 0;
        int pointer = 1;
        do {
            int leftOf = leftOf(pointer);
            int rightOf = rightOf(pointer);

            if (leftOf > size) {
                return result;
            } else if (rightOf > size) {
                child = leftOf;
            } else if (passengers[leftOf].compareTo(passengers[rightOf]) < 0) {
                child = leftOf;
            } else {
                child = rightOf;
            }
            if (passengers[pointer].compareTo(passengers[child]) > 0) {
                swap(pointer, child);
                pointer = child;
            } else {
                return result;
            }
        } while (true);  
    }


    @Override
    public Passenger peek() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Passenger result = passengers[1];
        return result;

    }

    @Override
    public int size() {
        return size;
    }

    private void print(PrintStream out, int pointer, String indent){
        if(pointer > size) return;
        print(out, rightOf(pointer), indent+"    ");
        out.println(indent+""+passengers[pointer]+" - " + pointer);
        print(out, leftOf(pointer), indent+"    ");
    }
    
    public void print(){
        print(System.out, 1, "");
    }
    
}

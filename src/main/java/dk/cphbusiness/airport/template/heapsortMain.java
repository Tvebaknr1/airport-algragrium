/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.airport.template;

import dk.cphbusiness.algorithm.examples.queues.HeapQueue;
import java.util.Scanner;

/**
 *
 * @author LouiseB
 */
public class heapsortMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Time time1 = new Time(10, 1, 10);
        Time time2 = new Time(10, 5, 10);
        Time time3 = new Time(10, 40, 40);
        Time time4 = new Time(10, 16, 50);

        Plane plane1 = new Plane(time1);
        Plane plane2 = new Plane(time2);
        Plane plane3 = new Plane(time3);
        Plane plane4 = new Plane(time4);

        Passenger businessclass = new Passenger(1, time1, Category.BusinessClass, plane1);
        Passenger monkeyclass = new Passenger(2, time2, Category.Monkey, plane2);
        Passenger familyclass = new Passenger(3, time3, Category.Family, plane3);
        Passenger latetoflightclass = new Passenger(4, time4, Category.LateToFlight, plane4);
        Passenger latetoflightclass2 = new Passenger(5, time2, Category.LateToFlight, plane3);
        Passenger familyclass2 = new Passenger(6, time3, Category.Family, plane1);
        Passenger monkeyclass2 = new Passenger(7, time4, Category.Monkey, plane4);

        HeapQueue hq = new HeapQueue(100);
        hq.enqueue(businessclass);
        hq.enqueue(monkeyclass);
        hq.enqueue(familyclass);
        hq.enqueue(latetoflightclass);
        hq.enqueue(latetoflightclass2);
        hq.enqueue(familyclass2);
        hq.enqueue(monkeyclass2);

        hq.print();
        System.out.println("dequeue");

        Scanner scanner = new Scanner(System.in);
        
        System.out.println(hq.dequeue());
        hq.print();
        scanner.next();
        System.out.println(hq.dequeue());
        hq.print();
        scanner.next();
        System.out.println(hq.dequeue());
        hq.print();
        scanner.next();
        System.out.println(hq.dequeue());
        hq.print();
        scanner.next();
        System.out.println(hq.dequeue());
        hq.print();
        scanner.next();
        System.out.println(hq.dequeue());
        hq.print();
        scanner.next();
        System.out.println(hq.dequeue());
        hq.print();
        scanner.next();

    }

}

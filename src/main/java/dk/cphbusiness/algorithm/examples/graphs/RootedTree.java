/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.algorithm.examples.graphs;

/**
 *
 * @author LouiseB
 */
public interface RootedTree<D,W> extends Graph<D,W> {
  Vertex<D,W> getRoot();
  void add(Edge<D,W> edge);
    
}

// A rooted tree is a connedted direced graph with no cycles
// Forskellen på et tree og en graph er, at der ikke er nogle cycles 
// cycles er noder, som er forbundet af edges og danner en cirkel i et tree

// Ideen med rooted tree er, at hvis man har en graph, putter man træet on top of the graph
// Man vælger selv hvilken node der skal være 'the root'
// addEdge er for at fortælle, at denne edge er også en del af træen
// Med rooted tree kan man ud fra en graph, danne sit eget træ



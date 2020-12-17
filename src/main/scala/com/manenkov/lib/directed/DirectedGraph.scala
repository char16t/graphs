package com.manenkov.lib.directed

import com.manenkov.lib.{Graph, Vertice}

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

class DirectedGraph[T](override val vertices: Set[Vertice[T]], override val edges: Set[DirectedEdge[T]]) extends Graph[T, DirectedEdge[T]]

object DirectedGraph {
  def fromEdges[T](edges: (T, T)*): DirectedGraph[T] = {
    val v = edges.flatMap(pair => List(pair._1, pair._2)).toSet.map(Vertice[T](_))
    val e = edges.map(pair => DirectedEdge(Vertice(pair._1), Vertice(pair._2))).toSet
    new DirectedGraph[T](v, e)
  }

  def fromVerticesAndEdges[T](vertices: Seq[T] = Seq(), edges: Seq[(T, T)] = Seq()): DirectedGraph[T] = {
    val v = edges.flatMap(pair => List(pair._1, pair._2)).toSet.map(Vertice[T](_)).concat(vertices.map(Vertice(_)))
    val e = edges.map(pair => DirectedEdge(Vertice(pair._1), Vertice(pair._2))).toSet
    new DirectedGraph[T](v, e)
  }

  def fromAdjacencyMatrix[T](matrix: Array[Array[Int]], labels: Vector[T]): DirectedGraph[T] = {
    val v = ListBuffer[Vertice[T]]()
    val e = ListBuffer[DirectedEdge[T]]()
    for (i <- matrix.indices) {
      v.append(Vertice(labels(i)))
      for (j <- i until matrix(i).length) {
        if (i != j && matrix(i)(j) == 1) e.append(DirectedEdge(Vertice(labels(i)), Vertice(labels(j))))
      }
    }
    new DirectedGraph[T](v.toSet, e.toSet)
  }

  def fromAdjacencyList[T](adjacencyList: Map[T, List[T]]): DirectedGraph[T] = {
    val v = mutable.Set.from[Vertice[T]](adjacencyList.keySet.map(Vertice(_)))
    val e = ListBuffer[DirectedEdge[T]]()
    for (connections <- adjacencyList) {
      val from = Vertice(connections._1)
      for (to <- connections._2) {
        e.append(DirectedEdge(from, Vertice(to)))
        v.add(Vertice(to))
      }
    }
    new DirectedGraph[T](v.toSet, e.toSet)
  }

  def fromIncidenceMatrix[T](matrix: Array[Array[Int]], labels: Vector[T]): DirectedGraph[T] = {
    val v = mutable.Set[Vertice[T]]()
    val idx = mutable.Map[Int, (Option[Vertice[T]], Option[Vertice[T]])]()
    for (i <- matrix.indices) {
      for (j <- matrix(i).indices) {
        v.add(Vertice(labels(i)))
        matrix(i)(j) match {
          case 1 if !idx.contains(j) =>
            idx.put(j, (Option(Vertice(labels(i))), None))
          case 1 =>
            idx.get(j) match {
              case Some((from, None)) => idx.put(j, Tuple2(from, Option(Vertice(labels(i)))))
              case Some((None, to)) => idx.put(j, Tuple2(Option(Vertice(labels(i))), to))
            }
          case -1 if !idx.contains(j) =>
            idx.put(j, (None, Option(Vertice(labels(i)))))
          case -1 =>
            idx.get(j) match {
              case Some((None, to)) => idx.put(j, Tuple2(Option(Vertice(labels(i))), to))
              case Some((from, None)) => idx.put(j, Tuple2(from, Option(Vertice(labels(i)))))
            }
          case 0 =>
        }
      }
    }
    new DirectedGraph[T](v.toSet, idx.values.map(edge => DirectedEdge(edge._1.get, edge._2.get)).toSet)
  }
}

package com.manenkov.lib

import scala.collection.immutable.Set
import scala.collection.mutable

abstract class Graph[T, V <: Vertice[T], E <: Edge[T]](val vertices: Set[V], val edges: Set[E]) {
  def bfs(): Seq[V] = bfs(vertices.head)

  def bfs(root: V): Seq[V] = {
    val answer = mutable.ListBuffer[V]()
    val visited = mutable.Set[V]()
    val queue = mutable.Queue[V]()
    queue.enqueue(root)
    visited.add(root)

    while (queue.nonEmpty) {
      val curr = queue.dequeue()
      answer.addOne(curr)

      val neighbors =
        edges.foldLeft(Set[V]())((acc, next) => {
          next match {
            case pair if pair.from == curr => acc + pair.to.asInstanceOf[V]
            case pair if pair.to == curr => acc + pair.from.asInstanceOf[V]
            case _ => acc
          }
        })
          .filter(!visited.contains(_))
      queue.enqueueAll(neighbors)
      visited.addAll(neighbors)
    }
    answer.toSeq
  }

  def dfs(): Seq[V] = dfs(vertices.head)

  def dfs(root: V): Seq[V] = {
    val answer = mutable.ListBuffer[V]()
    val visited = mutable.Set[V]()
    val stack = mutable.Stack[V]()
    stack.push(root)
    visited.add(root)

    while (stack.nonEmpty) {
      val curr = stack.pop()
      answer.addOne(curr)

      val neighbors =
        edges.foldLeft(Set[V]())((acc, next) => {
          next match {
            case pair if pair.from == curr => acc + pair.to.asInstanceOf[V]
            case pair if pair.to == curr => acc + pair.from.asInstanceOf[V]
            case _ => acc
          }
        })
          .filter(!visited.contains(_))
      stack.pushAll(neighbors)
      visited.addAll(neighbors)
    }
    answer.toSeq
  }
}

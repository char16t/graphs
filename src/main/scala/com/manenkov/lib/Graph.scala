package com.manenkov.lib

import scala.collection.mutable

abstract class Graph[T, E <: Edge[T]] extends TraversableGraph[Vertice[T]] {
  val vertices: Set[Vertice[T]]
  val edges: Set[E]

  override def bfs(): Seq[Vertice[T]] = bfs(vertices.head)

  override def bfs(root: Vertice[T]): Seq[Vertice[T]] = {
    type V = Vertice[T]
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

  override def dfs(): Seq[Vertice[T]] = dfs(vertices.head)

  override def dfs(root: Vertice[T]): Seq[Vertice[T]] = {
    type V = Vertice[T]
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

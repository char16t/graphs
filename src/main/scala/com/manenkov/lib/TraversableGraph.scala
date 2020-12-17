package com.manenkov.lib

trait TraversableGraph[V] {
  def bfs(): Seq[V]
  def bfs(root: V): Seq[V]
  def dfs(): Seq[V]
  def dfs(root: V): Seq[V]
}

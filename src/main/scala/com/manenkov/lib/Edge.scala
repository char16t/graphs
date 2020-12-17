package com.manenkov.lib

trait Edge[+T] {
  val from: Vertice[T]
  val to: Vertice[T]
}

package com.manenkov.lib

case class DirectedEdge[T](override val from: Vertice[T], override val to: Vertice[T]) extends Edge[T](from, to)

package com.manenkov.lib.directed

import com.manenkov.lib.{Edge, Vertice}

case class DirectedEdge[T](override val from: Vertice[T], override val to: Vertice[T]) extends Edge[T]

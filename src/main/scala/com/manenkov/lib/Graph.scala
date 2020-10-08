package com.manenkov.lib

abstract class Graph[T, V <: Vertice[T], E <: Edge[T]](val vertices: Set[V], val edges: Set[E])

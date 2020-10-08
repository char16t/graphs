package com.manenkov.lib

import org.junit.Assert._
import org.junit.Test

class Test1 {
  @Test def initEmptyUndirectedGraphFromEdges(): Unit = {
    val graph: Graph[Int] = UndirectedGraph.fromEdges()
    assertEquals(graph.edges, Set())
    assertEquals(graph.vertices, Set())
  }

  @Test def initEmptyDirectedGraphFromEdges(): Unit = {
    val graph: Graph[Int] = DirectedGraph.fromEdges()
    assertEquals(graph.edges, Set())
    assertEquals(graph.vertices, Set())
  }

  @Test def initUndirectedGraphFromEdges(): Unit = {
    val graph: Graph[Int] = UndirectedGraph.fromEdges(
      (1, 2), (1, 3), (2, 4), (2, 5), (3, 6), (3, 7)
    )
    assertEquals(graph.edges, Set(
      Edge(Vertice(1), Vertice(2)),
      Edge(Vertice(1), Vertice(3)),
      Edge(Vertice(2), Vertice(4)),
      Edge(Vertice(2), Vertice(5)),
      Edge(Vertice(3), Vertice(6)),
      Edge(Vertice(3), Vertice(7))
    ))
    assertEquals(graph.vertices, (1 to 7).map(Vertice(_)).toSet)
  }

  @Test def initDirectedGraphFromEdges(): Unit = {
    val graph: Graph[Int] = DirectedGraph.fromEdges(
      (1, 2), (1, 3), (2, 4), (2, 5), (3, 6), (3, 7)
    )
    assertEquals(graph.edges, Set(
      Edge(Vertice(1), Vertice(2)),
      Edge(Vertice(1), Vertice(3)),
      Edge(Vertice(2), Vertice(4)),
      Edge(Vertice(2), Vertice(5)),
      Edge(Vertice(3), Vertice(6)),
      Edge(Vertice(3), Vertice(7))
    ))
    assertEquals(graph.vertices, (1 to 7).map(Vertice(_)).toSet)
  }

  @Test def initDirectedGraphFromAdjacencyMatrix(): Unit = {
    val graph: Graph[Char] = DirectedGraph.fromAdjacencyMatrix(
      Array(
        Array(1, 1, 1, 0, 0, 0, 0),
        Array(1, 1, 0, 1, 1, 0, 0),
        Array(1, 0, 1, 0, 0, 1, 1),
        Array(0, 1, 0, 1, 0, 0, 0),
        Array(0, 1, 0, 0, 1, 0, 0),
        Array(0, 0, 1, 0, 0, 1, 0),
        Array(0, 0, 1, 0, 0, 0, 1)
      ),
      Vector('A', 'B','C', 'D', 'E', 'F', 'G')
    )
    assertEquals(graph.edges, Set(
      Edge(Vertice('A'), Vertice('B')),
      Edge(Vertice('A'), Vertice('C')),
      Edge(Vertice('B'), Vertice('D')),
      Edge(Vertice('B'), Vertice('E')),
      Edge(Vertice('C'), Vertice('F')),
      Edge(Vertice('C'), Vertice('G'))
    ))
    assertEquals(graph.vertices, ('A' to 'G').map(Vertice(_)).toSet)
  }

  @Test def initUndirectedGraphFromAdjacencyMatrix(): Unit = {
    val graph: Graph[Char] = UndirectedGraph.fromAdjacencyMatrix(
      Array(
        Array(1, 1, 1, 0, 0, 0, 0),
        Array(1, 1, 0, 1, 1, 0, 0),
        Array(1, 0, 1, 0, 0, 1, 1),
        Array(0, 1, 0, 1, 0, 0, 0),
        Array(0, 1, 0, 0, 1, 0, 0),
        Array(0, 0, 1, 0, 0, 1, 0),
        Array(0, 0, 1, 0, 0, 0, 1)
      ),
      Vector('A', 'B','C', 'D', 'E', 'F', 'G')
    )
    assertEquals(graph.edges, Set(
      Edge(Vertice('A'), Vertice('B')),
      Edge(Vertice('A'), Vertice('C')),
      Edge(Vertice('B'), Vertice('D')),
      Edge(Vertice('B'), Vertice('E')),
      Edge(Vertice('C'), Vertice('F')),
      Edge(Vertice('C'), Vertice('G'))
    ))
    assertEquals(graph.vertices, ('A' to 'G').map(Vertice(_)).toSet)
  }

  @Test def initDirectedGraphFromAdjacencyList(): Unit = {
    val graph: Graph[Char] = DirectedGraph.fromAdjacencyList(
      Map(
        'A' -> List('B', 'C'),
        'B' -> List('D', 'E'),
        'C' -> List('F', 'G')
      )
    )
    assertEquals(graph.edges, Set(
      Edge(Vertice('A'), Vertice('B')),
      Edge(Vertice('A'), Vertice('C')),
      Edge(Vertice('B'), Vertice('D')),
      Edge(Vertice('B'), Vertice('E')),
      Edge(Vertice('C'), Vertice('F')),
      Edge(Vertice('C'), Vertice('G'))
    ))
    assertEquals(graph.vertices, ('A' to 'G').map(Vertice(_)).toSet)
  }

  @Test def initUndirectedGraphFromAdjacencyList(): Unit = {
    val graph: Graph[Char] = UndirectedGraph.fromAdjacencyList(
      Map(
        'A' -> List('B', 'C'),
        'B' -> List('D', 'E'),
        'C' -> List('F', 'G')
      )
    )
    assertEquals(graph.edges, Set(
      Edge(Vertice('A'), Vertice('B')),
      Edge(Vertice('A'), Vertice('C')),
      Edge(Vertice('B'), Vertice('D')),
      Edge(Vertice('B'), Vertice('E')),
      Edge(Vertice('C'), Vertice('F')),
      Edge(Vertice('C'), Vertice('G'))
    ))
    assertEquals(graph.vertices, ('A' to 'G').map(Vertice(_)).toSet)
  }

  @Test def initDirectedGraphFromIncidenceMatrix(): Unit = {
    val graph: Graph[Char] = DirectedGraph.fromIncidenceMatrix(
      Array(
        Array(1, 1, 0, 0, 0, 0),
        Array(-1, 0, 1, 1, 0, 0),
        Array(0, -1, 0, 0, 1, 1),
        Array(0, 0, -1, 0, 0, 0),
        Array(0, 0, 0, -1, 0, 0),
        Array(0, 0, 0, 0, -1, 0),
        Array(0, 0, 0, 0, 0, -1)
      ),
      ('A' to 'G').toVector
    )
    assertEquals(graph.edges, Set(
      Edge(Vertice('A'), Vertice('B')),
      Edge(Vertice('A'), Vertice('C')),
      Edge(Vertice('B'), Vertice('D')),
      Edge(Vertice('B'), Vertice('E')),
      Edge(Vertice('C'), Vertice('F')),
      Edge(Vertice('C'), Vertice('G'))
    ))
    assertEquals(graph.vertices, ('A' to 'G').map(Vertice(_)).toSet)
  }

  @Test def initDirectedGraphFromIncidenceMatrix2(): Unit = {
    val graph: Graph[Char] = DirectedGraph.fromIncidenceMatrix(
      Array(
        Array(1, -1, 0, 0, 0, 0),
        Array(-1, 0, 1, 1, 0, 0),
        Array(0, 1, 0, 0, 1, 1),
        Array(0, 0, -1, 0, 0, 0),
        Array(0, 0, 0, -1, 0, 0),
        Array(0, 0, 0, 0, -1, 0),
        Array(0, 0, 0, 0, 0, -1)
      ),
      ('A' to 'G').toVector
    )
    assertEquals(graph.edges, Set(
      Edge(Vertice('A'), Vertice('B')),
      Edge(Vertice('A'), Vertice('C')),
      Edge(Vertice('B'), Vertice('D')),
      Edge(Vertice('B'), Vertice('E')),
      Edge(Vertice('C'), Vertice('F')),
      Edge(Vertice('C'), Vertice('G'))
    ))
    assertEquals(graph.vertices, ('A' to 'G').map(Vertice(_)).toSet)
  }

  @Test def initUndirectedGraphFromIncidenceMatrix(): Unit = {
    val graph: Graph[Char] = UndirectedGraph.fromIncidenceMatrix(
      Array(
        Array(1, 1, 0, 0, 0, 0),
        Array(1, 0, 1, 1, 0, 0),
        Array(0, 1, 0, 0, 1, 1),
        Array(0, 0, 1, 0, 0, 0),
        Array(0, 0, 0, 1, 0, 0),
        Array(0, 0, 0, 0, 1, 0),
        Array(0, 0, 0, 0, 0, 1)
      ),
      ('A' to 'G').toVector
    )
    assertEquals(graph.edges, Set(
      Edge(Vertice('A'), Vertice('B')),
      Edge(Vertice('A'), Vertice('C')),
      Edge(Vertice('B'), Vertice('D')),
      Edge(Vertice('B'), Vertice('E')),
      Edge(Vertice('C'), Vertice('F')),
      Edge(Vertice('C'), Vertice('G'))
    ))
    assertEquals(graph.vertices, ('A' to 'G').map(Vertice(_)).toSet)
  }

  @Test def edgeEquality(): Unit = {
    assertEquals(true, Edge(Vertice(1), Vertice(2)) == Edge(Vertice(1), Vertice(2)))
    assertEquals(true, Edge(Vertice(1), Vertice(2)) == Edge(Vertice(2), Vertice(1)))
    assertEquals(false, Edge(Vertice(1), Vertice(2)) == Edge(Vertice(2), Vertice(2)))
    assertEquals(
      List(
        Edge(Vertice(1), Vertice(2)),
        Edge(Vertice(2), Vertice(1)),
        Edge(Vertice(2), Vertice(2))
      ).toSet,
      Set(
        Edge(Vertice(1), Vertice(2)),
        Edge(Vertice(2), Vertice(2))
      )
    )
  }
}

package com.manenkov.lib

import org.junit.Assert._
import org.junit.Test

class Test1 {
  @Test def initEmptyUndirectedGraphFromEdges(): Unit = {
    val graph = UndirectedGraph.fromVerticesAndEdges()
    assertEquals(graph.edges, Set())
    assertEquals(graph.vertices, Set())
  }

  @Test def initEmptyDirectedGraphFromEdges(): Unit = {
    val graph = DirectedGraph.fromVerticesAndEdges()
    assertEquals(graph.edges, Set())
    assertEquals(graph.vertices, Set())
  }

  @Test def initUndirectedGraphFromEdges(): Unit = {
    val graph = UndirectedGraph.fromEdges(
      (1, 2), (1, 3), (2, 4), (2, 5), (3, 6), (3, 7)
    )
    assertEquals(graph.edges, Set(
      UndirectedEdge(Vertice(1), Vertice(2)),
      UndirectedEdge(Vertice(1), Vertice(3)),
      UndirectedEdge(Vertice(2), Vertice(4)),
      UndirectedEdge(Vertice(2), Vertice(5)),
      UndirectedEdge(Vertice(3), Vertice(6)),
      UndirectedEdge(Vertice(3), Vertice(7))
    ))
    assertEquals(graph.vertices, (1 to 7).map(Vertice(_)).toSet)
  }

  @Test def initDirectedGraphFromEdges(): Unit = {
    val graph = DirectedGraph.fromEdges(
      (1, 2), (1, 3), (2, 4), (2, 5), (3, 6), (3, 7)
    )
    assertEquals(graph.edges, Set(
      DirectedEdge(Vertice(1), Vertice(2)),
      DirectedEdge(Vertice(1), Vertice(3)),
      DirectedEdge(Vertice(2), Vertice(4)),
      DirectedEdge(Vertice(2), Vertice(5)),
      DirectedEdge(Vertice(3), Vertice(6)),
      DirectedEdge(Vertice(3), Vertice(7))
    ))
    assertEquals(graph.vertices, (1 to 7).map(Vertice(_)).toSet)
  }

  @Test def initUndirectedGraphFromVerticesAndEdges(): Unit = {
    val graph = UndirectedGraph.fromVerticesAndEdges(
      vertices = 1 to 7,
      edges = Seq((1, 2), (1, 3), (2, 4), (2, 5), (3, 6), (3, 7))
    )
    assertEquals(graph.edges, Set(
      UndirectedEdge(Vertice(1), Vertice(2)),
      UndirectedEdge(Vertice(1), Vertice(3)),
      UndirectedEdge(Vertice(2), Vertice(4)),
      UndirectedEdge(Vertice(2), Vertice(5)),
      UndirectedEdge(Vertice(3), Vertice(6)),
      UndirectedEdge(Vertice(3), Vertice(7))
    ))
    assertEquals(graph.vertices, (1 to 7).map(Vertice(_)).toSet)
  }

  @Test def initUndirectedUnconnectedGraphFromVerticesAndEdges(): Unit = {
    val graph = UndirectedGraph.fromVerticesAndEdges(
      vertices = 1 to 9,
      edges = Seq((1, 2), (1, 3), (2, 4), (2, 5), (3, 6), (3, 7))
    )
    assertEquals(graph.edges, Set(
      UndirectedEdge(Vertice(1), Vertice(2)),
      UndirectedEdge(Vertice(1), Vertice(3)),
      UndirectedEdge(Vertice(2), Vertice(4)),
      UndirectedEdge(Vertice(2), Vertice(5)),
      UndirectedEdge(Vertice(3), Vertice(6)),
      UndirectedEdge(Vertice(3), Vertice(7))
    ))
    assertEquals(graph.vertices, (1 to 9).map(Vertice(_)).toSet)
  }

  @Test def initDirectedGraphFromVerticesAndEdges(): Unit = {
    val graph = DirectedGraph.fromVerticesAndEdges(
      vertices = 1 to 7,
      edges = Seq((1, 2), (1, 3), (2, 4), (2, 5), (3, 6), (3, 7))
    )
    assertEquals(graph.edges, Set(
      DirectedEdge(Vertice(1), Vertice(2)),
      DirectedEdge(Vertice(1), Vertice(3)),
      DirectedEdge(Vertice(2), Vertice(4)),
      DirectedEdge(Vertice(2), Vertice(5)),
      DirectedEdge(Vertice(3), Vertice(6)),
      DirectedEdge(Vertice(3), Vertice(7))
    ))
    assertEquals(graph.vertices, (1 to 7).map(Vertice(_)).toSet)
  }

  @Test def initDirectedUnconnectedGraphFromVerticesAndEdges(): Unit = {
    val graph = DirectedGraph.fromVerticesAndEdges(
      vertices = 1 to 9,
      edges = Seq((1, 2), (1, 3), (2, 4), (2, 5), (3, 6), (3, 7))
    )
    assertEquals(graph.edges, Set(
      DirectedEdge(Vertice(1), Vertice(2)),
      DirectedEdge(Vertice(1), Vertice(3)),
      DirectedEdge(Vertice(2), Vertice(4)),
      DirectedEdge(Vertice(2), Vertice(5)),
      DirectedEdge(Vertice(3), Vertice(6)),
      DirectedEdge(Vertice(3), Vertice(7))
    ))
    assertEquals(graph.vertices, (1 to 9).map(Vertice(_)).toSet)
  }

  @Test def initDirectedGraphFromAdjacencyMatrix(): Unit = {
    val graph = DirectedGraph.fromAdjacencyMatrix(
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
      DirectedEdge(Vertice('A'), Vertice('B')),
      DirectedEdge(Vertice('A'), Vertice('C')),
      DirectedEdge(Vertice('B'), Vertice('D')),
      DirectedEdge(Vertice('B'), Vertice('E')),
      DirectedEdge(Vertice('C'), Vertice('F')),
      DirectedEdge(Vertice('C'), Vertice('G'))
    ))
    assertEquals(graph.vertices, ('A' to 'G').map(Vertice(_)).toSet)
  }

  @Test def initUndirectedGraphFromAdjacencyMatrix(): Unit = {
    val graph = UndirectedGraph.fromAdjacencyMatrix(
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
      UndirectedEdge(Vertice('A'), Vertice('B')),
      UndirectedEdge(Vertice('A'), Vertice('C')),
      UndirectedEdge(Vertice('B'), Vertice('D')),
      UndirectedEdge(Vertice('B'), Vertice('E')),
      UndirectedEdge(Vertice('C'), Vertice('F')),
      UndirectedEdge(Vertice('C'), Vertice('G'))
    ))
    assertEquals(graph.vertices, ('A' to 'G').map(Vertice(_)).toSet)
  }

  @Test def initDirectedGraphFromAdjacencyList(): Unit = {
    val graph = DirectedGraph.fromAdjacencyList(
      Map(
        'A' -> List('B', 'C'),
        'B' -> List('D', 'E'),
        'C' -> List('F', 'G')
      )
    )
    assertEquals(graph.edges, Set(
      DirectedEdge(Vertice('A'), Vertice('B')),
      DirectedEdge(Vertice('A'), Vertice('C')),
      DirectedEdge(Vertice('B'), Vertice('D')),
      DirectedEdge(Vertice('B'), Vertice('E')),
      DirectedEdge(Vertice('C'), Vertice('F')),
      DirectedEdge(Vertice('C'), Vertice('G'))
    ))
    assertEquals(graph.vertices, ('A' to 'G').map(Vertice(_)).toSet)
  }

  @Test def initUndirectedGraphFromAdjacencyList(): Unit = {
    val graph = UndirectedGraph.fromAdjacencyList(
      Map(
        'A' -> List('B', 'C'),
        'B' -> List('D', 'E'),
        'C' -> List('F', 'G')
      )
    )
    assertEquals(graph.edges, Set(
      UndirectedEdge(Vertice('A'), Vertice('B')),
      UndirectedEdge(Vertice('A'), Vertice('C')),
      UndirectedEdge(Vertice('B'), Vertice('D')),
      UndirectedEdge(Vertice('B'), Vertice('E')),
      UndirectedEdge(Vertice('C'), Vertice('F')),
      UndirectedEdge(Vertice('C'), Vertice('G'))
    ))
    assertEquals(graph.vertices, ('A' to 'G').map(Vertice(_)).toSet)
  }

  @Test def initDirectedGraphFromIncidenceMatrix(): Unit = {
    val graph = DirectedGraph.fromIncidenceMatrix(
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
      DirectedEdge(Vertice('A'), Vertice('B')),
      DirectedEdge(Vertice('A'), Vertice('C')),
      DirectedEdge(Vertice('B'), Vertice('D')),
      DirectedEdge(Vertice('B'), Vertice('E')),
      DirectedEdge(Vertice('C'), Vertice('F')),
      DirectedEdge(Vertice('C'), Vertice('G'))
    ))
    assertEquals(graph.vertices, ('A' to 'G').map(Vertice(_)).toSet)
  }

  @Test def initDirectedGraphFromIncidenceMatrix2(): Unit = {
    val graph = DirectedGraph.fromIncidenceMatrix(
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
      DirectedEdge(Vertice('A'), Vertice('B')),
      DirectedEdge(Vertice('C'), Vertice('A')),
      DirectedEdge(Vertice('B'), Vertice('D')),
      DirectedEdge(Vertice('B'), Vertice('E')),
      DirectedEdge(Vertice('C'), Vertice('F')),
      DirectedEdge(Vertice('C'), Vertice('G'))
    ))
    assertEquals(graph.vertices, ('A' to 'G').map(Vertice(_)).toSet)
  }

  @Test def initUndirectedGraphFromIncidenceMatrix(): Unit = {
    val graph = UndirectedGraph.fromIncidenceMatrix(
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
      UndirectedEdge(Vertice('A'), Vertice('B')),
      UndirectedEdge(Vertice('A'), Vertice('C')),
      UndirectedEdge(Vertice('B'), Vertice('D')),
      UndirectedEdge(Vertice('B'), Vertice('E')),
      UndirectedEdge(Vertice('C'), Vertice('F')),
      UndirectedEdge(Vertice('C'), Vertice('G'))
    ))
    assertEquals(graph.vertices, ('A' to 'G').map(Vertice(_)).toSet)
  }

  @Test def directedEdgeEquality(): Unit = {
    assertEquals(true, DirectedEdge(Vertice(1), Vertice(2)) == DirectedEdge(Vertice(1), Vertice(2)))
    assertEquals(false, DirectedEdge(Vertice(1), Vertice(2)) == DirectedEdge(Vertice(2), Vertice(1)))
    assertEquals(false, DirectedEdge(Vertice(1), Vertice(2)) == DirectedEdge(Vertice(2), Vertice(2)))
    assertEquals(
      List(
        DirectedEdge(Vertice(1), Vertice(2)),
        DirectedEdge(Vertice(2), Vertice(1)),
        DirectedEdge(Vertice(2), Vertice(2))
      ).toSet,
      Set(
        DirectedEdge(Vertice(1), Vertice(2)),
        DirectedEdge(Vertice(2), Vertice(1)),
        DirectedEdge(Vertice(2), Vertice(2))
      )
    )
  }

  @Test def undirectedEdgeEquality(): Unit = {
    assertEquals(true, UndirectedEdge(Vertice(1), Vertice(2)) == UndirectedEdge(Vertice(1), Vertice(2)))
    assertEquals(true, UndirectedEdge(Vertice(1), Vertice(2)) == UndirectedEdge(Vertice(2), Vertice(1)))
    assertEquals(false, UndirectedEdge(Vertice(1), Vertice(2)) == UndirectedEdge(Vertice(2), Vertice(2)))
    assertEquals(
      List(
        UndirectedEdge(Vertice(1), Vertice(2)),
        UndirectedEdge(Vertice(2), Vertice(1)),
        UndirectedEdge(Vertice(2), Vertice(2))
      ).toSet,
      Set(
        UndirectedEdge(Vertice(1), Vertice(2)),
        UndirectedEdge(Vertice(2), Vertice(2))
      )
    )
  }
}

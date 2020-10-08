package com.manenkov.lib

case class UndirectedEdge[T](override val from: Vertice[T], override val to: Vertice[T]) extends Edge[T](from, to) {
  override def equals(that: Any): Boolean = that match {
    case that: UndirectedEdge[T] => ( that canEqual this ) && (
      this.from == that.from && this.to == that.to ||
        this.from == that.to && this.to == that.from
      )
    case _ => false
  }
  override def canEqual( that:Any ): Boolean = that.isInstanceOf[UndirectedEdge[T]]
  override def hashCode: Int = from.hashCode + to.hashCode
}
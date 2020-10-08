package com.manenkov.lib

case class Edge[T](from: Vertice[T], to: Vertice[T]) {
  override def equals(that: Any): Boolean = that match {
    case that: Edge[T] => ( that canEqual this ) && (
      this.from == that.from && this.to == that.to ||
        this.from == that.to && this.to == that.from
      )
    case _ => false
  }
  override def canEqual( that:Any ): Boolean = that.isInstanceOf[Edge[T]]
  override def hashCode: Int = from.hashCode + to.hashCode
}

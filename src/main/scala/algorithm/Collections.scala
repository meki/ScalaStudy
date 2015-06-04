package algorithm

object Collections {

  /** returns nCr */
  def combination[A](lst: Traversable[A], r: Int): List[List[A]] = {
    if (r >= lst.size) {
      return List(lst)
    }
    
  }
}

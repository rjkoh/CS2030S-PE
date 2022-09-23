/**
 * CS2030S PE1 Question 1
 * AY21/22 Semester 2
 *
 * @author A0239234E
 */

package cs2030s.fp;

import java.util.NoSuchElementException;
/**
 * class Either monad
 *
 * @author Koh Rui Jie
 */

public abstract class Either<T> {
  /**
   * class Left of Either
   *
   * @author Koh Rui Jie
   */
  private static class Left<T> extends Either<T> {
    private T value;

    /**
     * constructor for instance of Left
     *
     * @param value value to store
     */
    public Left(T value) {
      this.value = value;
    }

    /**
     * checks if instance is Left
     *
     * @return boolean left or not
     */
    @Override
    public boolean isLeft() {
      return true;
    }

    /**
     * checks if instance is Right
     *
     * @return boolean right or not
     */
    @Override
    public boolean isRight() {
      return false;
    }

    /**
     * gets value if Left
     *
     * @return T value stored
     */
    @Override
    public T getLeft() throws NoSuchElementException {
      return this.value;
    }

    /**
     * gets value if Right
     *
     * @return T value stored
     */
    @Override
    public T getRight() throws NoSuchElementException {
      throw new NoSuchElementException();
    }

    /**
     * checks if 2 instances are the same
     *
     * @param o object to check to this
     * @return boolean equals or not
     */
    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      } else if (o instanceof Left<?>) {
        Left<?> l = (Left<?>) o;

        if (l.value == this.value) {
          return true;
        }

        if (l.value == null || this.value == null) {
          return false;
        }

        return l.value.equals(this.value);
      }
      return false;
    }

    /**
     * gives String representation
     *
     * @return String string representation
     */
    @Override
    public String toString() {
      return String.format("Left[%s]", this.value.toString());
    }  

    @Override
    /**
     * maps transformers to instance
     *
     * @param <S> type of Either to return
     * @param l transformer for left
     * @param r transformer for right
     * @return Either<S> transformed instance
     */
    public <S> Either<S> map(Transformer<? super T, ? extends S> l, 
        Transformer<? super T, ? extends S> r) {
      return Either.left(l.transform(this.value));
    }

    @Override
    /**
     * flatmap transformers to instance
     *
     * @param <S> type of Either to return
     * @param l transformer for left
     * @param r transformer for right
     * @return Either<S> transformed instance
     */
    public <S> Either<S> flatMap(Transformer<? super T, ? extends Either<? extends S>> l,
        Transformer<? super T, ? extends Either<? extends S>> r) {
      return Either.left(l.transform(this.value).getLeft());
    }  

  } 

  /**
   * class Right of Either
   *
   * @author Koh Rui Jie
   */
  private static class Right<T> extends Either<T> {
    private T value;

    /**
     * constructor for instance of Right
     *
     * @param value to store inside
     */
    public Right(T value) {
      this.value = value;
    } 

    /**
     * checks if instance is Left
     *
     * @return boolean left or not
     */
    @Override
    public boolean isLeft() {
      return false;
    }

    /**
     * checks if instance is Right
     *
     * @return boolean right or not
     */
    @Override
    public boolean isRight() {
      return true;
    }

    /**
     * gets value if right
     *
     * @return T value stored
     */
    @Override
    public T getRight() throws NoSuchElementException {
      return this.value;
    }

    /** gets value if left
     *
     * @return T value stored;
     */
    @Override
    public T getLeft() throws NoSuchElementException {
      throw new NoSuchElementException();
    }

    /**
     * checks if 2 instances are equal
     *
     * @param o object to check against this
     * @return boolean equals or not
     */
    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      } else if (o instanceof Right<?>) {
        Right<?> l = (Right<?>) o;

        if (l.value == this.value) {
          return true;
        }

        if (l.value == null || this.value == null) {
          return false;
        }

        return l.value.equals(this.value);
      }
      return false;
    }

    /**
     * gets String representation
     *
     * @return String string representation
     */
    @Override
    public String toString() {
      return String.format("Right[%s]", this.value.toString());
    }  

    @Override
    /**
     * maps transformers to instance
     *
     * @param <S> type of Either to return
     * @param l transformer for left
     * @param r transformer for right
     * @return Either<S> transformed instance
     */
    public <S> Either<S> map(Transformer<? super T, ? extends S> l, 
        Transformer<? super T, ? extends S> r) {
      return Either.right(r.transform(this.value));
    }

    @Override
    /**
     * flatmap transformers to instance
     *
     * @param <S> type of Either to return
     * @param l transformer for left
     * @param r transformer for right
     * @return Either<S> transformed instance
     */
    public <S> Either<S> flatMap(Transformer<? super T, ? extends Either<? extends S>> l,
        Transformer<? super T, ? extends Either<? extends S>> r) {
      return Either.right(r.transform(this.value).getRight());
    }  


  }  

  /**
   * creates new instance of Left
   *
   * @param <T> type of value stored
   * @param val value stored
   * @return Either<T> new left instance
   */
  public static <T> Either<T> left(T val) {
    return new Left<T>(val);
  }

  /**
   * creates new instance of Right
   *
   * @param <T> type of value stored
   * @param val value stored
   * @return Either<T> new right instance
   */
  public static <T> Either<T> right(T val) {
    return new Right<T>(val);
  }

  /**
   * checks if instance is Left
   *
   * @return boolean left or not
   */
  public abstract boolean isLeft();


  /**
   * checks if instance is Right
   *
   * @return boolean right or not
   */
  public abstract boolean isRight();

  /**
   * gets value if left
   *
   * @return T value stored
   */
  public abstract T getLeft() throws NoSuchElementException;

  /**
   * gets value if right
   *
   * @return T value stored
   */
  public abstract T getRight() throws NoSuchElementException;

  /**
   * maps transformers to instance
   *
   * @param <S> type of Either to return
   * @param l transformer for left
   * @param r transformer for right
   * @return Either<S> transformed instance
   */
  public abstract <S> Either<S> map(Transformer<? super T, ? extends S> l, 
      Transformer<? super T, ? extends S> r);

  /**
   * flatmap transformers to instance
   *
   * @param <S> type of Either to return
   * @param l transformer for left
   * @param r transformer for right
   * @return Either<S> transformed instance
   */
  public abstract <S> Either<S> flatMap(Transformer<? super T, ? extends Either<? extends S>> l,
      Transformer<? super T, ? extends Either<? extends S>> r);


}  

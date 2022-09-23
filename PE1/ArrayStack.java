/**
 * CS2030S PE1 Question 2
 * AY21/22 Semester 2
 *
 * @author A0239234E
 */

class ArrayStack<T> implements Stack<T> {

  private int max;
  private T[] arr;
  private int top;

  public ArrayStack(int max) {
    this.max = max;
    @SuppressWarnings("unchecked")
    T[] arr = (T[]) new Object[max];
    this.arr = arr;
    this.top = 0;
  }

  @Override
  public void push(T t) {
    if (this.top < max) {
      this.arr[top] = t;
      this.top++;
    }
  }

  @Override
  public T pop() {
    if (this.getStackSize() != 0) {
      this.top--;
      T elem = arr[this.top];
      arr[this.top] = null;
      return elem;
    } else {
      return null;
    }  
  }

  @Override
  public int getStackSize() {
    return this.top;
  }

  @Override
  public String toString() {
    String str = "Stack: ";
    for (int i = 0; i < this.getStackSize(); i++) {
      str = str + this.arr[i].toString() + " ";
    }
    return str;
  }

  public static <S> ArrayStack<S> of(S[] arr, int max) {
    int size = Math.min(max, arr.length);
    ArrayStack<S> st = new ArrayStack<S>(size);
    for (int i = 0; i < size; i++) {
      st.push(arr[i]);
    }
    return st;
  }

  public void pushAll(ArrayStack<? extends T> src) {
    int size = src.getStackSize();
    for (int i = 0; i < size; i++) {
      this.push(src.pop());
    }
  }  

  public void popAll(ArrayStack<? super T> dest) {
    dest.pushAll(this);
  }
}

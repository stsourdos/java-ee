package com.tsourdos.tricky_java.generics;

import java.util.List;

/**
 * @author s.tsourdos
 */
public class GenericsExamples {

  public class A {
    private String value;

    public String getValue() {
      return value;
    }

    public void setValue(String value) {
      this.value = value;
    }
  }

  public class B extends A {
      
  }

  public class C extends A {
  }

  /**
   * Accepts a List of objects that are instances of the class A, or subclasses of A
   * Method still cannot insert elements into the list, because you don't know if the list passed as parameter is typed
   * to the class A, B or C
   *
   * @param elements
   */
  public void processElements(List<? extends A> elements) {
    for (A a : elements) {
      System.out.println(a.getValue());
    }
  }

  /**
   * Accepts a list is typed to either the A class, or a superclass of A.
   * Method cannot read from the list though, except if it casts the read objects to Object.
   *
   * @param list
   */
  public void insertElements(List<? super A> list) {
    list.add(new A());
    list.add(new B());
    list.add(new C());
  }
}

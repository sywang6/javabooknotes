package org.onjava8.hiding.cookie2;

public class Cookie {
    public Cookie() {
        System.out.println("Cookie constructor");
    }
   protected void bite() {
        System.out.println("bite");
    }
}
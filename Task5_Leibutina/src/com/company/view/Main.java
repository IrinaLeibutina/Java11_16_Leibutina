package com.company.view;

import com.company.controller.Controller;

public class Main {

    public static void main(String[] args) {

        Controller controller = new Controller();

        System.out.println("DOM" + controller.parse("dom","src/resources/web.xml"));
        System.out.println("SAX" + controller.parse("sax","src/resources/web.xml"));
        System.out.println("STaX" + controller.parse("stax","src/resources/web.xml"));
    }
}

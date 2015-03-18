package com.ilyamur.topaz.swing;

interface Model {

    void setPresenter(Presenter presenter);

    String getFailureMessage();

    String getA();

    void setA(String a);

    String getB();

    void setB(String b);

    String getLine();

    void setLine(String line);

    void computeSum();

    String getSum();

    void computeProduct();

    String getProduct();

    void computeLength();

    String getLength();
}

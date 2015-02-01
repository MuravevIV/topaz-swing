package com.ilyamur.topaz.swing;

interface View {

    void setPresenter(Presenter presenter);

    String getA();

    void setA(String a);

    String getB();

    void setB(String b);

    String getLine();

    void setLine(String line);

    void setSum(String sum);

    void setProduct(String product);

    void setLength(String length);
}

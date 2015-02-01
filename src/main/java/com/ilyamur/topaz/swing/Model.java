package com.ilyamur.topaz.swing;

interface Model {

    void setPresenter(Presenter presenter);

    String getFailureMessage();

    void computeSum(String a, String b);

    void computeProduct(String a, String b);

    void computeLineLength(String line);

    String getInitialA();

    String getInitialB();

    String getInitialLine();
}

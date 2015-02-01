package com.ilyamur.topaz.swing;

interface Presenter {

    void eventInitialized();

    void eventChangedA();

    void eventChangedB();

    void eventChangedLine();

    //

    void updateComputeSumSuccess(String sum);

    void updateComputeSumFailure();

    void updateComputeProductSuccess(String product);

    void updateComputeProductFailure();

    void updateComputeLineLength(String length);
}

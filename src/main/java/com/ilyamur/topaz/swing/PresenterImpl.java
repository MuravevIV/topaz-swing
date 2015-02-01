package com.ilyamur.topaz.swing;

class PresenterImpl implements Presenter {

    private final View view;
    private final Model model;

    public PresenterImpl(Model model, View view) {
        this.view = view;
        this.model = model;
        view.setPresenter(this);
        model.setPresenter(this);
    }

    @Override
    public void eventInitialized() {
        //
        String initialA = model.getInitialA();
        String initialB = model.getInitialB();
        String initialLine = model.getInitialLine();
        //
        view.setA(initialA);
        view.setB(initialB);
        view.setLine(initialLine);
        //
        eventChangedNumber();
        eventChangedLine();
    }

    public void eventChangedA() {
        eventChangedNumber();
    }

    public void eventChangedB() {
        eventChangedNumber();
    }

    @Override
    public void eventChangedLine() {
        String line = view.getLine();
        model.computeLineLength(line) ;
    }

    private void eventChangedNumber() {
        String a = view.getA();
        String b = view.getB();
        model.computeSum(a, b);
        model.computeProduct(a, b);
    }

    @Override
    public void updateComputeSumSuccess(String sum) {
        view.setSum(sum);
    }

    @Override
    public void updateComputeSumFailure() {
        String failureMessage = model.getFailureMessage();
        view.setSum(failureMessage);
    }

    @Override
    public void updateComputeProductSuccess(String product) {
        view.setProduct(product);
    }

    @Override
    public void updateComputeProductFailure() {
        String failureMessage = model.getFailureMessage();
        view.setProduct(failureMessage);
    }

    @Override
    public void updateComputeLineLength(String length) {
        view.setLength(length);
    }
}

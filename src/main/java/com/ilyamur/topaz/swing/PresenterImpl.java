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
        String initialA = model.getA();
        String initialB = model.getB();
        String initialLine = model.getLine();
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
        model.setLine(view.getLine());
        model.computeLength() ;
    }

    private void eventChangedNumber() {
        model.setA(view.getA());
        model.setB(view.getB());
        model.computeSum();
        model.computeProduct();
    }

    @Override
    public void updateComputeSumSuccess() {
        String sum = model.getSum();
        view.setSum(sum);
    }

    @Override
    public void updateComputeSumFailure() {
        String failureMessage = model.getFailureMessage();
        view.setSum(failureMessage);
    }

    @Override
    public void updateComputeProductSuccess() {
        String product = model.getProduct();
        view.setProduct(product);
    }

    @Override
    public void updateComputeProductFailure() {
        String failureMessage = model.getFailureMessage();
        view.setProduct(failureMessage);
    }

    @Override
    public void updateComputeLineLength() {
        String length = model.getLength();
        view.setLength(length);
    }
}

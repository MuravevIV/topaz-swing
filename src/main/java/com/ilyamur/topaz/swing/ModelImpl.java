package com.ilyamur.topaz.swing;

import java.math.BigInteger;

class ModelImpl implements Model {

    public static final String FAILURE_MESSAGE = "###";

    private final AppProperties appProperties;
    private Presenter presenter;

    public ModelImpl(AppProperties appProperties) {
        this.appProperties = appProperties;
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public String getFailureMessage() {
        return FAILURE_MESSAGE;
    }

    @Override
    public String getInitialA() {
        return appProperties.getProperty(AppProperties.INITIAL_A);
    }

    @Override
    public String getInitialB() {
        return appProperties.getProperty(AppProperties.INITIAL_B);
    }

    @Override
    public String getInitialLine() {
        return appProperties.getProperty(AppProperties.INITIAL_LINE);
    }

    @Override
    public void computeSum(String a, String b) {
        try {
            BigInteger bintA = new BigInteger(a);
            BigInteger bintB = new BigInteger(b);
            BigInteger bintSum = bintA.add(bintB);
            String sum = bintSum.toString();
            presenter.updateComputeSumSuccess(sum);
        } catch (NumberFormatException e) {
            presenter.updateComputeSumFailure();
        }
    }

    @Override
    public void computeProduct(String a, String b) {
        try {
            BigInteger bintA = new BigInteger(a);
            BigInteger bintB = new BigInteger(b);
            BigInteger bintProduct = bintA.multiply(bintB);
            String strProduct = bintProduct.toString();
            presenter.updateComputeProductSuccess(strProduct);
        } catch (NumberFormatException e) {
            presenter.updateComputeProductFailure();
        }
    }

    @Override
    public void computeLineLength(String line) {
        int intLength = line.length();
        String length = String.valueOf(intLength);
        presenter.updateComputeLineLength(length);
    }
}

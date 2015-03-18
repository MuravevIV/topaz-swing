package com.ilyamur.topaz.swing;

import java.math.BigInteger;

class ModelImpl implements Model {

    public static final String FAILURE_MESSAGE = "###";

    private final AppProperties appProperties;
    private Presenter presenter;

    private String a;
    private String b;
    private String line;
    private String sum;
    private String product;
    private String length;

    public ModelImpl(AppProperties appProperties) {
        this.appProperties = appProperties;
        setInitialValues();
    }

    private void setInitialValues() {
        a = appProperties.getProperty(AppProperties.INITIAL_A);
        b = appProperties.getProperty(AppProperties.INITIAL_B);
        line = appProperties.getProperty(AppProperties.INITIAL_LINE);
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
    public String getA() {
        return a;
    }

    @Override
    public void setA(String a) {
        this.a = a;
    }

    @Override
    public String getB() {
        return b;
    }

    @Override
    public void setB(String b) {
        this.b = b;
    }

    @Override
    public String getLine() {
        return line;
    }

    @Override
    public void setLine(String line) {
        this.line = line;
    }

    @Override
    public void computeSum() {
        try {
            BigInteger bintA = new BigInteger(a);
            BigInteger bintB = new BigInteger(b);
            BigInteger bintSum = bintA.add(bintB);
            sum = bintSum.toString();
            presenter.updateComputeSumSuccess();
        } catch (NumberFormatException e) {
            presenter.updateComputeSumFailure();
        }
    }

    @Override
    public String getSum() {
        return sum;
    }

    @Override
    public void computeProduct() {
        try {
            BigInteger bintA = new BigInteger(a);
            BigInteger bintB = new BigInteger(b);
            BigInteger bintProduct = bintA.multiply(bintB);
            product = bintProduct.toString();
            presenter.updateComputeProductSuccess();
        } catch (NumberFormatException e) {
            presenter.updateComputeProductFailure();
        }
    }

    @Override
    public String getProduct() {
        return product;
    }

    @Override
    public void computeLength() {
        int intLength = line.length();
        length = String.valueOf(intLength);
        presenter.updateComputeLineLength();
    }

    @Override
    public String getLength() {
        return length;
    }
}

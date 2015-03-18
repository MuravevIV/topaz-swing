package com.ilyamur.topaz.swing;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;

public class ModelImplTest {

    private static final String INITIAL_A = "10";
    private static final String INITIAL_B = "20";
    private static final String INITIAL_LINE = "test";

    private Model model;
    private Presenter mockPresenter;

    //

    @Before
    public void before() {
        //
        AppProperties mockAppProperties = mock(AppProperties.class);
        //
        when(mockAppProperties.getProperty(AppProperties.INITIAL_A)).thenReturn(INITIAL_A);
        when(mockAppProperties.getProperty(AppProperties.INITIAL_B)).thenReturn(INITIAL_B);
        when(mockAppProperties.getProperty(AppProperties.INITIAL_LINE)).thenReturn(INITIAL_LINE);
        //
        model = new ModelImpl(mockAppProperties);
        mockPresenter = mock(Presenter.class);
        model.setPresenter(mockPresenter);
    }

    @Test
    public void getFailureMessage() {
        //
        String computeFailureText = model.getFailureMessage();
        //
        assertSame(ModelImpl.FAILURE_MESSAGE, computeFailureText);
    }

    @Test
    public void computeSum_bothCorrect() {
        //
        model.setA("2");
        model.setB("4");
        model.computeSum();
        String sum = model.getSum();
        //
        verify(mockPresenter).updateComputeSumSuccess();
        assertEquals("6", sum);
    }

    @Test
    public void computeSum_oneIncorrect() {
        //
        model.setA("2");
        model.setB("b");
        model.computeSum();
        //
        verify(mockPresenter).updateComputeSumFailure();
    }

    @Test
    public void computeSum_bothIncorrect() {
        //
        model.setA("a");
        model.setB("b");
        model.computeSum();
        //
        verify(mockPresenter).updateComputeSumFailure();
    }

    @Test
    public void computeProduct_bothCorrect() {
        //
        model.setA("2");
        model.setB("4");
        model.computeProduct();
        String product = model.getProduct();
        //
        verify(mockPresenter).updateComputeProductSuccess();
        assertEquals("8", product);
    }

    @Test
    public void computeProduct_oneIncorrect() {
        //
        model.setA("2");
        model.setB("b");
        model.computeProduct();
        //
        verify(mockPresenter).updateComputeProductFailure();
    }

    @Test
    public void computeProduct_bothIncorrect() {
        //
        model.setA("a");
        model.setB("b");
        model.computeProduct();
        //
        verify(mockPresenter).updateComputeProductFailure();
    }

    @Test
    public void computeLineLength_zeroLength() {
        //
        model.setLine("");
        model.computeLength();
        String length = model.getLength();
        //
        verify(mockPresenter).updateComputeLineLength();
        assertEquals("0", length);
    }

    @Test
    public void computeLineLength_someLength() {
        //
        model.setLine("test");
        model.computeLength();
        String length = model.getLength();
        //
        verify(mockPresenter).updateComputeLineLength();
        assertEquals("4", length);
    }

    @Test
    public void getInitialA() {
        //
        String actInitialA = model.getA();
        //
        assertEquals(INITIAL_A, actInitialA);
    }

    @Test
    public void getInitialB() {
        //
        String actInitialB = model.getB();
        //
        assertEquals(INITIAL_B, actInitialB);
    }

    @Test
    public void getInitialLine() {
        //
        String actInitialLine = model.getLine();
        //
        assertEquals(INITIAL_LINE, actInitialLine);
    }
}

package com.ilyamur.topaz.swing;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

public class ModelImplTest {

    private AppProperties mockAppProperties;
    private Model model;
    private Presenter mockPresenter;

    //

    @Before
    public void before() {
        mockAppProperties = mock(AppProperties.class);
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
        model.computeSum("2", "4");
        //
        verify(mockPresenter).updateComputeSumSuccess("6");
    }

    @Test
    public void computeSum_oneIncorrect() {
        //
        model.computeSum("2", "b");
        //
        verify(mockPresenter).updateComputeSumFailure();
    }

    @Test
    public void computeSum_bothIncorrect() {
        //
        model.computeSum("a", "b");
        //
        verify(mockPresenter).updateComputeSumFailure();
    }

    @Test
    public void computeProduct_bothCorrect() {
        //
        model.computeProduct("2", "4");
        //
        verify(mockPresenter).updateComputeProductSuccess("8");
    }

    @Test
    public void computeProduct_oneIncorrect() {
        //
        model.computeProduct("2", "b");
        //
        verify(mockPresenter).updateComputeProductFailure();
    }

    @Test
    public void computeProduct_bothIncorrect() {
        //
        model.computeProduct("a", "b");
        //
        verify(mockPresenter).updateComputeProductFailure();
    }

    @Test
    public void computeLineLength_zeroLength() {
        //
        model.computeLineLength("");
        //
        verify(mockPresenter).updateComputeLineLength("0");
    }

    @Test
    public void computeLineLength_someLength() {
        //
        model.computeLineLength("test");
        //
        verify(mockPresenter).updateComputeLineLength("4");
    }

    @Test
    public void getInitialA() {
        //
        String expInitialA = "10";
        when(mockAppProperties.getProperty(AppProperties.INITIAL_A)).thenReturn(expInitialA);
        //
        String actInitialA = model.getInitialA();
        //
        verify(mockAppProperties).getProperty(AppProperties.INITIAL_A);
        assertEquals(expInitialA, actInitialA);
    }

    @Test
    public void getInitialB() {
        //
        String expInitialB = "10";
        when(mockAppProperties.getProperty(AppProperties.INITIAL_B)).thenReturn(expInitialB);
        //
        String actInitialB = model.getInitialB();
        //
        verify(mockAppProperties).getProperty(AppProperties.INITIAL_B);
        assertEquals(expInitialB, actInitialB);
    }

    @Test
    public void getInitialLine() {
        //
        String expInitialLine = "10";
        when(mockAppProperties.getProperty(AppProperties.INITIAL_LINE)).thenReturn(expInitialLine);
        //
        String actInitialLine = model.getInitialLine();
        //
        verify(mockAppProperties).getProperty(AppProperties.INITIAL_LINE);
        assertEquals(expInitialLine, actInitialLine);
    }
}

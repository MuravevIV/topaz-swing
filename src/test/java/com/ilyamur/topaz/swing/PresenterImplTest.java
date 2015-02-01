package com.ilyamur.topaz.swing;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class PresenterImplTest {

    private Presenter presenter;
    private View mockView;
    private Model mockModel;

    //

    @Before
    public void before() {
        mockModel = mock(Model.class);
        mockView = mock(View.class);
        presenter = new PresenterImpl(mockModel, mockView);
    }

    @Test
    public void test() {
        verify(mockModel).setPresenter(presenter);
        verify(mockView).setPresenter(presenter);
    }

    //

    @Test
    public void eventInitialized() {
        //
        String initialA = "10";
        String initialB = "20";
        String initialLine = "test";
        when(mockModel.getInitialA()).thenReturn(initialA);
        when(mockModel.getInitialB()).thenReturn(initialB);
        when(mockModel.getInitialLine()).thenReturn(initialLine);
        when(mockView.getA()).thenReturn(initialA);
        when(mockView.getB()).thenReturn(initialB);
        when(mockView.getLine()).thenReturn(initialLine);
        //
        presenter.eventInitialized();
        //
        verify(mockView).setA(initialA);
        verify(mockView).setB(initialB);
        verify(mockView).setLine(initialLine);
        verify(mockModel).computeSum(initialA, initialB);
        verify(mockModel).computeProduct(initialA, initialB);
        verify(mockModel).computeLineLength(initialLine);
    }

    @Test
    public void eventChangedA() {
        //
        String strA = "2";
        String strB = "3";
        when(mockView.getA()).thenReturn(strA);
        when(mockView.getB()).thenReturn(strB);
        //
        presenter.eventChangedA();
        //
        verify(mockModel).computeSum(strA, strB);
        verify(mockModel).computeProduct(strA, strB);
    }

    @Test
    public void eventChangedB() {
        //
        String strA = "2";
        String strB = "4";
        when(mockView.getA()).thenReturn(strA);
        when(mockView.getB()).thenReturn(strB);
        //
        presenter.eventChangedB();
        //
        verify(mockModel).computeSum(strA, strB);
        verify(mockModel).computeProduct(strA, strB);
    }

    @Test
    public void eventChangedLine() {
        //
        String string = "test";
        when(mockView.getLine()).thenReturn(string);
        //
        presenter.eventChangedLine();
        //
        verify(mockModel).computeLineLength(string);
    }

    //

    @Test
    public void updateComputeSumSuccess() {
        //
        String strSum = "6";
        //
        presenter.updateComputeSumSuccess(strSum);
        //
        verify(mockView).setSum(strSum);
    }

    @Test
    public void updateComputeSumFailure() {
        //
        String computeFailureText = "###";
        when(mockModel.getFailureMessage()).thenReturn(computeFailureText);
        //
        presenter.updateComputeSumFailure();
        //
        verify(mockModel).getFailureMessage();
        verify(mockView).setSum(computeFailureText);
    }

    @Test
    public void updateComputeProductSuccess() {
        //
        String strProduct = "6";
        //
        presenter.updateComputeProductSuccess(strProduct);
        //
        verify(mockView).setProduct(strProduct);
    }

    @Test
    public void updateComputeProductFailure() {
        //
        String computeFailureText = "###";
        when(mockModel.getFailureMessage()).thenReturn(computeFailureText);
        //
        presenter.updateComputeProductFailure();
        //
        verify(mockModel).getFailureMessage();
        verify(mockView).setProduct(computeFailureText);
    }

    @Test
    public void updateComputeLineLength() {
        //
        String strLength = "10";
        //
        presenter.updateComputeLineLength(strLength);
        //
        verify(mockView).setLength(strLength);
    }
}

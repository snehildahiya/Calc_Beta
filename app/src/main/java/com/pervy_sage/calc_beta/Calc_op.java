package com.pervy_sage.calc_beta;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Stack;

/**
 * Created by pervy_sage on 14/6/17.
 */

public interface Calc_op<T> {

    void setCompo();
    void activateCompo();
    void compute(Stack<T>numbers,Stack<T>symbols,boolean isReversed);
    double evaluate(StringBuilder expression) throws  Exception;


}

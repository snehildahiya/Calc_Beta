package com.pervy_sage.calc_beta;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Scroller;
import android.widget.TextView;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Stack;

import javax.security.auth.callback.CallbackHandler;

public class MainActivity<T> extends AppCompatActivity implements View.OnClickListener,Calc_op {

    public static final String TAG="debug";
    StringBuilder expression; //  for holding expression
    private Calc_Compo calcCompo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        expression = new StringBuilder();
        setContentView(R.layout.activity_main);
        calcCompo=new Calc_Compo();
        setCompo();
        activateCompo();
    }

    @Override
    public void setCompo() {

        calcCompo.screen=(TextView)findViewById(R.id.display);
        calcCompo.result=(TextView)findViewById(R.id.result);
        calcCompo.num0=(Button)findViewById(R.id.num0);
        calcCompo.num1=(Button)findViewById(R.id.num1);
        calcCompo.num2=(Button)findViewById(R.id.num2);
        calcCompo.num3=(Button)findViewById(R.id.num3);
        calcCompo.num4=(Button)findViewById(R.id.num4);
        calcCompo.num5=(Button)findViewById(R.id.num5);
        calcCompo.num6=(Button)findViewById(R.id.num6);
        calcCompo.num7=(Button)findViewById(R.id.num7);
        calcCompo.num8=(Button)findViewById(R.id.num8);
        calcCompo.num9=(Button)findViewById(R.id.num9);
        calcCompo.plus=(Button)findViewById(R.id.plus);
        calcCompo.minus=(Button)findViewById(R.id.minus);
        calcCompo.multiply=(Button)findViewById(R.id.multiply);
        calcCompo.divide=(Button)findViewById(R.id.division);
        calcCompo.brac_close=(Button)findViewById(R.id.brac_close);
        calcCompo.brac_open=(Button)findViewById(R.id.brac_open);
        calcCompo.equal=(Button)findViewById(R.id.equals);
        calcCompo.AC=(ImageButton)findViewById(R.id.AllClear);
        calcCompo.decimal=(Button)findViewById(R.id.dot);
        calcCompo.clear=(ImageButton)findViewById(R.id.clear);

    }

    @Override
    public void activateCompo() {
        calcCompo.num0.setOnClickListener(this);
        calcCompo.num1.setOnClickListener(this);
        calcCompo.num2.setOnClickListener(this);
        calcCompo.num3.setOnClickListener(this);
        calcCompo.num4.setOnClickListener(this);
        calcCompo.num5.setOnClickListener(this);
        calcCompo.num6.setOnClickListener(this);
        calcCompo.num7.setOnClickListener(this);
        calcCompo.num8.setOnClickListener(this);
        calcCompo.num9.setOnClickListener(this);
        calcCompo.plus.setOnClickListener(this);
        calcCompo.minus.setOnClickListener(this);
        calcCompo.multiply.setOnClickListener(this);
        calcCompo.divide.setOnClickListener(this);
        calcCompo.brac_open.setOnClickListener(this);
        calcCompo.brac_close.setOnClickListener(this);
        calcCompo.equal.setOnClickListener(this);
        calcCompo.AC.setOnClickListener(this);
        calcCompo.decimal.setOnClickListener(this);
        calcCompo.clear.setOnClickListener(this);
        calcCompo.screen.setSelected(true);

    }

    // function to compute values
    @Override
    public void compute(Stack numbers, Stack symbols, boolean isReversed) {
        try {

            char op = (char)symbols.pop();
            Double val1 = (Double) numbers.pop();
            Double val2 = (Double) numbers.pop();

            switch (op) {
                case '+':
                    numbers.push(val2 + val1);
                    break;
                case '-':
                    if(isReversed){
                        numbers.push(val1-val2);
                    }else {
                        numbers.push(val2 - val1);
                    }
                    break;
                case '*':
                    numbers.push(val1 * val2);

                    break;
                case '/':

                    if(isReversed){
                        numbers.push(val1/val2);
                    }else {
                        numbers.push(val2 /val1);
                    }
                    break;
                default:
                    // do nothing
                    break;
            }
        }catch (EmptyStackException e){

        }
    }

    @Override
    public void onClick(View v) {
        double num =0;
        char prevChar='\0';
        switch (v.getId()){
            case R.id.num0:
                calcCompo.screen.setTextColor(this.getResources().getColor(R.color.colorDarkNum));
                calcCompo.result.setTextColor(this.getResources().getColor(R.color.colorDarkNum));
                calcCompo.result.setText("");
                expression.append('0');
                calcCompo.screen.setText(expression);
                try {
                    num = evaluate(expression);
                    if(num!=Double.MIN_VALUE) {
                        calcCompo.result.setText('=' + String.valueOf(num));
                    }
                }catch (Exception e){
                   // do nothing
                }
                break;
            case R.id.num1:
                calcCompo.screen.setTextColor(this.getResources().getColor(R.color.colorDarkNum));
                calcCompo.result.setTextColor(this.getResources().getColor(R.color.colorDarkNum));
                calcCompo.result.setText("");
                expression.append('1');
                calcCompo.screen.setText(expression);
                try {
                    num = evaluate(expression);
                    if(num!=Double.MIN_VALUE) {
                        calcCompo.result.setText('=' + String.valueOf(num));
                    }
                }catch (Exception e){
                    // do nothing
                }
                break;
            case R.id.num2:
                calcCompo.screen.setTextColor(this.getResources().getColor(R.color.colorDarkNum));
                calcCompo.result.setTextColor(this.getResources().getColor(R.color.colorDarkNum));
                calcCompo.result.setText("");
                expression.append('2');
                calcCompo.screen.setText(expression);
                try {
                    num = evaluate(expression);
                    if(num!=Double.MIN_VALUE) {
                        calcCompo.result.setText('=' + String.valueOf(num));
                    }
                }catch (Exception e){
                    // do nothing
                }
                break;
            case R.id.num3:
                calcCompo.screen.setTextColor(this.getResources().getColor(R.color.colorDarkNum));
                calcCompo.result.setTextColor(this.getResources().getColor(R.color.colorDarkNum));
                calcCompo.result.setText("");
                expression.append('3');
                calcCompo.screen.setText(expression);
                try {
                    num = evaluate(expression);
                    if(num!=Double.MIN_VALUE) {
                        calcCompo.result.setText('=' + String.valueOf(num));
                    }
                }catch (Exception e){
                    // do nothing
                }
                break;
            case R.id.num4:
                calcCompo.screen.setTextColor(this.getResources().getColor(R.color.colorDarkNum));
                calcCompo.result.setTextColor(this.getResources().getColor(R.color.colorDarkNum));
                calcCompo.result.setText("");
                expression.append('4');
                calcCompo.screen.setText(expression);
                try {
                    num = evaluate(expression);
                    if(num!=Double.MIN_VALUE) {
                        calcCompo.result.setText('=' + String.valueOf(num));
                    }
                }catch (Exception e){
                    // do nothing
                }
                break;
            case R.id.num5:
                calcCompo.screen.setTextColor(this.getResources().getColor(R.color.colorDarkNum));
                calcCompo.result.setTextColor(this.getResources().getColor(R.color.colorDarkNum));
                calcCompo.result.setText("");
                expression.append('5');
                calcCompo.screen.setText(expression);
                try {
                    num = evaluate(expression);
                    if(num!=Double.MIN_VALUE) {
                        calcCompo.result.setText('=' + String.valueOf(num));
                    }
                }catch (Exception e){
                    // do nothing
                }
                break;
            case R.id.num6:
                calcCompo.screen.setTextColor(this.getResources().getColor(R.color.colorDarkNum));
                calcCompo.result.setTextColor(this.getResources().getColor(R.color.colorDarkNum));
                calcCompo.result.setText("");
                expression.append('6');
                calcCompo.screen.setText(expression);
                try {
                    num = evaluate(expression);
                    if(num!=Double.MIN_VALUE) {
                        calcCompo.result.setText('=' + String.valueOf(num));
                    }
                }catch (Exception e){
                    // do nothing
                }
                break;
            case R.id.num7:
                calcCompo.screen.setTextColor(this.getResources().getColor(R.color.colorDarkNum));
                calcCompo.result.setTextColor(this.getResources().getColor(R.color.colorDarkNum));
                calcCompo.result.setText("");
                expression.append('7');
                calcCompo.screen.setText(expression);
                try {
                    num = evaluate(expression);
                    if(num!=Double.MIN_VALUE) {
                        calcCompo.result.setText('=' + String.valueOf(num));
                    }
                }catch (Exception e){
                    // do nothing
                }
                break;
            case R.id.num8:
                calcCompo.screen.setTextColor(this.getResources().getColor(R.color.colorDarkNum));
                calcCompo.result.setTextColor(this.getResources().getColor(R.color.colorDarkNum));
                calcCompo.result.setText("");
                expression.append('8');
                calcCompo.screen.setText(expression);
                try {
                    num = evaluate(expression);
                    if(num!=Double.MIN_VALUE) {
                        calcCompo.result.setText('=' + String.valueOf(num));
                    }
                }catch (Exception e){
                    // do nothing
                }
                break;
            case R.id.num9:
                calcCompo.screen.setTextColor(this.getResources().getColor(R.color.colorDarkNum));
                calcCompo.result.setTextColor(this.getResources().getColor(R.color.colorDarkNum));
                calcCompo.result.setText("");
                expression.append('9');
                calcCompo.screen.setText(expression);
                try {
                    num = evaluate(expression);
                    if(num!=Double.MIN_VALUE) {
                        calcCompo.result.setText('=' + String.valueOf(num));
                    }
                }catch (Exception e){
                    // do nothing
                }
                break;
            case R.id.dot:
                calcCompo.screen.setTextColor(this.getResources().getColor(R.color.colorDarkNum));
                calcCompo.result.setTextColor(this.getResources().getColor(R.color.colorDarkNum));
                calcCompo.result.setText("");
                expression.append('.');
                calcCompo.screen.setText(expression);
                try {
                    num = evaluate(expression);
                    if(num!=Double.MIN_VALUE) {
                        calcCompo.result.setText('=' + String.valueOf(num));
                    }
                }catch (Exception e){
                    // do nothing
                }
                break;

            case R.id.plus:
                calcCompo.screen.setTextColor(this.getResources().getColor(R.color.colorDarkNum));
                calcCompo.result.setTextColor(this.getResources().getColor(R.color.colorDarkNum));
                calcCompo.result.setText("");
                /* handling of errors like "9+*8" it will take only one
                  operator or set clicked operator and delete previous operator
                  */
                // loop 2 times for cases "3/-"and then another operator loads like '+'
                // then it has to check two previous characters
                for(int i=0;i<2;i++) {
                    if (expression.length() != 0) {
                        prevChar = expression.charAt(expression.length() - 1);
                        if (prevChar == '-' || prevChar == '/' || prevChar == '+' || prevChar == '*') {
                            expression.deleteCharAt(expression.length() - 1);
                        }
                    }
                }
                // if someone tries to put operator first in  the beginning of expression
                if(expression.length()!=0) {
                    expression.append('+');
                }
                calcCompo.screen.setText(expression);
                try {
                    num = evaluate(expression);
                    if(num!=Double.MIN_VALUE) {
                        calcCompo.result.setText('=' + String.valueOf(num));
                    }
                }catch (Exception e){
                    // do nothing
                }
                break;
            case R.id.minus:
                calcCompo.screen.setTextColor(this.getResources().getColor(R.color.colorDarkNum));
                calcCompo.result.setTextColor(this.getResources().getColor(R.color.colorDarkNum));
                calcCompo.result.setText("");
                /* handling of errors like "9+-8" it will take only one
                  operator or set clicked operator and delete previous operator
                 */
                // loop 2 times for cases "3/-"and then another operator loads like '+'
                // then it has to check two previous characters
                if(expression.length()!=0) {
                    prevChar = expression.charAt(expression.length() - 1);
                    if (prevChar == '+' || prevChar == '-') {
                        expression.deleteCharAt(expression.length() - 1);
                    }
                }
                expression.append('-');
                calcCompo.screen.setText(expression);
                try {
                    num = evaluate(expression);
                    if(num!=Double.MIN_VALUE) {
                        calcCompo.result.setText('=' + String.valueOf(num));
                    }
                }catch (Exception e){
                    // do nothing
                }
                break;
            case R.id.multiply:
                calcCompo.screen.setTextColor(this.getResources().getColor(R.color.colorDarkNum));
                calcCompo.result.setTextColor(this.getResources().getColor(R.color.colorDarkNum));
                calcCompo.result.setText("");
                /* handling of errors like "9+*8" it will take only one
                  operator or set clicked operator and delete previous operator
                 */
                // loop 2 times for cases "3/-"and then another operator loads like '+'
                // then it has to check two previous characters
                for(int i=0;i<2;i++) {
                    if (expression.length() != 0) {
                        prevChar = expression.charAt(expression.length() - 1);
                        if (prevChar == '-' || prevChar == '/' || prevChar == '+' || prevChar == '*') {
                            expression.deleteCharAt(expression.length() - 1);
                        }
                    }
                }
                // if someone tries to put operator first in  the beginning of expression
                if(expression.length()!=0) {
                    expression.append('*');
                }
                calcCompo.screen.setText(expression);
                try {
                    num = evaluate(expression);
                    if(num!=Double.MIN_VALUE) {
                        calcCompo.result.setText('=' + String.valueOf(num));
                    }
                }catch (Exception e){
                    // do nothing
                }

                break;
            case R.id.division:
                calcCompo.screen.setTextColor(this.getResources().getColor(R.color.colorDarkNum));
                calcCompo.result.setTextColor(this.getResources().getColor(R.color.colorDarkNum));
                calcCompo.result.setText("");
                /* handling of errors like "9+*8" it will take only one
                  operator or set clicked operator and delete previous operator
                */

                for(int i=0;i<2;i++) {
                    if (expression.length() != 0) {
                        prevChar = expression.charAt(expression.length() - 1);
                        if (prevChar == '-' || prevChar == '/' || prevChar == '+' || prevChar == '*') {
                            expression.deleteCharAt(expression.length() - 1);
                        }
                    }
                }
                // if someone tries to put operator first in  the beginning of expression
                if(expression.length()!=0) {
                    expression.append('/');
                }
                calcCompo.screen.setText(expression);
                try {
                    num = evaluate(expression);
                    if(num!=Double.MIN_VALUE) {
                        calcCompo.result.setText('=' + String.valueOf(num));
                    }
                }catch (Exception e){
                    // do nothing
                }
                break;
            case R.id.clear:
                calcCompo.screen.setTextColor(this.getResources().getColor(R.color.colorDarkNum));
                calcCompo.result.setTextColor(this.getResources().getColor(R.color.colorDarkNum));
                calcCompo.result.setText("");
                if(expression.length()!=0) {
                    expression.deleteCharAt(expression.length() - 1);
                    calcCompo.screen.setText(expression);
                    try {
                        num = evaluate(expression);
                        if(num!=Double.MIN_VALUE) {
                            calcCompo.result.setText('=' + String.valueOf(num));
                        }
                    }catch (Exception e){
                        // do nothing
                    }
                }

                break;
            case R.id.brac_open:
                calcCompo.screen.setTextColor(this.getResources().getColor(R.color.colorDarkNum));
                calcCompo.result.setTextColor(this.getResources().getColor(R.color.colorDarkNum));
                calcCompo.result.setText("");
                expression.append('(');
                calcCompo.screen.setText(expression);
                try {
                    num = evaluate(expression);
                    if(num!=Double.MIN_VALUE) {
                        calcCompo.result.setText('=' + String.valueOf(num));
                    }
                }catch (Exception e){
                    // do nothing
                }

                break;
            case R.id.brac_close:
                calcCompo.screen.setTextColor(this.getResources().getColor(R.color.colorDarkNum));
                calcCompo.result.setTextColor(this.getResources().getColor(R.color.colorDarkNum));
                calcCompo.result.setText("");
                expression.append(')');
                calcCompo.screen.setText(expression);
                try {
                    num = evaluate(expression);
                    if(num!=Double.MIN_VALUE) {
                        calcCompo.result.setText('=' + String.valueOf(num));
                    }
                }catch (Exception e){
                    // do nothing
                }

                break;
            case R.id.equals:
                if(expression.length()!=0) {
                    try {
                        num = evaluate(expression);
                        if (num != Double.MIN_VALUE) {
                            expression = new StringBuilder();
                            expression.append(num);
                            calcCompo.screen.setText(expression);
                        }
                        calcCompo.result.setText("");
                    } catch (NumberFormatException e) {
                        calcCompo.screen.setTextColor(this.getResources().getColor(R.color.colorFury));
                        calcCompo.result.setTextColor(this.getResources().getColor(R.color.colorFury));
                        calcCompo.result.setText("Number Format Error");
                    } catch (Exception e) {
                        calcCompo.screen.setTextColor(this.getResources().getColor(R.color.colorFury));
                        calcCompo.result.setTextColor(this.getResources().getColor(R.color.colorFury));
                        calcCompo.result.setText("Syntax Error");
                    }
                }

                break;
            case R.id.AllClear:
                expression= new StringBuilder();
                calcCompo.screen.setText("");
                calcCompo.result.setText("");

                break;
        }

    }

    /*
    this function reads string , push numbers in numStack , operators in opStack
    and evalutes answer
     */

    public double evaluate(StringBuilder expression) throws  Exception{
        boolean isReversed=false;
        StringBuilder numString = new StringBuilder();
        Stack<Double>numStack = new Stack<>();
        Stack<Character>opStack= new Stack<>();
        boolean makeNegi=false;
        double num =0;

        /* loop extracting symbols and numbers from String expressiom
        * and pushing numbers to numStack and opertors , symbols to opStack
        * */

        for(int i=0;i<expression.length();i++){
            //fetching current character
            char currChar = expression.charAt(i);
            if((currChar>='0'&&currChar<='9')||currChar=='.'){
                numString.append(currChar);
                // for case "(6-7)8" 8 is supposed to be multiplied
                // push * in opstack
                char prevChar = '\0';
                if(expression.length()>1 && i>0){
                    prevChar=expression.charAt(i-1);
                    if(prevChar==')'){
                        opStack.push('*');
                    }
                }
            }
            // if close bracket encountered evaluate value within brackets first
            // and push in number stack
            else if(currChar==')'){
                if(numString.length()!=0) {

                    num = Double.parseDouble(numString.toString());

                    // case "9/-8" if number is negative
                    if(makeNegi) {
                        num=0-num;
                        makeNegi=false;
                    }
                    numStack.push(num);
                }
                // computing till "(" encountered
                while(opStack.peek()!='('){
                    compute(numStack,opStack,isReversed);
                }
                opStack.pop();
                // case handling "6(8-9)" or "6/(8-9)"
                // if last operation is '*' or '/' compute and push result in numStack
                if(!opStack.isEmpty() && (opStack.peek()=='*'||opStack.peek()=='/')){
                    compute(numStack,opStack,isReversed);
                }
                numString=new StringBuilder();
            }
            // case of operations and open bracket
            else{
                char  prevChar ='\0';

                if(expression.length()>1 && i!=0) {
                 prevChar= expression.charAt(i - 1);
                }
                // fetching number from string
                if(numString.length()!=0) {
                    num = Double.parseDouble(numString.toString());
                    // making negitive and pushing
                    if(makeNegi) {
                        num=0-num;
                        makeNegi=false;
                    }
                    numStack.push(num);
                }
                /* case of open bracket
                 in this , we need to push '*' as operator before
                 open brack is encountered
                */
                if(currChar=='('&& expression.charAt(0)!='(') {
                    // case "6/9(**" here it evalutes 6/9 then push it in numStack
                        if (prevChar >= '0' && prevChar <= '9') {
                            if (!opStack.isEmpty()) {
                                if (opStack.peek() == '/') {
                                    compute(numStack, opStack,isReversed);
                                }
                            }
                            // pushing '*' as operator if there are numbers before '('
                            opStack.push('*');
                        }

                }
                /* when operator is loaded then number is fetched
                   pushed in numStack
                   and after that operator is pushed in opStack
                  */
                else {
                    /* !!!!!!!!!!!!!!!!ERROR!!!!!!!!!!!!!!!!!!!!!!!!!!
                       case like "*** 7+(/ ***"
                    */
                    if((currChar == '+' || currChar == '*' || currChar == '/')&&prevChar=='('){
                        throw new Exception("Syntax ERROR");
                    }
                    if(!opStack.isEmpty()) {
                        // priority handling of divide and multiplication
                        if(numString.length()!=0) {
                            if ((currChar == '+' || currChar == '-' || currChar == '*' || currChar == '/') && (opStack.peek() == '*' || opStack.peek() == '/')) {
                                compute(numStack, opStack, isReversed);
                            }
                        }
                        /* if ')' is before '/' or '*'
                           then it must have number pushed in numStack
                           our numStack would be greater then opStack than 1

                           so for priority handling of divide and multiplication
                           like in these case "(9)/89"
                           it will evaluate it first then push it numStack
                        */

                        else{
                            if((currChar=='/'||currChar=='*')&&prevChar==')'){
                                compute(numStack, opStack, isReversed);
                            }
                        }
                    }
                }
                /* case where negative numbers are possible
                 case 1 : "9/-8 or 9*-8"
                 case 2: if first character is '-' like "-9+89*6"
                 case 3: "9/(-8)"
                 case 4: 9/-(2)
                 */
                if(currChar=='-' && (prevChar=='/'||prevChar=='*'||prevChar=='\0'||prevChar=='(')){
                    // setting makeNegi true
                    // when its true then in fetching num process it will push negative numbers
                    makeNegi=true;
                }else {
                    // pushing current operator in opStack
                    // '-' is pushed in opStack in Special cases mentioned above
                    opStack.push(currChar);
                }
                // make numString new for fetching new number
                numString = new StringBuilder();
            }
        }
        // fetching and pushing last number in expression
        if(numString.length()!=0){
                num = Double.parseDouble(numString.toString());
                // if last number is negative
                if(makeNegi) {
                    num=0-num;
                    makeNegi=false;
                }
                numStack.push(num);
        }
        /*
        if last operation is divide then it should be handled
        before + and -
        but in loop last divide operation is not handled

        So handled is here
         */
        if(!opStack.isEmpty() && opStack.peek()=='/'){
            while(!opStack.isEmpty()&&opStack.peek()=='/'){
                compute(numStack,opStack,isReversed);
            }
        }
         /*
        if last operation is multiply then it should be handled
        before + and -
        but in loop last multiply operation is not handled

        So handled is here
         */
        if(!opStack.isEmpty() && opStack.peek()=='*'){
            while(!opStack.isEmpty()&&opStack.peek()=='*'){
                compute(numStack,opStack,isReversed);
            }
        }
        // case when expression is only "9-8 or 6-7"
        if(opStack.size()==1 && opStack.peek()=='-'){
            compute(numStack,opStack,isReversed);
        }
        // ~~~~~~~~~~~~~AT this stage opStack only contains '+' and '-' ~~~~~~~~~~~~~~~~~~~


        //*********Reversing Stacks  as for left to right operation********************
        numStack=(Stack<Double>)this.reverseStack((Stack<T>)numStack);
        opStack=(Stack<Character>)this.reverseStack((Stack<T>)opStack);
        //*****************************************************************************

        //making isReversed true for left to right evaluation pf expression
        isReversed=true;

        while (!opStack.isEmpty()) {
            compute(numStack, opStack,isReversed);
        }
        double retval=Double.MIN_VALUE;
        retval = numStack.peek();
        return retval;
    }


    // Private function for reversing stack
    private <T>Stack<T> reverseStack(Stack<T> stack){
        Stack<T> spare = new Stack<>();
        while(!stack.isEmpty()){
            spare.push(stack.pop());
        }
        return  spare;
    }
}

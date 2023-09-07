/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uicalculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author USER
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField display;
    
   
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void OffButtonAction(ActionEvent event) 
    {
        System.exit(1);
    }

    @FXML
    private void ClearAction(ActionEvent event)
    {
        String oldtext=display.getText();//we first took the oldtext.why not newtext?cuase old text is sustaining all the the previous number with new one where newtext
        //only conatins one new number
       if(oldtext.equals(""))//if we keep clearing the screen even though the screen is blank ,program will crash.that's why kept such condition
            return;
        String substr=oldtext.substring(0,oldtext.length()-1);//as c clears one number from very right,we will divide the whole string before the last number comes.
        //and put that divided part in the substr.our index starts from 0 and ends before the last number which has been told inside the substring method.
        
         display.setText(substr);  
    }
//now to run the opeatoraction,we need two global variable which means some variable decalred outside the operatorsAction
    String operator="";
    double userinput1=0;
    boolean start=true;
    @FXML
    private void OperatorsAction(ActionEvent event) 
    {
        userinput1=Double.parseDouble(display.getText());//the number user will input will be on display...right?so  it will fetch that number and convert in it double
        //to carry calculations further as any numerical value cannot operate as string.parsedouble converts string to double data type
        //before tapping any operator,we want the number to vanish.the next steps are for that.
        //until we  apply settext,we wont be able to see the data on screen.so we havent used setetxt.all we want is that after inputing the numbe,the number will be fetched not showing it 
        //in the screen.
        operator=((Button)event.getSource()).getText();//event will pass the information the button user has pressed what is it really?it wil get stored in  empty space we have
        //declared outside the operatorsaction function.string opeator will store the data or event that + has been pressed.but we also want it wont be shown
        //in the screen.that's why we set the display as null screen.
        display.setText("");//the moment we will press +,there will conduct two operations.+ will get stored simultaneously having a blank screen for null string.
        
    }

    @FXML
    private void NumberButtonAction(ActionEvent event) 
    {
        if(start==true)//we want to clear the full screen.at initial the screen remains blank.aas we give number start=false means the screen is not blank.
            //after calculating the result we want blank screen again for which we have declared start=true at result button action.the moment we will call start=true,
        {
            display.setText("");//it will provide a blank screen as we have not alloted any string in the settext method.
            start=false;
        }
     //how will computer understand we are pressing number9 or 7 or any numerical value.for this we use event object of actionevent which will tell us button 9 has been pressed by 
      //the user.in short event will literally handle the text written upon the button.
        String oldtext=display.getText();
        String newtext=((Button)event.getSource()).getText();//here get source will sustain the information in which button the action has been carried out.then from that source info
        //we can access it's text on button through getText method.one thing is that we have do do something to hold the previous value otherwise the data will be lost.
        //as they are string type we will hold the previous info in the string named oldtext and then will concat it with new text.follow number 51 line.
        //now we will concat the two strings to show all the numbers we have given input till now.
        String number=oldtext+newtext;//for each tap of button the action from 51 to 57 will hold.
        display.setText(number);
       
    }
String percentage="";
    @FXML
    private void PercentageButtonAction(ActionEvent event)
    {
     double result=Double.parseDouble(display.getText());// it will fetch whatever data is in the display.sometimes we need to percentage a single number or oldtext somtimes we have to 
     //percentage our multiplication,sum numbers into percentage.but those needs new variable to declear as we have directly shown our sum in this way(userinput1Z+userinput2).so
     //to avoid taking new variable we took directly the data shown in the display.display shows string type data.we have to convert it into double through parsedouble.
     percentage=((Button)event.getSource()).getText();//we are being informed by event that percentage button has been tapped.and it will be stored in empty space of "".but wont be
     //displayed in the screen as we have done get text not settext
     display.setText(""+(result/100.00));//the final result we are showing in the display by settext.
    start=true;
     }

    @FXML
    private void DotButtonAction(ActionEvent event)
    {
        String oldtext=display.getText();//we first need the oldtext means single number.cause our number is oldtext+newtext.this is how they are shown in the screen.
        if(oldtext.contains("."))
            return;//if there is seen multiple .,it will not keep the dot rather return it
        display.setText(oldtext+".");//all operators are string thats why we have used the . inside the ""
    }

    @FXML
    private void AllClearAction(ActionEvent event)
    {
    display.setText("");
    }

    @FXML
    private void ResultButtonAction(ActionEvent event) 
    {
        //we took one number in the operatorsaction.the second number will be in the result button section as after inputing the second number we will press= which was given actionname
        //resultbuttonaction and it will carry all the oopeartions needed to give the output.
        double userinput2=Double.parseDouble(display.getText());//we received the second number from display by get text
        //now we will write opeartions for +,-,*,/ individually.
        if(operator.equals("+"))
        {
            display.setText(""+(userinput1+userinput2));//as display only show numbers as string.,we have convert the double result to string by ""(empty string)
        }
        if(operator.equals("-"))
        {
            display.setText(""+(userinput1-userinput2));//as display only show numbers as string.,we have convert the double result to string by ""(empty string)
        }
        if(operator.equals("X"))
        {
            display.setText(""+(userinput1*userinput2));//as display only show numbers as string.,we have convert the double result to string by ""(empty string)
        }
        if(operator.equals("/"))
        {
            if(userinput2==0)//we might have question why didnt we write userinput2.equals cause equals indicate stringg but 0 is number.so while using number,we will ==sign 
                display.setText("undefined");
            display.setText(""+(userinput1/userinput2));//as display only show numbers as string.,we have convert the double result to string by ""(empty string)
          
        }
          if(operator.equals("x^y"))
            {
                double result=1;
                for(int i=0;i<userinput2;i++)
                {
                    result=userinput1*result;
                    display.setText(""+result);
                }
            }
         
        start=true;//as it is declaring true it will go back to numberbuttonaction.
    }

    @FXML
    private void sinbuttonaction(ActionEvent event)
    {
        double userinput2=Math.sin(Double.parseDouble(display.getText()));
       
        display.setText(""+userinput2);
        start=true;
    }

    @FXML
    private void cosbuttonaction(ActionEvent event) 
    {
        double userinput2=Math.cos(Double.parseDouble(display.getText()));
      
        display.setText(""+userinput2);
        start=true;
    }

    @FXML
    private void tanbuttonaction(ActionEvent event)
    {
        double userinput2=Math.tan(Double.parseDouble(display.getText()));
        
        display.setText(""+userinput2);
        start=true;
    }

    @FXML
    private void logbuttonaction(ActionEvent event)
    {
        double userinput2=Math.log(Double.parseDouble(display.getText()));
        display.setText(""+userinput2);
        start=true;
    }

    @FXML
    private void exponentialbuttonaction(ActionEvent event) 
    {
        double userinput2=Math.exp(Double.parseDouble(display.getText()));
        display.setText(""+userinput2);
        start=true;
    }

    @FXML
    private void squarebuttonaction(ActionEvent event)
    {
       double userinput2=Double.parseDouble(display.getText());  
       display.setText(""+userinput2*userinput2);
       start=true;
    }

    @FXML
    private void cubebuttonaction(ActionEvent event)
    {
         double userinput2=Double.parseDouble(display.getText());
         display.setText(""+userinput2*userinput2*userinput2);
       start=true;
    }

   

    @FXML
    private void cuberootbuttonaction(ActionEvent event)
    {
        double userinput2=Math.cbrt(Double.parseDouble(display.getText()));
        display.setText(""+userinput2);
        start=true;  
    }

    @FXML
    private void factorialbuttonaction(ActionEvent event)
    {
         double userinput2=Double.parseDouble(display.getText());
         double fact=1;
         while(userinput2!=0)
         {
             fact=fact*userinput2;
             userinput2=userinput2-1;
         }
         display.setText(""+fact);
         start=true;
    }

    @FXML
    private void inversesinebuttonaction(ActionEvent event) 
    {
         double userinput2=Math.asin(Double.parseDouble(display.getText()));
       double result=Math.toDegrees(userinput2);
        display.setText(""+result);
        start=true;
    }

    @FXML
    private void cosinehbuttonaction(ActionEvent event) 
    {
        double userinput2=Math.cosh(Double.parseDouble(display.getText()));
      display.setText(""+userinput2);
        start=true;
    }

    @FXML
    private void sinhbuttonaction(ActionEvent event)
    {
        double userinput2=Math.sinh(Double.parseDouble(display.getText()));
      
        display.setText(""+userinput2);
        start=true;
    }

    @FXML
    private void inversetanbuttonaction(ActionEvent event)
    {
          double userinput2=Math.atan(Double.parseDouble(display.getText()));
       double result=Math.toDegrees(userinput2);
        display.setText(""+result);
        start=true;
    }

    @FXML
    private void inversecosinebuttonaction(ActionEvent event)
    {
          double userinput2=Math.acos(Double.parseDouble(display.getText()));
       double result=Math.toDegrees(userinput2);
        display.setText(""+result);
        start=true;
    }

    @FXML
    private void tanhbuttonaction(ActionEvent event) 
    {
      double userinput2=Math.tanh(Double.parseDouble(display.getText()));
      display.setText(""+userinput2);
        start=true;  
    }

   
}

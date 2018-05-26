package test;

import java.awt.*;
import java.awt.event.*;
 
public class AWTCounter3ButtonsGetSource extends Frame {
   private TextField tfCount;
   private Button btnCountUp, btnCountDown, btnReset;
   private int count = 0;
 
   // Constructor to setup the GUI components and event handlers
   public AWTCounter3ButtonsGetSource () {
      setLayout(new FlowLayout());
      add(new Label("Counter"));
      tfCount = new TextField("0", 10);
      tfCount.setEditable(false);
      add(tfCount);
 
      // Construct Buttons
      btnCountUp = new Button("Count Up");
      add(btnCountUp);
      btnCountDown = new Button("Count Down");
      add(btnCountDown);
      btnReset = new Button("Reset");
      add(btnReset);
 
      // Allocate an instance of inner class BtnListener.
      BtnListener listener = new BtnListener();
      // Use the same listener instance to all the 3 Buttons.
      btnCountUp.addActionListener(listener);
      btnCountDown.addActionListener(listener);
      btnReset.addActionListener(listener);
 
      setTitle("AWT Counter");
      setSize(400, 100);
      setVisible(true);
   }
 
   // The entry main method
   public static void main(String[] args) {
      new AWTCounter3ButtonsGetSource();  // Let the constructor do the job
   }
 
   /**
    * BtnListener is a named inner class used as ActionEvent listener for all the Buttons.
    */
   private class BtnListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent evt) {
         // Need to determine which button has fired the event.
         Button source = (Button)evt.getSource();
               // Get a reference of the source that has fired the event.
               // getSource() returns a java.lang.Object. Downcast back to Button.
         if (source == btnCountUp) {
            ++count;
         } else if (source == btnCountDown) {
            --count;
         } else {
            count = 0;
         }
         tfCount.setText(count + "");
      }
   }
}
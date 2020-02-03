package s4.B193312; // Please modify to s4.Bnnnnnn, where nnnnnn is your student ID. 
import java.lang.*;
import s4.specification.*;

/*
interface FrequencerInterface {     // This interface provides the design for frequency counter.
    void setTarget(byte[]  target); // set the data to search.
    void setSpace(byte[]  space);  // set the data to be searched target from.
    int frequency(); //It return -1, when TARGET is not set or TARGET's length is zero
                    //Otherwise, it return 0, when SPACE is not set or Space's length is zero
                    //Otherwise, get the frequency of TAGET in SPACE
    int subByteFrequency(int start, int end);
    // get the frequency of subByte of taget, i.e target[start], taget[start+1], ... , target[end-1].
    // For the incorrect value of START or END, the behavior is undefined.
}
*/

/*
package s4.specification;
public interface InformationEstimatorInterface{
    void setTarget(byte target[]); // set the data for computing the information quantities
    void setSpace(byte space[]); // set data for sample space to computer probability
    double estimation(); // It returns 0.0 when the target is not set or Target's length is zero;
// It returns Double.MAX_VALUE, when the true value is infinite, or space is not set.
// The behavior is undefined, if the true value is finete but larger than Double.MAX_VALUE.
// Note that this happens only when the space is unreasonably large. We will encounter other problem anyway.
// Otherwise, estimation of information quantity, 
}                        
*/

/**** my TestCase ****/
/*
public class TestCase {
  public static void main(String[] args) {
    System.out.println("checking s4.B193312.Frequencer");

    try {
      FrequencerInterface myObject;
      int freq;
      myObject = new s4.B193312.Frequencer();
      myObject.setSpace("Hi Ho Hi Ho".getBytes());
      myObject.setTarget("H".getBytes());
      freq = myObject.frequency();
      System.out.print("\"H\" in \"Hi Ho Hi Ho\" appears " + freq + " times. ");
      if (4 == freq) {
        System.out.println("OK");
      } else {
        System.out.println("WRONG");
      }
    } catch (Exception e) {
      System.out.println("Exception occurred: STOP");
    }

    // add following testcase

    try {
      FrequencerInterface test1 = new s4.B193312.Frequencer();
      test1.setSpace("Hi Ho Hi Ho".getBytes());
      System.out.println("\nif target is not set...");
      // exception occured in the following statements!! (target is not set)
      int freq = test1.frequency();  
      System.out.print("freq = " + freq);
      if (freq == -1) System.out.println(" ...OK");
      else System.out.println(" ...WRONG");
    } catch (Exception e) {
      System.out.println("Exception occurred: STOP");
    }

    try {
      FrequencerInterface test2 = new s4.B193312.Frequencer();
      test2.setSpace("Hi Ho Hi Ho".getBytes());
      test2.setTarget("".getBytes());
      System.out.println("\nif length of target is zero...");
      int freq = test2.frequency();
      System.out.print("freq = " + freq); // freq == 11?
      if (freq == -1) System.out.println(" ...OK");
      else System.out.println(" ...WRONG");
    } catch (Exception e) {
      System.out.println("Exception occurred: STOP");
    }

    try {
      FrequencerInterface test3 = new s4.B193312.Frequencer();
      test3.setTarget("H".getBytes());
      System.out.println("\nif space is not set...");
      int freq = test3.frequency();
      System.out.print("freq = " + freq);
      if (freq == 0) System.out.println(" ...OK");
      else System.out.println(" ...WRONG");
    } catch (Exception e) {
      System.out.println("Exception occurred: STOP");
    }
    
    try {
      FrequencerInterface test4 = new s4.B193312.Frequencer();
      test4.setTarget("H".getBytes());
      test4.setSpace("".getBytes());
      System.out.println("\nif length of space is zero...");
      int freq = test4.frequency();
      System.out.print("freq = " + freq); // OK
      if (freq == 0) System.out.println(" ...OK"); 
      else System.out.println(" ...WRONG");
    } catch (Exception e) {
      System.out.println("Exception occurred: STOP");
    }

    System.out.print("\n\n");

    try {
      InformationEstimatorInterface myObject;
      double value;
      System.out.println("checking s4.B193312.InformationEstimator");
      myObject = new s4.B193312.InformationEstimator();
      myObject.setSpace("3210321001230123".getBytes());
      myObject.setTarget("0".getBytes());
      value = myObject.estimation();
      System.out.println(">0 " + value);
      myObject.setTarget("01".getBytes());
      value = myObject.estimation();
      System.out.println(">01 " + value);
      myObject.setTarget("0123".getBytes());
      value = myObject.estimation();
      System.out.println(">0123 " + value);
      myObject.setTarget("00".getBytes());
      value = myObject.estimation();
      System.out.println(">00 " + value);
    } catch (Exception e) {
      System.out.println("Exception occurred: STOP");
    }
     
    // add following testcase 
    
    try {
      InformationEstimatorInterface test1 = new s4.B193312.InformationEstimator();
      test1.setSpace("3210321001230123".getBytes());
      System.out.println("\nif target is not set...");
      double value = test1.estimation();
      System.out.print("value = " + value);
      if (value == 0.0) System.out.println(" ...OK");
      else System.out.println(" ...WRONG");
    } catch (Exception e) {
      System.out.println("Exception occurred: STOP");
    }

    try {
      InformationEstimatorInterface test2 = new s4.B193312.InformationEstimator();
      test2.setSpace("3210321001230123".getBytes());
      test2.setTarget("".getBytes());
      System.out.println("\nif length of target is zero...");
      double value = test2.estimation();
      System.out.print("value = " + value); // not 0
      if (value == 0.0) System.out.println(" ...OK");
      else System.out.println(" ...WRONG");
    } catch (Exception e) {
      System.out.println("Exception occurred: STOP");
    }

    try {
      InformationEstimatorInterface test3 = new s4.B193312.InformationEstimator();
      test3.setTarget("01".getBytes());
      System.out.println("\nif space is not set...");
      double value = test3.estimation();
      System.out.print("value = " + value);
      if (value == Double.MAX_VALUE) System.out.println(" ...OK");
      else System.out.println(" ...WRONG");
    } catch (Exception e) {
      System.out.println("Exception occurred: STOP");
    }

    try {
      InformationEstimatorInterface test4 = new s4.B193312.InformationEstimator();
      test4.setTarget("01".getBytes());
      test4.setSpace("".getBytes());
      System.out.println("\nif length of space is zero...");
      double value = test4.estimation();
      System.out.print("value = " + value);
      if (value == Double.MAX_VALUE) System.out.println(" ...OK");
      else System.out.println(" ...WRONG");
    } catch (Exception e) {
      System.out.println("Exception occurred: STOP");
    }

    System.out.println("all tests are done!");
  }
}
*/

public class TestCase {
  public static void main(String[] args) {
int c;
c = 0;
try {
    FrequencerInterface  myObject;
    int freq;
      c = 0;
    System.out.println("checking Frequencer");
    myObject = new Frequencer();
    freq = myObject.frequency();
    if(-1 != freq) { System.out.println("frequency() should return -1, when target is not set, but returns "+freq); c++; }
    myObject = new Frequencer();
    myObject.setTarget("".getBytes());
    freq = myObject.frequency();
    if(-1 != freq) { System.out.println("frequency() should return -1, when target is empty, but return "+freq); c++; }
    myObject = new Frequencer();
    myObject.setSpace("AAA".getBytes());
    if(-1 != freq) { System.out.println("frequency() for AAA should return -1, when target is  not set. But it returns  "+freq); c++; }	
    myObject = new Frequencer();
    myObject.setSpace("AAA".getBytes());
    myObject.setTarget("".getBytes());
    freq = myObject.frequency();
    if(-1 != freq) { System.out.println("frequency() for AAA should return -1, when taget empty string. But it returns "+freq); c++; }
    myObject = new Frequencer();
    myObject.setTarget("A".getBytes());
    freq = myObject.frequency();	   
     if(0 != freq) { System.out.println("frequency() for not set, should return 0, when taget is not empty. But it returns "+freq); c++; }
    myObject = new Frequencer();
    myObject.setSpace("".getBytes());
    myObject.setTarget("A".getBytes());
    freq = myObject.frequency();	   
     if(0 != freq) { System.out.println("frequency() for empty space, should return 0, when taget is not empty. But it returns "+freq); c++; }
    myObject = new Frequencer();
    myObject.setSpace("AAA".getBytes());
    myObject.setTarget("A".getBytes());
    freq = myObject.frequency();
    if(3 != freq) { System.out.println("frequency() for AAA, should return 3, when taget is A. But it returns "+freq); c++; }
    myObject = new Frequencer();
    myObject.setSpace("AAA".getBytes());
    myObject.setTarget("AA".getBytes());
    freq = myObject.frequency();
    if(2 != freq) { System.out.println("frequency() for AAA, should return 2, when taget is AA. But it returns "+freq); c++; }
    myObject = new Frequencer();
    myObject.setSpace("AAA".getBytes());
    myObject.setTarget("AAA".getBytes());
    freq = myObject.frequency();
    if(1 != freq) { System.out.println("frequency() for AAA, should return 1, when taget is AAA. But it returns "+freq); c++; }
    myObject = new Frequencer();
    myObject.setSpace("AAA".getBytes());
    myObject.setTarget("AAAA".getBytes());
    freq = myObject.frequency();
    if(0 != freq) { System.out.println("frequency() for AAA, should return 0, when taget is AAAA. But it returns "+freq); c++; }
    myObject = new Frequencer();
    myObject.setSpace("Hi Ho Hi Ho".getBytes());
    myObject.setTarget("H".getBytes());
    freq = myObject.frequency();
    if(4 != freq) {System.out.println("frequency() for Hi_Ho_Hi_Ho, should return 4, when taget is H. But it returns "+freq); c++; }
    myObject = new Frequencer();
    myObject.setSpace("Hi Ho Hi Ho".getBytes());
    myObject.setTarget("Ho".getBytes());
    freq = myObject.frequency();
    if(2 != freq) {System.out.println("frequency() for Hi_Ho_Hi_Ho, should return 2, when taget is Ho. But it returns "+freq); c++; }
    /* please note subByteFreqency(0,0) is considered illeagal specification, and you should not include this case */
    myObject = new Frequencer();
    myObject.setSpace("AAAB".getBytes());
    myObject.setTarget("AAAAB".getBytes());
    freq = myObject.subByteFrequency(0,1);
    if(3 != freq) { System.out.println("SubBytefrequency() for AAAB, should return 3, when taget is AAAAB[0:1]. But it returns "+freq); c++; }
    myObject = new Frequencer();
    myObject.setSpace("AAAB".getBytes());
    myObject.setTarget("AAAAB".getBytes());
    freq = myObject.subByteFrequency(1,2);
    if(3 != freq) { System.out.println("SubBytefrequency() for AAAB, should return 3, when taget is AAAAB[1:2]. But it returns "+freq); c++; }
    if(2 == freq) { System.out.println("You might be confused by the intentional error in sample code.");   }
    myObject = new Frequencer();
    myObject.setSpace("AAAB".getBytes());
    myObject.setTarget("AAAAB".getBytes());
    freq = myObject.subByteFrequency(1,3);
    if(2 != freq) { System.out.println("SubBytefrequency() for AAAB, should return 2, when taget is AAAAB[1:3]. But it returns "+freq); c++; }
    myObject = new Frequencer();
    myObject.setSpace("AAAB".getBytes());
    myObject.setTarget("AAAAB".getBytes());
    freq = myObject.subByteFrequency(4,5);
    if(1 != freq) { 
  System.out.println("SubBytefrequency() for AAAB, should return 1, when taget is AAAAB[4:5]. But it returns "+freq); c++;  
    }
}
catch(Exception e) {
    System.out.println("Exception occurred in Frequencer Object: STOP");
    e.printStackTrace();
    c++;
}

try {
    InformationEstimatorInterface myObject;
    double value;
    System.out.println("checking s4.slow.InformationEstimator");
    myObject = new InformationEstimator();
    myObject.setSpace("3210321001230123".getBytes());
    myObject.setTarget("0".getBytes());
    value = myObject.estimation();
    if((value < 1.9999) || (2.0001 <value)) { System.out.println("IQ for 0 in 3210321001230123 should be 2.0. But it returns "+value); c++; }
    myObject.setTarget("01".getBytes());
    value = myObject.estimation();
    if((value < 2.9999) || (3.0001 <value)) { System.out.println("IQ for 01 in 3210321001230123 should be 3.0. But it returns "+value); c++; }
    myObject.setTarget("0123".getBytes());
    value = myObject.estimation();
    if((value < 2.9999) || (3.0001 <value)) { System.out.println("IQ for 0123 in 3210321001230123 should be 3.0. But it returns "+value); c++; }
    myObject.setTarget("00".getBytes());
    value = myObject.estimation();
    if((value < 3.9999) || (4.0001 <value)) { System.out.println("IQ for 00 in 3210321001230123 should be 4.0. But it returns "+value); c++; }
}
catch(Exception e) {
    System.out.println("Exception occurred: STOP");
    c++;
}
if(c == 0) { System.out.println("TestCase OK"); }
  }
}	    
    

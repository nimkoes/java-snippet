package com.tistory.xxxelppa.section_001;

public class BoxingUnboxing {
    public static void main(String[] args) {
        Integer myWrapperNumber = new Integer(21);    // Boxing
        int myPrimitiveNumber = myWrapperNumber.intValue();  // Unboxing
        
        Integer myAutoBoxingNumber = 21;                // AutoBoxing
        int myAutoUnBoxingNumber = myAutoBoxingNumber;  // AutoUnBoxing
    }
}

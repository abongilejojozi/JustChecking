package vm;

public class ByteCode { // A class directly inside a package cannot be static... only inner classes can be static.  

    //These bytecodes have to be public, static and final because they have to be accessible everywhere and final because they cannot change. 

    public static final int IADD = 1 ; 
    public static final int ISUB = 2 ; 
    public static final int IMUL = 3 ; 
    public static final int ILT = 4 ; 
    public static final int IEQ = 5 ; 
    public static final int BR = 6 ; 
    public static final int BRT = 7 ; 
    public static final int BRF = 8 ; 
    public static final int ICONST = 9 ; 
    public static final int LOAD = 10 ; 
    public static final int GLOAD = 11 ; 
    public static final int STORE = 12 ; 
    public static final int GSTORE = 13 ; 
    public static final int PRINT = 14 ; 
    public static final int POP = 15 ; 
    public static final int HALT = 16;


    

    
}
 
package vm ; 

import static vm.ByteCode.*; //Make the files static so I can use them in my static methods. 


public class Test {

    //Static means its object independent. 
    static int[] hello = { 
        ICONST, 23 , 
        ICONST, 43 , 
        IADD , 
        PRINT , 
        HALT   
    } ; //So the program is an array of instructions telling the CPU what to do. 

    public static void main(String[] args){

        VM vm = new VM(hello, 0, 0) ; 
        vm.trace = true ; 
        vm.cpu() ; 
    }
}
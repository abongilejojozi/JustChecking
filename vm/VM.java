package vm;

import static vm.ByteCode.* ; //Okay this make sense because those Bytecodes are static fields... and I want to use them in a non-static field.
import java.util.Arrays ; 

public class VM {

    int[] data ; //Data memory 
    int[] code ; //Code memory 
    int[] stack ; //This will be my stack. 

    int ip ; //instruction pointer or instruction register. 
    int sp = -1; 
    int fp ; 

    boolean trace = false ; 

    public VM(int[] code, int ip, int datasize){ //The constructor of the virtual machine will take the code it will needs to run, and a pointer to where it needs to start the execution. 

        this.code = code ; 
        this.ip = ip ; 

        data = new int[datasize] ; 
        stack = new int[100] ; 
    }

    public int[] trace(int[] stack){

        int[] true_stack = new int[sp+1] ; 
        for(int i = 0 ; i < sp+1; i++){
            true_stack[i] = stack[i] ; 
        }
        return true_stack ; 
    }


    //Now I need a function to execute in the virtual machine so i simulate a cpu cycle. 
    /*
        iconst, 1 , 
        iconst, 2 ,
        iadd, 
        print 

     */
    public void cpu(){

        
        loop:

            while(ip < code.length){

                int opcode = code[ip] ; //fetch the instruction to execute 
                int trace_value = ip ;
                ip++ ; 

                 

                    switch(opcode){
                    
                    case ICONST:

                        //This will go from code memory to the the stack. 
                        int v = code[ip] ; //get the value to push
                        ip++; 

                        sp++; //increment stack
                        stack[sp] = v ; //and then push. 

                        if(trace){
                            String_Opcodes string_opcode = new String_Opcodes(opcode) ;
                            System.err.printf("%04d - %s - %d %s", trace_value, string_opcode.instruction(), v , Arrays.toString(trace(stack))) ; 
                            System.out.println() ; 
                        }

                        
                        
                        break ; 

                    case IADD: 
                        int b = stack[sp]; 
                        sp-- ; 

                        int a = stack[sp] ; 
                        sp-- ; 

                        int new_value = a + b ; 
                        sp++ ; //to make space in the stack
                        stack[sp] = new_value ; 

                        if(trace){
                            String_Opcodes string_opcode = new String_Opcodes(opcode) ;
                            System.err.printf("%04d - %s - %d %s", trace_value, string_opcode.instruction(), new_value , Arrays.toString(trace(stack))) ; 
                            System.out.println() ; 
                        }

                        break ; 

                        

                    case PRINT: 
                        
                        int print_value = stack[sp] ; 
                        sp-- ; 
                        

                        if(trace){
                            String_Opcodes string_opcode = new String_Opcodes(opcode) ;
                            System.err.printf("%04d - %s - %d %s", trace_value, string_opcode.instruction(), print_value , Arrays.toString(trace(stack))) ; 
                            System.out.println() ; 
                        }

                        System.out.println(print_value) ; 

                       
                        break; 
                    
                    case HALT:
                        
                        break loop ; 
                    }
            }

    }
    
}

package vm;


public class String_Opcodes {
    
    int index ; 

    String[] instructions =  {"", 
        "IADD",  
        "ISUB", 
        "IMUL", 
        "ILT", 
        "IEQ", 
        "BR", 
        "BRT", 
        "BRF",
        "ICONST", 
        "LOAD",
        "GLOAD" ,
        "STORE",
        "GSTORE", 
        "PRINT", 
        "POP",
        "HALT"
    }; //This is an array so i have to insert the semi colon.
    
    public String_Opcodes(int index){
            this.index = index ; 
           
    }

    public String instruction(){
        return this.instructions[index] ; 
    }

}

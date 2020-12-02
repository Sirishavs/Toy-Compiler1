import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;

public class Controller {
    public static void main(String args[])
    {

        char expr[]= new char[20]; //storing the input from command line
        char operators[] = new char[20]; //storing expression and operator
        char variables[] = new char[20]; // storing variable or identifier
        int constants[] = new int[20]; //storing literals
        int cnt,i,j,dg; //cnt to store string length
        int vc =0,lc=0,oc=0;



        System.out.println("\n LEXICAL ANALYZER FOR AN EXPRESSION \n\n");

        System.out.println("Enter the String\n");
        //to read input and save it to an array
        int numberOfLinesToRead = 1;
        try(Scanner sc = new Scanner(System.in)){
            StringBuilder buff = new StringBuilder();
            while(numberOfLinesToRead-- > 0){
                String line = sc.nextLine();
                String noSpaces = line.replaceAll("\\s", "");
                buff.append(noSpaces);
            }
            expr = buff.toString().toCharArray();
            System.out.println("Array "+Arrays.toString(expr));
        }catch (Exception e) {
            e.printStackTrace();
        }
        cnt = expr.length;
        System.out.println("String length " + cnt); //To display string length

        for (i = 0; i < cnt; i++) {

            if( isLetter(expr[i]) ) //Condition for current element to be a variable
            {
                    variables[vc]=expr[i];
                    vc++;
            }

            else if(expr[i] == '+' || expr[i] == '-' || expr[i] == '/' || expr[i] == '*' || expr[i] == '=' || expr[i] == '^') // Conditions to check for operators
                {
                    operators[oc] = expr[i];
                    oc++;
                }
            else if(isDigit(expr[i])) // current element to change to be digit
            {
                dg= (expr[i]-'0');
                i=i+1;

                if (isDigit(expr[i])) //Run loop until successive elements are digits
                {
                    dg = dg*10 + (expr[i]-'0');
                    i++;
                }
                i= i-1;
                constants[lc] = dg;
                lc++;
            }



        }


        System.out.printf("\nThe literals are: \n");
        for(j=0;j<lc;j++)
        {
            System.out.println(""+constants[j]);
        }

        System.out.println("\nThe operators are: \n");
        for(j=0;j<oc;j++)
        {
            System.out.println(""+operators[j]);
        }

        System.out.println("\nThe variables are: \n");
        for(j=0;j<vc;j++)
        {
                System.out.println("" +variables[j]);


        }
    }
}

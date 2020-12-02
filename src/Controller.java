import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;

public class Controller {
    public static void main(String args[])
    {

        char expr[]= new char[20];
        char operators[] = new char[100]; //storing expression and operator
        char variables[][] = new char[20][20]; // storing variable or identifier
        int constants[] = new int[100];
        int ascii[] = new int[100]; //for storing ascii, constants values of expression
        int cnt,i,number=0; //cnt to store string length
        int j=-1,k=-1,l=-1,n=0,m=0; //counters for filling arrays
        int pr[] = new int[10]; //counters for printing identifier arrays


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
            System.out.println(Arrays.toString(expr));
        }catch (Exception e) {
            e.printStackTrace();
        }


        cnt = expr.length;
        System.out.println("String length" + cnt); //To display string length

        for (i = 0; i < cnt; ++i) //to store ascii values in array ascii
        {
            ascii[i] = (int)expr[i];
            System.out.println("ASCII values "+(int)expr[i]);
        }



        for (i = 0; i < cnt; ++i) {

            if (isDigit(expr[i])) // current element to change to be digit
            {
                while (isDigit(expr[i])) //Run loop until successive elements are digits
                {
                    number = 10 * number + ascii[i] - '0';
                    i++;
                }
                j++;
                constants[j] = number;
                number = 0;
            }
            if( isLetter(expr[i]) ) //Condition for current element to be a variable
            {
                //  while( isLetter(expr[i]) || isDigit(expr[i]) || expr[i]=='_' ) //Run loop till next element is a letter or digit.
                while( isLetter(expr[i]))
                {
                    k++;
                    variables[m][k]=expr[i];
                    i++;
                }
                m++;
                pr[n]=k;
                n++;
                k=-1;
            }
            if(expr[i]=='+'||expr[i]=='-'||expr[i]=='/'|| expr[i]=='*'|| expr[i]=='='|| expr[i]=='^') // Conditions to check for operators
            {
                l++;
                operators[l]= expr[i];
            }

        }

//——————–To Print the Literals——————————-//
        System.out.printf("\nThe literals are: \n");
        for(i=0;i<=j;i++)
        {
            System.out.println(""+constants[i]);
        }

//——————–To print the Operators——————————-//
        System.out.println("\nThe operators are: \n");
        for(i=0;i<=l;i++)
        {
            System.out.println(""+operators[i]);
        }

//——————–To Print the Varibles——————————-//
        System.out.println("\nThe variables are: \n");
        for(i=0;i<m;i++)
        {
            //System.out.println("\n\tid%d\t"+ i+1);
            for(j=0;j<=pr[i];j++)
            {
                System.out.println("" +variables[i][j]);
            }

        }
    }
}

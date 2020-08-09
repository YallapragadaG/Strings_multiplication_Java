{\rtf1\ansi\ansicpg1252\cocoartf2512
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\paperw11900\paperh16840\margl1440\margr1440\vieww10800\viewh8400\viewkind0
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural\partightenfactor0

\f0\fs24 \cf0 import java.util.Arrays;  \
import java.util.StringJoiner;\
import java.util.Scanner;\
import java.util.regex.*; \
\
public class String_Multiplication\{\
    \
    public static String multiply_strings(String a,String b)\{ \
      //we are going to multiply two large strings \
      // Now we are going to use classic multiplication, we did in elemetry school\
      // Example 234\
     //         *123\
     //     702 - result of multiplying 234 with 3\
     //   468 - result of multiplying 234 with 2\
     // 234 - result of multiplying 234 with 1\
     // 28782 - the end result after adding the above numbers.\
     \
     // for every number in second string we are iterating over and multiplying with the first one\
      // we are converting string to characters in an array using toCharArray() java inbuilt method- it makes it easy to iterate over numbers in a string\
      \
      int prod_result;\
      char[] string_1 = a.toCharArray();\
      char[] string_2 = b.toCharArray();\
      int len_string1 = string_1.length;\
      int len_string2 = string_2.length;\
      int len_array = len_string1+len_string2;\
      char[] final_res;\
      final_res = new char[len_array];\
      Arrays.fill(final_res,'0');\
      \
      \
\
      // Lets write for loops\
      for( int y=len_string2-1; y >= 0 ; y--) // we are going right to left\
      \{\
          for(int x=len_string1-1; x >= 0; x--)\
          \{\
              //we iterated over the characters in an array, lets multiply weith every character of b to a\
              //in java the int data type is restruced to 32 bit, we dont have to specify or put any constraint to it.\
               \
                \
                // System.out.println((string_1[x]) *2);\
                \
                // System.out.println((string_1[x]-'0') * 2);\
                \
               // System.out.println(string_2[y]);\
                \
                \
                prod_result = ((string_1[x] -'0') * (string_2[y] -'0'));\
                \
                // we got the result as 20,15,10,5,16,12,8,4,12,9,6,3,8,6,4,2\
                // now we rea doing sum of multiplication result of i for each number in j and storing in a values\
                int storage_add = (final_res[x+y+1]-'0') + prod_result;\
                // System.out.println(storage_add);\
                final_res[x+y+1] = (char)(storage_add%10 +'0');\
                final_res[x+y] = (char)((final_res[x+y]-'0' + storage_add/10)+ '0');\
            \
                //System.out.println(Arrays.toString(final_res));// we have append the sum into thye arry in the each character of the array including the carry over the addition.\
\
              \
          \}\
      \}\
      \
    // Now we got the product of two strings in an array, lets convert that to string, since our requirement is to return the result as string .\
      String string_output = new String(final_res);\
      String Pattern = "^0+(?!$)";\
      String str_return = string_output.replaceAll(Pattern, "");\
      return str_return;\
     \
  \}\
  \
\
  \
    public static void main(String[] args) \{\
    Scanner sc = new Scanner(System.in);\
    System.out.println("Enter Two Numbers " + "(Press Enter after each):");\
    System.out.println("Enter First Number: ");\
    String num1 = sc.nextLine();\
    System.out.println("Enter Second Number: ");\
    String num2 = sc.nextLine();\
    sc.close(); \
    if(num1.length() == 0 && num2.length() == 0)\{\
        \
        System.out.printf("Please enter correct numbers");\
        \
    \}else\{\
          \
        if (num1.matches("[0-9]+") && num2.matches("[0-9]+"))\{\
        \
            String multiplication_output = String_Multiplication.multiply_strings(num1,num2);\
        \
          System.out.println(multiplication_output);\
        \}else\{\
            System.out.println("Please enter only digits"); \}\
       \
       \
    \}\
    \
\
    \}\
\}\
        }
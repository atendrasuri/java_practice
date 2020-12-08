package com.suri.companyWise.AHaloDoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 03/08/19
 * @Description: (Overwrite)
 * A string is said to be valid
 *
 * 1. it contains only integers
 * 2. if it contains characters and integers both then throw the AlphaNumericException(Custom).
 * 3. if it contains only characters then throw String Exception(Custom).
 */
public class ValidateString {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i=1;i<=T;i++){

            String str = br.readLine();
            Validator validator = new Validator(str);

            boolean result = validator.isValid();
            if (result){
                System.out.println("It's a valid");
            }
        }

    }
}

class Validator{

    String str;
    Validator(String str){
        this.str = str;
    }

    boolean isValid(){
        int n = str.length();
        int intCount = countInt(str);
        int charCount = countChar(str);

        if (intCount==n){
            return true;
        }
        else if(charCount==n){
            try {
                throw  new StringException("It's a String");
            } catch (StringException e) {
                e.printStackTrace();
            }
        }
        else if(intCount+charCount ==n){
            try {
                throw new AlphaNumericException("Its an AlphaNumeric");
            } catch (AlphaNumericException e) {
                e.printStackTrace();
            }
        }
        else
            return false;
        return false;
    }

    public int countInt(String str){

        int count =0;
        int n = str.length();

        for(int i=0;i<n;i++){
            if(str.charAt(i)>=48 && str.charAt(i)<=57){
                count++;
            }
        }
        return count;
    }

    public int countChar(String str){

        int count =0;
        int n = str.length();

        for(int i=0;i<n;i++){
            if((str.charAt(i)>=65 && str.charAt(i)<=91)||(str.charAt(i)>=97 && str.charAt(i)<=123)){
                count++;
            }
        }
        return count;
    }


}


class AlphaNumericException extends Exception{

    AlphaNumericException(String msg){
        super(msg);
    }
}

class StringException extends Exception{
    StringException(String msg){
        super(msg);
    }

}
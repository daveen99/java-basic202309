package day07.exception;

import jdk.jshell.execution.Util;
import util.Utility;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        LoginUser user = new LoginUser("abc123", "1234");

        String id = Utility.input("ID: ");
        String pw = Utility.input("PW: ");


        try {
            String result = user.validate(id, pw);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
//        catch (NullPointerException e) {
//
//        }

        
    }
}

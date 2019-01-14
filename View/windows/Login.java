/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.windows;

/**
 *
 * @author pacomebondetdelabernardie
 */
public class Login {
 
    public static boolean authenticate(String username, String password) {
        // hardcoded username and password
        if (username.equals("root") && password.equals("root")) {
            return true;
        }
        return false;
    }
}

import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;
import java.net.*;
import java.applet.*;
import java.security.*;



class c3732741 {

    private String digest(String message) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(message.getBytes());
            BigInteger hash = new BigInteger(1, md.digest());
            String hpassword = hash.toString(16);
            return hpassword;
        } catch (Exception e) {
        }
        return null;
    }

}
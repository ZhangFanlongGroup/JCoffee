


class c1919602 {

    public static String encode(String plaintext) {
        try {
            MyHelperClass MessageDigest = new MyHelperClass();
            MessageDigest md =(MessageDigest)(Object) MessageDigest.getInstance("SHA");
            md.update(plaintext.getBytes("UTF-8"));
            byte raw[] =(byte[])(Object) md.digest();
            String hash =(String)(Object) (new BASE64Encoder()).encode(raw);
            return hash;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Could not encrypt password for ISA db verification");
        }
    }

}

// Code below this line has been added to remove errors
class MyHelperClass {

public MyHelperClass getInstance(String o0){ return null; }}

class MessageDigest {

public MyHelperClass digest(){ return null; }
	public MyHelperClass update(byte[] o0){ return null; }}

class BASE64Encoder {

public MyHelperClass encode(byte[] o0){ return null; }}

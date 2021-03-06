import java.io.*;
import java.lang.*;
import java.util.*;
import java.net.*;
import java.applet.*;
import java.security.*;import java.awt.*;



class c12428013 {
public static MyHelperClass NULL;
//public MyHelperClass NULL;
public static MyHelperClass FTPUtils;
	public static MyHelperClass PrefPageOne;
//public MyHelperClass FTPUtils;
//	public MyHelperClass PrefPageOne;

    public static void polishOff(IProgressMonitor monitor, String from, String to, String renameTo) {
        if (monitor != null && (boolean)(Object)monitor.isCanceled()) {
            return;
        }
        try {
            FTPClient ftpClient =(FTPClient)(Object) NULL; //new FTPClient();
            ftpClient = new FTPClient();
            MyHelperClass CONSTANTS = new MyHelperClass();
            ftpClient.setRemoteAddr(InetAddress.getByName((String)(Object)PrefPageOne.getValue(CONSTANTS.PREF_HOST)));
//            MyHelperClass CONSTANTS = new MyHelperClass();
            ftpClient.setControlPort(PrefPageOne.getIntValue(CONSTANTS.PREF_FTPPORT));
//            MyHelperClass ftpClient = new MyHelperClass();
            ftpClient.connect();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            MyHelperClass CONSTANTS = new MyHelperClass();
            ftpClient.login((PrefPageOne.getValue(CONSTANTS.PREF_USERNAME)), FTPUtils.decrypt(PrefPageOne.getValue(CONSTANTS.PREF_PASSWORD)));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (from != null) {
                FTPHolder ftpHolder = new FTPHolder(from, to, renameTo, false);
                MyHelperClass synchedSet = new MyHelperClass();
                synchedSet.add(ftpHolder);
            }
            MyHelperClass JobHandler = new MyHelperClass();
            JobHandler.aquireFTPLock();
            MyHelperClass synchedSet = new MyHelperClass();
            for (Iterator iter =(Iterator)(Object) synchedSet.iterator(); iter.hasNext(); ) {
                if (monitor != null && (boolean)(Object)monitor.isCanceled()) {
//                    MyHelperClass JobHandler = new MyHelperClass();
                    JobHandler.releaseFTPLock();
//                    MyHelperClass ftpClient = new MyHelperClass();
                    ftpClient.quit();
                    return;
                }
                Thread.yield();
                FTPHolder element = (FTPHolder) iter.next();
                MyHelperClass FTPTransferType = new MyHelperClass();
                ftpClient.setType(FTPTransferType.ASCII);
//                MyHelperClass ftpClient = new MyHelperClass();
                ftpClient.put(element.from, element.to);
                if (element.renameTo != null) {
                    try {
//                        MyHelperClass ftpClient = new MyHelperClass();
                        ftpClient.delete(element.renameTo);
                    } catch (Exception e) {
                    }
//                    MyHelperClass ftpClient = new MyHelperClass();
                    ftpClient.rename(element.to, element.renameTo);
                    MyHelperClass log = new MyHelperClass();
                    log.info("RENAME: " + element.to + "To: " + element.renameTo);
                }
            }
//            MyHelperClass JobHandler = new MyHelperClass();
            JobHandler.releaseFTPLock();
//            MyHelperClass ftpClient = new MyHelperClass();
            ftpClient.quit();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (UncheckedIOException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        MyHelperClass synchedSet = new MyHelperClass();
        synchedSet.clear();
    }

}

// Code below this line has been added to remove errors
class MyHelperClass {
public MyHelperClass PREF_USERNAME;
	public MyHelperClass PREF_FTPPORT;
	public MyHelperClass ASCII;
	public MyHelperClass PREF_PASSWORD;
	public MyHelperClass PREF_HOST;
public MyHelperClass info(String o0){ return null; }
	public MyHelperClass iterator(){ return null; }
	public MyHelperClass aquireFTPLock(){ return null; }
	public MyHelperClass put(MyHelperClass o0, MyHelperClass o1){ return null; }
	public MyHelperClass clear(){ return null; }
	public MyHelperClass delete(MyHelperClass o0){ return null; }
	public MyHelperClass add(FTPHolder o0){ return null; }
	public MyHelperClass decrypt(MyHelperClass o0){ return null; }
	public MyHelperClass releaseFTPLock(){ return null; }
	public MyHelperClass getValue(MyHelperClass o0){ return null; }
	public MyHelperClass connect(){ return null; }
	public MyHelperClass setType(MyHelperClass o0){ return null; }
	public MyHelperClass getIntValue(MyHelperClass o0){ return null; }
	public MyHelperClass quit(){ return null; }
	public MyHelperClass rename(MyHelperClass o0, MyHelperClass o1){ return null; }}

class IProgressMonitor {

public MyHelperClass isCanceled(){ return null; }}

class FTPHolder {
public MyHelperClass renameTo;
	public MyHelperClass from;
	public MyHelperClass to;
FTPHolder(String o0, String o1, String o2, boolean o3){}
	FTPHolder(){}}

class FTPException extends Exception{
	public FTPException(String errorMessage) { super(errorMessage); }
}

class FTPClient {

public MyHelperClass put(MyHelperClass o0, MyHelperClass o1){ return null; }
	public MyHelperClass connect(){ return null; }
	public MyHelperClass setControlPort(MyHelperClass o0){ return null; }
	public MyHelperClass delete(MyHelperClass o0){ return null; }
	public MyHelperClass setType(MyHelperClass o0){ return null; }
	public MyHelperClass login(MyHelperClass o0, MyHelperClass o1){ return null; }
	public MyHelperClass quit(){ return null; }
	public MyHelperClass setRemoteAddr(InetAddress o0){ return null; }
	public MyHelperClass rename(MyHelperClass o0, MyHelperClass o1){ return null; }}

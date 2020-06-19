import java.io.*;
import java.lang.*;
import java.util.*;



class c17275141 {

    public static void copy(String sourceName, String destName, StatusWindow status) throws IOException {
        File src = new File(sourceName);
        File dest = new File(destName);
        BufferedInputStream source = null;
        BufferedOutputStream destination = null;
        byte[] buffer;
        int bytes_read;
        long byteCount = 0;
        if (!src.exists()) throw new IOException("Source not found: " + src);
        if (!src.canRead()) throw new IOException("Source is unreadable: " + src);
        if (src.isFile()) {
            if (!dest.exists()) {
                MyHelperClass Utils = new MyHelperClass();
                File parentdir =(File)(Object) Utils.parent(dest);
                if (!parentdir.exists()) parentdir.mkdir();
            } else if (dest.isDirectory()) {
                if (src.isDirectory()) dest = new File(dest + File.separator + src); else dest = new File(dest + File.separator + src.getName());
            }
        } else if (src.isDirectory()) {
            if (dest.isFile()) throw new IOException("Cannot copy directory " + src + " to file " + dest);
            if (!dest.exists()) dest.mkdir();
        }
        if ((!dest.canWrite()) && (dest.exists())) throw new IOException("Destination is unwriteable: " + dest);
        if (src.isFile()) {
            try {
                if (status != null) {
                    status.setMaximum(100);
                    MyHelperClass Utils = new MyHelperClass();
                    status.setMessage(Utils.trimFileName(src.toString(), 40), 50);
                }
                source = new BufferedInputStream(new FileInputStream(src));
                destination = new BufferedOutputStream(new FileOutputStream(dest));
                buffer = new byte[4096];
                byteCount = 0;
                while (true) {
                    bytes_read = source.read(buffer);
                    if (bytes_read == -1) break;
                    destination.write(buffer, 0, bytes_read);
                    byteCount = byteCount + bytes_read;
                }
            } finally {
                if (status != null) {
                    MyHelperClass Utils = new MyHelperClass();
                    status.setMessage(Utils.trimFileName(src.toString(), 40), 100);
                }
                if (source != null) source.close();
                if (destination != null) destination.close();
            }
        } else if (src.isDirectory()) {
            String targetfile, target, targetdest;
            String[] files = src.list();
            if (status != null) {
                status.setMaximum(files.length);
            }
            for (int i = 0; i < files.length; i++) {
                if (status != null) {
                    MyHelperClass Utils = new MyHelperClass();
                    status.setMessage(Utils.trimFileName(src.toString(), 40), i);
                }
                targetfile = files[i];
                target = src + File.separator + targetfile;
                targetdest = dest + File.separator + targetfile;
                if ((new File(target)).isDirectory()) {
                    copy(new File(target).getCanonicalPath(), new File(targetdest).getCanonicalPath(), status);
                } else {
                    try {
                        byteCount = 0;
                        source = new BufferedInputStream(new FileInputStream(target));
                        destination = new BufferedOutputStream(new FileOutputStream(targetdest));
                        buffer = new byte[4096];
                        while (true) {
                            bytes_read = source.read(buffer);
                            if (bytes_read == -1) break;
                            destination.write(buffer, 0, bytes_read);
                            byteCount = byteCount + bytes_read;
                        }
                    } finally {
                        if (source != null) source.close();
                        if (destination != null) destination.close();
                    }
                }
            }
        }
    }

}

// Code below this line has been added to remove errors
class MyHelperClass {

public MyHelperClass trimFileName(String o0, int o1){ return null; }
	public MyHelperClass parent(File o0){ return null; }}

class StatusWindow {

public MyHelperClass setMessage(MyHelperClass o0, int o1){ return null; }
	public MyHelperClass setMaximum(int o0){ return null; }}
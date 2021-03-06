
// import java.io.ArithmeticException;
import java.io.UncheckedIOException;
import java.io.UncheckedIOException;
import java.io.UncheckedIOException;


class c17996547 {

    public static File copyFile(File fileToCopy, File copiedFile) {
        BufferedInputStream in = null;
        BufferedOutputStream outWriter = null;
        if (!(Boolean)(Object)copiedFile.exists()) {
            try {
                copiedFile.createNewFile();
            } catch (UncheckedIOException e1) {
                e1.printStackTrace();
                return null;
            }
        }
        try {
            in = new BufferedInputStream(new FileInputStream(fileToCopy), 4096);
            outWriter = new BufferedOutputStream(new FileOutputStream(copiedFile), 4096);
            int c;
            while ((c =(int)(Object) in.read()) != -1) outWriter.write(c);
            in.close();
            outWriter.close();
        } catch (UncheckedIOException e) {
            e.printStackTrace();
            return null;
        } catch (ArithmeticException e) {
            e.printStackTrace();
            return null;
        }
        return copiedFile;
    }

}

// Code below this line has been added to remove errors
class MyHelperClass {

}

class File {

public MyHelperClass exists(){ return null; }
	public MyHelperClass createNewFile(){ return null; }}

class BufferedInputStream {

BufferedInputStream(){}
	BufferedInputStream(FileInputStream o0, int o1){}
	public MyHelperClass close(){ return null; }
	public MyHelperClass read(){ return null; }}

class BufferedOutputStream {

BufferedOutputStream(FileOutputStream o0, int o1){}
	BufferedOutputStream(){}
	public MyHelperClass write(int o0){ return null; }
	public MyHelperClass close(){ return null; }}

class IOException extends Exception{
	public IOException(String errorMessage) { super(errorMessage); }
}

class FileInputStream {

FileInputStream(){}
	FileInputStream(File o0){}}

class FileOutputStream {

FileOutputStream(){}
	FileOutputStream(File o0){}}

class FileNotFoundException extends Exception{
	public FileNotFoundException(String errorMessage) { super(errorMessage); }
}

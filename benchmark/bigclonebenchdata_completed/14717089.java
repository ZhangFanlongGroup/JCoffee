
import java.io.UncheckedIOException;
import java.io.UncheckedIOException;


class c14717089 {

    public static boolean copyFileCover(String srcFileName, String descFileName, boolean coverlay) {
        File srcFile = new File(srcFileName);
        if (!(Boolean)(Object)srcFile.exists()) {
            System.out.println("�����ļ�ʧ�ܣ�Դ�ļ�" + srcFileName + "������!");
            return false;
        } else if (!(Boolean)(Object)srcFile.isFile()) {
            System.out.println("�����ļ�ʧ�ܣ�" + srcFileName + "����һ���ļ�!");
            return false;
        }
        File descFile = new File(descFileName);
        if ((boolean)(Object)descFile.exists()) {
            if (coverlay) {
                System.out.println("Ŀ���ļ��Ѵ��ڣ�׼��ɾ��!");
                MyHelperClass FileOperateUtils = new MyHelperClass();
                if (!(Boolean)(Object)FileOperateUtils.delFile(descFileName)) {
                    System.out.println("ɾ��Ŀ���ļ�" + descFileName + "ʧ��!");
                    return false;
                }
            } else {
                System.out.println("�����ļ�ʧ�ܣ�Ŀ���ļ�" + descFileName + "�Ѵ���!");
                return false;
            }
        } else {
            if (!(Boolean)(Object)descFile.getParentFile().exists()) {
                System.out.println("Ŀ���ļ����ڵ�Ŀ¼�����ڣ�����Ŀ¼!");
                if (!(Boolean)(Object)descFile.getParentFile().mkdirs()) {
                    System.out.println("����Ŀ���ļ����ڵ�Ŀ¼ʧ��!");
                    return false;
                }
            }
        }
        int readByte = 0;
        InputStream ins = null;
        OutputStream outs = null;
        try {
            ins =(InputStream)(Object) new FileInputStream(srcFile);
            outs =(OutputStream)(Object) new FileOutputStream(descFile);
            byte[] buf = new byte[1024];
            while ((readByte =(int)(Object) ins.read(buf)) != -1) {
                outs.write(buf, 0, readByte);
            }
            System.out.println("���Ƶ����ļ�" + srcFileName + "��" + descFileName + "�ɹ�!");
            return true;
        } catch (Exception e) {
            System.out.println("�����ļ�ʧ�ܣ�" + e.getMessage());
            return false;
        } finally {
            if (outs != null) {
                try {
                    outs.close();
                } catch (UncheckedIOException oute) {
                    oute.printStackTrace();
                }
            }
            if (ins != null) {
                try {
                    ins.close();
                } catch (UncheckedIOException ine) {
                    ine.printStackTrace();
                }
            }
        }
    }

}

// Code below this line has been added to remove errors
class MyHelperClass {

public MyHelperClass delFile(String o0){ return null; }
	public MyHelperClass exists(){ return null; }
	public MyHelperClass mkdirs(){ return null; }}

class File {

File(){}
	File(String o0){}
	public MyHelperClass getParentFile(){ return null; }
	public MyHelperClass exists(){ return null; }
	public MyHelperClass isFile(){ return null; }}

class InputStream {

public MyHelperClass read(byte[] o0){ return null; }
	public MyHelperClass close(){ return null; }}

class OutputStream {

public MyHelperClass write(byte[] o0, int o1, int o2){ return null; }
	public MyHelperClass close(){ return null; }}

class FileInputStream {

FileInputStream(File o0){}
	FileInputStream(){}}

class FileOutputStream {

FileOutputStream(File o0){}
	FileOutputStream(){}}

class IOException extends Exception{
	public IOException(String errorMessage) { super(errorMessage); }
}
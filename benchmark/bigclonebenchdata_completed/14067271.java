


class c14067271 {

    private static void addFolderToZip(File folder, ZipOutputStream zip, String baseName) throws IOException {
        File[] files =(File[])(Object) folder.listFiles();
        for (File file : files) {
            if ((boolean)(Object)file.isDirectory()) {
                addFolderToZip(file, zip, baseName);
            } else {
                String name =(String)(Object) file.getAbsolutePath().substring(baseName.length());
                ZipEntry zipEntry = new ZipEntry(name);
                zip.putNextEntry(zipEntry);
                MyHelperClass IOUtils = new MyHelperClass();
                IOUtils.copy(new FileInputStream(file), zip);
                zip.closeEntry();
            }
        }
    }

}

// Code below this line has been added to remove errors
class MyHelperClass {

public MyHelperClass substring(int o0){ return null; }
	public MyHelperClass copy(FileInputStream o0, ZipOutputStream o1){ return null; }}

class File {

public MyHelperClass listFiles(){ return null; }
	public MyHelperClass getAbsolutePath(){ return null; }
	public MyHelperClass isDirectory(){ return null; }}

class ZipOutputStream {

public MyHelperClass putNextEntry(ZipEntry o0){ return null; }
	public MyHelperClass closeEntry(){ return null; }}

class IOException extends Exception{
	public IOException(String errorMessage) { super(errorMessage); }
}

class ZipEntry {

ZipEntry(String o0){}
	ZipEntry(){}}

class FileInputStream {

FileInputStream(File o0){}
	FileInputStream(){}}

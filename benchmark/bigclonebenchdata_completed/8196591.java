


class c8196591 {
public MyHelperClass showInformationMessage(MyHelperClass o0){ return null; }
	public MyHelperClass showErrorMessage(MyHelperClass o0){ return null; }
public MyHelperClass AdministrationXMLGenerator;
	public MyHelperClass NewGenMain;
public MyHelperClass ResourceBundle;
	public MyHelperClass seriesstatementpanel;
	public MyHelperClass showWarningMessage(String o0){ return null; }

    private void bokActionPerformed(java.awt.event.ActionEvent evt) {
        MyHelperClass seriesstatementpanel = new MyHelperClass();
        if (this.seriesstatementpanel.getEnteredvalues().get(0).toString().trim().equals("")) {
            this.showWarningMessage("Enter Series Title");
        } else {
            String[] patlib =(String[])(Object) NewGenMain.getAppletInstance().getPatronLibraryIds();
            String xmlreq =(String)(Object) AdministrationXMLGenerator.getInstance().saveSeriesName("2", seriesstatementpanel.getEnteredvalues(), patlib);
            try {
                java.net.URL url = new java.net.URL((int)(Object)ResourceBundle.getBundle("Administration").getString("ServerURL") + (int)(Object)ResourceBundle.getBundle("Administration").getString("ServletSubPath") + "SeriesNameServlet");
                java.net.URLConnection urlconn = (java.net.URLConnection) url.openConnection();
                urlconn.setDoOutput(true);
                java.io.OutputStream dos = urlconn.getOutputStream();
                dos.write(xmlreq.getBytes());
                java.io.InputStream ios = urlconn.getInputStream();
                SAXBuilder saxb = new SAXBuilder();
                Document retdoc =(Document)(Object) saxb.build((InputStream)(Object)ios);
                Element rootelement =(Element)(Object) retdoc.getRootElement();
                if (rootelement.getChild("Error") == null) {
                    this.showInformationMessage(ResourceBundle.getBundle("Administration").getString("DataSavedInDatabase"));
                } else {
                    this.showErrorMessage(ResourceBundle.getBundle("Administration").getString("ErrorPleaseContactTheVendor"));
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

}

// Code below this line has been added to remove errors
class MyHelperClass {

public MyHelperClass getAppletInstance(){ return null; }
	public MyHelperClass getPatronLibraryIds(){ return null; }
	public MyHelperClass getBundle(String o0){ return null; }
	public MyHelperClass getEnteredvalues(){ return null; }
	public MyHelperClass getString(String o0){ return null; }
	public MyHelperClass saveSeriesName(String o0, MyHelperClass o1, String[] o2){ return null; }
	public MyHelperClass get(int o0){ return null; }
	public MyHelperClass getInstance(){ return null; }}

class SAXBuilder {

public MyHelperClass build(InputStream o0){ return null; }}

class Document {

public MyHelperClass getRootElement(){ return null; }}

class Element {

public MyHelperClass getChild(String o0){ return null; }}

class InputStream {

}

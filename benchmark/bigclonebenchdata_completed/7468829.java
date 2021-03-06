


class c7468829 {

    public static String doGetWithBasicAuthentication(URL url, String username, String password, int timeout, Map headers) throws Throwable {
        HttpURLConnection con = (HttpURLConnection)(HttpURLConnection)(Object) url.openConnection();
        con.setRequestMethod("GET");
        con.setDoInput(true);
        if (username != null || password != null) {
            byte[] encodedPassword = (username + ":" + password).getBytes();
            BASE64Encoder encoder = new BASE64Encoder();
            con.setRequestProperty("Authorization", "Basic " + encoder.encode(encodedPassword));
        }
        if (headers != null) {
            for (Entry header :(Entry[])(Object) (Object[])(Object)headers.entrySet()) {
                con.setRequestProperty((String)(Object)header.getKey(),(String)(Object) header.getValue());
            }
        }
        con.setConnectTimeout(timeout);
        InputStream is =(InputStream)(Object) con.getInputStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
        String line;
        StringBuffer response = new StringBuffer();
        while ((line =(String)(Object) rd.readLine()) != null) {
            response.append(line);
            response.append('\n');
        }
        rd.close();
        is.close();
        con.disconnect();
        return response.toString();
    }

}

// Code below this line has been added to remove errors
class MyHelperClass {

}

class URL {

public MyHelperClass openConnection(){ return null; }}

class Map {

public MyHelperClass entrySet(){ return null; }}

class HttpURLConnection {

public MyHelperClass setRequestProperty(String o0, String o1){ return null; }
	public MyHelperClass setRequestMethod(String o0){ return null; }
	public MyHelperClass setDoInput(boolean o0){ return null; }
	public MyHelperClass getInputStream(){ return null; }
	public MyHelperClass disconnect(){ return null; }
	public MyHelperClass setConnectTimeout(int o0){ return null; }}

class BASE64Encoder {

public MyHelperClass encode(byte[] o0){ return null; }}

class InputStream {

public MyHelperClass close(){ return null; }}

class BufferedReader {

BufferedReader(){}
	BufferedReader(InputStreamReader o0){}
	public MyHelperClass readLine(){ return null; }
	public MyHelperClass close(){ return null; }}

class InputStreamReader {

InputStreamReader(InputStream o0){}
	InputStreamReader(){}}

class Entry {

public MyHelperClass getKey(){ return null; }
	public MyHelperClass getValue(){ return null; }}

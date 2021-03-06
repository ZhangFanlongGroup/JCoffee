


class c17116115 {
public MyHelperClass systemManager;
	public MyHelperClass usrIds;
	public MyHelperClass database;

    public void assign() throws Exception {
        MyHelperClass proposalIds = new MyHelperClass();
        if (proposalIds.equals("") || usrIds.equals("")) throw new Exception("No proposal or peer-viewer selected.");
//        MyHelperClass proposalIds = new MyHelperClass();
        String[] pids =(String[])(Object) proposalIds.split(",");
        MyHelperClass usrIds = new MyHelperClass();
        String[] uids =(String[])(Object) usrIds.split(",");
        int pnum = pids.length;
        int unum = uids.length;
        if (pnum == 0 || unum == 0) throw new Exception("No proposal or peer-viewer selected.");
        int i, j;
        String pStr = "update proposal set current_status='assigned' where ";
        for (i = 0; i < pnum; i++) {
            if (i > 0) pStr += " OR ";
            pStr += "PROPOSAL_ID=" + pids[i];
        }
        MyHelperClass Calendar = new MyHelperClass();
        Calendar date =(Calendar)(Object) Calendar.getInstance();
//        MyHelperClass Calendar = new MyHelperClass();
        int day =(int)(Object) date.get(Calendar.DATE);
//        MyHelperClass Calendar = new MyHelperClass();
        int month =(int)(Object) date.get(Calendar.MONTH);
//        MyHelperClass Calendar = new MyHelperClass();
        int year =(int)(Object) date.get(Calendar.YEAR);
        String dt = String.valueOf(year) + "-" + String.valueOf(month + 1) + "-" + String.valueOf(day);
        PreparedStatement prepStmt = null;
        try {
            MyHelperClass con = new MyHelperClass();
            con = database.getConnection();
//            MyHelperClass con = new MyHelperClass();
            con.setAutoCommit(false);
//            MyHelperClass con = new MyHelperClass();
            prepStmt =(PreparedStatement)(Object) con.prepareStatement(pStr);
            prepStmt.executeUpdate();
            MyHelperClass userId = new MyHelperClass();
            pStr = "insert into event (summary,document1,document2,document3,publicComments,privateComments,ACTION_ID,eventDate,ROLE_ID,reviewText,USR_ID,PROPOSAL_ID,SUBJECTUSR_ID) values " + "('','','','','','','assigned','" + dt + "',2,'new'," + userId + ",?,?)";
//            MyHelperClass con = new MyHelperClass();
            prepStmt =(PreparedStatement)(Object) con.prepareStatement(pStr);
            for (i = 0; i < pnum; i++) {
                for (j = 0; j < unum; j++) {
                    prepStmt.setString(1, pids[i]);
                    prepStmt.setString(2, uids[j]);
                    prepStmt.executeUpdate();
                }
            }
//            MyHelperClass con = new MyHelperClass();
            con.commit();
        } catch (Exception e) {
            MyHelperClass con = new MyHelperClass();
            if (!(Boolean)(Object)con.isClosed()) {
//                MyHelperClass con = new MyHelperClass();
                con.rollback();
                prepStmt.close();
//                MyHelperClass con = new MyHelperClass();
                con.close();
            }
            throw e;
        }
        event_Form fr = new event_Form();
        for (j = 0; j < unum; j++) {
            MyHelperClass userId = new MyHelperClass();
            fr.setUSR_ID(userId);
            fr.setSUBJECTUSR_ID(uids[j]);
            MyHelperClass SystemManager = new MyHelperClass();
            systemManager.handleEvent(SystemManager.EVENT_PROPOSAL_ASSIGNED, fr, null, null);
        }
    }

}

// Code below this line has been added to remove errors
class MyHelperClass {
public MyHelperClass YEAR;
	public MyHelperClass EVENT_PROPOSAL_ASSIGNED;
	public MyHelperClass DATE;
	public MyHelperClass MONTH;
public MyHelperClass isClosed(){ return null; }
	public MyHelperClass commit(){ return null; }
	public MyHelperClass rollback(){ return null; }
	public MyHelperClass setAutoCommit(boolean o0){ return null; }
	public MyHelperClass getConnection(){ return null; }
	public MyHelperClass close(){ return null; }
	public MyHelperClass handleEvent(MyHelperClass o0, event_Form o1, Object o2, Object o3){ return null; }
	public MyHelperClass split(String o0){ return null; }
	public MyHelperClass prepareStatement(String o0){ return null; }
	public MyHelperClass getInstance(){ return null; }}

class Calendar {

public MyHelperClass get(MyHelperClass o0){ return null; }}

class PreparedStatement {

public MyHelperClass close(){ return null; }
	public MyHelperClass setString(int o0, String o1){ return null; }
	public MyHelperClass executeUpdate(){ return null; }}

class event_Form {

public MyHelperClass setSUBJECTUSR_ID(String o0){ return null; }
	public MyHelperClass setUSR_ID(MyHelperClass o0){ return null; }}

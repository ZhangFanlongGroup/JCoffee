import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;
import java.net.*;
import java.applet.*;
import java.security.*;



class c144769 {

    public void elimina(Cliente cli) throws Throwable, errorSQL, errorConexionBD {
        System.out.println("GestorCliente.elimina()");
        int id =(int)(Object) cli.getId();
        String sql;
        Statement stmt = null;
        try {
            MyHelperClass gd = new MyHelperClass();
            gd.begin();
            sql = "DELETE FROM cliente WHERE cod_cliente =" + id;
            System.out.println("Ejecutando: " + sql);
//            MyHelperClass gd = new MyHelperClass();
            stmt =(Statement)(Object) gd.getConexion().createStatement();
            stmt.executeUpdate(sql);
            System.out.println("executeUpdate");
            sql = "DELETE FROM persona WHERE id =" + id;
            System.out.println("Ejecutando: " + sql);
            stmt.executeUpdate(sql);
//            MyHelperClass gd = new MyHelperClass();
            gd.commit();
            System.out.println("commit");
            stmt.close();
        } catch (ArithmeticException e) {
            MyHelperClass gd = new MyHelperClass();
            gd.rollback();
            throw new errorSQL(e.toString());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Error en GestorCliente.elimina(): " + e);
        } catch (ArrayStoreException e) {
            System.err.println("Error en GestorCliente.elimina(): " + e);
        }
    }

}

// Code below this line has been added to remove errors
class MyHelperClass {

public MyHelperClass begin(){ return null; }
	public MyHelperClass commit(){ return null; }
	public MyHelperClass createStatement(){ return null; }
	public MyHelperClass rollback(){ return null; }
	public MyHelperClass getConexion(){ return null; }}

class Cliente {

public MyHelperClass getId(){ return null; }}

class errorSQL extends Exception{
	public errorSQL(String errorMessage) { super(errorMessage); }
}

class errorConexionBD extends Exception{
	public errorConexionBD(String errorMessage) { super(errorMessage); }
}

class Statement {

public MyHelperClass close(){ return null; }
	public MyHelperClass executeUpdate(String o0){ return null; }}

class SQLException extends Exception{
	public SQLException(String errorMessage) { super(errorMessage); }
}

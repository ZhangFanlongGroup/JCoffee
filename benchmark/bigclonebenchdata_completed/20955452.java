
import java.io.UncheckedIOException;


class c20955452 {

    private void criarQuestaoMultiplaEscolha(QuestaoMultiplaEscolha q) throws SQLException {
        PreparedStatement stmt = null;
        String sql = "INSERT INTO multipla_escolha (id_questao, texto, gabarito) VALUES (?,?,?)";
        try {
            for (Alternativa alternativa :(Alternativa[])(Object) (Object[])(Object)q.getAlternativa()) {
                MyHelperClass conexao = new MyHelperClass();
                stmt =(PreparedStatement)(Object) conexao.prepareStatement(sql);
                stmt.setInt(1, q.getIdQuestao());
                stmt.setString(2, alternativa.getTexto());
                stmt.setBoolean(3, alternativa.getGabarito());
                stmt.executeUpdate();
//                MyHelperClass conexao = new MyHelperClass();
                conexao.commit();
            }
        } catch (UncheckedIOException e) {
            MyHelperClass conexao = new MyHelperClass();
            conexao.rollback();
            throw e;
        }
    }

}

// Code below this line has been added to remove errors
class MyHelperClass {

public MyHelperClass commit(){ return null; }
	public MyHelperClass prepareStatement(String o0){ return null; }
	public MyHelperClass rollback(){ return null; }}

class QuestaoMultiplaEscolha {

public MyHelperClass getAlternativa(){ return null; }
	public MyHelperClass getIdQuestao(){ return null; }}

class SQLException extends Exception{
	public SQLException(String errorMessage) { super(errorMessage); }
}

class PreparedStatement {

public MyHelperClass setBoolean(int o0, MyHelperClass o1){ return null; }
	public MyHelperClass setString(int o0, MyHelperClass o1){ return null; }
	public MyHelperClass setInt(int o0, MyHelperClass o1){ return null; }
	public MyHelperClass executeUpdate(){ return null; }}

class Alternativa {

public MyHelperClass getGabarito(){ return null; }
	public MyHelperClass getTexto(){ return null; }}

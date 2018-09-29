package uninorte;

import java.io.*;
import java.sql.*;	
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Conexion implements Serializable{	
	String serverbd, userbd, passbd;
	
	ResultSet rs;
	Connection conn;
	Statement st; 
	PreparedStatement pst; 
	ResultSetMetaData rsmd;
    
	public Conexion() {
		this.serverbd = "jdbc:mariadb://172.17.9.112:80/eclipse"; 
		/*System.getenv("serverbd");*/
		this.userbd = "eclipse";
		/*System.getenv("userbd");*/
		this.passbd = "uninorte";
		/*System.getenv("passbd");*/
		
	}
	public boolean abrirConexion(){ 
        try{
            try{

                Class.forName("org.mariadb.jdbc.Driver");
                conn = DriverManager.getConnection(this.serverbd, this.userbd, this.passbd);
                st = conn.createStatement();
                return  true;

            }catch(ClassNotFoundException sqle){ 
                    return false;
            }
        }catch(SQLException sqle){ 
                return false;
        }
	}
	public boolean cerrarConexion(){
		try{
			conn.close(); 
			st.close(); 
			return  true;
		}catch(SQLException sqle){ 
			return  false;
		}
	}
	public String consultar(String query) throws JSONException{
		String message;
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		JSONObject item = new JSONObject();
		
		
		try{ 
            rs=st.executeQuery(query);
            rsmd = rs.getMetaData();
            while (rs.next()){			
                 for(int i=1; i <= rsmd.getColumnCount(); i++){
                        if(rs.getString(i)!=null)
                        	item.put(rsmd.getColumnName(i),rs.getString(i));					
                }
                array.put(item);
            }
            json.put("items", array);
            message = json.toString();
            rs.close();
		}catch(SQLException sqle){ 
			message="[]";
		}
		return message;
	}
}
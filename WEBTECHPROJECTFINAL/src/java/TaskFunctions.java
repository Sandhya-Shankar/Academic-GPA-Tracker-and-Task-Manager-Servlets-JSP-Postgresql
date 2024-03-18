import java.sql.*;

public class TaskFunctions {
	Connection con;
	
	public TaskFunctions() {
		
	}
	
	//to Add the task
	public boolean task_add(Task task){
        boolean set = false;
        try{

        	String query = "insert into tasks(title,description,targetDate,status) values(?,?,?,?)";
        	ConnectionPro c = new ConnectionPro();
	        PreparedStatement pt = c.getConnection().prepareStatement(query);
	        pt.setString(1, task.getTitle());
	        pt.setString(2, task.getDescription());
	        pt.setString(3,task.getTargetDate());
	        pt.setBoolean(4, task.getStatus());
	        pt.executeUpdate();
	        set = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return set;
        
    }

	public boolean DeleteTask(int id) {
		boolean set =false;
		try {
			String query ="DELETE from tasks where id=?";
			ConnectionPro c = new ConnectionPro();
	        PreparedStatement pt = c.getConnection().prepareStatement(query);
	        pt.setInt(1, id);
	        pt.executeUpdate();
	        set = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return set;
		
	}

	public boolean ChangeStatusTask(int id) {
		boolean set =false;
		try {
			String query ="update tasks set status = true where id = ?";
			ConnectionPro c = new ConnectionPro();
	        PreparedStatement pt = c.getConnection().prepareStatement(query);
	        pt.setInt(1, id);
	        pt.executeUpdate();
	        set = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return set;	
		
	}
	
}

package AllActions;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimerTask;

import DBAccess.DeleteInfo;

import java.util.Timer;



public class TimerAction extends TimerTask {
	
	public void run()
	{
		DeleteInfo deleteInfo=new DeleteInfo();
		deleteInfo.deleteAllTables();
	
	}
	
	
	

	public String execute()
	{
		DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date=dateFormat.parse("2017-12-31");
			
			Timer timer=new Timer();
			timer.schedule(new TimerAction(), date);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
return "success";
	}

}


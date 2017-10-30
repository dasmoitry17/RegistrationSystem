package AllActions;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import DBAccess.DeleteInfo;

public class TimerDelete extends TimerTask {
	
	public void run()
	{
		DeleteInfo deleteInfo=new DeleteInfo();
		deleteInfo.deleteAllTables();
	
	}

	public String execute(String givendate)
	{
		DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date=dateFormat.parse(givendate);
			
			Timer timer=new Timer();
			timer.schedule(new TimerAction(), date);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
return "success";
	}


}

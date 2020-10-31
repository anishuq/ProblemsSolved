import java.util.*;

public class ClockHandAngle 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String time = sc.nextLine();
		
		//parse string
		String[] timeArr = time.split(":");
		int hour = Integer.parseInt(timeArr[0]);
		int minute = Integer.parseInt(timeArr[1]);
		
		//System.out.println("Hour:  "+hour+"   Min: "+minute);
		if(minute == 60)
		{
			hour = hour + 1;
			minute = 0;
		}
		double minAngle = minute * 6;
		//Hour part (start)
		double hPart = hour * 30;
		double mPart = 30.0*(minute/60.0);
		double hourAngle = hPart + mPart;
		//Hour part (end)
		//Two angles
		
		double f_angle = hourAngle - minAngle;
		f_angle = Math.abs(f_angle);
		double s_angle = 360 - f_angle;
		s_angle = Math.abs(s_angle);
		
		//System.out.println("First angle  "+f_angle+"  Second Angle: "+s_angle);
		double min = Math.min(f_angle, s_angle);
		if(Math.floor(min) == Math.ceil(min))
			System.out.println((int)min);
		else
			System.out.println(min);
		
		
		sc.close();
	}

}

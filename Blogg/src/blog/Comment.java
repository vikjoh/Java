package blog;

import java.util.Calendar;


public class Comment {
	Author author;
	String text;
	Calendar calendar;
	
	public Comment(Author a, String t, Calendar c)
	{
		this.author = a;
		this.text = t;
		this.calendar = c;
	}
	
	public Author getAuthor()
	{
		return author;
	}
	public String getText()
	{
		return text;
	}
	public Calendar getCalendar()
	{
		return calendar;
	}
	public String printCalendar(){
		return String.format("%4d-%02d-%02d %02d:%02d", calendar.get(Calendar.YEAR), (calendar.get(Calendar.MONTH) + 1), calendar.get(Calendar.DATE), calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
	}
}

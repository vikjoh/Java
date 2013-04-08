package blog;

import java.util.Calendar;


public class Comment {
	private Author author;
	private String text;
	private Calendar calendar;
	
	//Constructors
	public Comment(Author a, String t, Calendar c)
	{
		this.author = a;
		this.text = t;
		this.calendar = c;
	}
	
	//Getters n setters
	public Author getAuthor()
	{
		return author;
	}
	public void setAuthor(Author a)
	{
		this.author = a;
	}
	public String getText()
	{
		return text;
	}
	public void setText(String t)
	{
		this.text = t;
	}
	public Calendar getCalendar()
	{
		return calendar;
	}
	public void setCalendar(Calendar c)
	{
		this.calendar = c;
	}
	
	//Other functions
	public String printCalendar()
	{
		return String.format("%4d-%02d-%02d %02d:%02d", calendar.get(Calendar.YEAR), (calendar.get(Calendar.MONTH) + 1), calendar.get(Calendar.DATE), calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
	}
}

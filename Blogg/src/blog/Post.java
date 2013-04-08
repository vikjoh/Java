package blog;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class Post {
	String title;
	String text;
	Author author;
	Calendar calendar;
	List<Comment> comments = new ArrayList<>();
	
	public Post(String ti, String te, Author a, Calendar c)
	{
		this.title = ti;
		this.text = te;
		this.author = a;
		this.calendar = c;
	}
	
	public String getTitle(){
		return title;
	}
	public String getText(){
		return text;
	}
	public Author getAuthor(){
		return author;
	}
	public Calendar getCalendar(){
		return calendar;
	}
	public String printCalendar(){
		return String.format("%4d-%02d-%02d %02d:%02d", calendar.get(Calendar.YEAR), (calendar.get(Calendar.MONTH) + 1), calendar.get(Calendar.DATE), calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
	}
	public List<Comment> getComments()
	{
		return comments;
	}
	public void addComment(Comment c)
	{
		comments.add(c);
	}
}

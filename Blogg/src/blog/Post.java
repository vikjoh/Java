package blog;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Post {
	private String title;
	private String text;
	private Author author;
	private Calendar calendar;
	private int numberOfComments;
	private List<Comment> comments = new ArrayList<>();
	private List<String> tags = new ArrayList<>();
	private int sqlID;
	
	//Constructors
	public Post(String ti, String te, Author a, Calendar c)
	{
		this.title = ti;
		this.text = te;
		this.author = a;
		this.calendar = c;
	}
	public Post(String ti, String te, Author a, Calendar c, List<Comment> cList)
	{
		this.title = ti;
		this.text = te;
		this.author = a;
		this.calendar = c;
		this.comments = cList;
	}
	
	//Getters n setters
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String t)
	{
		this.title = t;
	}
	public String getText()
	{
		return text;
	}
	public void setText(String t)
	{
		this.text = t;
	}
	public Author getAuthor()
	{
		return author;
	}
	public void setAuthor(Author a)
	{
		this.author = a;
	}
	public Calendar getCalendar()
	{
		return calendar;
	}
	public void setCalendar(Calendar c)
	{
		this.calendar = c;
	}
	public List<String> getTags()
	{
		return tags;
	}
	public void setTags(List<String> t)
	{
		this.tags = t;
	}
	public int getNumberOfComments()
	{
		return numberOfComments;
	}
	public void setNumberOfComments(int n)
	{
		this.numberOfComments = n;
	}
	public List<Comment> getComments()
	{
		return comments;
	}
	public void addComment(Comment c)
	{
		comments.add(c);
	}
	public void addMultipleComments(List<Comment> cList)
	{
		for(Comment c : cList)
		{
			comments.add(c);
		}
	}
	public void removeComment(int id)
	{
		comments.remove(id);
	}
	public void removeComment(Comment c)
	{
		comments.remove(c);
	}
	public void removeAllComments(List<Comment> cList)
	{
		comments.removeAll(null);
	}
	public int getSqlID()
	{
		return sqlID;
	}
	public void setSqlID(int id)
	{
		sqlID = id;
	}
	
	//Other functions
	public String printCalendar(){
		return String.format("%4d-%02d-%02d %02d:%02d", calendar.get(Calendar.YEAR), (calendar.get(Calendar.MONTH) + 1), calendar.get(Calendar.DATE), calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
	}
}

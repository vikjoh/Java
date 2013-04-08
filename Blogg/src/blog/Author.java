package blog;

public class Author {
	String name;
	int age;
	String mail;
	
	public Author(String n, String m)
	{
		this.name = n;
		this.mail = m;
	}
	
	public String getName()
	{
		return name;
	}
	public int getAge()
	{
		return age;
	}
	public String getMail()
	{
		return mail;
	}
}

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.List;
import org.eclipse.wb.swt.SWTResourceManager;
import blog.*;

public class MainWindow_old {
	
	public static ArrayList<Post> posts = new ArrayList<>();
	static Display display = Display.getDefault();
	static Shell shlBlogg = new Shell();

	final static List list = new List(shlBlogg, SWT.BORDER);
	
	public static void main() {
		
		shlBlogg.setSize(450, 300);
		shlBlogg.setText("Blogg");
		
		final Label lblMainLabel = new Label(shlBlogg, SWT.NONE);
		lblMainLabel.setAlignment(SWT.CENTER);
		lblMainLabel.setBounds(134, 66, 290, 155);
		
		Button btnLggTill = new Button(shlBlogg, SWT.NONE);
		btnLggTill.setBounds(10, 227, 109, 25);
		btnLggTill.setText("L\u00E4gg till post");

		final Label lblHeaderlabel = new Label(shlBlogg, SWT.NONE);
		lblHeaderlabel.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		lblHeaderlabel.setAlignment(SWT.CENTER);
		lblHeaderlabel.setBounds(134, 10, 290, 39);
		
		list.setBounds(10, 10, 109, 211);
		
		final Label lblFooterlabel = new Label(shlBlogg, SWT.NONE);
		lblFooterlabel.setFont(SWTResourceManager.getFont("Segoe UI", 8, SWT.NORMAL));
		lblFooterlabel.setAlignment(SWT.RIGHT);
		lblFooterlabel.setBounds(134, 227, 290, 25);
		
		init();
		
		for(Post p : posts){
			list.add(p.getTitle(), posts.indexOf(p));
		}
		
		
		btnLggTill.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				AddWindow_old window = new AddWindow_old();
				window.open();
			}
		});	
		
		list.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
		        int[] selectedItems = list.getSelectionIndices();
		        lblHeaderlabel.setText(posts.get(selectedItems[0]).getTitle());
		        lblMainLabel.setText(posts.get(selectedItems[0]).getText());
		        lblFooterlabel.setText(posts.get(selectedItems[0]).getAuthor().getName() + ", " +
		        sdf.format(posts.get(selectedItems[0]).getCalendar().getTime()));
			}
		});
		
		shlBlogg.open();
		shlBlogg.layout();
		while (!shlBlogg.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	public static void init(){
		
		Post p = new Post("First post", "This is the first post", new Author("Victor", "kontakt@vicolsson.se"), new GregorianCalendar(2013, 4, 25, 11, 10));
		p.addComment(new Comment(new Author("Victor", "kontakt@vicolsson.se"), "Grattis!", new GregorianCalendar(2013, 4, 25, 11, 24)));
		p.addComment(new Comment(new Author("Kalle", "kalle@ankeborg.se"), "Yo!", new GregorianCalendar(2013, 4, 26, 13, 40)));
		posts.add(p);
		
		p = new Post("Second lolz", "This is second", new Author("Victor", "kontakt@vicolsson.se"), new GregorianCalendar(2013, 5, 2, 8, 46));
		p.addComment(new Comment(new Author("Victor", "kontakt@vicolsson.se"), "Tjena", new GregorianCalendar(2013, 5, 2, 8, 48)));
		posts.add(p);
		
	}
	
	public static void refresh() {
		list.removeAll();
		for(Post p : posts){
			list.add(p.getTitle(), posts.indexOf(p));
		}
	}
}

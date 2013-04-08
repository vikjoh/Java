import java.util.Calendar;
import java.util.GregorianCalendar;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import blog.*;

public class AddWindow {
	private Text txtTitel;
	private Text txtText;
	private Text txtNamn;
	private Text txtMail;

	
	Display display = Display.getDefault();
	Shell shlLggTillPost = new Shell();
	public void open() {
		shlLggTillPost.setSize(450, 300);
		shlLggTillPost.setText("L\u00E4gg till post");
		
		Button btnSpara = new Button(shlLggTillPost, SWT.NONE);
		btnSpara.setBounds(349, 227, 75, 25);
		btnSpara.setText("Spara");
		
		txtTitel = new Text(shlLggTillPost, SWT.BORDER);
		txtTitel.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		txtTitel.setText("Titel");
		txtTitel.setBounds(10, 10, 414, 34);
		
		txtText = new Text(shlLggTillPost, SWT.BORDER);
		txtText.setText("Text");
		txtText.setBounds(10, 50, 414, 106);
		
		txtNamn = new Text(shlLggTillPost, SWT.BORDER);
		txtNamn.setText("Namn");
		txtNamn.setBounds(10, 231, 76, 21);
		
		txtMail = new Text(shlLggTillPost, SWT.BORDER);
		txtMail.setText("Mail");
		txtMail.setBounds(92, 231, 76, 21);
		
		
		btnSpara.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String titel = txtTitel.getText();
				String text = txtText.getText();
				String namn = txtNamn.getText();
				String mail = txtMail.getText();
				
				if(titel != null && text != null && namn != null && mail != null)
				{
					Author a = new Author(namn, mail);
					Calendar c = new GregorianCalendar();
					MainWindow.posts.add(new Post(titel, text, a, c));
					MainWindow.refresh();
					shlLggTillPost.close();
				}
			}
		});
		
		

		shlLggTillPost.open();
		shlLggTillPost.layout();
		while (!shlLggTillPost.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}

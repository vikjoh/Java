import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import blog.*;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;


public class MainWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	public static ArrayList<Post> posts = new ArrayList<>();
	SimpleDateFormat mainSDF = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		init();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		final JList<String> list = new JList<String>(listModel);
		list.setSize(100, 241);
		for(Post p : posts){
			listModel.addElement(p.getTitle());
		}
		
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		list.setLocation(10, 10);
		contentPane.add(list);

		
		final JLabel lblHeader = new JLabel(posts.get(0).getTitle());
		lblHeader.setSize(304, 30);
		lblHeader.setLocation(120, 11);
		contentPane.add(lblHeader);
		
		final JLabel lblFooter = new JLabel(posts.get(0).getAuthor().getName() + ", " +
		        mainSDF.format(posts.get(0).getCalendar().getTime()));
		lblFooter.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFooter.setSize(304, 20);
		lblFooter.setLocation(120, 231);
		contentPane.add(lblFooter);
		
		final JLabel lblBody = new JLabel("<html>" + posts.get(0).getText() + 
        		"<br><br>" + posts.get(0).getNumberOfComments() + 
        		" kommentarer</html>");
		lblBody.setVerticalAlignment(SwingConstants.TOP);
		lblBody.setSize(304, 168);
		lblBody.setLocation(120, 52);
		contentPane.add(lblBody);
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {

		        int[] selectedItems = list.getSelectedIndices();
		        lblHeader.setText(posts.get(selectedItems[0]).getTitle());
		        lblBody.setText("<html>" + posts.get(selectedItems[0]).getText() + 
		        		"<br><br>" + posts.get(selectedItems[0]).getNumberOfComments() + 
		        		" kommentarer</html>");
		        lblFooter.setText(posts.get(selectedItems[0]).getAuthor().getName() + ", " +
		        		mainSDF.format(posts.get(selectedItems[0]).getCalendar().getTime()));
			}
		});
	}
	public static void init()
	{
		posts = (ArrayList<Post>) BlogFactory.getAllPosts();
	}

}

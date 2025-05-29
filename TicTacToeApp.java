//Name: Tanvi Jain
//Date: April 3rd, 2023
//Purpose: To make a fun game :)

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.Applet;
import java.text.DateFormat;
import java.util.Date;
import java.util.TimeZone;
public class TicTacToeApp extends Applet implements ActionListener
{

    //For screens
    Panel p_card;
    Panel card1, card2, card3, card4, card5, card6, card7;
    CardLayout cdLayout = new CardLayout ();

    //Global Variables
    JLabel turnPic;
    JButton a, b, c, d, ee, f, g, h, i;
    char board[] [] = {{'b', 'b', 'b'}, {'b', 'b', 'b'}, {'b', 'b', 'b'}};
    int hiarchyBoard[] [] = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    int hiarchy = 1;
    char turn = 'x';
    JTextField choice, name, first;
    Image img;

    JButton goodSmol, goodMid, goodBig, badSmol, badMid, badBig;
    String goodPiece = ("smolgood.png");
    String badPiece = ("smolbad.png");
    String piece = goodPiece;
    int gs = 2;
    int gm = 2;
    int gb = 2;
    int bs = 2;
    int bm = 2;
    int bb = 2;

    //Formatting
    Color backgroundColour = new Color (223, 198, 231);
    Color buttonColour = new Color (126, 226, 169);
    Color buttonText = new Color (26, 167, 87);
    Color titleColour = new Color (222, 66, 126);
    Font titleFont = new Font ("Gabriola", Font.BOLD, 30);
    Font promptFont = new Font ("Segoe Print", Font.PLAIN, 20);
    Dimension boardSquare = new Dimension (96, 96);

    //displays date
    public void date ()
    {
	Date now = new Date ();
	DateFormat df = DateFormat.getDateInstance ();
	df.setTimeZone (TimeZone.getTimeZone ("Canada/Toronto"));
	String s = df.format (now);
	JOptionPane.showMessageDialog (null, "Today is " + s,
		"Date", JOptionPane.INFORMATION_MESSAGE);
    }


    public void init ()
    {
	p_card = new Panel ();
	p_card.setLayout (cdLayout);
	date ();
	opening ();
	story1 ();
	story2 ();
	instructions ();
	gameScreen ();
	winScreen ();
	lossScreen ();
	resize (350, 700);
	setLayout (new BorderLayout ());
	menu ();
	add ("Center", p_card);
    }


    //adds a menu for users
    public void menu ()
    {
	JMenuBar menuBar = new JMenuBar ();
	JMenu menu;
	JMenuItem menuItem;

	menu = new JMenu ("File");
	menuBar.add (menu);
	menuItem = new JMenuItem ("Date");
	menuItem.addActionListener (this);
	menuItem.setActionCommand ("date");
	menu.add (menuItem);
	menuItem = new JMenuItem ("Reset Level");
	menuItem.setActionCommand ("reset");
	menuItem.addActionListener (this);
	menu.add (menuItem);
	menuItem = new JMenuItem ("Exit");
	menuItem.addActionListener (this);
	menuItem.setActionCommand ("Close");
	menu.add (menuItem);

	menu = new JMenu ("Navigate");
	menuBar.add (menu);
	menuItem = new JMenuItem ("Opening");
	menuItem.addActionListener (this);
	menuItem.setActionCommand ("1");
	menu.add (menuItem);
	menuItem = new JMenuItem ("Story");
	menuItem.addActionListener (this);
	menuItem.setActionCommand ("2");
	menu.add (menuItem);
	menuItem = new JMenuItem ("Intructions");
	menuItem.addActionListener (this);
	menuItem.setActionCommand ("4");
	menu.add (menuItem);
	menuItem = new JMenuItem ("Play");
	menuItem.addActionListener (this);
	menuItem.setActionCommand ("5");
	menu.add (menuItem);
	add ("North", menuBar);
    }


    public void opening ()
    { //creates the first screen players see
	card1 = new Panel ();
	JButton next = new JButton (createImageIcon ("bgk.jpg"));
	next.setPreferredSize (new Dimension (350, 700));
	next.setActionCommand ("2");
	next.addActionListener (this);
	card1.add (next);
	p_card.add ("1", card1);
    }


    public void story1 ()
    { //first story page
	card2 = new Panel ();
	JButton next = new JButton (createImageIcon ("story1.jpg"));
	next.setPreferredSize (new Dimension (350, 700));
	next.setActionCommand ("3");
	next.addActionListener (this);
	card2.add (next);
	p_card.add ("2", card2);
    }


    public void story2 ()
    { //second story page
	card3 = new Panel ();
	JButton next = new JButton (createImageIcon ("story2.jpg"));
	next.setPreferredSize (new Dimension (350, 700));
	next.setActionCommand ("4");
	next.addActionListener (this);
	card3.add (next);
	p_card.add ("3", card3);
    }


    public void instructions ()
    { //tells players how to play
	card4 = new Panel ();
	JButton next = new JButton (createImageIcon ("instruc.jpg"));
	next.setPreferredSize (new Dimension (350, 700));
	next.setActionCommand ("5");
	next.addActionListener (this);
	card4.add (next);
	p_card.add ("4", card4);
    }


    public void gameScreen ()
    { //what players see to play the game
	card5 = new Panel ();
	card5.setBackground (backgroundColour);
	JLabel title = new JLabel (createImageIcon ("title.png"));
	Panel p = new Panel ();
	JLabel curturn = new JLabel (createImageIcon ("subhead.png"));
	curturn.setFont (promptFont);
	turnPic = new JLabel (createImageIcon ("biggood.png"));
	p.add (curturn);
	p.add (turnPic);

	//game grid
	Panel p2 = new Panel (new GridLayout (3, 3));
	p2.setBackground (backgroundColour);
	a = new JButton (createImageIcon ("b.png"));
	a.setActionCommand ("a");
	a.setBackground (backgroundColour);
	a.setPreferredSize (boardSquare);
	a.addActionListener (this);
	p2.add (a);
	b = new JButton (createImageIcon ("b.png"));
	b.setActionCommand ("b");
	b.setBackground (backgroundColour);
	b.setPreferredSize (boardSquare);
	b.addActionListener (this);
	p2.add (b);
	c = new JButton (createImageIcon ("b.png"));
	c.setActionCommand ("c");
	c.setBackground (backgroundColour);
	c.setPreferredSize (boardSquare);
	c.addActionListener (this);
	p2.add (c);
	d = new JButton (createImageIcon ("b.png"));
	d.setActionCommand ("d");
	d.setBackground (backgroundColour);
	d.setPreferredSize (boardSquare);
	d.addActionListener (this);
	p2.add (d);
	ee = new JButton (createImageIcon ("b.png"));
	ee.setActionCommand ("ee");
	ee.setBackground (backgroundColour);
	ee.setPreferredSize (boardSquare);
	ee.addActionListener (this);
	p2.add (ee);
	f = new JButton (createImageIcon ("b.png"));
	f.setActionCommand ("f");
	f.setBackground (backgroundColour);
	f.setPreferredSize (boardSquare);
	f.addActionListener (this);
	p2.add (f);
	g = new JButton (createImageIcon ("b.png"));
	g.setActionCommand ("g");
	g.setBackground (backgroundColour);
	g.setPreferredSize (boardSquare);
	g.addActionListener (this);
	p2.add (g);
	h = new JButton (createImageIcon ("b.png"));
	h.setActionCommand ("h");
	h.setBackground (backgroundColour);
	h.setPreferredSize (boardSquare);
	h.addActionListener (this);
	p2.add (h);
	i = new JButton (createImageIcon ("b.png"));
	i.setActionCommand ("i");
	i.setBackground (backgroundColour);
	i.setPreferredSize (boardSquare);
	i.addActionListener (this);
	p2.add (i);


	//which pieces players have left
	Panel p4 = new Panel (new GridLayout (2, 3));
	p4.setBackground (backgroundColour);
	goodSmol = new JButton (createImageIcon ("smolgood.png"));
	goodSmol.setPreferredSize (new Dimension (75, 75));
	goodSmol.setBackground (backgroundColour);
	goodSmol.addActionListener (this);
	goodSmol.setActionCommand ("goodSmall");
	p4.add (goodSmol);
	goodMid = new JButton (createImageIcon ("midgood.png"));
	goodMid.setPreferredSize (new Dimension (75, 75));
	goodMid.setBackground (backgroundColour);
	goodMid.addActionListener (this);
	goodMid.setActionCommand ("goodMid");
	p4.add (goodMid);
	goodBig = new JButton (createImageIcon ("biggood.png"));
	goodBig.setPreferredSize (new Dimension (75, 75));
	goodBig.setBackground (backgroundColour);
	goodBig.addActionListener (this);
	goodBig.setActionCommand ("goodBig");
	p4.add (goodBig);
	badSmol = new JButton (createImageIcon ("smolbad.png"));
	badSmol.setPreferredSize (new Dimension (75, 75));
	badSmol.setBackground (backgroundColour);
	badSmol.addActionListener (this);
	badSmol.setActionCommand ("badSmall");
	p4.add (badSmol);
	badMid = new JButton (createImageIcon ("midbad.png"));
	badMid.setPreferredSize (new Dimension (75, 75));
	badMid.setBackground (backgroundColour);
	badMid.addActionListener (this);
	badMid.setActionCommand ("badMid");
	p4.add (badMid);
	badBig = new JButton (createImageIcon ("bigbad.png"));
	badBig.setPreferredSize (new Dimension (75, 75));
	badBig.setBackground (backgroundColour);
	badBig.addActionListener (this);
	badBig.setActionCommand ("badBig");
	p4.add (badBig);

	card5.add (title);
	card5.add (p);
	card5.add (p2);
	card5.add (p4);
	p_card.add ("5", card5);
    }


    public void winScreen ()
    { //tells players they won
	card6 = new Panel ();
	JButton next = new JButton (createImageIcon ("win.jpg"));
	next.setPreferredSize (new Dimension (350, 700));
	next.setActionCommand ("replay");
	next.addActionListener (this);
	card6.add (next);
	p_card.add ("6", card6);
    }


    public void lossScreen ()
    { //tells players they lost
	card7 = new Panel ();
	JButton next = new JButton (createImageIcon ("lose.jpg"));
	next.setPreferredSize (new Dimension (350, 700));
	next.setActionCommand ("replay");
	next.addActionListener (this);
	card7.add (next);
	p_card.add ("7", card7);
    }


    public boolean isValid (int x, int y)
    { //checks to see if piece is playable
	if (hiarchyBoard [x] [y] > hiarchy)
	    return false;
	else
	    return true;
    }


    public void flipTurn ()
    {
	if (turn == 'x')
	{
	    turn = 'o';
	    turnPic.setIcon (createImageIcon ("bigbad.png"));
	}
	else
	{
	    turn = 'x';
	    turnPic.setIcon (createImageIcon ("biggood.png"));
	}
    }


    public void pickPiece (String piece)
    {
	//switches to piece
	if (piece == ("gs"))
	{
	    goodPiece = ("smolgood.png");
	    gs--;
	    hiarchy = 1;
	}
	else if (piece == ("gm"))
	{
	    goodPiece = ("midgood.png");
	    gm--;
	    hiarchy = 2;
	}
	else if (piece == ("gb"))
	{
	    goodPiece = ("biggood.png");
	    gb--;
	    hiarchy = 3;
	}
	else if (piece == ("bs"))
	{
	    badPiece = ("smolbad.png");
	    bs--;
	    hiarchy = 1;
	}
	else if (piece == ("bm"))
	{
	    badPiece = ("midbad.png");
	    bm--;
	    hiarchy = 2;
	}
	else if (piece == ("bb"))
	{
	    badPiece = ("bigbad.png");
	    bb--;
	    hiarchy = 3;
	}
	else
	{
	}
	if (gs == 0)
	    goodSmol.setEnabled (false);
	if (gm == 0)
	    goodMid.setEnabled (false);
	if (gb == 0)
	    goodBig.setEnabled (false);
	if (bs == 0)
	    badSmol.setEnabled (false);
	if (bm == 0)
	    badMid.setEnabled (false);
	if (bb == 0)
	    badBig.setEnabled (false);
	enableBoard (true);
    }


    public void enableBoard (boolean value)
    {
	a.setEnabled (value);
	b.setEnabled (value);
	c.setEnabled (value);
	d.setEnabled (value);
	ee.setEnabled (value);
	f.setEnabled (value);
	g.setEnabled (value);
	h.setEnabled (value);
	i.setEnabled (value);
    }



    public void enablePiece (boolean value)
    {
	goodSmol.setEnabled (true);
	goodMid.setEnabled (true);
	goodBig.setEnabled (true);
	badSmol.setEnabled (true);
	badMid.setEnabled (true);
	badBig.setEnabled (true);
	enableBoard (true);
    }



    public void upDateSquare (int x, int y, JButton square)
    {
	//it makes a square switch
	if (turn == 'x')
	{
	    board [x] [y] = turn;
	    if (isValid (x, y) == true)
	    {
		hiarchyBoard [x] [y] = hiarchy;
		square.setIcon (createImageIcon (goodPiece));
		flipTurn ();
	    }
	}
	else
	{
	    board [x] [y] = turn;
	    if (isValid (x, y) == true)
	    {
		hiarchyBoard [x] [y] = hiarchy;
		square.setIcon (createImageIcon (badPiece));
		flipTurn ();
	    }
	}
	enableBoard (false);
    }


    public void win ()
    { //checks to see if someone has won
	if ((board [0] [0] == 'x') && (board [0] [1] == 'x') && (board [0] [2] == 'x')) //top line
	    cdLayout.show (p_card, "6");
	else if ((board [1] [0] == 'x') && (board [1] [1] == 'x') && (board [1] [2] == 'x')) //middle line
	    cdLayout.show (p_card, "6");
	else if ((board [2] [0] == 'x') && (board [2] [1] == 'x') && (board [2] [2] == 'x')) //bottom line
	    cdLayout.show (p_card, "6");
	else if ((board [0] [0] == 'x') && (board [1] [1] == 'x') && (board [2] [2] == 'x')) //right diag
	    cdLayout.show (p_card, "6");
	else if ((board [2] [0] == 'x') && (board [1] [1] == 'x') && (board [0] [2] == 'x')) //left diag
	    cdLayout.show (p_card, "6");
	else if ((board [0] [0] == 'x') && (board [1] [0] == 'x') && (board [2] [0] == 'x')) //left down
	    cdLayout.show (p_card, "6");
	else if ((board [0] [1] == 'x') && (board [1] [1] == 'x') && (board [2] [1] == 'x')) //middle down
	    cdLayout.show (p_card, "6");
	else if ((board [0] [2] == 'x') && (board [1] [2] == 'x') && (board [2] [2] == 'x')) //right down
	    cdLayout.show (p_card, "6");
	else if ((board [0] [0] == 'o') && (board [0] [1] == 'o') && (board [0] [2] == 'o')) //top line
	    cdLayout.show (p_card, "7");
	else if ((board [1] [0] == 'o') && (board [1] [1] == 'o') && (board [1] [2] == 'o')) //middle line
	    cdLayout.show (p_card, "7");
	else if ((board [2] [0] == 'o') && (board [2] [1] == 'o') && (board [2] [2] == 'o')) //bottom line
	    cdLayout.show (p_card, "7");
	else if ((board [0] [2] == 'o') && (board [1] [1] == 'o') && (board [2] [0] == 'o')) //right diag
	    cdLayout.show (p_card, "7");
	else if ((board [0] [0] == 'o') && (board [1] [1] == 'o') && (board [2] [2] == 'o')) //left diag
	    cdLayout.show (p_card, "7");
	else if ((board [0] [0] == 'o') && (board [1] [0] == 'o') && (board [2] [0] == 'o')) //left down
	    cdLayout.show (p_card, "7");
	else if ((board [0] [1] == 'o') && (board [1] [1] == 'o') && (board [2] [1] == 'o')) //middle down
	    cdLayout.show (p_card, "7");
	else if ((board [0] [2] == 'o') && (board [1] [2] == 'o') && (board [2] [2] == 'o')) //right down
	    cdLayout.show (p_card, "7");
    }


    public void reset ()
    {
	a.setIcon (createImageIcon ("b.png"));
	for (int i = 0 ; i < 3 ; i++)
	{
	    for (int j = 0 ; j < 3 ; j++)
	    {
		board [i] [j] = 'b';
		hiarchyBoard [i] [j] = 0;
	    }
	}
	gs = 2;
	gm = 2;
	gb = 2;
	bs = 2;
	bm = 2;
	bb = 2;
	a.setIcon (createImageIcon ("b.png"));
	b.setIcon (createImageIcon ("b.png"));
	c.setIcon (createImageIcon ("b.png"));
	d.setIcon (createImageIcon ("b.png"));
	ee.setIcon (createImageIcon ("b.png"));
	f.setIcon (createImageIcon ("b.png"));
	g.setIcon (createImageIcon ("b.png"));
	h.setIcon (createImageIcon ("b.png"));
	i.setIcon (createImageIcon ("b.png"));
	enableBoard (true);
	enablePiece (true);
    }


    public void actionPerformed (ActionEvent e)
    { //switches between screens
	if (e.getActionCommand ().equals ("1"))
	    cdLayout.show (p_card, "1");
	else if (e.getActionCommand ().equals ("2"))
	    cdLayout.show (p_card, "2");
	else if (e.getActionCommand ().equals ("3"))
	    cdLayout.show (p_card, "3");
	else if (e.getActionCommand ().equals ("4"))
	    cdLayout.show (p_card, "4");
	else if (e.getActionCommand ().equals ("5"))
	    cdLayout.show (p_card, "5");
	else if (e.getActionCommand ().equals ("6"))
	    cdLayout.show (p_card, "6");
	else if (e.getActionCommand ().equals ("7"))
	    cdLayout.show (p_card, "7");


	else if (e.getActionCommand ().equals ("date"))
	    date ();
	else if (e.getActionCommand ().equals ("Close"))
	    System.exit (0);

	//switches to screens in the game (menu)
	else if (e.getActionCommand ().equals ("reset"))
	    reset ();
	else if (e.getActionCommand ().equals ("replay"))
	{
	    cdLayout.show (p_card, "1");
	    reset ();
	}

	//chooses piece size
	else if (e.getActionCommand ().equals ("goodSmall"))
	{
	    pickPiece ("gs");
	}
	else if (e.getActionCommand ().equals ("goodMid"))
	{
	    pickPiece ("gm");
	}
	else if (e.getActionCommand ().equals ("goodBig"))
	{
	    pickPiece ("gb");
	}
	else if (e.getActionCommand ().equals ("badSmall"))
	{
	    pickPiece ("bs");
	}
	else if (e.getActionCommand ().equals ("badMid"))
	{
	    pickPiece ("bm");
	}
	else if (e.getActionCommand ().equals ("badBig"))
	{
	    pickPiece ("bb");
	}

	//changes pieces on board
	else
	{
	    if (e.getActionCommand ().equals ("a"))
		upDateSquare (0, 0, a);
	    else if (e.getActionCommand ().equals ("b"))
		upDateSquare (0, 1, b);
	    else if (e.getActionCommand ().equals ("c"))
		upDateSquare (0, 2, c);
	    else if (e.getActionCommand ().equals ("d"))
		upDateSquare (1, 0, d);
	    else if (e.getActionCommand ().equals ("ee"))
		upDateSquare (1, 1, ee);
	    else if (e.getActionCommand ().equals ("f"))
		upDateSquare (1, 2, f);
	    else if (e.getActionCommand ().equals ("g"))
		upDateSquare (2, 0, g);
	    else if (e.getActionCommand ().equals ("h"))
		upDateSquare (2, 1, h);
	    else if (e.getActionCommand ().equals ("i"))
		upDateSquare (2, 2, i);
	}
	win ();
    }




    protected static ImageIcon createImageIcon (String path)
    {
	java.net.URL imgURL = TicTacToeApp.class.getResource (path);
	if (imgURL != null)
	{
	    return new ImageIcon (imgURL);
	}
	else
	{
	    System.err.println ("Couldn't find file: " + path);
	    return null;
	}
    }
}



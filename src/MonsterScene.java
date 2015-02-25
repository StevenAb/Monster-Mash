import java.applet.Applet;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Graphics2D;
//name last
public class MonsterScene extends Applet implements KeyListener{
	private static final String Graphics2D = null;
	int ptCounter=0;
	int str1=1,str2=1,agi1=1,agi2=1,stm1=1,stm2=1;
	int x1 = 150;
	int y1 = 400;
	int x2 = 150;
	int y2 = 200;
	int x3 = 400;
	int y3 = 100;
	int k =0;
	int round=1;
    boolean arm1=false,arm2=false,wep1=false,wep2=false,j1=false,j2=false;
	Monster m1;
	Monster m2;
	String result ="";
	boolean main=false;
	boolean help=false;
	boolean char1=false;
	boolean char2=false;
	boolean start=true;
	boolean end = false;
	public void init(){
		setSize(1200,800);
		//Color(Color.BLACK);
		addKeyListener(this);
		setFocusable(true);
	}
	public void paint(Graphics g)
	{
		Graphics2D g2d = (Graphics2D)g;
		Font font = new Font("Arial", Font.BOLD, 75);
		if(!main)
		{
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, 1200, 800);
		}
		if(start)
		{
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, 1200, 800);
	
			g.setColor(Color.LIGHT_GRAY);
			g2d.setFont(font);
			g.drawString("MONSTER MASH", x1+140, y1-125);
	
			g.setColor(Color.RED);
			g2d.setFont(font);
			g.drawString("PRESS SPACE TO START", x1, y1);
	
			g.setColor(Color.BLUE);
			Font font2 = new Font("Arial", Font.BOLD, 50);
			g2d.setFont(font2);
			g.drawString("PRESS 0 FOR HELP", x1+200, y1+75);
		}
		if(k==48&&start){
			start=false;
			help=true;
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, 1200, 800);

			g.setColor(Color.YELLOW);
			Font font4 = new Font("Arial", Font.BOLD, 40);
			g2d.setFont(font4);
			g.drawString("You are given 5 points to level up the following skills", x2-100, y2-50);

			g.setColor(Color.GREEN);
			Font font3 = new Font("Arial", Font.BOLD, 25);
			g2d.setFont(font3);

			g.drawString("�Strength - Increases base damage by 5% and increases critical strike chance by 10%", x2-50, y2);	
			g.drawString("Critical strikes do 150% of base damage", x2, y2+35);
			g.drawString("�Agility - Increases chance of dodging enemy attacks by 4%", x2-50, y2+70);
			g.drawString("Dodging makes your monster take no damage", x2, y2+105);
			g.drawString("�Stamina - Increases base health by 25 and increases damage reduction chance by 10%", x2-50, y2+140);
			g.drawString("Reduction of total damage by 5% per point", x2, y2+175);

			g.setColor(Color.CYAN);
			Font font5 = new Font("Arial", Font.BOLD, 35);
			g2d.setFont(font5);
			g.drawString("Each skill starts off with 1 point and caps at 5 points per skill", x2-100, y2+275);

			g.setColor(Color.MAGENTA);
			Font font6 = new Font("Arial", Font.BOLD, 30);
			g2d.setFont(font6);
			g.drawString("After you and your opponent assigns points, your monsters will ", x2-100, y2+325);
			g.drawString("fight each other in the arena", x2-50, y2+365);

			g.setColor(Color.WHITE);
			Font font7 = new Font("Arial", Font.BOLD, 40);
			g2d.setFont(font7);
			g.drawString("MAY THE BEST MONSTER WIN", x2+110, y2+420+50);
			g.drawString("PRESS SPACE TO START", x2+165, y2+480+50);
		} else if (k == 32&&(start||help)){
			start = false;
			char1=true;
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, 1200, 800);
			
			g.setColor(Color.RED);
			g2d.setFont(font);
			g.drawString("PLAYER 1", x3, y3);
			
			Font font3 = new Font("Arial", Font.BOLD, 25);
			g2d.setFont(font3);
			g.drawString("1:\tSTRENGTH", x3-300, y3+100);
			g.drawString("2:\tAGILITY", x3-300, y3+300);
			g.drawString("3:\tSTAMINA", x3-300, y3+500);
			
		}else if (k==49&&char1)
		{
			if(ptCounter<5&&str1<=5)
			{
                ptCounter++;
				str1++;
			}else if (ptCounter==5){
				char1=false;
				char2=true;
				ptCounter=0;
			}
		}else if (k==50&&char1)
		{
			if(ptCounter<5&&agi1<=5)
			{
                ptCounter++;
				agi1++;
			}else if (ptCounter==5){
				char1=false;
				char2=true;
				ptCounter=0;
			}
		}else if (k==51&&char1)
		{
			if(ptCounter<5&&stm1<=5)
			{
                ptCounter++;
				stm1++;
			}else if (ptCounter==5){
				char1=false;
				char2=true;
				ptCounter=0;
			}
		}else if (k==52&&char1)
        {
            if(ptCounter<5&&arm1==false)
            {
                ptCounter++;
                stm1+=3;
                arm1=true;
            }else if (ptCounter==5) {
                char1 = false;
                char2 = true;
                ptCounter = 0;
            }
        }else if (k==53&&char1)
        {
            if (ptCounter < 5 && wep1==false)
            {
                ptCounter++;
                str1 += 3;
                wep1 = true;
            } else if (ptCounter == 5) {
                char1 = false;
                char2 = true;
                ptCounter = 0;
            }
        }else if (k==54&&char1)
        {
            if (ptCounter < 5 && j1==false)
            {
                ptCounter++;
                agi1+=3;
                j1=true;
            } else if (ptCounter == 5) {
                char1 = false;
                char2 = true;
                ptCounter = 0;}
        }else if (k==49&&char2)
		{
			if(ptCounter<5&&str2<=5)
			{
                ptCounter++;
				str2++;
			}else if (ptCounter==5){
				char2=false;
				main=true;
				
			}
		}else if (k==50&&char2)
		{
			if(ptCounter<5&&agi2<=5)
			{
                ptCounter++;
				agi2++;
			}else if (ptCounter==5){
				char2=false;
				main=true;
				
			}
		}else if (k==51&&char2)
		{
			if(ptCounter<5&&stm2<=5)
			{
                ptCounter++;
				stm2++;
			}else if (ptCounter==5){
				char2=false;
				main=true;
				
			}
		}else if (k==52&&char2)
        {
            if(ptCounter<5&&arm2==false)
            {
                ptCounter++;
                stm2+=3;
                arm2=true;
            }else if (ptCounter==5) {
                char2=false;
                main=true;
            }
        }else if (k==53&&char2)
        {
            if (ptCounter < 5 && wep2==false)
            {
                ptCounter++;
                str2 += 3;
                wep2 = true;
            } else if (ptCounter == 5) {
                char2=false;
                main=true;
            }
        }else if (k==54&&char2)
        {
            if (ptCounter < 5 && j2==false)
            {
                ptCounter++;
                agi2+=3;
                j2=true;
            } else if (ptCounter == 5) {
                char2=false;
                main=true;}
        }if (main)
		{
			declare();
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, 1200, 800);
			
			g.setColor(Color.RED);
			g.fillRect(50, 100, 500, 50);
			g.fillRect(650, 100, 500, 50);
			g.setColor(Color.white);
			g.fillOval(188, 193,75, 75);
			g.fillOval(150, 250,150, 150);
			g.fillOval(100, 375,250, 250);
			Graphics2D g2 = (Graphics2D) g;
			g2.setStroke(new BasicStroke (10));
			g.drawLine(225, 300, 425, 325);
			g.drawLine(225, 300, 25, 325);
			g.setColor(Color.black);
			g.fillOval(210,215,10,10);
			g.fillOval(240,215,10,10);
			int x=225;
			int y=275;
			for(int i=0;i<12;i++)
			{
				g.fillOval(x, y, 10, 10);
				y+=25;
			}
			
			g.setColor(Color.red);
			g.fillOval(785, 325, 215, 65);
			g.fillOval(900, 183,100, 100);
			g.fillOval(850, 250,200, 350);			
			g.setColor(Color.black);
			g.fillOval(910,215,10,10);
			g.fillOval(930,215,10,10);
			g.setColor(Color.ORANGE);
			g.fillOval(850, 300, 125, 250);
			g.setColor(Color.red);
			g.fillOval(825, 375, 220, 75);
			
			
			

			
			
			g.setColor(Color.WHITE);
			Font font9 = new Font("Arial", Font.BOLD, 50);
			g2d.setFont(font9);
			g.drawString("ROUND", 510, 75);
			g.drawString("Monster 1", 50, 75);
			g.drawString("Monster 2", 900, 75);
			
			
			
			
			String a ="Monster:"+m1.getName()+" has lost";
			String b="Monster:"+m2.getName()+" has lost";
			String c="DRAW";
			while ((!m1.getDead()&&!m2.getDead())&&k==39)
			{
				String round1 = String.valueOf(round);
				g.drawString(round1, 585, 140);
				round++;
				Font fightin = new Font("Arial", Font.BOLD, 15);
				g2d.setFont(fightin);
				result = m1.fight(m2);	
				if(m1.getDead()||m2.getDead())
				{
					main = false;
					end = true;
					g.setColor(Color.BLACK);
					g.fillRect(0, 0, 1200, 800);
					g.setColor(Color.BLACK);
					g.fillRect(0, 0, 1200, 800);
					g.setColor(Color.RED);
					g2d.setFont(font);
					String f = "";
					if(m1.getDead())
					{
						g.drawString("Monster 1 has died", x1+100, y1);
					}else if (m2.getDead())
					{
						g.drawString("Monster 2 has died", x1+100, y1);
					}
					System.out.println(25);
					
					break;
				}
				
				g.drawString(result.substring(0, result.lastIndexOf("M")-1), 50, 700);
				g.drawString(result.substring(result.lastIndexOf("M")), 50, 725);
				//double dmgTaken = (m1.getHealthRemaining()/500.0)-(m1.getDD()/500.0);
				//System.out.println(dmgTaken);
				double temp = m1.getMaxHealth()/500;
				double temp2 = m2.getMaxHealth()/500;
				int healthbar1=(int) (m1.getMaxHealth()*temp);
				int rHealthbar1=(int)(500/((m1.getMaxHealth()/ (m1.getHealthRemaining()*1.0))));
				int rHealthbar2=(int)(500/((m2.getMaxHealth()/ (m2.getHealthRemaining()*1.0))));
				g.setColor(Color.BLUE);
				g.fillRect(50, 100, rHealthbar1, 50);
				g.fillRect(650, 100, rHealthbar2, 50);
				k=0;
			
			}
				
		}
		if(char1)
		{
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, 1200, 800);
			
			g.setColor(Color.RED);
			g2d.setFont(font);
			g.drawString("MONSTER 1", x3, y3);
			
			Font font3 = new Font("Arial", Font.BOLD, 25);
			g2d.setFont(font3);
			g.drawString("1:\tSTRENGTH", x3-300, y3+100);
			g.drawString("2:\tAGILITY", x3-300, y3+300);
			g.drawString("3:\tSTAMINA", x3-300, y3+500);
			
			g.fillRect(x3-75, y3+160, 500, 50);
			g.fillRect(x3-75, y3+360, 500, 50);
			g.fillRect(x3-75, y3+560, 500, 50);
			
			g.setColor(Color.BLACK);
			if(str1==1&&char1)
			{
				g.setColor(Color.BLACK);
				g.fillRect(x3+25, y3+160, 400, 50);
				g.setColor(Color.RED);
				String strValue1 = String.valueOf(str1);
				g.drawString(strValue1+"/5", x3+425, y3+200);
			}else if(str1==2&&char1)
			{
				g.setColor(Color.BLACK);
				g.fillRect(x3+125, y3+160, 300, 50);
				g.setColor(Color.RED);
				String strValue1 = String.valueOf(str1);
				g.drawString(strValue1+"/5", x3+425, y3+200);
			}else if(str1==3&&char1)
			{
				g.setColor(Color.BLACK);
				g.fillRect(x3+225, y3+160, 200, 50);
				g.setColor(Color.RED);
				String strValue1 = String.valueOf(str1);
				g.drawString(strValue1+"/5", x3+425, y3+200);
			}else if(str1==4&&char1)
			{
				g.setColor(Color.BLACK);
				g.fillRect(x3+325, y3+160, 100, 50);
				g.setColor(Color.RED);
				String strValue1 = String.valueOf(str1);
				g.drawString(strValue1+"/5", x3+425, y3+200);
			}
			if(agi1==1&&char1)
			{
				g.setColor(Color.BLACK);
				g.fillRect(x3+25, y3+360, 400, 50);
				g.setColor(Color.RED);
				String agiValue1 = String.valueOf(agi1);
				g.drawString(agiValue1+"/5", x3+425, y3+400);
			}else if(agi1==2&&char1)
			{
				g.setColor(Color.BLACK);
				g.fillRect(x3+125, y3+360, 300, 50);
				g.setColor(Color.RED);
				String agiValue1 = String.valueOf(agi1);
				g.drawString(agiValue1+"/5", x3+425, y3+400);
			}else if(agi1==3&&char1)
			{
				g.setColor(Color.BLACK);
				g.fillRect(x3+225, y3+360, 200, 50);
				g.setColor(Color.RED);
				String agiValue1 = String.valueOf(agi1);
				g.drawString(agiValue1+"/5", x3+425, y3+400);
			}else if(agi1==4&&char1)
			{
				g.setColor(Color.BLACK);
				g.fillRect(x3+325, y3+360, 100, 50);
				g.setColor(Color.RED);
				String agiValue1 = String.valueOf(agi1);
				g.drawString(agiValue1+"/5", x3+425, y3+400);
			}
			if(stm1==1&&char1)
			{
				g.setColor(Color.BLACK);
				g.fillRect(x3+25, y3+560, 400, 50);
				g.setColor(Color.RED);
				String stmValue1 = String.valueOf(stm1);
				g.drawString(stmValue1+"/5", x3+425, y3+600);
			}else if(stm1==2&&char1)
			{
				g.setColor(Color.BLACK);
				g.fillRect(x3+125, y3+560, 300, 50);
				g.setColor(Color.RED);
				String stmValue1 = String.valueOf(stm1);
				g.drawString(stmValue1+"/5", x3+425, y3+600);
			}else if(stm1==3&&char1)
			{
				g.setColor(Color.BLACK);
				g.fillRect(x3+225, y3+560, 200, 50);
				g.setColor(Color.RED);
				String stmValue1 = String.valueOf(stm1);
				g.drawString(stmValue1+"/5", x3+425, y3+600);
			}else if(stm1==4&&char1)
			{
				g.setColor(Color.BLACK);
				g.fillRect(x3+325, y3+560, 100, 50);
				g.setColor(Color.RED);
				String stmValue1 = String.valueOf(stm1);
				g.drawString(stmValue1+"/5", x3+425, y3+600);
			}
		}
		if(char2)
		{
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, 1200, 800);
			
			g.setColor(Color.RED);
			g2d.setFont(font);
			g.drawString("MONSTER 2", x3, y3);
			
			Font font3 = new Font("Arial", Font.BOLD, 25);
			g2d.setFont(font3);
			g.drawString("1:\tSTRENGTH", x3-300, y3+100);
			g.drawString("2:\tAGILITY", x3-300, y3+300);
			g.drawString("3:\tSTAMINA", x3-300, y3+500);
			
			g.fillRect(x3-75, y3+160, 500, 50);
			g.fillRect(x3-75, y3+360, 500, 50);
			g.fillRect(x3-75, y3+560, 500, 50);
			
			g.setColor(Color.BLACK);
			if(str2==1&&char2)
			{
				g.setColor(Color.BLACK);
				g.fillRect(x3+25, y3+160, 400, 50);
				g.setColor(Color.RED);
				String strValue2 = String.valueOf(str2);
				g.drawString(strValue2+"/5", x3+425, y3+200);
			}else if(str2==2&&char2)
			{
				g.setColor(Color.BLACK);
				g.fillRect(x3+125, y3+160, 300, 50);
				g.setColor(Color.RED);
				String strValue2 = String.valueOf(str2);
				g.drawString(strValue2+"/5", x3+425, y3+200);
			}else if(str2==3&&char2)
			{
				g.setColor(Color.BLACK);
				g.fillRect(x3+225, y3+160, 200, 50);
				g.setColor(Color.RED);
				String strValue2 = String.valueOf(str2);
				g.drawString(strValue2+"/5", x3+425, y3+200);;
			}else if(str2==4&&char2)
			{
				g.setColor(Color.BLACK);
				g.fillRect(x3+325, y3+160, 100, 50);
				g.setColor(Color.RED);
				String strValue2 = String.valueOf(str2);
				g.drawString(strValue2+"/5", x3+425, y3+200);
			}
			if(agi2==1&&char2)
			{
				g.setColor(Color.BLACK);
				g.fillRect(x3+25, y3+360, 400, 50);
				g.setColor(Color.RED);
				String agiValue2 = String.valueOf(agi2);
				g.drawString(agiValue2+"/5", x3+425, y3+400);
			}else if(agi2==2&&char2)
			{
				g.setColor(Color.BLACK);
				g.fillRect(x3+125, y3+360, 300, 50);
				g.setColor(Color.RED);
				String agiValue2 = String.valueOf(agi2);
				g.drawString(agiValue2+"/5", x3+425, y3+400);
			}else if(agi2==3&&char2)
			{
				g.setColor(Color.BLACK);
				g.fillRect(x3+225, y3+360, 200, 50);
				g.setColor(Color.RED);
				String agiValue2 = String.valueOf(agi2);
				g.drawString(agiValue2+"/5", x3+425, y3+400);
			}else if(agi2==4&&char2)
			{
				g.setColor(Color.BLACK);
				g.fillRect(x3+325, y3+360, 100, 50);
				g.setColor(Color.RED);
				String agiValue2 = String.valueOf(agi2);
				g.drawString(agiValue2+"/5", x3+425, y3+400);
			}
			if(stm2==1&&char2)
			{
				g.setColor(Color.BLACK);
				g.fillRect(x3+25, y3+560, 400, 50);
				g.setColor(Color.RED);
				String stmValue2 = String.valueOf(stm2);
				g.drawString(stmValue2+"/5", x3+425, y3+600);
			}else if(stm2==2&&char2)
			{
				g.setColor(Color.BLACK);
				g.fillRect(x3+125, y3+560, 300, 50);
				g.setColor(Color.RED);
				String stmValue2 = String.valueOf(stm2);
				g.drawString(stmValue2+"/5", x3+425, y3+600);
			}else if(stm2==3&&char2)
			{
				g.setColor(Color.BLACK);
				g.fillRect(x3+225, y3+560, 200, 50);
				g.setColor(Color.RED);
				String stmValue2 = String.valueOf(stm2);
				g.drawString(stmValue2+"/5", x3+425, y3+600);
			}else if(stm2==4&&char2)
			{
				g.setColor(Color.BLACK);
				g.fillRect(x3+325, y3+560, 100, 50);
				g.setColor(Color.RED);
				String stmValue2 = String.valueOf(stm2);
				g.drawString(stmValue2+"/5", x3+425, y3+600);
			}
		}
	}
	

	//	public static void main(String args[]){
	//		Scanner sc = new Scanner(System.in);
	//		System.out.println("What is Player 1 Monster's name?");
	//		String Monster1 = sc.next();
	//		int srtChoice;
	//		System.out.println("Player 1, how many points do you want to put in the following skills?");
	//		if(srtChoice == 2){
	//			
	//			System.out.println("Strength (Increases base damage and increases critical strike chance)");
	//			System.out.println("Agility (Increases chance of dodging enemy attacks)");
	//			System.out.println("Stamina (Increases base health and increases damage reduction chance)");
	//		}
	//	}
	//	Monster p1 =  new Monster()

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		k=e.getKeyCode();
		if(k==48||k==32||k==49||k==50||k==51||k==39)
		repaint();
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	public void declare()
	{
		if(m1==null){
		m1=new Monster (str1,stm1,agi1,"Player 1");
		m2= new Monster (str2,stm2,agi2,"Player 2");
		}
	}
}
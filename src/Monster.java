import java.util.Random;
public class Monster {
// create the monsters stats and information
	//bool for crit dodge and block
	//string for fight to return what happens 
	private int maxHealth,str,stm,agi,healthRemaining,damageDealt;
	private String name;
	private boolean dead,fiery,onFire,poisoner,poisoned,icy,iced,shocky,shocked;
	public  Monster(int str, int stm, int agi, boolean fire, boolean poison, boolean ice, boolean shock, String name )
	{
		this.maxHealth=(500+(stm*25));
		this.healthRemaining=maxHealth;
		this.str=(50+(5*str));
		this.stm=stm;//calculates damage reduction chances
		this.agi=agi;//calculates dodge chances
		this.name= name;
		this.damageDealt=0;
		dead=false;
		fiery=fire;
		poisoner=poison;
		icy=ice;
		shocky=shock;
		
	}
	/**
	 * 
	 * @param other
	 * @return both monsters healths and damage taken (addt. info 
	 * @return crit or not dodge or not damage reduced or not 
	 */
	public int getHealthRemaining()
	{
		return this.healthRemaining;
	}
	public int str()
	{
		return this.str;
	}
	public int agi ()
	{
		return this.agi;
	}
	public int sta ()
	{
		return this.sta();
	}
	public int getMaxHealth ()
	{
		return this.maxHealth;
	}
	public  String fight(Monster other)
	{
		this.onFire=this.onFire(other);
		other.onFire=other.onFire(this);
		poisoned=this.poisoned(other);
		other.poisoned=other.poisoned(this);
		this.iced=this.iced(other);
		other.iced=other.iced(this);
		this.shocked=this.shocked(other);
		other.shocked=other.shocked(this);
		String aTotal = "";
		String bTotal = "";
		boolean crita=this.crit(this.str);
		if (crita)
			aTotal+=(this.getName()+" crit " + other.getName()+", " );
		else
			aTotal+=(this.getName()+" did not crit "+ other.getName()+", ");
		
		boolean reducta=this.reduct(this.stm);
		if (reducta)
			aTotal+=("and reduced " + other.getName()+"'s damage, " );
		else
			aTotal+=("and did not reduce "+ other.getName()+"'s damage, ");
		boolean dodgea=this.dodge(this.agi);
		if (dodgea)
			aTotal=(this.getName()+" dodged " + other.getName()+", " );
		else
			aTotal+=("did not dodge "+ other.getName()+", ");
		
		boolean critb=other.crit(other.str);
		if (critb)
			bTotal+=(other.getName()+" crit " + this.getName()+", " );
		else
			bTotal+=(other.getName()+" did not crit "+ this.getName()+", ");
		
		boolean reductb=other.reduct(other.stm);
		if (reductb)
			bTotal+=("and reduced " + this.getName()+"'s damage, " );
		else
			bTotal+=("and did not reduce "+ this.getName()+"'s damage, ");
		boolean dodgeb=other.dodge(other.agi);
		if (dodgeb)
			bTotal=(other.getName()+" dodged " + this.getName()+", " );
		else
			bTotal+=("did not dodge "+ this.getName()+", ");
		
		this.healthRemaining-=this.healthLost(other, critb, dodgea, reducta);
		aTotal+= "and has "+this.healthRemaining+" health remaining ";
		other.healthRemaining-=other.healthLost(this, crita, dodgeb, reductb);
		bTotal+= "and has "+other.healthRemaining+" health remaining ";
		int thisLost =this.healthLost(other, critb, dodgea, reducta);
		aTotal+="and lost "+thisLost+" health";
		int otherLost=other.healthLost(this, crita, dodgeb, reductb);
		bTotal+="and lost "+otherLost+" health";
		String Total="Monster 1's stats: "+aTotal+"\nMonster 2's stats: "+bTotal;
		if(this.healthRemaining<=0||other.healthRemaining<=0)
		{
			
			if(this.healthRemaining<=0)
			{
				this.dead=true;
				return "Monster:"+this.getName()+" has lost";
			}
			if(other.healthRemaining<=0)
				{other.dead=true;
				return "Monster:"+other.getName()+" has lost";}
			if(this.healthRemaining<=0&&other.healthRemaining==0)
			{
				//while((m1.getHealthRemaining() >0||m2.getHealthRemaining()> 0)&& k==39){
				return "DRAW";
			}
			
		}
		return Total;
	}
	private boolean reduct(int stm) {
		Random r=new Random();
		int chance = r.nextInt(10);
		if (chance<=stm)
			return true;
		else 
		return false;
	}
	private boolean dodge(int agi) {
		Random r=new Random();
		int chance = r.nextInt(30);
		if (chance<=agi)
			return true;
		else 
		return false;
		
	}
	private boolean crit(int str) {
		Random r=new Random();
		int chance = r.nextInt(10);
		if (chance<=((int)((str-50)/5)))
			return true;
		else 
		return false;
		
	}
	private int healthLost(Monster other,boolean ecrit,boolean mdodge, boolean mreduct)
	{
		float damage=other.str;
		if (mdodge)
		{
			this.damageDealt=0;
			return 0;
		}
		else if (ecrit)
		{
			damage = (int)(other.str*1.5);
			if (mreduct)
			{
				float temp = this.stm*5;
				damage -= (damage*(temp/100));
				damageDealt=(int) damage;
				return (int) damage;
			}else
				damageDealt=(int) damage;
				return (int) damage;
		}else if (mreduct)
		{
			float temp = this.stm*5;
			damage-=(other.str*(temp/100));
			damageDealt=(int) damage;
			return (int) damage;
		}else
			damageDealt=(int) damage;
		damage=str;
		return (int) damage;
	}
	public String getName()
	{
		return this.name;
	}
	public int getDD()
	{
		return damageDealt;
	}
	public boolean getDead(){
		return dead;
	}
	public boolean onFire(Monster enemyMonster)
	{
		if(enemyMonster.fiery)return true;
		else return false;
	}
	public boolean poisoned(Monster enemyMonster)
	{
		if(enemyMonster.poisoner)return true;
		else return false;
	}public boolean iced(Monster enemyMonster)
	{
		if(enemyMonster.icy)return true;
		else return false;
	}public boolean shocked(Monster enemyMonster)
	{
		if(enemyMonster.shocky)return true;
		else return false;
	}
	
}



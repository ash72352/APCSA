package Unit15;

interface Collidable 
{
	
	public boolean didCollideLeft(Object obj);
	public boolean didCollideRight(Object obj);
	public boolean didCollideTop(Object obj);
	public abstract boolean didCollideBottom(Object obj);
	public boolean didCollideWall(Object obj, Wall w);
	
}

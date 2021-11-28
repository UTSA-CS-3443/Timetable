package application;

public class Notifier implements Runnable
{
	private Thread t;
	@Override
	public void run() 
	{
		
	}
	
	public void start()
	{
		if (t == null)
		{
			t = new Thread(this);
			t.start();
		}
	}
}

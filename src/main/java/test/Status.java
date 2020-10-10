package test;

public enum Status {
	
	READY,COMPLETE(true),ERROR(true);
	boolean endState=false;
	private Status() {
		// TODO Auto-generated constructor stub
	}
	Status(boolean isEndState)
	{
		this.endState=isEndState;
	}
	public boolean isEndState()
	{
		return this.endState;
	}
}

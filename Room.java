/**
*
*Room class for CPSC 101 final project
*
*@author Scott Howes
*@version 03/03/2016
*
*/



public class Room
{

	//class variable(s)
	private int roomNum = 0;
	private int buildingNum = 0;
	private String buildingID = ""; 


	//constructor takes the full room number including
	//the building number and room number ie) 8-2030
	public Room( String fullRoomNum )
	{
		String[] roomLocation = fullRoomNum.split("-");

		this.buildingNum = Integer.parseInt( roomLocation[0] );
		this.roomNum = Integer.parseInt( roomLocation[1] );
	}


	//this constructor for if the building ID is to be included ie) AGO, LIB, TAL
	public Room( String buildingID, String fullRoomNum )
	{
		String[] roomLocation = fullRoomNum.split("-");

		this.buildingID = buildingID;
		this.buildingNum = Integer.parseInt( roomLocation[0] );
		this.roomNum = Integer.parseInt( roomLocation[1] );
	}


	//for manually setting the building ID
	public void setBuildingID( String ID )
	{
		this.buildingID = buildingID;
	}


	//for getting the buildingID
	public String getBuildingID()
	{
		return buildingID;
	}


	//for manually setting the building number
	public void setBuildingNum( int buildingNum )
	{
		this.buildingNum = buildingNum;
	} 


	//for getting the building number
	public int getBuildingNum()
	{
		return buildingNum;
	}


	//for manually setting the Room Number
	public void setRoomNum( int roomNum )
	{
		this.roomNum = roomNum;
	}


	//for getting the room number
	public int getRoomNum()
	{
		return roomNum;
	}


	//returns the full room number as a string
	//if the building ID was assigned in the constructor then it will display
	public String getFullRoomNum()
	{
		if( buildingID == "" )
		{
			return buildingNum + "-" + roomNum;
		}
		else
		{
			return buildingID + " " + buildingNum + "-" + roomNum;
		}
	}


	//toString returns the the full room number
	//if the building ID was assigned in the constructor then it will display
	public String toString()
	{
		if( buildingID == "" )
		{
			return buildingNum + "-" + roomNum;
		}
		else
		{
			return buildingID + " " + buildingNum + "-" + roomNum;
		}

	}

}
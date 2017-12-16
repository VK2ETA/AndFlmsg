/*
 * config.java  
 *
 * Copyright (C) 2011 John Douyere (VK2ETA) 
 *
 * This program is distributed in the hope that it will be useful,  
 * but WITHOUT ANY WARRANTY; without even the implied warranty of  
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the  
 * GNU General Public License for more details.  
 *
 * You should have received a copy of the GNU General Public License  
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.  
 */

package com.AndFlmsg;

import android.content.SharedPreferences;

public class config {



	/**
	 * 
	 * @param Key
	 * @return
	 */
	public static String getPreferenceS(String Key) {
		String myReturn="";

		try {
			myReturn = AndFlmsg.mysp.getString(Key,"");
		}
		catch (Exception e) {
			myReturn = "";
		}
		return myReturn;
	}

	/**
	 * Get the saved value, if its not there then use the default value
	 * @param Key
	 * @param Default
	 * @return
	 */
	public static String getPreferenceS(String Key, String Default) {
		String myReturn="";

		try {
			myReturn = AndFlmsg.mysp.getString(Key, Default);
			//if (myReturn.equals("")) myReturn = Default;
		}
		catch (Exception e) {
			myReturn = Default;
		}
		return myReturn;
	}

	//Reads an integer from preferences, with default value
	public static int getPreferenceI(String Key, int Default) {
		int myReturn = 0;
		String myPref ="";

		try {
			myPref = AndFlmsg.mysp.getString(Key, "");
			if (myPref.equals("")) {
				myReturn = Default;
			} else {
				//Try integer conversion
				try {
					myReturn = Integer.parseInt(myPref);
				} catch (NumberFormatException ex) {
					//Return zero is probably the best logic here since we cannot interract with the user anyway
					loggingclass.writelog("Cannot convert preference [" + Key + "] to a number" + ex.getMessage(),
							null, true);
					myReturn = 0;
				}
			}
		}
		catch (Exception e) {
			myReturn = Default;
		}
		return myReturn;
	}

	//Reads a double from preferences, with default value
	public static double getPreferenceD(String Key, double Default) {
		double myReturn = 0;
		String myPref ="";

		try {
			myPref = AndFlmsg.mysp.getString(Key,"");
			if (myPref.equals("")) {
				myReturn = Default;
			} else {
				//Try double conversion
				try {
					myReturn = Double.parseDouble(myPref);
				} catch (NumberFormatException ex) {
					//Return zero is probably the best logic here since we cannot interract with the user anyway
					loggingclass.writelog("Cannot convert preference [" + Key + "] to a number" + ex.getMessage(),
							null, true);
					myReturn = 0.0f;
				}
			}
		}
		catch (Exception e) {
			//No value entered or no preference not found
			myReturn = Default;
		}
		return myReturn;
	}


	/**
	 * 
	 * @param Key
	 * @return
	 */
	public static boolean getPreferenceB(String Key) {
		boolean myReturn = false;

		try {
			myReturn = AndFlmsg.mysp.getBoolean(Key,false);
		}
		catch (Exception e) {
			myReturn = false;
		}
		return myReturn;
	}

	/**
	 * Get the saved value, if its not there then use the default value
	 * @param Key
	 * @param Default
	 * @return
	 */
	public static boolean getPreferenceB(String Key, boolean Default) {
		boolean myReturn = false;

		try {
			myReturn = AndFlmsg.mysp.getBoolean(Key, Default);
		}
		catch (Exception e) {
			myReturn = Default;
		}

		return myReturn;
	}


	/**
	 * Sets the passes value into the assed preference Key, if its not there do nothing
	 * @param key
	 * @param Default
	 * @return
	 */
	public static Boolean setPreferenceS(String key, String newValue) {
		Boolean myReturn = true;

		try {
			//store value into preferences
			SharedPreferences.Editor editor = AndFlmsg.mysp.edit();
			editor.putString(key, newValue);
			// Commit the edits!
			editor.commit();
		}
		catch (Exception e) {
			myReturn = false;
		}
		return myReturn;
	}

	

	//For storing Boolean preferences
	public static boolean setPreferenceB(String pref, boolean flag) {
		Boolean myReturn = true;
		try {
		//store value into preferences
		SharedPreferences.Editor editor = AndFlmsg.mysp.edit();
		editor.putBoolean(pref, flag);
		// Commit the edits!
		editor.commit();
		}
		catch (Exception e) {
			myReturn = false;
		}
		return myReturn;
	}


	
}


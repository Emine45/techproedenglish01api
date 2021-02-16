package techproedenglish01.techproedenglish01api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

  /*
	   POJO: Plain old Java Object
	   We will create pojo Classes by using our Json Format tehn
	   We will create object from Pojo Classes and use the, in test scripts
	   
	   POJO Classes have 1)private variable    2)getter() and setter()   3)Constructor with all parameters
	                     4)Constructor without parameter   5) toString() 
	 */

public class Bookingdates {

	@SerializedName("checkin")
	@Expose
	private String checkin;
	@SerializedName("checkout")
	@Expose
	private String checkout;
	
	public String getCheckin() {
		return checkin;
	}
	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}
	public String getCheckout() {
		return checkout;
	}
	public void setCheckout(String checkout) {
		this.checkout = checkout;
    }
	public Bookingdates(String checkin, String checkout) {
		this.checkin = checkin;
		this.checkout = checkout;
	}
	public Bookingdates() {

	}
	@Override
	public String toString() {
		return "Bookingdates [checkin=" + checkin + ", checkout=" + checkout + "]";
	}

}
package com.buddy.admin.export.service;

public class CommonUtil {

	public static String getPinCode(String input) {
		input = "No 5,bangalore,karnataka 56088";
		String pincode = null;
		if (null != input && "" != input) {
			pincode = input.substring(input.lastIndexOf(" ") + 1);
			if (isInteger(pincode)) {
				System.out.println(pincode);
			} else {
				System.out.println("OOPS");
			}

		}

		return pincode;
	}

	public static boolean isInteger(String pin) {
		try {
			System.out.println("#PIN ********** " + pin);
			Integer.parseInt(pin);
			return true;
		} catch (NumberFormatException ex) {
			System.err.println(ex.getMessage());
			return false;
		}
	}
}

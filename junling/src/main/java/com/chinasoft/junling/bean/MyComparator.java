package com.chinasoft.junling.bean;

import java.util.Comparator;

public class MyComparator implements Comparator{

	@Override
	public int compare(Object arg0, Object arg1) {
		if (arg0 instanceof Books && arg1 instanceof Books) {  
			Books b1 = (Books) arg0;  
			Books b2 = (Books) arg1;  
            return b2.getbClicks() - b1.getbClicks();
		}
		return 0;
	}
}

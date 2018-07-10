/**
 * 
 */
package com.mindtree.comparator;

import java.util.Comparator;

import com.mindtree.model.Hotel;

/**
 * @author Ashutosh
 *
 */
public class HotelComparator implements Comparator<Hotel> {

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */

	@Override
	public int compare(Hotel o1, Hotel o2) {
		return Double.compare(o1.getTariff(), o2.getTariff());
	}

}

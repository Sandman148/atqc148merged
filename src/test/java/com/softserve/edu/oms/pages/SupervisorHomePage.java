package com.softserve.edu.oms.pages;

import com.softserve.edu.atqc.controls.ILink;
import com.softserve.edu.atqc.controls.Link;

/**
 * @author Andrew
 *
 */
public class SupervisorHomePage extends HomePage {
	private class SupervisorHomePageUIMap {
		public final ILink itemManagementTab;

		public SupervisorHomePageUIMap() {
			this.itemManagementTab = Link
					.getByPartialLinkText("Item Management");
		}
	}
	
	// Elements
		private SupervisorHomePageUIMap controls;

		public SupervisorHomePage() {
			super();
			this.controls = new SupervisorHomePageUIMap();
		}

		// getters

		public ILink getItemManagementTab() {
			return this.controls.itemManagementTab;
		}

		// setters

		public void itemManagementTabClick() {
			this.controls.itemManagementTab.click();
		}

}

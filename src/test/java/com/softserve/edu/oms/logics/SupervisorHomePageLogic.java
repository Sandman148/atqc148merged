package com.softserve.edu.oms.logics;

import com.softserve.edu.oms.pages.ItemManagementPage;
import com.softserve.edu.oms.pages.SupervisorHomePage;

/**
 * @author Andrew
 *
 */
public class SupervisorHomePageLogic extends HomePageLogic {
	// Elements
	private SupervisorHomePage supervisorHomePage;

	public SupervisorHomePageLogic(SupervisorHomePage supervisorHomePage) {
		super(supervisorHomePage);
		this.supervisorHomePage = supervisorHomePage;
	}

	// getters

	public SupervisorHomePage getSupervisorHomePage() {
		return supervisorHomePage;
	}

	// business

	public ItemManagementPageLogic gotoItemManagement() {
		this.supervisorHomePage.getItemManagementTab().click();
		return new ItemManagementPageLogic(new ItemManagementPage());
	}

}

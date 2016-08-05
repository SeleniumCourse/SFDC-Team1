package com.salesforce.dev.lead;

import org.testng.Assert;
import com.salesforce.dev.framework.dto.Lead;
import com.salesforce.dev.framework.utils.JSONMapper;
import com.salesforce.dev.pages.LoginPage;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.ObjectGenie;
import com.salesforce.dev.pages.leads.LeadDetail;
import com.salesforce.dev.pages.leads.LeadForm;
import com.salesforce.dev.pages.leads.LeadsHome;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * This class will be used to test the edition of a lead.
 *
 * @author Jimmy Vargas.
 * @since 6/21/2015.
 */
public class EditLead {

    private MainPage mainPage;

    private Lead lead;

    private Lead leadEditEnum;

    @BeforeMethod(groups = {"Acceptance"})
    public void setup() {
        lead = JSONMapper.getGeneric(Lead.class,"CreateLeadBase.json");
        leadEditEnum = JSONMapper.getGeneric(Lead.class,"EditLead.json");

        //Creating a lead
        ObjectGenie.createLead(lead);
    }

    @Test(groups = {"Acceptance"})
    public void testEditLead() {
        mainPage = LoginPage.loginAsPrimaryUser();
        LeadsHome leadsHome = mainPage.gotoNavBar().gotToLeadsHome();
        LeadDetail leadDetail = leadsHome.openLead(lead.getLastName());
        LeadForm leadForm = leadDetail.clickEditBtn();

        //editing some fields
        leadForm.setLastName(leadEditEnum.getLastName());
        leadForm.setPhone(leadEditEnum.getPhone());
        leadForm.setWebsite(leadEditEnum.getWebsite());
        leadForm.selectLeadStatusByVisibleText(leadEditEnum.getLeadStatus());
        leadForm.setNumEmployees(leadEditEnum.getNumEmployees());
        leadForm.selectProductInterestByVisibleText(leadEditEnum.getProductInterest());
        leadForm.selectPrimaryByVisibleText(leadEditEnum.getPrimary());
        leadForm.setDescription(leadEditEnum.getDescription());
        leadDetail = leadForm.clickSaveBtn();

        //assertions
        Assert.assertEquals(leadDetail.getWebsite(), "http://" + leadEditEnum.getWebsite(), "The website is not correct");
        leadDetail.validateFields(leadEditEnum);
    }

    @AfterMethod(groups = {"Acceptance"})
    public void tearDown() {
        LeadsHome leadsHome = mainPage.gotoNavBar().gotToLeadsHome();
        LeadDetail leadDetail = leadsHome.openLead(leadEditEnum.getLastName());
        leadDetail.clickDeleteButton();
    }
}

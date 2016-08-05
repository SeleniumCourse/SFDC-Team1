package com.salesforce.dev.pages.campaigns;

import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.base.DetailsBase;
import com.salesforce.dev.pages.base.HomeBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

import static com.salesforce.dev.framework.selenium.CommonOperation.getTextWebElement;
import static com.salesforce.dev.pages.campaigns.CampaignSteps.*;


/**
 * This class will be used to represent Campaing detail page.
 *
 * @author Marcelo.Vargas
 * @since 13-06-15.
 */
public class CampaignDetail extends DetailsBase {

    @FindBy(id = "cpn1_ileinner")
    private WebElement campaignName;

    @FindBy(id = "cpn2_ileinner")
    private WebElement campaignType;

    @FindBy(id = "cpn3_ileinner")
    private WebElement campaignStatus;

    @FindBy(id = "cpn5_ileinner")
    private WebElement campaignStartDate;

    @FindBy(id = "cpn6_ileinner")
    private WebElement campaignEndDate;

    @FindBy(id = "cpn8_ileinner")
    private WebElement campaignExpectedRevenue;

    @FindBy(id = "cpn9_ileinner")
    private WebElement campaignBudgetedCost;

    @FindBy(id = "cpn10_ileinner")
    private WebElement campaignActualCost;

    @FindBy(id = "cpn11_ileinner")
    private WebElement campaignExpectedResponse;

    @FindBy(id = "cpn13_ileinner")
    private WebElement campaignNumSent;

    @FindBy(id = "Parent_ileinner")
    private WebElement campaignParent;

    @Override
    public CampaignForm clickEditBtn() {
        clickEditButton();
        return new CampaignForm();
    }


    @Override
    public HomeBase clickDeleteButton() {
        clickDeletedButton();
        return new CampaignsHome();
    }

    @Override
    public MainPage gotoMainPage() {
        return new MainPage();
    }

    public String validateCampaignNameFld() {
        return getTextWebElement(campaignName).substring(0, campaignName.getText().length() - 17);
    }

    /**
     * {@inheritDoc CommonOperation.getTextWebElement}
     */
    public String validateCampaignType() {
        return getTextWebElement(campaignType);
    }

    /**
     * {@inheritDoc CommonOperation.getTextWebElement}
     */
    public String validateCampaignStatus() {
        return getTextWebElement(campaignStatus);
    }

    /**
     * {@inheritDoc CommonOperation.getTextWebElement}
     */
    public String validateCampaignStartDate() {
        return getTextWebElement(campaignStartDate);
    }

    /**
     * {@inheritDoc CommonOperation.getTextWebElement}
     */
    public String validateCampaignEndDate() {
        return getTextWebElement(campaignEndDate);
    }

    /**
     * {@inheritDoc CommonOperation.getTextWebElement}
     * "¤"
     */
    public String validateCampaignExpectedRevenue() {
        return getTextWebElement(campaignExpectedRevenue);
    }

    /**
     * {@inheritDoc CommonOperation.getTextWebElement}
     */
    public String validateCampaignBudgetedCost() {
        return getTextWebElement(campaignBudgetedCost);
    }

    /**
     * {@inheritDoc CommonOperation.getTextWebElement}
     */
    public String validateCampaignActualCost() {

        return getTextWebElement(campaignActualCost);
    }

    /**
     * {@inheritDoc CommonOperation.getTextWebElement}
     */
    public String validateCampaignExpectedResponse() {
        return getTextWebElement(campaignExpectedResponse);
    }

    public String validateCampaignNumSent() {
        return getTextWebElement(campaignNumSent);
    }

    public String validateCampaignParent() {
        return getTextWebElement(campaignParent);
    }

    @Override
    public Map<Enum, Object> getAssertionMap() {
        Map<Enum, Object> assertionMap = new HashMap<>();
        assertionMap.put(CAMPAIGN_NAME, validateCampaignNameFld());
        assertionMap.put(CAMPAIGN_STATUS, validateCampaignStatus());
        assertionMap.put(CAMPAIGN_TYPE, validateCampaignType());
        assertionMap.put(START_DATE, validateCampaignStartDate());
        assertionMap.put(END_DATE, validateCampaignEndDate());
        assertionMap.put(PARENT_CAMPAIGN, validateCampaignParent());
        assertionMap.put(BUDGETED_COST, validateCampaignBudgetedCost());
        assertionMap.put(ACTUAL_COST, validateCampaignActualCost());
        assertionMap.put(EXPECTED_RESPONSE, validateCampaignExpectedResponse());
        assertionMap.put(NUM_SENT, validateCampaignNumSent());
        assertionMap.put(EXPECTED_REVENUE, validateCampaignExpectedRevenue());
        return assertionMap;
    }
}

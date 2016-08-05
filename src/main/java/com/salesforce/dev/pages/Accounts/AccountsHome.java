package com.salesforce.dev.pages.accounts;

import com.salesforce.dev.pages.base.HomeBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.salesforce.dev.framework.selenium.CommonOperation.isWebElementVisible;


/**
 * This class will be used to represent Account home page and its options.
 *
 * @author Walter.
 * @since 10/06/2015.
 */
public class AccountsHome extends HomeBase {

    @FindBy(xpath = "//h1[contains(.,'Accounts:')]")
    private WebElement accountSection;

    @Override
    public AccountForm clickNewBtn() {
        clickNewButton();
        return new AccountForm();
    }

    @Override
    public AccountView clickNewViewLnk() {
        clickNewViewLink();
        return new AccountView();
    }

    @Override
    public AccountView clickEditViewLnk(String value) {
        editViewLnk(value);
        return new AccountView();
    }

    @Override
    public AccountDetail selectRecentItem(String value) {
        clickRecentItem(value);
        return new AccountDetail();
    }

    @Override
    public AccountsHome selectRecentViewItem(String value) {
        selectRecentView(value);
        return this;
    }

    public boolean isUserInAccountsTab() {
        return isWebElementVisible(accountSection);
    }
}

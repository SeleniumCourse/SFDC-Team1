package com.salesforce.dev.pages.product;

import java.util.Map;

import com.salesforce.dev.pages.base.DetailsBase;
import com.salesforce.dev.pages.base.FormBase;
import com.salesforce.dev.pages.base.HomeBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This class will be used to represents all detail view of a product.
 *
 * @author Monica
 * @since 6/11/2015.
 */
public class ProductDetails extends DetailsBase {

    @FindBy(id = "Name_ileinner")
    private WebElement productNameReg;

    @Override
    public FormBase clickEditBtn() {
        super.clickEditButton();
        return new ProductForm();
    }

    @Override
    public HomeBase clickDeleteButton() {
        clickDeletedButton();
        return new ProductsHome();
    }

    @Override
    public Map<Enum, Object> getAssertionMap() {
        return null;
    }


    public boolean verifyProduct(String nameValue) {
        String nameProductForm = productNameReg.getText();

        if (nameProductForm.equals(nameValue)) {
            return true;
        }
        return false;
    }

}

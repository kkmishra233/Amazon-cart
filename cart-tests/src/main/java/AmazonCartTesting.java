import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class AmazonCartTesting extends BaseTest {

    @Test(priority = 1)
    public void verifyAmazonHomePage() {
        AmazonMethodsObjectModel amazonPageObjectModel = new AmazonMethodsObjectModel(getDriver());
        assertTrue(getDriver().getTitle().contains("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more"));
    }

    @Test(priority = 2)
    public void searchProductAndVerifyList() {
        AmazonMethodsObjectModel amazonPageObjectModel = new AmazonMethodsObjectModel(getDriver());
        amazonPageObjectModel.searchProduct("Database System Concepts");
        amazonPageObjectModel.submitProductSearch();
        amazonPageObjectModel.searchListDisplayed();
        assertTrue(amazonPageObjectModel.verifyProductIsAvailableIntoResult().contains("Database System Concepts"));
    }

    @Test(priority = 3)
    public void addProductIntoCartAndVerifyCart() {
        AmazonMethodsObjectModel amazonPageObjectModel = new AmazonMethodsObjectModel(getDriver());
        amazonPageObjectModel.searchProduct("Database System Concepts");
        amazonPageObjectModel.submitProductSearch();
        amazonPageObjectModel.searchListDisplayed();
        amazonPageObjectModel.selectFirstItemFromProductSearList();
        amazonPageObjectModel.verifyProductTitleInProductPage();
        amazonPageObjectModel.addProductToShoppingCart();
        amazonPageObjectModel.navigateToShoppingCart();
        amazonPageObjectModel.verifyShoppingCartIsDisplayed();
        assertTrue(amazonPageObjectModel.verifyProductNameAvailableIntoCart().contains("Database System Concepts"));
        assertTrue(amazonPageObjectModel.verifyProductPriceInCart().contains("$190.77"));
        assertTrue(amazonPageObjectModel.verifyCartSubTotal().contains("$190.77"));
        assertTrue(amazonPageObjectModel.verifyQuantityOfAddedProduct().contains("1"));

    }

    @Test(priority = 4)
    public void increaseTheNumberOfProductAndVerifyCart() {
        AmazonMethodsObjectModel amazonPageObjectModel = new AmazonMethodsObjectModel(getDriver());
        amazonPageObjectModel.goToCartWindow();
        amazonPageObjectModel.increaseProductQuanityToTen();
        assertTrue(amazonPageObjectModel.verifyCartSubTotal().contains("$1,907.70")); // product price is multiplied by 10 times

    }

    @Test(priority = 5)
    public void addAnotherProductAndVerifyCartChange() {
        AmazonMethodsObjectModel amazonPageObjectModel = new AmazonMethodsObjectModel(getDriver());
        amazonPageObjectModel.searchProduct("Classic Shell Scripting");
        amazonPageObjectModel.submitProductSearch();
        amazonPageObjectModel.searchListDisplayed();
        assertTrue(amazonPageObjectModel.verifyProductIsAvailableIntoResult().contains("Classic Shell Scripting"));
        amazonPageObjectModel.selectFirstItemFromProductSearList();
        amazonPageObjectModel.addProductToShoppingCart();
        amazonPageObjectModel.navigateToShoppingCart();
        amazonPageObjectModel.verifyShoppingCartIsDisplayed();
        assertTrue(amazonPageObjectModel.verifyProductNameAvailableIntoCart().contains("Classic Shell Scripting"));
        assertTrue(amazonPageObjectModel.verifyCartSubTotal().contains("$1,952.69"));

    }

    @Test(priority = 6)
    public void checkFirstProductAsGift() {
        AmazonMethodsObjectModel amazonPageObjectModel = new AmazonMethodsObjectModel(getDriver());
        amazonPageObjectModel.goToCartWindow();
        amazonPageObjectModel.checkProductShouldShipAsGift();
    }

    @Test(priority = 7)
    public void removeAProductFromCartAndVerifyTheChange() {
        AmazonMethodsObjectModel amazonPageObjectModel = new AmazonMethodsObjectModel(getDriver());
        amazonPageObjectModel.goToCartWindow();
        amazonPageObjectModel.deleteFirstItemFromCart();
        assertTrue(amazonPageObjectModel.verifyCartSubTotal().contains("$1,907.70"));

    }

    @Test(priority = 8)
    public void moveProductIntoSaveForLater(){
        AmazonMethodsObjectModel amazonPageObjectModel = new AmazonMethodsObjectModel(getDriver());
        amazonPageObjectModel.goToCartWindow();
        amazonPageObjectModel.moveFirstProductIntoSaveForLater();
        System.out.println(amazonPageObjectModel.verifyCartSubTotal());
        amazonPageObjectModel.verifyproductMovedinSavedForLaterMessage();
    }

    @Test(priority = 9)
    public void addProductFromSavedForLaterIntoCartAgain(){
        AmazonMethodsObjectModel amazonPageObjectModel = new AmazonMethodsObjectModel(getDriver());
        amazonPageObjectModel.goToCartWindow();
        amazonPageObjectModel.addMovedProductIntoCartAgain();
        amazonPageObjectModel.verifyproductMovedINtoCartfromSavedForLater();

    }

    @Test(priority = 10)
    public void removeAllProductFromCartAndVerifyTheChange() {
        AmazonMethodsObjectModel amazonPageObjectModel = new AmazonMethodsObjectModel(getDriver());
        amazonPageObjectModel.goToCartWindow();
        amazonPageObjectModel.deleteFirstItemFromCart();
        assertTrue(amazonPageObjectModel.verifyCartSubTotal().contains("$0.00"));
    }


}

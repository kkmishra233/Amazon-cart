import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonMethodsObjectModel extends BaseMethods {

    private By productSearchArea = By.id("twotabsearchtextbox");
    private By submitSearch = By.xpath("//input[@value='Go']");
    private By searchList = By.xpath("//div[@class='s-result-list sg-row']");
    private By firstFromSearchList = By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]");
    private By productTitle = By.id("productTitle");
    private By addToCart = By.id("add-to-cart-button");
    private By goToCart = By.id("hlb-view-cart-announce");
    private By shoppingCartHeader = By.xpath("//h2");
    private By productAddedIntoCart = By.xpath("//ul/li//span[@class='a-size-medium sc-product-title a-text-bold']");
    private By productPriceInCartpage = By.xpath("//span[@class='a-size-medium a-color-price sc-price sc-white-space-nowrap sc-product-price sc-price-sign a-text-bold']");
    private By cartSubtotal = By.xpath("//span[@class='a-size-medium a-color-price sc-price sc-white-space-nowrap sc-price-sign']");
    private By productQuantity =By.xpath("//span[@class='a-button-text a-declarative']//span[@class='a-dropdown-prompt']");
    private By selectTenPlusOption = By.xpath("//li[@class='a-dropdown-item quantity-option quantity-option-10']");
    private By increaseProductquantitytoTen = By.xpath("//input[@class='a-input-text a-span8 sc-quantity-textfield sc-hidden']");
    private By updateQuantityUpdate = By.xpath("//a[@class='a-button-text']");
    private By checkProductIsSelectedToShippedAsGifted = By.xpath("//input[@id='sc-buy-box-gift-checkbox' and @name='isToBeGiftWrapped']");
    private By deleteFirstItemFromCart = By.xpath("(//span[@class='a-declarative' and @ data-action='sc-item-action']/input[@value='Delete'])[1]");
    private By deleteSecondItemFromCart = By.xpath("(//span[@class='a-declarative' and @ data-action='sc-item-action']/input[@value='Delete'])[2]");
    private By saveForLater = By.xpath("(//span[@class='a-declarative' and @ data-action='sc-item-action']/input[@value='Save for later'])[1]");
    private By movedInSaveLaterMessage = By.xpath("(//div[@data-action='save-for-later']/span[text()[contains(.,'has been moved to Save for Later')]])[1]");
    private By navigateToCartWindow = By.xpath("//span[@class='nav-cart-icon nav-sprite']");
    private By addToCartFromSaveLaterWindow = By.xpath("(//span[@class='a-declarative' and @ data-action='sc-item-action']/input[@value='Move to Cart'])");
    private By moveTocartFromSavedLaterMessage = By.xpath("(//div[@data-action='move-to-cart']/span[text()[contains(.,'has been moved to Shopping Cart')]])[2]");



    protected AmazonMethodsObjectModel(WebDriver driver) {

        super(driver);
        driver.get("https://www.amazon.com");

    }

    public void searchProduct(String productName){
        driver.findElement(productSearchArea).sendKeys(productName);
    }

    public void submitProductSearch(){
        driver.findElement(submitSearch).click();
    }

    public void searchListDisplayed(){
        super.waitForElementToAppear(searchList);
    }

    public String verifyProductIsAvailableIntoResult(){
        return driver.findElement(firstFromSearchList).getText();
    }

    public void selectFirstItemFromProductSearList(){
        driver.findElement(firstFromSearchList).click();
    }
    public void verifyProductTitleInProductPage(){
        super.waitForElementToAppear(productTitle);
    }
    public void addProductToShoppingCart(){
        driver.findElement(addToCart).click();
    }
    public void navigateToShoppingCart(){
        driver.findElement(goToCart).click();
    }
    public String verifyShoppingCartIsDisplayed(){
        waitForElementToAppear(shoppingCartHeader);
        return driver.findElement(shoppingCartHeader).getText();
    }
    public String verifyProductNameAvailableIntoCart(){
        return driver.findElement(productAddedIntoCart).getText();
    }
    public String verifyProductPriceInCart(){
        return driver.findElement(productPriceInCartpage).getText();
    }
    public String verifyCartSubTotal(){
        waitForElementToAppear(cartSubtotal);
        staticWait();
        return driver.findElement(cartSubtotal).getText();
    }
    public String verifyQuantityOfAddedProduct(){
        return driver.findElement(productQuantity).getText();
    }
    public void increaseProductQuanityToTen(){
        driver.findElement(productQuantity).click();
        waitForElementToAppear(selectTenPlusOption);
        waitForElementToBeClickable(selectTenPlusOption);
        driver.findElement(selectTenPlusOption).click();
        waitForElementToBeClickable(increaseProductquantitytoTen);
        driver.findElement(increaseProductquantitytoTen).sendKeys("10");
        waitForElementToAppear(updateQuantityUpdate);
        driver.findElement(updateQuantityUpdate).click();
        staticWait();
    }

    public void checkProductShouldShipAsGift(){
        super.staticWait();
        driver.findElement(checkProductIsSelectedToShippedAsGifted).click();
    }

    public void deleteFirstItemFromCart(){
        driver.findElement(deleteFirstItemFromCart).click();
    }
    public void deleteSecondItemFromCart(){
        driver.findElement(deleteSecondItemFromCart).click();
    }

    public void moveFirstProductIntoSaveForLater(){
        driver.findElement(saveForLater).click();
    }
    public void verifyproductMovedinSavedForLaterMessage(){
        driver.findElement(movedInSaveLaterMessage);
    }
    public void verifyproductMovedINtoCartfromSavedForLater(){
        staticWait();
        driver.findElement(moveTocartFromSavedLaterMessage);
    }
    public void goToCartWindow(){
        driver.findElement(navigateToCartWindow).click();
    }
    public void addMovedProductIntoCartAgain(){
        driver.findElement(addToCartFromSaveLaterWindow).click();
    }
}

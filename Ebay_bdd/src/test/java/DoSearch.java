import cuc.pages.HeaderMenu;
import cuc.pages.ProductItem;
import cuc.pages.SearchResult;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import cuc.settings.StartDriver;
import cuc.utils.Utils;

public class DoSearch extends StartDriver {
    String searchQuery = "ASUS";
    String foundItemNumber = "1";

    HeaderMenu headerMenu;
    SearchResult searchResult;
    ProductItem productItem;
    Utils utils;

    @BeforeClass(description = "Initialize class incenses")
    public void initializeInstance(){
        headerMenu = new HeaderMenu(driver);
        searchResult = new SearchResult(driver);
        productItem = new ProductItem(driver);
        utils = new Utils(driver);
    }

    @Test (testName = "Change app language", priority = 0)
    public void changeLanguage(){
        headerMenu.changeLanguage("English");
        Assert.assertTrue(headerMenu.isLanguageEng(), "Language is not changed");
        headerMenu.hidePopUp();
    }

    @Test (testName = "Search items", priority = 1)
    public void doSearch(){
        utils.waiterElement(headerMenu.getElementSearchBtn());
        headerMenu.doSearch(searchQuery);
        Assert.assertTrue(searchResult.foundItemRelatesToSearchQuery(foundItemNumber, searchQuery), "Item number '" + foundItemNumber + "' is not related to search query '" + searchQuery + "'.");
        System.out.println("Search is done using query: '" + searchQuery + "'.");
    }

    @Test (testName = "Select 'Buy It Now' items", priority = 2)
    public void filterBuyNow(){
        searchResult.filterBuyNow();
        Assert.assertFalse(searchResult.findElementsWithText("ставк"), "Filtered by 'Buy It Now' search results contain auction items");
    }


    @Test (testName = "Select found item", dependsOnMethods = "filterBuyNow", priority = 3)
    public void selectSearchResultItem(){
        String itemResultItemText = searchResult.getResultItemText(foundItemNumber);
        System.out.println("Item that will be selected has label: '" + itemResultItemText + "'.");
        searchResult.selectResultItem(foundItemNumber);
        System.out.println("Select row item '" + foundItemNumber + "'.");
        Assert.assertTrue(StringUtils.containsIgnoreCase(itemResultItemText, productItem.getItemTitleText()), "Selected item and opened item is not the same");
    }

}

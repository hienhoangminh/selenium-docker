package com.rocktester.search.tests;

import com.rocktester.BaseTest;
import com.rocktester.search.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
    @Parameters({"keyword"})
    public void searchTest(String keyword) {
        SearchPage searchPage = new SearchPage(driver);
        int size = searchPage.goTo()
                .doSearch(keyword)
                .goToVideos()
                .getResult();
        Assert.assertTrue(size > 0);
    }

}

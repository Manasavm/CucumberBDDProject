package pages;

import steps.Hooks;

public class BasicSearchPage {
    private static final String URL = "https://www.vlm.cem.va.gov/";

    public static void openVeteranPage() {
        Hooks.getDriver().get(URL);

    }
}


package moneycalculator.persistence;

import moneycalculator.model.Currency;
import moneycalculator.model.CurrencySet;

public class FileCurrencySetLoader {

    private static FileCurrencySetLoader instance;

    private FileCurrencySetLoader() {
    }

    public static FileCurrencySetLoader getInstance() {
        if (instance == null)
            instance = new FileCurrencySetLoader();
        return instance;
    }

    public void load(Currency[] currencies) {
        CurrencySet set = CurrencySet.getInstance();
        for (int i = 0; i < currencies.length; i++)
            set.add(currencies[i]);
    }
}

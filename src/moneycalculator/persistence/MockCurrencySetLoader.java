package moneycalculator.persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import moneycalculator.model.Currency;
import moneycalculator.model.CurrencySet;

public class MockCurrencySetLoader implements CurrencySetLoader {

    private static MockCurrencySetLoader instance;

    private MockCurrencySetLoader() {
    }

    public static MockCurrencySetLoader getInstance() {
        if (instance == null)
            instance = new MockCurrencySetLoader();
        return instance;
    }

    @Override
    public void load() {
        CurrencySet set = CurrencySet.getInstance();
        try {
            FileReader fr = new FileReader("currencies");
            BufferedReader br = new BufferedReader(fr);

            String text = "";

            while ((text = br.readLine()) != null) {
                String[] split = text.split(",");

                set.add(new Currency(split[1], split[0],split[2]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*
        set.add(new Currency("EUR", "Euro", "€"));
        set.add(new Currency("GBP", "British pound", "£"));
        set.add(new Currency("USD", "United States dollar", "$"));
        set.add(new Currency("CNY", "Chinese yuan", "元"));
        set.add(new Currency("AUD", "Australian dollar", "$"));*/
    }

}


        
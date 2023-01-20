package moneycalculator.ui.console;

import moneycalculator.model.Currency;
import moneycalculator.ui.CurrencyViewer;

public class ConsoleCurrencyViewer implements CurrencyViewer {

    private Currency currency;

    public ConsoleCurrencyViewer(Currency currency) {
        this.currency = currency;
    }

    @Override
    public void show() {
        System.out.println(currency.getSymbol());
    }
}

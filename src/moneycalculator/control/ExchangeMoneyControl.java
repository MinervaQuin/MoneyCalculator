package moneycalculator.control;

import moneycalculator.model.Currency;
import moneycalculator.model.ExchangeRate;
import moneycalculator.model.Money;
import moneycalculator.model.MoneyExchanger;
import moneycalculator.persistence.MockCurrencySetLoader;
import moneycalculator.persistence.MockExchangeRateLoader;
import moneycalculator.ui.console.ConsoleCurrencyDialog;
import moneycalculator.ui.console.ConsoleMoneyDialog;
import moneycalculator.ui.console.ConsoleMoneyViewer;

public class ExchangeMoneyControl {

    public void execute() {
        MockCurrencySetLoader.getInstance().load();
        Money money = readMoney();
        Currency currency = readCurrency();
        ExchangeRate exchangeRate = new MockExchangeRateLoader().load(money.getCurrency(), currency);
        System.out.println(money.getCurrency());
        new ConsoleMoneyViewer().show(MoneyExchanger.exchange(money, exchangeRate));
    }

    private Money readMoney() {
        ConsoleMoneyDialog dialog = new ConsoleMoneyDialog();
        dialog.execute();
        return dialog.getMoney();
    }

    private Currency readCurrency() {
        ConsoleCurrencyDialog dialog = new ConsoleCurrencyDialog();
        dialog.execute();
        return dialog.getCurrency();
    }

}

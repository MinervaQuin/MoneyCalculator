package moneycalculator.control;

import moneycalculator.model.Currency;
import moneycalculator.model.ExchangeRate;
import moneycalculator.model.Money;
import moneycalculator.model.MoneyExchanger;
import moneycalculator.persistence.MockExchangeRateLoader;
import moneycalculator.ui.CurrencyDialog;
import moneycalculator.ui.MoneyDialog;
import moneycalculator.ui.swing.MoneyDialogPanel;

public class CalculateCommand extends Command {

    private final MoneyDialog moneyDialog;
    private final CurrencyDialog currencyDialog;

    public CalculateCommand(MoneyDialog moneyDialog, CurrencyDialog currencyDialog) {
        this.moneyDialog = moneyDialog;
        this.currencyDialog = currencyDialog;
    }

    @Override
    public void execute() {
        Money money = moneyDialog.getMoney();
        Currency currency = currencyDialog.getCurrency();
        ExchangeRate exchangeRate = new MockExchangeRateLoader().load(money.getCurrency(), currency);
        Money result = MoneyExchanger.exchange(money, exchangeRate);
        MoneyDialogPanel.refresh(result.getAmount().toString());

    }
}

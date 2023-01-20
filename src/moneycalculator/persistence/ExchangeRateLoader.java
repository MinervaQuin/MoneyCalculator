package moneycalculator.persistence;

import java.util.Date;
import moneycalculator.model.Currency;
import moneycalculator.model.ExchangeRate;

public interface ExchangeRateLoader {

    public ExchangeRate load(Date date, Currency to, Currency from);

    public ExchangeRate load(Currency to, Currency from);

}

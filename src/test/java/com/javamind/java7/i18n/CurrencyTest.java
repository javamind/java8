package com.javamind.java7.i18n;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Currency;
import java.util.Locale;

/**
 * Des ameliorations au niveau de l'internationalisation
 * http://docs.oracle.com/javase/7/docs/technotes/guides/intl/enhancements.7.html
 */
public class CurrencyTest {
    @Test
    public void moreCurrencyInAvailableCurrencies(){
        Assertions.assertThat(Currency.getAvailableCurrencies()).extracting("currencyCode").contains("EUR", "USD");
    }

    @Test
    public void currencyNumeric(){
        Assertions.assertThat(Currency.getInstance(Locale.FRANCE).getCurrencyCode()).isEqualTo("EUR");
        Assertions.assertThat(Currency.getInstance(Locale.FRANCE).getNumericCode()).isEqualTo(978);
    }

    @Test
    public void currencyName(){
        Assertions.assertThat(Currency.getInstance(Locale.FRANCE).getDisplayName()).isEqualTo("euro");
        Assertions.assertThat(Currency.getInstance(Locale.US).getDisplayName()).isEqualTo("dollar des États-Unis");
    }
}

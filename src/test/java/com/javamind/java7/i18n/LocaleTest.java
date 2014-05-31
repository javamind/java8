package com.javamind.java7.i18n;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Currency;
import java.util.Locale;

/**
 * Des ameliorations au niveau de l'internationalisation
 * http://docs.oracle.com/javase/7/docs/technotes/guides/intl/enhancements.7.html
 */
public class LocaleTest {
    @Test
    public void localeForLanguage(){
        Assertions.assertThat(Locale.forLanguageTag("FR").getDisplayName()).isEqualTo("français");
    }


}

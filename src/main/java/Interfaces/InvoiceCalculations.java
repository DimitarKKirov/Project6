package com.estafet.learning.Interfaces;

import java.io.IOException;

public interface InvoiceCalculations {
    void methodOfPayment();

    void priceCalc();

    void discountCalc();

    void vatArticles();

    void articlesList();
    void priceList() throws IOException;

}

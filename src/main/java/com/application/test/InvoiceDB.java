package com.application.test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InvoiceDB {
    private List<Invoice> invoiceList = new ArrayList<>();

    public Optional<Invoice> getInvoiceByInvoiceNumber(int nip, String invoiceNumber){
        for (Invoice invoice : invoiceList) {
            if (nip == invoice.getNip() && invoiceNumber.equals(invoice.getInvoiceNumber())) {
                return Optional.of(invoice);
            }
        }
        return Optional.empty();
    }

    public void addInvoice(Invoice invoice){
        if(getInvoiceByInvoiceNumber(invoice.getNip(), invoice.getInvoiceNumber()).isEmpty()){
            invoiceList.add(invoice);
        }
    }

    public List<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public InvoiceDB(List<Invoice> invoiceList) {
        this.invoiceList = invoiceList;
    }

    public InvoiceDB() {
        invoiceList.add(new Invoice(
                1,
                1060001535,
                "I0123",
                new BigDecimal("900.50"),
                LocalDate.of(2019, 5, 25),
                LocalDate.of(2019, 5, 25)));
    }
}

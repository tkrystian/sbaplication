package com.application.test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Invoice {
    private int id;
    private int nip;
    private String invoiceNumber;
    private BigDecimal netValue;
    private LocalDate dateOfInvoice;
    private LocalDate dateOfPayment;

    public Invoice() {
    }

    public Invoice(int id, int nip, String invoiceNumber, BigDecimal netValue, LocalDate dateOfInvoice, LocalDate dateOfPayment) {
        this.id = id;
        this.nip = nip;
        this.invoiceNumber = invoiceNumber;
        this.netValue = netValue;
        this.dateOfInvoice = dateOfInvoice;
        this.dateOfPayment = dateOfPayment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNip() {
        return nip;
    }

    public void setNip(int nip) {
        this.nip = nip;
    }

    public BigDecimal getNetValue() {
        return netValue;
    }

    public void setNetValue(BigDecimal netValue) {
        this.netValue = netValue;
    }

    public LocalDate getDateOfInvoice() {
        return dateOfInvoice;
    }

    public void setDateOfInvoice(LocalDate dateOfInvoice) {
        this.dateOfInvoice = dateOfInvoice;
    }

    public LocalDate getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(LocalDate dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }
}

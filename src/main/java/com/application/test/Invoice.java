package com.application.test;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Invoice {
    @NotNull(message = "Pole nie może być puste")
    private int id;
    @NotNull(message = "Pole nie może być puste")
    private int nip;
    @NotEmpty(message = "Pole nie może być puste")
    private String invoiceNumber;
    @NotNull(message = "Pole nie może być puste")
    private BigDecimal netValue;
    @NotNull(message = "Pole nie może być puste")
    private LocalDate dateOfInvoice;
    @NotNull(message = "Pole nie może być puste")
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

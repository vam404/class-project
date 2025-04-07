package co.edu.poli.models;

/**
 * SalesMenReport class
 * This class represents a salesmen report
 *
 * @version 1.0 06 Apr 2024
 */
public class SalesMenReport extends SalesMen {
    // Document number of the salesmen
    private double totalSales;

    /**
     * Class constructor
     *
     * @param documentNumber Salesmen document number
     * @param documentType   Salesmen document type
     * @param names          Salesmen names
     * @param surnames       Salesmen surnames
     */
    public SalesMenReport(String documentNumber, String documentType, String names, String surnames, double totalSales) {
        super(documentNumber, documentType, names, surnames);
        this.totalSales = totalSales;
    }

    /**
     * Get the total sales info
     *
     * @return Total sales info
     */
    @Override
    public String toString() {
        return super.toString() + ';' + totalSales;
    }
}

package co.edu.poli.models;

/**
 * SalesMen class
 * This class represents a salesmen
 *
 * @version 1.0 22 Mar 2024
 */
public class SalesMen {
    private String documentNumber;
    private String documentType;
    private String names;
    private String surnames;

    /**
     * Constructor
     * @param documentNumber Salesmen document number
     * @param documentType Salesmen document type
     * @param names Salesmen names
     * @param surnames Salesmen surnames
     */
    public SalesMen(String documentNumber, String documentType, String names, String surnames) {
        this.documentNumber = documentNumber;
        this.documentType = documentType;
        this.names = names;
        this.surnames = surnames;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public String getDocumentType() {
        return documentType;
    }

    @Override
    public String toString() {
        return documentType + ';' + documentNumber + ';' + names + ';' + surnames;
    }
}

package co.edu.poli.models;

/**
 * SalesMan class
 * This class represents a salesmen
 *
 * @version 1.0 22 Mar 2025
 */
public class SalesMan {
    // Document number of the salesmen
    private String documentNumber;
    // Document type of the salesmen
    private String documentType;
    // Names of the salesmen
    private String names;
    // Surnames of the salesmen
    private String surnames;

    /**
     * Class constructor
     * @param documentNumber Salesmen document number
     * @param documentType Salesmen document type
     * @param names Salesmen names
     * @param surnames Salesmen surnames
     */
    public SalesMan(String documentNumber, String documentType, String names, String surnames) {
        this.documentNumber = documentNumber;
        this.documentType = documentType;
        this.names = names;
        this.surnames = surnames;
    }

    /**
     * Get the salesmen names
     * @return Salesmen names
     */
    public String getDocumentNumber() {
        return documentNumber;
    }

    /**
     * Get the salesmen surnames
     * @return Salesmen surnames
     */
    public String getDocumentType() {
        return documentType;
    }

    /**
     * Get the salesmen info
     * @return Salesmen info
     */
    @Override
    public String toString() {
        return documentType + ';' + documentNumber + ';' + names + ';' + surnames;
    }
}

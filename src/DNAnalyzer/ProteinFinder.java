package DNAnalyzer;

import java.util.ArrayList;

// This class is used to find proteins in a DNA sequence.
public class FindProteins {
    private final ArrayList<String> aminoAcidList = new ArrayList<>();
    private final ArrayList<String> geneList = new ArrayList<>();

    public ArrayList<String> getProtein(final String dna, final String aminoAcid, final ArrayList<String> isoleucine,
            final ArrayList<String> leucine,
            final ArrayList<String> valine, final ArrayList<String> phenylalanine, final ArrayList<String> methionine,
            final ArrayList<String> cysteine, final ArrayList<String> alanine, final ArrayList<String> glycine,
            final ArrayList<String> proline,
            final ArrayList<String> threonine, final ArrayList<String> serine, final ArrayList<String> tyrosine,
            final ArrayList<String> tryptophan, final ArrayList<String> glutamine, final ArrayList<String> asparagine,
            final ArrayList<String> histidine, final ArrayList<String> glutamicAcid,
            final ArrayList<String> asparticAcid,
            final ArrayList<String> lysine, final ArrayList<String> arginine, final ArrayList<String> stop) {

        // Maps the amino acid that the user entered to the start codon list.
        switch (aminoAcid) {
            case "isoleucine", "i", "ile" -> this.aminoAcidList.addAll(isoleucine);
            case "leucine", "l", "leu" -> this.aminoAcidList.addAll(leucine);
            case "valine", "v", "val" -> this.aminoAcidList.addAll(valine);
            case "phenylalanine", "f", "phe" -> this.aminoAcidList.addAll(phenylalanine);
            case "methionine", "m", "met" -> this.aminoAcidList.addAll(methionine);
            case "cysteine", "c", "cys" -> this.aminoAcidList.addAll(cysteine);
            case "alanine", "a", "ala" -> this.aminoAcidList.addAll(alanine);
            case "glycine", "g", "gly" -> this.aminoAcidList.addAll(glycine);
            case "proline", "p", "pro" -> this.aminoAcidList.addAll(proline);
            case "threonine", "t", "thr" -> this.aminoAcidList.addAll(threonine);
            case "serine", "s", "ser" -> this.aminoAcidList.addAll(serine);
            case "tyrosine", "y", "tyr" -> this.aminoAcidList.addAll(tyrosine);
            case "tryptophan", "w", "trp" -> this.aminoAcidList.addAll(tryptophan);
            case "glutamine", "q", "gln" -> this.aminoAcidList.addAll(glutamine);
            case "asparagine", "n", "asn" -> this.aminoAcidList.addAll(asparagine);
            case "histidine", "h", "his" -> this.aminoAcidList.addAll(histidine);
            case "glutamic acid", "e", "glu" -> this.aminoAcidList.addAll(glutamicAcid);
            case "aspartic acid", "d", "asp" -> this.aminoAcidList.addAll(asparticAcid);
            case "lysine", "k", "lys" -> this.aminoAcidList.addAll(lysine);
            case "arginine", "r", "arg" -> this.aminoAcidList.addAll(arginine);
            default -> System.out.println("Invalid amino acid");
        }

        // MAIN ALGORITHM: Finds proteins in the DNA sequence.

        int start_index;
        int stop_index;
        // Loops through the start codons for the amino acid that the user entered.
        for (final String start_codon : this.aminoAcidList) {
            start_index = dna.indexOf(start_codon.toLowerCase());
            for (final String stop_codon : stop) {
                stop_index = dna.indexOf(stop_codon.toLowerCase(), start_index + 3);
                if ((start_index != -1) && (stop_index != -1)) {
                    this.geneList.add(dna.substring(start_index, stop_index + 3).toUpperCase());
                    break;
                }
            }
        }

        if (this.geneList.size() <= 0) {
            System.out.println("No gene found");
            return null;
        }

        return this.geneList;
    }
}
package br.com.mpa.sampleproject.core.models;

import java.util.List;

public interface MeuComponenteAem {
    /***
     * @return a string to display as the name.
     */
    String getName();

    /***
     * Occupations are to be sorted alphabetically in a descending order.
     *
     * @return a list of occupations.
     */
    List<String> getOccupations();

    /***
     * @return a boolean if the component has content to display.
     */
    boolean isEmpty();
}
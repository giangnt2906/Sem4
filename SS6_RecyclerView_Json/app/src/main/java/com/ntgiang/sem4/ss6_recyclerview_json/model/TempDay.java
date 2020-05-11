package com.ntgiang.sem4.ss6_recyclerview_json.model;

public class TempDay {
    private Temperature Minimum;
    private Temperature Maximum;

    public Temperature getMinimum() {
        return Minimum;
    }

    public void setMinimum(Temperature minimum) {
        Minimum = minimum;
    }

    public Temperature getMaximum() {
        return Maximum;
    }

    public void setMaximum(Temperature maximum) {
        Maximum = maximum;
    }
}

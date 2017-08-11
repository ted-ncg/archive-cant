package com.visa.ncg.canteen.web;

import com.visa.ncg.canteen.conversion.ConversionResponse;

/**
 * Created by nedsouza on 8/11/2017.
 */
public class ConversionResponseWebModel {

    private String from;
    private String to;
    private int converted;

    public ConversionResponseWebModel() {

    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getConverted() {
        return converted;
    }

    public void setConverted(int converted) {
        this.converted = converted;
    }
}

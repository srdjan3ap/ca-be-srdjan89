/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.aaap.assignment.communities;

import java.util.Objects;

/**
 *
 * @author Срђан
 */
public class CommunityConsolidatedRow implements CommunityIdentity {

    private final String ID;
    private final String shortName;
    private final String zipCode;
    private final String zipCodeNameShort;
    private final String districtName;
    private final String kantonShort;

    public CommunityConsolidatedRow(String ID, String shortName, String zipCode, String zipCodeNameShort, String districtName, String kantonShort) {
        this.ID = ID;
        this.shortName = shortName;
        this.zipCode = zipCode;
        this.zipCodeNameShort = zipCodeNameShort;
        this.districtName = districtName;
        this.kantonShort = kantonShort;
    }

    @Override
    public String getID() {
        return ID;
    }

    @Override
    public String getShortName() {
        return shortName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getZipCodeNameShort() {
        return zipCodeNameShort;
    }

    public String getDistrictName() {
        return districtName;
    }

    public String getKantonShort() {
        return kantonShort;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.ID);
        hash = 37 * hash + Objects.hashCode(this.shortName);
        hash = 37 * hash + Objects.hashCode(this.zipCode);
        hash = 37 * hash + Objects.hashCode(this.zipCodeNameShort);
        hash = 37 * hash + Objects.hashCode(this.districtName);
        hash = 37 * hash + Objects.hashCode(this.kantonShort);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CommunityConsolidatedRow other = (CommunityConsolidatedRow) obj;
        if (!Objects.equals(this.ID, other.ID)) {
            return false;
        }
        if (!Objects.equals(this.shortName, other.shortName)) {
            return false;
        }
        if (!Objects.equals(this.zipCode, other.zipCode)) {
            return false;
        }
        if (!Objects.equals(this.zipCodeNameShort, other.zipCodeNameShort)) {
            return false;
        }
        if (!Objects.equals(this.districtName, other.districtName)) {
            return false;
        }
        if (!Objects.equals(this.kantonShort, other.kantonShort)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CommunityConsolidatedRow{" + "ID=" + ID + ", shortName=" + shortName + ", zipCode=" + zipCode + ", zipCodeNameShort=" + zipCodeNameShort + ", districtName=" + districtName + ", kantonShort=" + kantonShort + '}';
    }

}

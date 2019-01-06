package ch.aaap.assignments.communities;

import ch.aaap.assignment.communities.CommunityMain;
import org.junit.Assert;
import org.junit.Test;

public class CommunityMainTest {

    /* The system under test */
    CommunityMain sut = new CommunityMain();

    @Test
    public void returnsCorrectCountOfCommunitiesInZH() {
        long amount = sut.getAmountOfCommunitiesInKanton("ZH");
        Assert.assertEquals("Correct amount of communities in ZH", 168, amount);
    }

    @Test
    public void returnsCorrectDistrictNameForZipCode() {
        String districtName = sut.getDistrictForZipCode("8305");
        Assert.assertEquals("Correct DistrictName for zip", "Bezirk Bülach", districtName);
    }

    @Test
    public void returnsCorrectCommunitiesWhereCommunityShortNameAndZipCodeShortNameEqual() {
        int equalCommunities = sut.findCommunitiesWhereCommunityShortNameAndZipCodeShortNameEqual().size();
        Assert.assertEquals("Correct communitites where communityShoreName and ZipCodeShortName equals", 1785,
                equalCommunities);
    }

}

package ch.aaap.assignment.communities;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CommunityMain {

    private final Set<CommunityListRow> politicalCommunities;
    private final Set<CommunityPostalCodeRow> postalcommunities;
    private final Set<CommunityConsolidatedRow> consolidatedCommunities;

    public CommunityMain() {
        politicalCommunities = CSVUtil.getCommunityListRows();
        postalcommunities = CSVUtil.getCommunityPostalCodeRows();
        consolidatedCommunities = CommunityMain.this.createModel(politicalCommunities, postalcommunities);
    }

    public static void main(String[] args) {

        CommunityMain main = new CommunityMain();

        System.err.println("community count: "
                + main.politicalCommunities.size());
        System.err.println("community postal code count: "
                + main.postalcommunities.size());

        System.err.println("1st of community list: "
                + main.politicalCommunities.iterator().next());
        System.err.println("1st of community postal code list: "
                + main.postalcommunities.iterator().next());

    }

    /**
     * Create a model / data structure that combines the input sets.
     *
     * @param communities
     * @param communityPostalCodes
     * @return
     */
    public Set<CommunityConsolidatedRow> createModel(Set<CommunityListRow> communities,
            Set<CommunityPostalCodeRow> communityPostalCodes) {

        Map<String, CommunityConsolidatedRow> consolidatedMap = new HashMap<>(communities.size());

        boolean isIdEqual;
        boolean isShortNameEqual;
        boolean isRowInsideMap;

        for (CommunityListRow communityRow : communities) {

            for (CommunityPostalCodeRow communityPostalRow : communityPostalCodes) {

                isIdEqual = communityRow.getCommunityNo().equals(communityPostalRow.getCommunityNo());
                isShortNameEqual = communityRow.getCommunityNameShort().equals(communityPostalRow.getZipCodeNameShort());
                isRowInsideMap = consolidatedMap.containsKey(communityRow.getCommunityNo());

                if (isIdEqual && isShortNameEqual) {

                    CommunityConsolidatedRow consolidatedRow = new CommunityConsolidatedRow(
                            communityRow.getCommunityNo(), communityRow.getCommunityNameShort(),
                            communityPostalRow.getZipCode(), communityPostalRow.getZipCodeNameShort(),
                            communityRow.getDistrictName(), communityRow.getKantonShort());

                    consolidatedMap.put(consolidatedRow.getID(), consolidatedRow);
                    break;

                } else if (isIdEqual && !isRowInsideMap) {

                    CommunityConsolidatedRow consolidatedRow = new CommunityConsolidatedRow(
                            communityRow.getCommunityNo(), communityRow.getCommunityNameShort(),
                            communityPostalRow.getZipCode(), communityPostalRow.getZipCodeNameShort(),
                            communityRow.getDistrictName(), communityRow.getKantonShort());

                    consolidatedMap.put(consolidatedRow.getID(), consolidatedRow);
                }
            }

        }

        Set<CommunityConsolidatedRow> models = new HashSet<>(consolidatedMap.values());

        return models;
    }

    /**
     *
     * @param kantonShort
     * @return
     */
    public long getAmountOfCommunitiesInKanton(String kantonShort) {

        long communitiesCount = 0;

        for (CommunityConsolidatedRow community : consolidatedCommunities) {
            if (community.getKantonShort().equals(kantonShort)) {
                communitiesCount++;
            }
        }

        return communitiesCount;
    }

    /**
     *
     * @param zipCode
     * @return
     */
    public String getDistrictForZipCode(String zipCode) {

        for (CommunityConsolidatedRow current : consolidatedCommunities) {
            if (current.getZipCode().equals(zipCode)) {
                return current.getDistrictName();
            }
        }

        return null;
    }

    /**
     *
     * @return
     */
    public Set<CommunityIdentity> findCommunitiesWhereCommunityShortNameAndZipCodeShortNameEqual() {

        Set<CommunityIdentity> resultSet = new HashSet<>();

        for (CommunityConsolidatedRow current : consolidatedCommunities) {
            if (current.getShortName().equals(current.getZipCodeNameShort())) {
                resultSet.add(current);
            }
        }

        return resultSet;
    }
}

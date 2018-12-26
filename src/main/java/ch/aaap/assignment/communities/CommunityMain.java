package ch.aaap.assignment.communities;

import java.util.Set;

public class CommunityMain {

	private final Set<CommunityListRow> politicalCommunities;
	private final Set<CommunityPostalCodeRow> postalcommunities;

	public CommunityMain() {
		politicalCommunities = CSVUtil.getCommunityListRows();
		postalcommunities = CSVUtil.getCommunityPostalCodeRows();

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
	public Object createModel(Set<CommunityListRow> communities,
			Set<CommunityPostalCodeRow> communityPostalCodes) {
		throw new RuntimeException("Not yet implemented");
	}

	/**
	 * 
	 * @param kantonShort
	 * @return
	 */
	public long getAmountOfCommunitiesInKanton(String kantonShort) {
		throw new RuntimeException("Not yet implemented");
	}

	/**
	 * 
	 * @param zipCode
	 * @return
	 */
	public String getDistrictForZipCode(String zipCode) {
		throw new RuntimeException("Not yet implemented");
	}

	/**
	 * 
	 * @return
	 */
	public Set<CommunityIdentity> findCommunitiesWhereCommunityShortNameAndZipCodeShortNameEqual() {
		throw new RuntimeException("Not yet implemented");
	}
}

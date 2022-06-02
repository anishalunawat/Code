import java.util.*;

class LetterCombination {
	private static List<String> lettterCombination(String digits) {
		List<String> resultsLetterComb = new ArrayList<String>();
		if (digits != null && !digits.isEmpty()) {
			int digitLength = digits.length();
			String[] numberAlphabetMap = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
			Queue<String> intermediateSting = new LinkedList<String>();
			intermediateSting.add("");
			while (!intermediateSting.isEmpty()) {
				String popString = intermediateSting.remove();
				int popLength = popString.length();
				// final set of results
				if (popLength == digitLength) {
					resultsLetterComb.add(popString);
				} else { // intermediate string formations
					int digit = Character.getNumericValue(digits.charAt(popLength));
					String alphabetSet = numberAlphabetMap[digit];
					int alphaLength = alphabetSet.length();
					for (int i = 0; i < alphaLength; i++) {
						intermediateSting.add(popString + alphabetSet.charAt(i));
					}
				}
			}

		}
		return resultsLetterComb;
	}

	public static void main(String args[]) {
		List<String> resultSet = lettterCombination("23");
		if (resultSet == null)
			return;
		for (String entry : resultSet) {
			System.out.println(entry);
		}
	}

}

// Complexity 3^N * 4 ^ M where N is number of 3 digit elements and M is numer
// of 4 alphabet numbers
public class StripComments {

	public static String stripComments(String text, String[] commentSymbols) {
		if (text == null || text.isEmpty()) {
			return "";
		}

		String[] lines = text.split("\n");
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < lines.length; i++) {
			String line = lines[i];
			int earliestCommentPos = line.length();

			// Find the earliest comment symbol in the line
			for (String symbol : commentSymbols) {
				int pos = line.indexOf(symbol);
				if (pos != -1 && pos < earliestCommentPos) {
					earliestCommentPos = pos;
				}
			}

			// Get the part of the line before the comment
			String processedLine = line.substring(0, earliestCommentPos).replaceAll("\\s+$", "");

			result.append(processedLine);

			// Add a newline if this isn't the last line
			if (i < lines.length - 1) {
				result.append("\n");
			}
		}

		return result.toString();
	}
}

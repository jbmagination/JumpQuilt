package link.infra.jumploader.util;

import java.net.URL;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {
	private RegexUtil() {}

	public static boolean patternMatchesJars(Pattern pattern, List<URL> loadedJars) {
		for (URL jar : loadedJars) {
			if (pattern.matcher(jar.toString()).find()) {
				return true;
			}
		}
		return false;
	}

	public static String groupResultJars(Pattern pattern, List<URL> loadedJars) {
		for (URL jar : loadedJars) {
			Matcher matcher = pattern.matcher(jar.toString());
			if (!matcher.find()) {
				continue;
			}
			return matcher.group(1);
		}
		return null;
	}
}

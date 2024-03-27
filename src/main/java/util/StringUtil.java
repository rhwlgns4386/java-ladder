package util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtil {
    public static List<String> splitStringToList(String str, String regex) {
        return Arrays.stream(str.split(regex))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}

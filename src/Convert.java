import java.util.HashMap;
import java.util.Map;

public class Convert {
    private final Map<String, Integer> roman = new HashMap<>();

    public Convert() {
        roman.put("I", 1);
        roman.put("II", 2);
        roman.put("III", 3);
        roman.put("IV", 4);
        roman.put("V", 5);
        roman.put("VI", 6);
        roman.put("VII", 7);
        roman.put("VIII", 8);
        roman.put("VIV", 9);
        roman.put("X", 10);
        roman.put("XX", 20);
        roman.put("XXX", 30);
        roman.put("XL", 40);
        roman.put("L", 50);
        roman.put("LX", 60);
        roman.put("LXX", 70);
        roman.put("LXXX", 80);
        roman.put("XC", 90);
        roman.put("C", 100);
    }

    public int returnNumber(String romanNumber) {
        return roman.get(romanNumber);
    }

    public boolean isRoman(String inputNumber) {
        String[] keys = new String[roman.size()];
        int index = 0;
        for (String valueNumber : roman.keySet()) {
            keys[index] = valueNumber;
            index++;
        }
        for (String key : keys) {
            if (inputNumber.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public String getKeysByValue(Integer value) {
        for (Map.Entry<String, Integer> entry : roman.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null;
    }
}


package analyser;

import model.OriginalOffer;
import parser.OriginalOfferParseUtils;

import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * Created by Wladimir Litvinov on 13.05.2016.
 */
public class NotChangingFieldsAnalyser implements Analyser {
    private Map<String, Boolean> onlyOneValue = new HashMap<>();
    final Map<String, Object> fieldsValues = new HashMap<>();

    @Override
    public BiFunction<String, File, Object> initLineProcessor() {
        fieldsValues.clear();
        final Field[] fields = OriginalOffer.class.getDeclaredFields();
        onlyOneValue.clear();
        for (Field field : fields) {
            field.setAccessible(true);
            onlyOneValue.put(field.getName(), true);
        }
        return (line, file) -> {
            final OriginalOffer originalOffer = OriginalOfferParseUtils.parseOriginalFileLine(line);
            for (int i = 0; i < fields.length; i++) {
                final Field field = fields[i];
                final String name = field.getName();
                try {
                    final Object value = field.get(originalOffer);
                    final Object savedValue = fieldsValues.get(name);
                    if (onlyOneValue.get(name)
                            && (
                            (value != null && savedValue != null && !value.equals(savedValue))
                                    || (value == null && savedValue != null))) {
                        onlyOneValue.put(name, false);
                    }
                    if (onlyOneValue.get(name) && savedValue == null) {
                        fieldsValues.put(name, value);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            return null;
        };
    }

    public Map<String, Object> getResult() {
        final Map<String, Object> result = new HashMap<>();
        for (Map.Entry<String, Boolean> entry : onlyOneValue.entrySet()) {
            if (entry.getValue()){
                result.put(entry.getKey(), fieldsValues.get(entry.getKey()));
            }
        }
        return result;
    }
}

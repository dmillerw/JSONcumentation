package dmillerw.author.client.data.widget;

import com.google.common.collect.Maps;
import com.google.gson.*;
import dmillerw.author.lib.JsonLib;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * @author dmillerw
 */
public class WidgetContainer {

    public String type;
    public Map<String, Object> data;

    @Override
    public String toString() {
        return "{ident: " + type + ", data: " + data + "}";
    }

    public static class Deserializer implements JsonDeserializer<WidgetContainer> {

        @Override
        public WidgetContainer deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            if (!json.isJsonObject()) {
                throw new JsonParseException("");
            }

            JsonObject object = json.getAsJsonObject();
            JsonElement type = object.get("ident");

            if (type == null) {
                throw new JsonParseException("");
            }

            WidgetContainer widgetContainer = new WidgetContainer();
            widgetContainer.type = type.getAsString();

            Map<String, Object> data = Maps.newHashMap();

            for (Map.Entry<String, JsonElement> entry : object.entrySet()) {
                if (!("ident".equals(entry.getKey()))) {
                    data.put(entry.getKey(), JsonLib.convert(entry.getValue()));
                }
            }

            widgetContainer.data = data;

            return widgetContainer;
        }
    }
}

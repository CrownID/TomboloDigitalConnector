package uk.org.tombolo.field.assertion;

import uk.org.tombolo.core.Attribute;
import uk.org.tombolo.importer.osm.OSMBuiltInImporters;
import uk.org.tombolo.recipe.AttributeMatcher;
import uk.org.tombolo.recipe.FieldRecipe;

import java.util.List;
import java.util.Map;

/**
 *  Returns the value of the 'field' if the subject has an attribute matching one of the built-in attributes in the
 *  built-in importer class specified. At the moment we only have built-in support for OSM importers.
 */
public class OSMBuiltInAttributeMatcherField extends AttributeMatcherField {

    public OSMBuiltInAttributeMatcherField(String label, List<AttributeMatcher> attributes, FieldRecipe field) {
        super(label, attributes, field);
    }

    @Override
    protected Map<Attribute, List<String>> getAttributeValueMatches(AttributeMatcher attributeMatcher) {
        try {
            return OSMBuiltInImporters.checkBuiltIn(attributeMatcher);
        } catch (Exception e) {
            throw new Error("Unknown built-in importer class: " + e.getMessage());
        }
    }
}
